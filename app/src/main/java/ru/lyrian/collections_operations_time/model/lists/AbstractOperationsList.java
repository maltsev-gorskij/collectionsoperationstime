package ru.lyrian.collections_operations_time.model.lists;

import java.util.ArrayList;
import java.util.List;

import ru.lyrian.collections_operations_time.model.operations.operations.AbstractOperation;

public abstract class AbstractOperationsList {
    protected List<AbstractOperation> operationList = new ArrayList<>();

    public abstract List<AbstractOperation> getOperationsList();
}
