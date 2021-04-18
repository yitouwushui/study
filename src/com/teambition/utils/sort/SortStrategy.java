package com.teambition.utils.sort;


/**
 * Copyright ©2018 by Teambition
 */
public abstract class SortStrategy<T> {

    public static <T, E extends Comparable<? super E>> SortStrategy<T> ascendant(
            ComparableExtraction<T, E> extraction) {

        return new Ascendant<>(extraction);
    }

    public static <T, E extends Comparable<? super E>> SortStrategy<T> descendant(
            ComparableExtraction<T, E> extraction) {
        return new Descendant<>(extraction);
    }

    /**
     * @param left
     * @param right
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    abstract int compare(T left, T right);
}