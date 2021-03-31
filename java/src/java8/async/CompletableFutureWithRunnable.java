package java8.async;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class CompletableFutureWithRunnable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Completable Future with no executorService - executes in common ForkJoinPool
		Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
		CompletableFuture.runAsync(runnable);
		
		
		//Using ExecutorService with CompletableFuture - runs in thread pool
		ExecutorService executor = Executors.newSingleThreadExecutor();
		CompletableFuture.runAsync(runnable, executor);
	}
}
