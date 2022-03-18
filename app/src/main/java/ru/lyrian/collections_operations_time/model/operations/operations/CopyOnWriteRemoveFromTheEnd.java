package ru.lyrian.collections_operations_time.model.operations.operations;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.util.Utility;

public class CopyOnWriteRemoveFromTheEnd extends AbstractOperation {
    public CopyOnWriteRemoveFromTheEnd(ViewTag viewTag) {
        super(viewTag);
    }

    @Override
    protected void executeInternal() {
        int elementForRemoval = Utility.copyOnWriteArrayList.get(Utility.copyOnWriteArrayList.size() - 1);
        Utility.copyOnWriteArrayList.forEach(element -> {
            if(element == elementForRemoval) {
                Utility.copyOnWriteArrayList.remove(element);
            }
        });
    }
}
