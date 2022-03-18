package ru.lyrian.collections_operations_time.presentation;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.lyrian.collections_operations_time.di.annotations.qualifiers.PresentersMap;

@Singleton
public class PresenterFactory {
    private final Map<Class<? extends AbstractPresenter>, AbstractPresenter> presenters;

    @Inject
    public PresenterFactory(@PresentersMap Map<Class<? extends AbstractPresenter>, AbstractPresenter> presenters) {
        this.presenters = presenters;
    }

    public <P extends AbstractPresenter> P getPresenter(Class<P> fragmentClass) {
        return (P) this.presenters.get(fragmentClass);
    }
}
