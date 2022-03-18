package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class TreeMapRemoving extends AbstractOperation {
    public TreeMapRemoving(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        Integer treeMapSize = Utility.treeMap.size();
        Utility.treeMap.remove(treeMapSize / 2);
    }
}
