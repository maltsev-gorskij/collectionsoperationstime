package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class LinkedListRemoveFromTheBeginning extends AbstractOperation {
    public LinkedListRemoveFromTheBeginning(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Utility.linkedList.remove(0);
    }
}
