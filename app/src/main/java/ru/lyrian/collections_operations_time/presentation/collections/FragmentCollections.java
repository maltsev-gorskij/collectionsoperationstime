package ru.lyrian.collections_operations_time.presentation.collections;

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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.lyrian.collections_operations_time.databinding.FragmentCollectionsBinding;
import ru.lyrian.collections_operations_time.enumerations.ButtonTag;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.presentation.AbstractFragment;

public class FragmentCollections extends AbstractFragment<CollectionsPresenter> {
    private final String defaultCollectionsSize = "50000";
    private FragmentCollectionsBinding boundViews;
    private final List<TextView> tableTextViews = new ArrayList<>();
    private final List<ProgressBar> tableProgressBars = new ArrayList<>();

    @Override
    protected View createFragmentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.boundViews = FragmentCollectionsBinding.inflate(inflater, container, false);

        return this.boundViews.getRoot();
    }

    @Override
    protected void unbindViews() {
        this.boundViews = null;
    }

    @Override
    protected EditText getSizeView() {
        return this.boundViews.etCollectionsSize;
    }

    @Override
    protected String getDefaultSize() {
        return this.defaultCollectionsSize;
    }

    @Override
    protected List<TextView> getTableTextViews() {
        return this.tableTextViews;
    }

    @Override
    protected List<ProgressBar> getTableProgressBars() {
        return this.tableProgressBars;
    }

    @Override
    protected Button getEvaluateButton() {
        return this.boundViews.btEvaluate;
    }

    @Inject
    @Override
    protected Class<CollectionsPresenter> getPresenterClass() {
        return CollectionsPresenter.class;
    }

    @Override
    protected void prepareOperations(int size) {
        this.abstractPresenter.prepareOperations(size);
    }

    @Override
    protected void fillTextViewsList() {
        this.tableTextViews.add(this.boundViews.tvArrayListCreate);
        this.tableTextViews.add(this.boundViews.tvArrayListAddInTheBeginning);
        this.tableTextViews.add(this.boundViews.tvArrayListAddInTheMiddle);
        this.tableTextViews.add(this.boundViews.tvArrayListAddInTheEnd);
        this.tableTextViews.add(this.boundViews.tvArrayListSearchByValue);
        this.tableTextViews.add(this.boundViews.tvArrayListRemoveFromTheBeginning);
        this.tableTextViews.add(this.boundViews.tvArrayListRemoveFromTheMiddle);
        this.tableTextViews.add(this.boundViews.tvArrayListRemoveFromTheEnd);
        this.tableTextViews.add(this.boundViews.tvLinkedListCreate);
        this.tableTextViews.add(this.boundViews.tvLinkedListAddInTheBeginning);
        this.tableTextViews.add(this.boundViews.tvLinkedListAddInTheMiddle);
        this.tableTextViews.add(this.boundViews.tvLinkedListAddInTheEnd);
        this.tableTextViews.add(this.boundViews.tvLinkedListSearchByValue);
        this.tableTextViews.add(this.boundViews.tvLinkedListRemoveFromTheBeginning);
        this.tableTextViews.add(this.boundViews.tvLinkedListRemoveFromTheMiddle);
        this.tableTextViews.add(this.boundViews.tvLinkedListRemoveFromTheEnd);
        this.tableTextViews.add(this.boundViews.tvCopyOnWriteArrayListCreate);
        this.tableTextViews.add(this.boundViews.tvCopyOnWriteArrayListAddInTheBeginning);
        this.tableTextViews.add(this.boundViews.tvCopyOnWriteArrayListAddInTheMiddle);
        this.tableTextViews.add(this.boundViews.tvCopyOnWriteArrayListAddInTheEnd);
        this.tableTextViews.add(this.boundViews.tvCopyOnWriteArrayListSearchByValue);
        this.tableTextViews.add(this.boundViews.tvCopyOnWriteArrayListRemoveFromTheBeginning);
        this.tableTextViews.add(this.boundViews.tvCopyOnWriteArrayListRemoveFromTheMiddle);
        this.tableTextViews.add(this.boundViews.tvCopyOnWriteArrayListRemoveFromTheEnd);
    }

    @Override
    protected void fillProgressBarsList() {
        this.tableProgressBars.add(this.boundViews.pbArrayListCreate);
        this.tableProgressBars.add(this.boundViews.pbArrayListAddToBeginning);
        this.tableProgressBars.add(this.boundViews.pbArrayListAddInTheMiddle);
        this.tableProgressBars.add(this.boundViews.pbArrayListAddInTheEnd);
        this.tableProgressBars.add(this.boundViews.pbArrayListSearchByValue);
        this.tableProgressBars.add(this.boundViews.pbArrayListRemoveFromTheBeginning);
        this.tableProgressBars.add(this.boundViews.pbArrayListRemoveFromTheMiddle);
        this.tableProgressBars.add(this.boundViews.pbArrayListRemoveFromTheEnd);
        this.tableProgressBars.add(this.boundViews.pbLinkedListCreate);
        this.tableProgressBars.add(this.boundViews.pbLinkedListAddToBeginning);
        this.tableProgressBars.add(this.boundViews.pbLinkedListAddInTheMiddle);
        this.tableProgressBars.add(this.boundViews.pbLinkedListAddInTheEnd);
        this.tableProgressBars.add(this.boundViews.pbLinkedListSearchByValue);
        this.tableProgressBars.add(this.boundViews.pbLinkedListRemoveFromTheBeginning);
        this.tableProgressBars.add(this.boundViews.pbLinkedListRemoveFromTheMiddle);
        this.tableProgressBars.add(this.boundViews.pbLinkedListRemoveFromTheEnd);
        this.tableProgressBars.add(this.boundViews.pbCopyOnWriteArrayListCreate);
        this.tableProgressBars.add(this.boundViews.pbCopyOnWriteArrayListAddToBeginning);
        this.tableProgressBars.add(this.boundViews.pbCopyOnWriteArrayListAddInTheMiddle);
        this.tableProgressBars.add(this.boundViews.pbCopyOnWriteArrayListAddInTheEnd);
        this.tableProgressBars.add(this.boundViews.pbCopyOnWriteArrayListSearchByValue);
        this.tableProgressBars.add(this.boundViews.pbCopyOnWriteArrayListRemoveFromTheBeginning);
        this.tableProgressBars.add(this.boundViews.pbCopyOnWriteArrayListRemoveFromTheMiddle);
        this.tableProgressBars.add(this.boundViews.pbCopyOnWriteArrayListRemoveFromTheEnd);
    }

    @Override
    protected void setViewTags(View view) {
        this.boundViews.tvArrayListCreate.setTag(ViewTag.TV_ARRAY_LIST_CREATE);
        this.boundViews.pbArrayListCreate.setTag(ViewTag.PB_ARRAY_LIST_CREATE);
        this.boundViews.tvArrayListAddInTheBeginning.setTag(ViewTag.TV_ARRAY_LIST_ADD_IN_THE_BEGINNING);
        this.boundViews.pbArrayListAddToBeginning.setTag(ViewTag.PB_ARRAY_LIST_ADD_IN_THE_BEGINNING);
        this.boundViews.tvArrayListAddInTheMiddle.setTag(ViewTag.TV_ARRAY_LIST_ADD_IN_THE_MIDDLE);
        this.boundViews.pbArrayListAddInTheMiddle.setTag(ViewTag.PB_ARRAY_LIST_ADD_IN_THE_MIDDLE);
        this.boundViews.tvArrayListAddInTheEnd.setTag(ViewTag.TV_ARRAY_LIST_ADD_IN_THE_END);
        this.boundViews.pbArrayListAddInTheEnd.setTag(ViewTag.PB_ARRAY_LIST_ADD_IN_THE_END);
        this.boundViews.tvArrayListSearchByValue.setTag(ViewTag.TV_ARRAY_LIST_SEARCH_BY_VALUE);
        this.boundViews.pbArrayListSearchByValue.setTag(ViewTag.PB_ARRAY_LIST_SEARCH_BY_VALUE);
        this.boundViews.tvArrayListRemoveFromTheBeginning.setTag(ViewTag.TV_ARRAY_LIST_REMOVE_FROM_THE_BEGINNING);
        this.boundViews.pbArrayListRemoveFromTheBeginning.setTag(ViewTag.PB_ARRAY_LIST_REMOVE_FROM_THE_BEGINNING);
        this.boundViews.tvArrayListRemoveFromTheMiddle.setTag(ViewTag.TV_ARRAY_LIST_REMOVE_FROM_THE_MIDDLE);
        this.boundViews.pbArrayListRemoveFromTheMiddle.setTag(ViewTag.PB_ARRAY_LIST_REMOVE_FROM_THE_MIDDLE);
        this.boundViews.tvArrayListRemoveFromTheEnd.setTag(ViewTag.TV_ARRAY_LIST_REMOVE_FROM_THE_END);
        this.boundViews.pbArrayListRemoveFromTheEnd.setTag(ViewTag.PB_ARRAY_LIST_REMOVE_FROM_THE_END);

        this.boundViews.tvLinkedListCreate.setTag(ViewTag.TV_LINKED_LIST_CREATE);
        this.boundViews.pbLinkedListCreate.setTag(ViewTag.PB_LINKED_LIST_CREATE);
        this.boundViews.tvLinkedListAddInTheBeginning.setTag(ViewTag.TV_LINKED_LIST_ADD_IN_THE_BEGINNING);
        this.boundViews.pbLinkedListAddToBeginning.setTag(ViewTag.PB_LINKED_LIST_ADD_IN_THE_BEGINNING);
        this.boundViews.tvLinkedListAddInTheMiddle.setTag(ViewTag.TV_LINKED_LIST_ADD_IN_THE_MIDDLE);
        this.boundViews.pbLinkedListAddInTheMiddle.setTag(ViewTag.PB_LINKED_LIST_ADD_IN_THE_MIDDLE);
        this.boundViews.tvLinkedListAddInTheEnd.setTag(ViewTag.TV_LINKED_LIST_ADD_IN_THE_END);
        this.boundViews.pbLinkedListAddInTheEnd.setTag(ViewTag.PB_LINKED_LIST_ADD_IN_THE_END);
        this.boundViews.tvLinkedListSearchByValue.setTag(ViewTag.TV_LINKED_LIST_SEARCH_BY_VALUE);
        this.boundViews.pbLinkedListSearchByValue.setTag(ViewTag.PB_LINKED_LIST_SEARCH_BY_VALUE);
        this.boundViews.tvLinkedListRemoveFromTheBeginning.setTag(ViewTag.TV_LINKED_LIST_REMOVE_FROM_THE_BEGINNING);
        this.boundViews.pbLinkedListRemoveFromTheBeginning.setTag(ViewTag.PB_LINKED_LIST_REMOVE_FROM_THE_BEGINNING);
        this.boundViews.tvLinkedListRemoveFromTheMiddle.setTag(ViewTag.TV_LINKED_LIST_REMOVE_FROM_THE_MIDDLE);
        this.boundViews.pbLinkedListRemoveFromTheMiddle.setTag(ViewTag.PB_LINKED_LIST_REMOVE_FROM_THE_MIDDLE);
        this.boundViews.tvLinkedListRemoveFromTheEnd.setTag(ViewTag.TV_LINKED_LIST_REMOVE_FROM_THE_END);
        this.boundViews.pbLinkedListRemoveFromTheEnd.setTag(ViewTag.PB_LINKED_LIST_REMOVE_FROM_THE_END);

        this.boundViews.tvCopyOnWriteArrayListCreate.setTag(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_CREATE);
        this.boundViews.pbCopyOnWriteArrayListCreate.setTag(ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_CREATE);
        this.boundViews.tvCopyOnWriteArrayListAddInTheBeginning.setTag(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_BEGINNING);
        this.boundViews.pbCopyOnWriteArrayListAddToBeginning.setTag(ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_BEGINNING);
        this.boundViews.tvCopyOnWriteArrayListAddInTheMiddle.setTag(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_MIDDLE);
        this.boundViews.pbCopyOnWriteArrayListAddInTheMiddle.setTag(ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_MIDDLE);
        this.boundViews.tvCopyOnWriteArrayListAddInTheEnd.setTag(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_END);
        this.boundViews.pbCopyOnWriteArrayListAddInTheEnd.setTag(ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_END);
        this.boundViews.tvCopyOnWriteArrayListSearchByValue.setTag(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_SEARCH_BY_VALUE);
        this.boundViews.pbCopyOnWriteArrayListSearchByValue.setTag(ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_SEARCH_BY_VALUE);
        this.boundViews.tvCopyOnWriteArrayListRemoveFromTheBeginning.setTag(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_BEGINNING);
        this.boundViews.pbCopyOnWriteArrayListRemoveFromTheBeginning.setTag(ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_BEGINNING);
        this.boundViews.tvCopyOnWriteArrayListRemoveFromTheMiddle.setTag(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_MIDDLE);
        this.boundViews.pbCopyOnWriteArrayListRemoveFromTheMiddle.setTag(ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_MIDDLE);
        this.boundViews.tvCopyOnWriteArrayListRemoveFromTheEnd.setTag(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_END);
        this.boundViews.pbCopyOnWriteArrayListRemoveFromTheEnd.setTag(ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_END);

        this.boundViews.btEvaluate.setTag(ButtonTag.BT_COLLECTIONS);
    }

    @Override
    protected void linkViews() {
        this.linkTextViewToProgressBar.put(ViewTag.TV_ARRAY_LIST_CREATE, ViewTag.PB_ARRAY_LIST_CREATE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_ARRAY_LIST_ADD_IN_THE_BEGINNING, ViewTag.PB_ARRAY_LIST_ADD_IN_THE_BEGINNING);
        this.linkTextViewToProgressBar.put(ViewTag.TV_ARRAY_LIST_ADD_IN_THE_MIDDLE, ViewTag.PB_ARRAY_LIST_ADD_IN_THE_MIDDLE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_ARRAY_LIST_ADD_IN_THE_END, ViewTag.PB_ARRAY_LIST_ADD_IN_THE_END);
        this.linkTextViewToProgressBar.put(ViewTag.TV_ARRAY_LIST_SEARCH_BY_VALUE, ViewTag.PB_ARRAY_LIST_SEARCH_BY_VALUE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_ARRAY_LIST_REMOVE_FROM_THE_BEGINNING, ViewTag.PB_ARRAY_LIST_REMOVE_FROM_THE_BEGINNING);
        this.linkTextViewToProgressBar.put(ViewTag.TV_ARRAY_LIST_REMOVE_FROM_THE_MIDDLE, ViewTag.PB_ARRAY_LIST_REMOVE_FROM_THE_MIDDLE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_ARRAY_LIST_REMOVE_FROM_THE_END, ViewTag.PB_ARRAY_LIST_REMOVE_FROM_THE_END);

        this.linkTextViewToProgressBar.put(ViewTag.TV_LINKED_LIST_CREATE, ViewTag.PB_LINKED_LIST_CREATE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_LINKED_LIST_ADD_IN_THE_BEGINNING, ViewTag.PB_LINKED_LIST_ADD_IN_THE_BEGINNING);
        this.linkTextViewToProgressBar.put(ViewTag.TV_LINKED_LIST_ADD_IN_THE_MIDDLE, ViewTag.PB_LINKED_LIST_ADD_IN_THE_MIDDLE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_LINKED_LIST_ADD_IN_THE_END, ViewTag.PB_LINKED_LIST_ADD_IN_THE_END);
        this.linkTextViewToProgressBar.put(ViewTag.TV_LINKED_LIST_SEARCH_BY_VALUE, ViewTag.PB_LINKED_LIST_SEARCH_BY_VALUE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_LINKED_LIST_REMOVE_FROM_THE_BEGINNING, ViewTag.PB_LINKED_LIST_REMOVE_FROM_THE_BEGINNING);
        this.linkTextViewToProgressBar.put(ViewTag.TV_LINKED_LIST_REMOVE_FROM_THE_MIDDLE, ViewTag.PB_LINKED_LIST_REMOVE_FROM_THE_MIDDLE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_LINKED_LIST_REMOVE_FROM_THE_END, ViewTag.PB_LINKED_LIST_REMOVE_FROM_THE_END);

        this.linkTextViewToProgressBar.put(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_CREATE, ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_CREATE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_BEGINNING, ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_BEGINNING);
        this.linkTextViewToProgressBar.put(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_MIDDLE, ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_MIDDLE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_END, ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_END);
        this.linkTextViewToProgressBar.put(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_SEARCH_BY_VALUE, ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_SEARCH_BY_VALUE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_BEGINNING, ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_BEGINNING);
        this.linkTextViewToProgressBar.put(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_MIDDLE, ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_MIDDLE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_END, ViewTag.PB_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_END);
    }
}