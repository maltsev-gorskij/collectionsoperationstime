package ru.lyrian.collections_operations_time.model.operations.creation;

import ru.lyrian.collections_operations_time.enumerations.Collections;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class TreeMapCreate extends AbstractCreator {
    public TreeMapCreate(ViewTag viewTag, int size) {
        super(viewTag, size);
    }

    @Override
    protected void executeInternal() {
        Utility.getFilledCollection(Collections.TREE_MAP, size);
    }
}
