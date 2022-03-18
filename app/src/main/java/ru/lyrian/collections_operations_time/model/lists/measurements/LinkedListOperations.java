package ru.lyrian.collections_operations_time.model.lists.measurements;

import java.util.List;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.lists.AbstractOperationsList;
import ru.lyrian.collections_operations_time.model.operations.operations.AbstractOperation;
import ru.lyrian.collections_operations_time.model.operations.operations.LinkedListAddInTheBeginning;
import ru.lyrian.collections_operations_time.model.operations.operations.LinkedListAddInTheEnd;
import ru.lyrian.collections_operations_time.model.operations.operations.LinkedListAddInTheMiddle;
import ru.lyrian.collections_operations_time.model.operations.operations.LinkedListRemoveFromTheBeginning;
import ru.lyrian.collections_operations_time.model.operations.operations.LinkedListRemoveFromTheEnd;
import ru.lyrian.collections_operations_time.model.operations.operations.LinkedListRemoveFromTheMiddle;
import ru.lyrian.collections_operations_time.model.operations.operations.LinkedListSearchByValue;

public class LinkedListOperations extends AbstractOperationsList {
    public LinkedListOperations() {
        this.operationList.add(new LinkedListAddInTheBeginning(ViewTag.TV_LINKED_LIST_ADD_IN_THE_BEGINNING));
        this.operationList.add(new LinkedListAddInTheMiddle(ViewTag.TV_LINKED_LIST_ADD_IN_THE_MIDDLE));
        this.operationList.add(new LinkedListAddInTheEnd(ViewTag.TV_LINKED_LIST_ADD_IN_THE_END));
        this.operationList.add(new LinkedListSearchByValue(ViewTag.TV_LINKED_LIST_SEARCH_BY_VALUE));
        this.operationList.add(new LinkedListRemoveFromTheBeginning(ViewTag.TV_LINKED_LIST_REMOVE_FROM_THE_BEGINNING));
        this.operationList.add(new LinkedListRemoveFromTheMiddle(ViewTag.TV_LINKED_LIST_REMOVE_FROM_THE_MIDDLE));
        this.operationList.add(new LinkedListRemoveFromTheEnd(ViewTag.TV_LINKED_LIST_REMOVE_FROM_THE_END));
    }

    @Override
    public List<AbstractOperation> getOperationsList() {
        return this.operationList;
    }
}
