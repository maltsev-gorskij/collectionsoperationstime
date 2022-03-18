package ru.lyrian.collections_operations_time.model.operations.creation;

import ru.lyrian.collections_operations_time.enumerations.Collections;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class HashMapCreate extends AbstractCreator {
    public HashMapCreate(ViewTag viewTag, int size) {
        super(viewTag, size);
    }

    @Override
    protected void executeInternal() {
        Utility.getFilledCollection(Collections.HASH_MAP, size);
    }
}
