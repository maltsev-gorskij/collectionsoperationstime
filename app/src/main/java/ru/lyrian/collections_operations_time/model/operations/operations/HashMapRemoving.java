package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class HashMapRemoving extends AbstractOperation {
    public HashMapRemoving(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Integer hashMapSize = Utility.hashMap.size();
        Utility.hashMap.remove(hashMapSize / 2);
    }
}
