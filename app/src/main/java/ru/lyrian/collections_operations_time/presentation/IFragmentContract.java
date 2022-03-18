package ru.lyrian.collections_operations_time.presentation;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;

public interface IFragmentContract {
    interface IPresenter {
        void attach(IView iView);

        void detach();

        void prepareOperations(int size);
    }

    interface IView {
        void onOperationsStart();

        void setTextViewValue(ViewTag textViewTag, String value);

        void enableButton();
    }
}
