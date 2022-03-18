package ru.lyrian.collections_operations_time.model.operations.creation;

import ru.lyrian.collections_operations_time.enumerations.Collections;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class CopyOnWriteArrayListCreate extends AbstractCreator {
    public CopyOnWriteArrayListCreate(ViewTag viewTag, int size) {
        super(viewTag, size);
    }

    @Override
    protected void executeInternal() {
        Utility.getFilledCollection(Collections.COPY_ON_WRITE_ARRAY_LIST, this.size);
    }
}
