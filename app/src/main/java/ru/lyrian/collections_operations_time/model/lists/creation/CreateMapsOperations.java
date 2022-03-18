package ru.lyrian.collections_operations_time.model.lists.creation;

import java.util.List;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.lists.CreationOperationsList;
import ru.lyrian.collections_operations_time.model.operations.creation.HashMapCreate;
import ru.lyrian.collections_operations_time.model.operations.creation.TreeMapCreate;
import ru.lyrian.collections_operations_time.model.operations.operations.AbstractOperation;

public class CreateMapsOperations extends CreationOperationsList {
    public CreateMapsOperations(int size) {
        super(size);

        this.operationList.add(new HashMapCreate(ViewTag.TV_HASH_MAP_CREATE, this.size));
        this.operationList.add(new TreeMapCreate(ViewTag.TV_TREE_MAP_CREATE, this.size));
    }

    @Override
    public List<AbstractOperation> getOperationsList() {
        return this.operationList;
    }
}
