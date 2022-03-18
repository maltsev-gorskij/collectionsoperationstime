package ru.lyrian.collections_operations_time.di.module;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ru.lyrian.collections_operations_time.di.annotations.maps.PresentersMapKey;
import ru.lyrian.collections_operations_time.di.annotations.qualifiers.PresentersMap;
import ru.lyrian.collections_operations_time.presentation.AbstractPresenter;
import ru.lyrian.collections_operations_time.presentation.collections.CollectionsPresenter;
import ru.lyrian.collections_operations_time.presentation.maps.MapsPresenter;

@Module
public interface PresenterModule {
    @Binds
    @Singleton
    @IntoMap
    @PresentersMap
    @PresentersMapKey(CollectionsPresenter.class)
    AbstractPresenter provideCollectionsPresenter(CollectionsPresenter collectionsPresenter);

    @Binds
    @Singleton
    @IntoMap
    @PresentersMap
    @PresentersMapKey(MapsPresenter.class)
    AbstractPresenter provideMapsPresenter(MapsPresenter mapsPresenter);
}
