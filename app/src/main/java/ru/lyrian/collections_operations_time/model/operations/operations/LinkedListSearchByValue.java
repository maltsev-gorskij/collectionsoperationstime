package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class LinkedListSearchByValue extends AbstractOperation {
    public LinkedListSearchByValue(ViewTag viewTag) {
        super(viewTag);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    protected void executeInternal() {
        Utility.linkedList.get(Utility.linkedList.size() / 2);
    }
}
