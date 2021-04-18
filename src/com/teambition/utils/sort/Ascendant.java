package com.teambition.utils.sort;

/**
 * Copyright ©2018 by Teambition
 */
final class Ascendant<T, E extends Comparable<? super E>> extends SortStrategy<T> {

    private ComparableExtraction<T, E> extraction;

    Ascendant(ComparableExtraction<T, E> extraction) {
        this.extraction = extraction;
    }

    @Override
    public int compare(T left, T right) {
        E comparableLeft = extraction.extract(left);
        E comparableRight = extraction.extract(right);
        if (comparableLeft != null && comparableRight != null) {
            return comparableLeft.compareTo(comparableRight);
        } else if (comparableLeft == comparableRight) {
            return 0;
        } else if (comparableLeft == null) {
            return 1;
        } else {
            return -1;
        }
    }

}
