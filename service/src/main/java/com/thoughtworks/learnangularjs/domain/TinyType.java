package com.thoughtworks.learnangularjs.domain;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

public abstract class TinyType<T extends Comparable & Serializable> implements Comparable<TinyType<T>>, Serializable {

    private final T value;

    public TinyType(T value) {
        this.value = Preconditions.checkNotNull(value);
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value == null ? "" : value.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other.getClass().equals(this.getClass()))) {
            return false;
        }
        TinyType that = (TinyType) other;
        return new EqualsBuilder().append(this.getValue(), that.getValue()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getValue()).toHashCode();
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(TinyType<T> that) {
        if (this.getClass() != that.getClass()) {
            throw new IllegalArgumentException(String.format("Trying to compare instance of [%s] with instance of [%s]",
                                                             this.getClass().getSimpleName(),
                                                             that.getClass().getSimpleName()));
        }
        return this.value.compareTo(that.value);
    }
}
