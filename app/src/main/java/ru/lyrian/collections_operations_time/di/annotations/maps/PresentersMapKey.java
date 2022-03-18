package ru.lyrian.collections_operations_time.di.annotations.maps;

import dagger.MapKey;
import ru.lyrian.collections_operations_time.presentation.AbstractPresenter;

@MapKey
public @interface PresentersMapKey {
    Class<? extends AbstractPresenter> value();
}
