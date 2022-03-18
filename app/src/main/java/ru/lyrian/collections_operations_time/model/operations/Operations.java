package ru.lyrian.collections_operations_time.model.operations;

import java.util.Map;

import ru.lyrian.collections_operations_time.enumerations.FragmentTag;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.lists.AbstractOperationsList;

public class Operations {
    private final FragmentTag fragmentTag;
    private final AbstractOperationsList creationOperations;
    private final Map<ViewTag, AbstractOperationsList> measurementOperations;

    public Operations(FragmentTag fragmentTag,
                      AbstractOperationsList creationOperations,
                      Map<ViewTag, AbstractOperationsList> measurementOperations) {
        this.fragmentTag = fragmentTag;
        this.creationOperations = creationOperations;
        this.measurementOperations = measurementOperations;
    }

    public FragmentTag getFragmentTag() {
        return fragmentTag;
    }

    public AbstractOperationsList getCreationOperations() {
        return this.creationOperations;
    }

    public Map<ViewTag, AbstractOperationsList> getMeasurementOperations() {
        return this.measurementOperations;
    }
}