package ru.lyrian.collections_operations_time.model;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;
import ru.lyrian.collections_operations_time.enumerations.FragmentTag;
import ru.lyrian.collections_operations_time.model.lists.AbstractOperationsList;
import ru.lyrian.collections_operations_time.model.operations.Operations;
import ru.lyrian.collections_operations_time.model.operations.operations.AbstractOperation;
import ru.lyrian.collections_operations_time.util.Utility;

@Singleton
public class MeasurementsStorage implements IMeasurementContract.IMeasurementsStorage {
    private final String onCompleteMessage = "onComplete";
    private final Subject<Measurement> presenterSubject = ReplaySubject.createWithSize(Utility.OPERATIONS_COUNT);
    private final Map<FragmentTag, Subject<String>> onCompleteNotifiers = new HashMap<>();

    @Inject
    public MeasurementsStorage() {
    }

    @Override
    public Observable<Measurement> getMeasurementsObservable() {
        return this.presenterSubject;
    }

    @Override
    public Observable<String> getOnCompleteSubject(@NonNull FragmentTag fragmentTag) {
        Subject<String> onCompleteNotifier;

        if (this.onCompleteNotifiers.get(Objects.requireNonNull(fragmentTag)) == null) {
            onCompleteNotifier = PublishSubject.create();
            this.onCompleteNotifiers.put(fragmentTag, onCompleteNotifier);
        } else {
            onCompleteNotifier = this.onCompleteNotifiers.get(fragmentTag);
        }

        return onCompleteNotifier;
    }

    @SuppressLint("CheckResult")
    @Override
    public void executeOperations(Operations operations) {
        FragmentTag fragmentTag = operations.getFragmentTag();

        Observable
                .just(operations)
                .subscribeOn(Schedulers.computation())
                .map(Operations::getCreationOperations)
                .flatMapIterable(AbstractOperationsList::getOperationsList)
                .map(AbstractOperation::execute)
                .doOnNext(presenterSubject::onNext)
                .flatMapIterable(measurement -> operations
                        .getMeasurementOperations()
                        .get(measurement.getViewTag())
                        .getOperationsList())
                .map(AbstractOperation::execute)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(() -> onCompleteNotifiers.get(fragmentTag).onNext(this.onCompleteMessage))
                .subscribe(presenterSubject::onNext);
    }
}
