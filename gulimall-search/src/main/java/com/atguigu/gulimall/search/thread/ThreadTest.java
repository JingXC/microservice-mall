package com.atguigu.gulimall.search.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                50,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(()->{
            System.out.println("任务被执行...."+ Thread.currentThread().getName());
        });
        executor.execute(()->{
            System.out.println("任务被执行...."+ Thread.currentThread().getName());
        });*/
        /*CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("当前线程，" + Thread.currentThread().getName());
            int i = 10 / 2;
            System.out.println("运行结果，" + i);
        },executorService);*/
        /*CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程，" + Thread.currentThread().getName());
            int i = 10 / 2;
            System.out.println("运行结果，" + i);
            return i;
        }, executorService).whenComplete((res, exception) -> {
            System.out.println("异步任务成功完成了...结果是：" + res + "；异常是：" + exception);
        }).exceptionally(throwable -> {
            return 10;
        });
        Integer integer = completableFuture.get();
        System.out.println(integer);*/


        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1开始" + Thread.currentThread().getName());
            int i = 10 / 2;
            System.out.println("任务1结束");
            return i;
        }, executorService);

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2开始" + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("任务2结束");
            return "hello";
        }, executorService);
        CompletableFuture<String> thenned = completableFuture1.thenCombineAsync(completableFuture2, (f1, f2) -> {
            return f1 + f2;
        }, executorService);
        System.out.println(thenned.get());

        System.out.println("main....end....");
    }

}
