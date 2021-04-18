package com.teambition.utils.sort;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Copyright ©2018 by Teambition
 */
public class SortStrategies<T> {

    private List<SortStrategy<T>> strategies;

    private SortStrategies(List<SortStrategy<T>> sortStrategies) {
        this.strategies = sortStrategies;
    }

    @NotNull
    @SafeVarargs
    public static <T> SortStrategies<T> assemble(@NotNull  SortStrategy<T> firstSortStrategy,
                                                 SortStrategy<T>... sortStrategyArray) {
        List<SortStrategy<T>> strategies = new ArrayList<>();
        strategies.add(firstSortStrategy);
        strategies.addAll(Arrays.asList(sortStrategyArray));
        return new SortStrategies<>(strategies);
    }

    public Comparator<T> buildComparator() {
        return (o1, o2) -> {
            for (int i = 0; i < strategies.size(); i++) {
                SortStrategy<T> sortStrategy = strategies.get(i);
                if (sortStrategy == null) {
                    throw new IllegalArgumentException("encountered a null sort strategy, index: " + i);
                }
                int result = sortStrategy.compare(o1, o2);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        };
    }

}