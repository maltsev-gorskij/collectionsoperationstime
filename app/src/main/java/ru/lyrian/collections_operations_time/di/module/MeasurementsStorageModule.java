package ru.lyrian.collections_operations_time.di.module;

import dagger.Binds;
import dagger.Module;
import ru.lyrian.collections_operations_time.model.IMeasurementContract;
import ru.lyrian.collections_operations_time.model.MeasurementsStorage;

@Module
public interface MeasurementsStorageModule {
    @Binds
    IMeasurementContract.IMeasurementsStorage bindMeasurementStorage(MeasurementsStorage measurementsStorage);
}

