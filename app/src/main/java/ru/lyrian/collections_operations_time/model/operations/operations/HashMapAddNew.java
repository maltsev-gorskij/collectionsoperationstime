package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class HashMapAddNew extends AbstractOperation {
    public HashMapAddNew(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Integer hashMapSize = Utility.hashMap.size();
        Utility.hashMap.put(hashMapSize, hashMapSize);
    }
}
