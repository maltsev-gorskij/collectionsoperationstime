package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class ArrayListRemoveFromTheEnd extends AbstractOperation {
    public ArrayListRemoveFromTheEnd(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Utility.arrayList.remove(Utility.arrayList.size() - 1);
    }
}
