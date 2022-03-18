package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class ArrayListSearchByValue extends AbstractOperation {
    public ArrayListSearchByValue(ViewTag viewTag) {
        super(viewTag);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    protected void executeInternal() {
        Utility.arrayList.get(Utility.arrayList.size() / 2);
    }
}
