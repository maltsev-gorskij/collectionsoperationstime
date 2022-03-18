package ru.lyrian.collections_operations_time.presentation.maps;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ru.lyrian.collections_operations_time.enumerations.FragmentTag;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.IMeasurementContract;
import ru.lyrian.collections_operations_time.model.lists.AbstractOperationsList;
import ru.lyrian.collections_operations_time.model.lists.creation.CreateMapsOperations;
import ru.lyrian.collections_operations_time.model.lists.measurements.HashMapOperations;
import ru.lyrian.collections_operations_time.model.lists.measurements.TreeMapOperations;
import ru.lyrian.collections_operations_time.model.operations.Operations;
import ru.lyrian.collections_operations_time.presentation.AbstractPresenter;
import ru.lyrian.collections_operations_time.util.Utility;

public class MapsPresenter extends AbstractPresenter {
    @Inject
    public MapsPresenter(IMeasurementContract.IMeasurementsStorage measurementsStorage) {
        super(measurementsStorage);
    }

    @Override
    public FragmentTag getFragmentTag() {
        return FragmentTag.MAPS;
    }

    @Override
    protected Operations getOperations(int size) {
        Utility.emptyMaps();
        FragmentTag fragmentTag = getFragmentTag();
        CreateMapsOperations createMapsOperations = new CreateMapsOperations(size);
        Map<ViewTag, AbstractOperationsList> measurementOperationsLists = new HashMap<>();
        measurementOperationsLists.put(ViewTag.TV_HASH_MAP_CREATE, new HashMapOperations());
        measurementOperationsLists.put(ViewTag.TV_TREE_MAP_CREATE, new TreeMapOperations());

        return new Operations(fragmentTag, createMapsOperations, measurementOperationsLists);
    }
}