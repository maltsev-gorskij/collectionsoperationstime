package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class TreeMapAddNew extends AbstractOperation {
    public TreeMapAddNew(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Integer treeMapSize = Utility.treeMap.size();
        Utility.treeMap.put(treeMapSize, treeMapSize);
    }
}
