package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class ArrayListAddInTheEnd extends AbstractOperation {
    public ArrayListAddInTheEnd(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Utility.arrayList.add(Utility.arrayList.size() - 1, 9999);
    }
}
