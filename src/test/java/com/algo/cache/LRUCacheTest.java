package com.algo.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LRUCacheV2Test {

    @Test
    void shouldReturnOnlyTheMostRecentItemsFromCacheWhenTheAmountOfItemsGraterThanCapacitySize() {
        LRUCacheV2<Integer, String> cacheV2 = new LRUCacheV2<>(3);
        cacheV2.put(1, "Andre");
        cacheV2.put(2, "Karol");
        cacheV2.put(3, "Joe");
        cacheV2.put(4, "Lucas");

        assertAll(
                () -> assertFalse(cacheV2.get(1).isPresent()),
                () -> assertTrue(cacheV2.get(2).isPresent()),
                () -> assertTrue(cacheV2.get(3).isPresent()),
                () -> assertTrue(cacheV2.get(4).isPresent())
        );
    }

    @Test
    void shouldKeepTheMostRecentItemsFromCacheWhenItWasGotLast() {
        LRUCacheV2<Integer, String> cacheV2 = new LRUCacheV2<>(3);
        cacheV2.put(1, "Andre");
        cacheV2.put(2, "Karol");
        cacheV2.put(3, "Joe");

        cacheV2.get(1); //Andre
        cacheV2.get(3); //Joe
        cacheV2.get(1); //Andre

        cacheV2.put(4, "Lucas");
        cacheV2.put(5, "Fernando");

        assertAll(
                () -> assertTrue(cacheV2.get(4).isPresent()),
                () -> assertTrue(cacheV2.get(5).isPresent()),
                () -> assertTrue(cacheV2.get(1).isPresent()),
                () -> assertFalse(cacheV2.get(3).isPresent()),
                () -> assertFalse(cacheV2.get(2).isPresent())
        );
    }
}