package ru.lyrian.collections_operations_time.di.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import ru.lyrian.collections_operations_time.di.application.App;
import ru.lyrian.collections_operations_time.di.module.ActivityBuildersModule;
import ru.lyrian.collections_operations_time.di.module.MeasurementsStorageModule;
import ru.lyrian.collections_operations_time.di.module.PresenterModule;
import ru.lyrian.collections_operations_time.model.MeasurementsStorage;

@Component(modules = {
        ActivityBuildersModule.class,
        AndroidInjectionModule.class,
        PresenterModule.class,
        MeasurementsStorageModule.class})
@Singleton
public interface IAppComponent extends AndroidInjector<App> {
    MeasurementsStorage measurementsStorage();
}
