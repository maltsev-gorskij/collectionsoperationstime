package ru.lyrian.collections_operations_time.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;

public abstract class AbstractFragment<P extends AbstractPresenter> extends DaggerFragment implements IFragmentContract.IView {
    protected final Map<ViewTag, ViewTag> linkTextViewToProgressBar = new HashMap<>();
    protected P abstractPresenter;

    @Inject
    protected PresenterFactory presenterFactory;

    protected abstract String getDefaultSize();

    protected abstract Button getEvaluateButton();

    protected abstract List<TextView> getTableTextViews();

    protected abstract List<ProgressBar> getTableProgressBars();

    protected abstract EditText getSizeView();

    protected abstract Class<P> getPresenterClass();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createFragmentView(inflater, container, savedInstanceState);
        fillTextViewsList();
        fillProgressBarsList();
        setViewTags(view);
        linkViews();
        getEvaluateButton().setOnClickListener(v -> prepareOperations(Integer.parseInt(this.getSizeView().getText().toString())));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.abstractPresenter = this.presenterFactory.getPresenter(getPresenterClass());
        this.abstractPresenter.attach(this);
        getSizeView().setText(getDefaultSize());

        if (savedInstanceState != null) {
            for (TextView textView : getTableTextViews()) {
                String testViewId = String.valueOf(textView.getId());
                int textViewVisibility = savedInstanceState.getInt(testViewId);
                textView.setVisibility(textViewVisibility);
            }

            for (ProgressBar progressBar : getTableProgressBars()) {
                String progressBarId = String.valueOf(progressBar.getId());
                int progressBarVisibility = savedInstanceState.getInt(progressBarId);
                progressBar.setVisibility(progressBarVisibility);
            }

            String buttonEvaluateId = String.valueOf(getEvaluateButton().getId());
            boolean isEvaluateButtonEnabled = savedInstanceState.getBoolean(buttonEvaluateId);
            getEvaluateButton().setEnabled(isEvaluateButtonEnabled);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        for (TextView textView : getTableTextViews()) {
            String testViewId = String.valueOf(textView.getId());
            int textViewVisibility = textView.getVisibility();
            outState.putInt(testViewId, textViewVisibility);
        }

        for (ProgressBar progressBar : getTableProgressBars()) {
            String progressBarId = String.valueOf(progressBar.getId());
            int progressBarVisibility = progressBar.getVisibility();
            outState.putInt(progressBarId, progressBarVisibility);
        }

        String buttonEvaluateId = String.valueOf(getEvaluateButton().getId());
        boolean isEvaluateButtonEnabled = getEvaluateButton().isEnabled();
        outState.putBoolean(buttonEvaluateId, isEvaluateButtonEnabled);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        this.abstractPresenter.detach();
        unbindViews();
    }

    @Override
    public void onOperationsStart() {
        getEvaluateButton().setEnabled(false);
        getTableTextViews().forEach(view1 -> view1.setVisibility(View.INVISIBLE));
        getTableProgressBars().forEach(view1 -> view1.setVisibility(View.VISIBLE));
    }

    @Override
    public void setTextViewValue(ViewTag textViewTag, String value) {
        ViewTag progressBarTag = this.linkTextViewToProgressBar.get(textViewTag);
        TextView textView = (TextView) findViewByTag(textViewTag);
        ProgressBar progressBar = (ProgressBar) findViewByTag(progressBarTag);

        if (textView != null && progressBar != null) {
            progressBar.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.VISIBLE);
            textView.setText(value);
        }
    }

    View findViewByTag(ViewTag viewTag) {
        View foundView = null;

        for (View view : getTableProgressBars()) {
            if (view.getTag() != null && view.getTag() == viewTag) {
                foundView = view;
                return foundView;
            }
        }

        if (foundView == null) {
            for (View view : getTableTextViews()) {
                if (view.getTag() != null && view.getTag() == viewTag) {
                    foundView = view;
                    return foundView;
                }
            }
        }

        return foundView;
    }

    @Override
    public void enableButton() {
        getEvaluateButton().setEnabled(true);
    }

    protected abstract View createFragmentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected abstract void unbindViews();

    protected abstract void fillTextViewsList();

    protected abstract void fillProgressBarsList();

    protected abstract void setViewTags(View view);

    protected abstract void linkViews();

    protected abstract void prepareOperations(int size);
}
