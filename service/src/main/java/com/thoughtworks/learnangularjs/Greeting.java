package com.thoughtworks.learnangularjs;

import com.google.common.base.Preconditions;

public class Greeting {
    private final String name;
    private final String message;

    public Greeting(String name) {
        this.name = Preconditions.checkNotNull(name);
        this.message = Math.random() < 0.5 ? "What a wonderful day!" : "It's great to be alive!";
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
