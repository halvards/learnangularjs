package com.thoughtworks.learnangularjs.domain;

import com.google.common.base.Preconditions;

public class TaskType {
    private final String description;

    public TaskType(String description) {
        this.description = Preconditions.checkNotNull(description);
    }

    public String getDescription() {
        return description;
    }
}
