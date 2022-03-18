package ru.lyrian.collections_operations_time.model;

import io.reactivex.Observable;
import ru.lyrian.collections_operations_time.enumerations.FragmentTag;
import ru.lyrian.collections_operations_time.model.operations.Operations;

public interface IMeasurementContract {
    interface IMeasurementsStorage {
        Observable<Measurement> getMeasurementsObservable();

        Observable<String> getOnCompleteSubject(FragmentTag fragmentTag);

        void executeOperations(Operations operations);
    }

    interface IMeasurementsObserver {
        FragmentTag getFragmentTag();

        void publishChanges(Measurement measurement);
    }
}
