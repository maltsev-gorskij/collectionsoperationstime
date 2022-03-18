package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class CopyOnWriteAddInTheMiddle extends AbstractOperation {
    public CopyOnWriteAddInTheMiddle(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Utility.copyOnWriteArrayList.add(Utility.copyOnWriteArrayList.size() / 2, 9999);
    }
}
