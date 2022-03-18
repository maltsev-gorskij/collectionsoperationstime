package ru.lyrian.collections_operations_time.di.application;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import ru.lyrian.collections_operations_time.di.component.DaggerIAppComponent;
import ru.lyrian.collections_operations_time.di.component.IAppComponent;

public class App extends DaggerApplication {
    private IAppComponent iAppComponent;

    public IAppComponent getIAppComponent() {
        return iAppComponent;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        this.iAppComponent = DaggerIAppComponent.create();
        return this.iAppComponent;
    }
}
