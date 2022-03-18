package ru.lyrian.collections_operations_time.model.lists.measurements;

import java.util.List;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.lists.AbstractOperationsList;
import ru.lyrian.collections_operations_time.model.operations.operations.AbstractOperation;
import ru.lyrian.collections_operations_time.model.operations.operations.TreeMapAddNew;
import ru.lyrian.collections_operations_time.model.operations.operations.TreeMapRemoving;
import ru.lyrian.collections_operations_time.model.operations.operations.TreeMapSearchByKey;

public class TreeMapOperations extends AbstractOperationsList {
    public TreeMapOperations() {
        this.operationList.add(new TreeMapAddNew(ViewTag.TV_TREE_MAP_ADD_NEW));
        this.operationList.add(new TreeMapSearchByKey(ViewTag.TV_TREE_MAP_SEARCH_BY_KEY));
        this.operationList.add(new TreeMapRemoving(ViewTag.TV_TREE_MAP_REMOVING));
    }

    @Override
    public List<AbstractOperation> getOperationsList() {
        return this.operationList;
    }
}
