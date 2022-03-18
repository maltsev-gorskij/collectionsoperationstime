package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class LinkedListAddInTheBeginning extends AbstractOperation {
    public LinkedListAddInTheBeginning(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Utility.linkedList.add(0, 9999);
    }
}
