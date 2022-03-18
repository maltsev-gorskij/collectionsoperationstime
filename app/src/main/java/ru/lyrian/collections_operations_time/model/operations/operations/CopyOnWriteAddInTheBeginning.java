package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class CopyOnWriteAddInTheBeginning extends AbstractOperation {
    public CopyOnWriteAddInTheBeginning(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Utility.copyOnWriteArrayList.add(0, 9999);
    }
}
