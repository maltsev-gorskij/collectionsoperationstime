package ru.lyrian.collections_operations_time.model.operations.creation;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.operations.operations.AbstractOperation;

public abstract class AbstractCreator extends AbstractOperation {
    final int size;

    public AbstractCreator(ViewTag viewTag, int size) {
        super(viewTag);
        this.size = size;
    }
}