package ru.lyrian.collections_operations_time.model;

import ru.lyrian.collections_operations_time.enumerations.ViewTag;

public class Measurement {
    private final ViewTag viewTag;
    private final int executionTime;

    public Measurement(ViewTag viewTag, int executionTime) {
        this.viewTag = viewTag;
        this.executionTime = executionTime;
    }

    public ViewTag getViewTag() {
        return viewTag;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "viewTag=" + viewTag +
                ", executionTime=" + executionTime +
                '}';
    }
}
