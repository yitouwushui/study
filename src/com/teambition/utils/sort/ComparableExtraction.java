package com.teambition.utils.sort;

import org.jetbrains.annotations.NotNull;

/**
 * Copyright ©2018 by Teambition
 */
public interface ComparableExtraction<T, E extends Comparable<? super E>> {

    /**
     * Object -> E Comparable<E>
     *
     * @param t Object
     * @return E
     */
    E extract(@NotNull T t);
}