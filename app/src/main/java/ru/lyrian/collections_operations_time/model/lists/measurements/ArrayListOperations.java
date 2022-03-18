package ru.lyrian.collections_operations_time.model.lists.measurements;

import java.util.List;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.lists.AbstractOperationsList;
import ru.lyrian.collections_operations_time.model.operations.operations.AbstractOperation;
import ru.lyrian.collections_operations_time.model.operations.operations.ArrayListAddInTheBeginning;
import ru.lyrian.collections_operations_time.model.operations.operations.ArrayListAddInTheEnd;
import ru.lyrian.collections_operations_time.model.operations.operations.ArrayListAddInTheMiddle;
import ru.lyrian.collections_operations_time.model.operations.operations.ArrayListRemoveFromTheBeginning;
import ru.lyrian.collections_operations_time.model.operations.operations.ArrayListRemoveFromTheEnd;
import ru.lyrian.collections_operations_time.model.operations.operations.ArrayListRemoveFromTheMiddle;
import ru.lyrian.collections_operations_time.model.operations.operations.ArrayListSearchByValue;

public class ArrayListOperations extends AbstractOperationsList {
    public ArrayListOperations() {
        this.operationList.add(new ArrayListAddInTheBeginning(ViewTag.TV_ARRAY_LIST_ADD_IN_THE_BEGINNING));
        this.operationList.add(new ArrayListAddInTheMiddle(ViewTag.TV_ARRAY_LIST_ADD_IN_THE_MIDDLE));
        this.operationList.add(new ArrayListAddInTheEnd(ViewTag.TV_ARRAY_LIST_ADD_IN_THE_END));
        this.operationList.add(new ArrayListSearchByValue(ViewTag.TV_ARRAY_LIST_SEARCH_BY_VALUE));
        this.operationList.add(new ArrayListRemoveFromTheBeginning(ViewTag.TV_ARRAY_LIST_REMOVE_FROM_THE_BEGINNING));
        this.operationList.add(new ArrayListRemoveFromTheMiddle(ViewTag.TV_ARRAY_LIST_REMOVE_FROM_THE_MIDDLE));
        this.operationList.add(new ArrayListRemoveFromTheEnd(ViewTag.TV_ARRAY_LIST_REMOVE_FROM_THE_END));

    }

    @Override
    public List<AbstractOperation> getOperationsList() {
        return this.operationList;
    }
}
