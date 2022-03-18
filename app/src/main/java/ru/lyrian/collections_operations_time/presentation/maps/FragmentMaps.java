package ru.lyrian.collections_operations_time.presentation.maps;

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

import ru.lyrian.collections_operations_time.databinding.FragmentMapsBinding;
import ru.lyrian.collections_operations_time.enumerations.ButtonTag;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.presentation.AbstractFragment;

public class FragmentMaps extends AbstractFragment<MapsPresenter> {
    private final String defaultMapsSize = "1000000";
    private FragmentMapsBinding boundViews;
    private final List<TextView> tableTextViews = new ArrayList<>();
    private final List<ProgressBar> tableProgressBars = new ArrayList<>();

    @Override
    protected View createFragmentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.boundViews = FragmentMapsBinding.inflate(inflater, container, false);

        return this.boundViews.getRoot();
    }

    @Override
    protected void unbindViews() {
        this.boundViews = null;
    }

    @Override
    protected EditText getSizeView() {
        return this.boundViews.etMapsSize;
    }

    @Override
    protected String getDefaultSize() {
        return this.defaultMapsSize;
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
    protected Class<MapsPresenter> getPresenterClass() {
        return MapsPresenter.class;
    }

    @Override
    protected void prepareOperations(int size) {
        this.abstractPresenter.prepareOperations(size);
    }

    @Override
    protected void fillTextViewsList() {
        this.tableTextViews.add(this.boundViews.tvHashMapCreate);
        this.tableTextViews.add(this.boundViews.tvHashMapAddNew);
        this.tableTextViews.add(this.boundViews.tvHashMapSearchByKey);
        this.tableTextViews.add(this.boundViews.tvHashMapRemoving);
        this.tableTextViews.add(this.boundViews.tvTreeMapCreate);
        this.tableTextViews.add(this.boundViews.tvTreeMapAddNew);
        this.tableTextViews.add(this.boundViews.tvTreeMapSearchByKey);
        this.tableTextViews.add(this.boundViews.tvTreeMapRemoving);
    }

    @Override
    protected void fillProgressBarsList() {
        this.tableProgressBars.add(this.boundViews.pbHashMapCreate);
        this.tableProgressBars.add(this.boundViews.pbHashMapAddNew);
        this.tableProgressBars.add(this.boundViews.pbHashMapSearchByKey);
        this.tableProgressBars.add(this.boundViews.pbHashMapRemoving);
        this.tableProgressBars.add(this.boundViews.pbTreeMapCreate);
        this.tableProgressBars.add(this.boundViews.pbTreeMapAddNew);
        this.tableProgressBars.add(this.boundViews.pbTreeMapSearchByKey);
        this.tableProgressBars.add(this.boundViews.pbTreeMapRemoving);
    }

    @Override
    protected void setViewTags(View view) {
        this.boundViews.tvHashMapCreate.setTag(ViewTag.TV_HASH_MAP_CREATE);
        this.boundViews.pbHashMapCreate.setTag(ViewTag.PB_HASH_MAP_CREATE);
        this.boundViews.tvHashMapAddNew.setTag(ViewTag.TV_HASH_MAP_ADD_NEW);
        this.boundViews.pbHashMapAddNew.setTag(ViewTag.PB_HASH_MAP_ADD_NEW);
        this.boundViews.tvHashMapSearchByKey.setTag(ViewTag.TV_HASH_MAP_SEARCH_BY_KEY);
        this.boundViews.pbHashMapSearchByKey.setTag(ViewTag.PB_HASH_MAP_SEARCH_BY_KEY);
        this.boundViews.tvHashMapRemoving.setTag(ViewTag.TV_HASH_MAP_REMOVING);
        this.boundViews.pbHashMapRemoving.setTag(ViewTag.PB_HASH_MAP_REMOVING);

        this.boundViews.tvTreeMapCreate.setTag(ViewTag.TV_TREE_MAP_CREATE);
        this.boundViews.pbTreeMapCreate.setTag(ViewTag.PB_TREE_MAP_CREATE);
        this.boundViews.tvTreeMapAddNew.setTag(ViewTag.TV_TREE_MAP_ADD_NEW);
        this.boundViews.pbTreeMapAddNew.setTag(ViewTag.PB_TREE_MAP_ADD_NEW);
        this.boundViews.tvTreeMapSearchByKey.setTag(ViewTag.TV_TREE_MAP_SEARCH_BY_KEY);
        this.boundViews.pbTreeMapSearchByKey.setTag(ViewTag.PB_TREE_MAP_SEARCH_BY_KEY);
        this.boundViews.tvTreeMapRemoving.setTag(ViewTag.TV_TREE_MAP_REMOVING);
        this.boundViews.pbTreeMapRemoving.setTag(ViewTag.PB_TREE_MAP_REMOVING);

        this.boundViews.btEvaluate.setTag(ButtonTag.BT_MAPS);
    }

    @Override
    protected void linkViews() {
        this.linkTextViewToProgressBar.put(ViewTag.TV_HASH_MAP_CREATE, ViewTag.PB_HASH_MAP_CREATE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_HASH_MAP_ADD_NEW, ViewTag.PB_HASH_MAP_ADD_NEW);
        this.linkTextViewToProgressBar.put(ViewTag.TV_HASH_MAP_SEARCH_BY_KEY, ViewTag.PB_HASH_MAP_SEARCH_BY_KEY);
        this.linkTextViewToProgressBar.put(ViewTag.TV_HASH_MAP_REMOVING, ViewTag.PB_HASH_MAP_REMOVING);
        this.linkTextViewToProgressBar.put(ViewTag.TV_TREE_MAP_CREATE, ViewTag.PB_TREE_MAP_CREATE);
        this.linkTextViewToProgressBar.put(ViewTag.TV_TREE_MAP_ADD_NEW, ViewTag.PB_TREE_MAP_ADD_NEW);
        this.linkTextViewToProgressBar.put(ViewTag.TV_TREE_MAP_SEARCH_BY_KEY, ViewTag.PB_TREE_MAP_SEARCH_BY_KEY);
        this.linkTextViewToProgressBar.put(ViewTag.TV_TREE_MAP_REMOVING, ViewTag.PB_TREE_MAP_REMOVING);
    }
}