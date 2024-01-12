package com.algo.cache;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


class LRUCacheTest {

    @Test
    void shouldReturnOnlyTheMostRecentItemsFromCacheWhenTheAmountOfItemsGraterThanCapacitySize() {
        LRUCache<Integer, String> cacheV2 = new LRUCache<>(3);
        cacheV2.put(1, "Andre");
        cacheV2.put(2, "Karol");
        cacheV2.put(3, "Joe");
        cacheV2.put(4, "Lucas");

        cacheV2.display();

        assertAll(
                () -> assertFalse(cacheV2.get(1).isPresent()),
                () -> assertTrue(cacheV2.get(2).isPresent()),
                () -> assertTrue(cacheV2.get(3).isPresent()),
                () -> assertTrue(cacheV2.get(4).isPresent())
        );
    }

    @Test
    void shouldKeepTheMostRecentItemsFromCacheWhenItWasGotLast() {
        LRUCache<Integer, String> cacheV2 = new LRUCache<>(3);
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

    @Test
    void shouldReturnEmptyWhenItemNotExists() {
        LRUCache<Integer, String> cacheV2 = new LRUCache<>(3);

        assertTrue(cacheV2.get(1).isEmpty());
    }

    @Test
    void shouldRunInMultiThreadWhenPutDataInConcurrentToCacheThenNoDataLost() throws InterruptedException {
        final int size = 50;
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        Cache<Integer, String> cache = new LRUCache<>(size);

        CountDownLatch countDownLatch = new CountDownLatch(size);

        try {
            IntStream.range(0, size).<Runnable>mapToObj(key -> () -> {
                cache.put(key, "value " + key);
                countDownLatch.countDown();
            }).forEach(executorService::submit);

            countDownLatch.await();
        } finally {

            executorService.shutdown();
        }

        assertEquals(size, cache.size());

        IntStream.range(0, size)
                .forEach(index -> {
                    assertTrue(cache.get(index).isPresent());
                    assertEquals("value " + index, cache.get(index).get());
                });

    }
}