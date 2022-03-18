package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class LinkedListAddInTheMiddle extends AbstractOperation {
    public LinkedListAddInTheMiddle(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Utility.linkedList.add(Utility.linkedList.size() / 2, 9999);
    }
}
