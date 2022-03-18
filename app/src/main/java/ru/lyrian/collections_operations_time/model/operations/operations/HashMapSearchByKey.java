package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class HashMapSearchByKey extends AbstractOperation {
    public HashMapSearchByKey(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Integer hashMapSize = Utility.hashMap.size();
        Utility.hashMap.get(hashMapSize / 2);
    }
}

