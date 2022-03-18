package ru.lyrian.collections_operations_time.presentation.collections;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ru.lyrian.collections_operations_time.enumerations.FragmentTag;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.IMeasurementContract;
import ru.lyrian.collections_operations_time.model.lists.AbstractOperationsList;
import ru.lyrian.collections_operations_time.model.lists.creation.CreateCollectionsOperations;
import ru.lyrian.collections_operations_time.model.lists.measurements.ArrayListOperations;
import ru.lyrian.collections_operations_time.model.lists.measurements.CopyOnWriteArrayListOperations;
import ru.lyrian.collections_operations_time.model.lists.measurements.LinkedListOperations;
import ru.lyrian.collections_operations_time.model.operations.Operations;
import ru.lyrian.collections_operations_time.presentation.AbstractPresenter;
import ru.lyrian.collections_operations_time.util.Utility;

public class CollectionsPresenter extends AbstractPresenter  {
    @Inject
    public CollectionsPresenter(IMeasurementContract.IMeasurementsStorage measurementsStorage) {
        super(measurementsStorage);
    }

    @Override
    public FragmentTag getFragmentTag() {
        return FragmentTag.COLLECTIONS;
    }

    @Override
    protected Operations getOperations(int size) {
        Utility.emptyLists();
        FragmentTag fragmentTag = getFragmentTag();
        AbstractOperationsList createCollectionsOperations = new CreateCollectionsOperations(size);
        Map<ViewTag, AbstractOperationsList> measurementOperationsLists = new HashMap<>();
        measurementOperationsLists.put(ViewTag.TV_ARRAY_LIST_CREATE, new ArrayListOperations());
        measurementOperationsLists.put(ViewTag.TV_LINKED_LIST_CREATE, new LinkedListOperations());
        measurementOperationsLists.put(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_CREATE, new CopyOnWriteArrayListOperations());

        return new Operations(fragmentTag, createCollectionsOperations, measurementOperationsLists);
    }
}