package com.teambition.utils.sort;


/**
 * Copyright ©2018 by Teambition
 */
final class Descendant<T, E extends Comparable<? super E>> extends SortStrategy<T> {

    private ComparableExtraction<T, E> extraction;

    Descendant(ComparableExtraction<T, E> extraction) {
        this.extraction = extraction;
    }

    public static <T, E extends Comparable<? super E>> Descendant by(ComparableExtraction<T, E> extraction) {
        return new Descendant<>(extraction);
    }

    @Override
    public int compare(T left, T right) {
        E comparableLeft = extraction.extract(left);
        E comparableRight = extraction.extract(right);
        if (comparableLeft != null && comparableRight != null) {
            return -1 * comparableLeft.compareTo(comparableRight);
        } else if ((comparableLeft == comparableRight)) {
            return 0;
        } else if (comparableLeft == null) {
            return 1;
        } else {
            return -1;
        }
    }
}