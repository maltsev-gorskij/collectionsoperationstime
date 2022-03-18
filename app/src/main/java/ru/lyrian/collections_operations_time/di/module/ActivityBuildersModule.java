package ru.lyrian.collections_operations_time.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ru.lyrian.collections_operations_time.MainActivity;

@Module
public interface ActivityBuildersModule {
    @ContributesAndroidInjector(modules = {FragmentsBuilderModule.class})
    MainActivity contributeMainActivity();
}
