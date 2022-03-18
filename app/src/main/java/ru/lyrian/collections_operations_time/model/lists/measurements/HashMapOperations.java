package ru.lyrian.collections_operations_time.model.lists.measurements;

import java.util.List;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.lists.AbstractOperationsList;
import ru.lyrian.collections_operations_time.model.operations.operations.AbstractOperation;
import ru.lyrian.collections_operations_time.model.operations.operations.HashMapAddNew;
import ru.lyrian.collections_operations_time.model.operations.operations.HashMapRemoving;
import ru.lyrian.collections_operations_time.model.operations.operations.HashMapSearchByKey;

public class HashMapOperations extends AbstractOperationsList {
    public HashMapOperations() {
        this.operationList.add(new HashMapAddNew(ViewTag.TV_HASH_MAP_ADD_NEW));
        this.operationList.add(new HashMapSearchByKey(ViewTag.TV_HASH_MAP_SEARCH_BY_KEY));
        this.operationList.add(new HashMapRemoving(ViewTag.TV_HASH_MAP_REMOVING));
    }

    @Override
    public List<AbstractOperation> getOperationsList() {
        return this.operationList;
    }
}
