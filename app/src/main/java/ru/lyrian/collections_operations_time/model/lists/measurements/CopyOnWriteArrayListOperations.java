package ru.lyrian.collections_operations_time.model.lists.measurements;

import java.util.List;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.lists.AbstractOperationsList;
import ru.lyrian.collections_operations_time.model.operations.operations.AbstractOperation;
import ru.lyrian.collections_operations_time.model.operations.operations.CopyOnWriteAddInTheBeginning;
import ru.lyrian.collections_operations_time.model.operations.operations.CopyOnWriteAddInTheEnd;
import ru.lyrian.collections_operations_time.model.operations.operations.CopyOnWriteAddInTheMiddle;
import ru.lyrian.collections_operations_time.model.operations.operations.CopyOnWriteRemoveFromTheBeginning;
import ru.lyrian.collections_operations_time.model.operations.operations.CopyOnWriteRemoveFromTheEnd;
import ru.lyrian.collections_operations_time.model.operations.operations.CopyOnWriteRemoveFromTheMiddle;
import ru.lyrian.collections_operations_time.model.operations.operations.CopyOnWriteSearchByValue;

public class CopyOnWriteArrayListOperations extends AbstractOperationsList {
    public CopyOnWriteArrayListOperations() {
        this.operationList.add(new CopyOnWriteAddInTheBeginning(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_BEGINNING));
        this.operationList.add(new CopyOnWriteAddInTheMiddle(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_MIDDLE));
        this.operationList.add(new CopyOnWriteAddInTheEnd(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_ADD_IN_THE_END));
        this.operationList.add(new CopyOnWriteSearchByValue(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_SEARCH_BY_VALUE));
        this.operationList.add(new CopyOnWriteRemoveFromTheBeginning(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_BEGINNING));
        this.operationList.add(new CopyOnWriteRemoveFromTheMiddle(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_MIDDLE));
        this.operationList.add(new CopyOnWriteRemoveFromTheEnd(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_REMOVE_FROM_THE_END));
    }

    @Override
    public List<AbstractOperation> getOperationsList() {
        return this.operationList;
    }
}
