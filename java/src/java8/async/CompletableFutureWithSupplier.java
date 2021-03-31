package java8.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureWithSupplier {

	public static void main(String[] args){
	ExecutorService executor = Executors.newSingleThreadExecutor();
	
	Supplier<String> supplier = () -> {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Thread.currentThread().getName();
		};
	
    //---------------completableFuture.complete()--------------------------
	// if called before the task is completed, overrides the value. Else has no effect if called after task is completed
	CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier,executor);
	
	completableFuture.complete("Too long!");
	String result = completableFuture.join();
	System.out.println("Result = " + result);
	
	//completableFuture.complete("Too long!");
	//System.out.println("Result = " + result);
	//----------------------------------------------------------------------
	
	//---------------completableFuture.obtrude-----------------------------
	//called in error conditions
	//overrides the result irrespective of the task has completed or not
	System.out.println("------Obtrude results--------");
	completableFuture.obtrudeValue("Too long!");
	String result1 = completableFuture.join();
	System.out.println("Result =" + result1);
	
	
	result1 = completableFuture.join();
	System.out.println("Result =" + result1);
	executor.shutdown();
	}
}
