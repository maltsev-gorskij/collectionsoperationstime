package ru.lyrian.collections_operations_time.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ru.lyrian.collections_operations_time.presentation.collections.FragmentCollections;
import ru.lyrian.collections_operations_time.presentation.maps.FragmentMaps;

@Module
public interface FragmentsBuilderModule {
    @ContributesAndroidInjector
    FragmentCollections contributeFragmentCollections();

    @ContributesAndroidInjector
    FragmentMaps contributeFragmentMaps();
}
