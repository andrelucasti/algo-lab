package com.algo.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LFUCacheTest {
    @Test
    void shouldStoreTheItemsWhichWasFetchedFrequently() {

        LFUCache<Integer, String> lfuCache = new LFUCache<>(3);
        lfuCache.put(1, "Andre");
        lfuCache.put(2, "Lucas");
        lfuCache.put(3, "Joao");

        //Andre
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.get(1);
        //Lucas
        lfuCache.get(2);
        lfuCache.get(2);
        lfuCache.get(2);
        lfuCache.get(2);
        //Joao
        lfuCache.get(3);

        lfuCache.put(4, "Karol");
        lfuCache.put(5, "Benedita");

        lfuCache.display();

        Assertions.assertAll(
                ()-> Assertions.assertTrue(lfuCache.get(1).isPresent()),
                ()-> Assertions.assertTrue(lfuCache.get(2).isPresent()),
                ()-> Assertions.assertTrue(lfuCache.get(5).isPresent()),
                ()-> Assertions.assertFalse(lfuCache.get(3).isPresent()),
                ()-> Assertions.assertFalse(lfuCache.get(4).isPresent())
        );

    }

    @Test
    void shouldReturnEmptyWhenItemNotExists() {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(3);

        assertTrue(lfuCache.get(1).isEmpty());
    }

    @Test
    void shouldRunInMultiThreadWhenPutDataInConcurrentToCacheThenNoDataLost() throws InterruptedException {
        final int size = 50;
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        Cache<Integer, String> cache = new LFUCache<>(size);

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