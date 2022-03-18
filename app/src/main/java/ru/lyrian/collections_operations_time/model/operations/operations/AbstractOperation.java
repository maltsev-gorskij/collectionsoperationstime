package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.Measurement;

public abstract class AbstractOperation {
    protected final ViewTag viewTag;

    protected AbstractOperation(ViewTag viewTag) {
        this.viewTag = viewTag;
    }

    public Measurement execute() {
        long startTime = System.currentTimeMillis();
        executeInternal();
        long endTime = System.currentTimeMillis();
        int executionTime = (int) (endTime - startTime);
        return new Measurement(this.viewTag, executionTime);
    }

    protected abstract void executeInternal();
}
