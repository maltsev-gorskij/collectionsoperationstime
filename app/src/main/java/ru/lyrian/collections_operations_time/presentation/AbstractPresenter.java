package ru.lyrian.collections_operations_time.presentation;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.IMeasurementContract;
import ru.lyrian.collections_operations_time.model.Measurement;
import ru.lyrian.collections_operations_time.model.operations.Operations;

public abstract class AbstractPresenter implements IFragmentContract.IPresenter, IMeasurementContract.IMeasurementsObserver {
    protected final IMeasurementContract.IMeasurementsStorage measurementsStorage;
    protected WeakReference<IFragmentContract.IView> iView;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public AbstractPresenter(IMeasurementContract.IMeasurementsStorage measurementsStorage) {
        this.measurementsStorage = measurementsStorage;
    }

    @Override
    public void attach(@NonNull IFragmentContract.IView iView) {
        this.iView = new WeakReference<>(Objects.requireNonNull(iView));
        Disposable measurementsDisposable = this.measurementsStorage
                .getMeasurementsObservable()
                .filter(measurement -> measurement.getViewTag() != null)
                .filter(measurement -> measurement.getViewTag().getFragmentTag() == getFragmentTag())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::publishChanges);
        Disposable onCompleteDisposable = this.measurementsStorage
                .getOnCompleteSubject(getFragmentTag())
                .subscribe(message -> {
                    iView.enableButton();
                });
        this.compositeDisposable.add(measurementsDisposable);
        this.compositeDisposable.add(onCompleteDisposable);
    }

    @Override
    public void detach() {
        this.iView = null;
        this.compositeDisposable.clear();
    }

    @Override
    public void publishChanges(Measurement measurement) {
        if (this.iView != null && this.iView.get() != null) {
            ViewTag textViewTag = measurement.getViewTag();
            String executionTime = String.valueOf(measurement.getExecutionTime());
            this.iView.get().setTextViewValue(textViewTag, executionTime);
        }
    }

    @Override
    public void prepareOperations(int size) {
        if (this.iView != null && this.iView.get() != null) {
            this.iView.get().onOperationsStart();
            Operations operations = getOperations(size);
            this.measurementsStorage.executeOperations(operations);
        }
    }

    protected abstract Operations getOperations(int size);
}