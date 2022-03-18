package ru.lyrian.collections_operations_time.model.lists.creation;

import java.util.List;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.lists.CreationOperationsList;
import ru.lyrian.collections_operations_time.model.operations.creation.ArrayListCreate;
import ru.lyrian.collections_operations_time.model.operations.creation.CopyOnWriteArrayListCreate;
import ru.lyrian.collections_operations_time.model.operations.creation.LinkedListCreate;
import ru.lyrian.collections_operations_time.model.operations.operations.AbstractOperation;

public class CreateCollectionsOperations extends CreationOperationsList {
    public CreateCollectionsOperations(int size) {
        super(size);

        this.operationList.add(new ArrayListCreate(ViewTag.TV_ARRAY_LIST_CREATE, this.size));
        this.operationList.add(new LinkedListCreate(ViewTag.TV_LINKED_LIST_CREATE, this.size));
        this.operationList.add(new CopyOnWriteArrayListCreate(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_CREATE, this.size));
    }

    @Override
    public List<AbstractOperation> getOperationsList() {
        return this.operationList;
    }
}
