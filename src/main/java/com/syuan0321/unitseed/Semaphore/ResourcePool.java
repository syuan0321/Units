package com.syuan0321.unitseed.Semaphore;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.xml.internal.ws.Closeable;

/**
 * Blockingqueue for a thread-safe resource pool 
 * 					VS 
 * ThreadPoolExecutor(int corePoolSize, int maximumPoolSize,long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
 * 
 * 
 * **/

public class ResourcePool {
	protected final BlockingQueue<ResourceExample> pool;
	private ResourcePool(int poolSize){ 
		this.pool  = new ArrayBlockingQueue<ResourceExample>(poolSize); 
	}
	
	public ResourceExample acquire(){
		ResourceExample resource = pool.poll();//take first element of queue [FIFO]. poll()<==>take() [return null VS if no then wait infinetely till get it] ; offer() <==> take();
		return resource == null ? create() : resource;
	}
	
	public void recycle(ResourceExample resource){
		if(!pool.offer(resource)){//try to store resource back in queue, if successful then return true [offer() vs put()]
			close(resource);
		}
	}
	
	protected void close(ResourceExample resource){
		resource.setStatus(44);
		//set resource status to be ready to use
	}
	
	protected ResourceExample create(){
		ResourceExample newInstance = new ResourceExample();
//		newInstance.setStatus(ResourceExample.IN_USE);
		newInstance.setStatus(33);
		return newInstance;
	}
	
	
	public static void main(String[] args) {
		ResourcePool poolInstance = new ResourcePool(2);
		
		ResourcePollRunable threadRunA = new ResourcePollRunable(poolInstance.acquire(), 1);
		ResourcePollRunable threadRunB = new ResourcePollRunable(poolInstance.acquire(), 2);
		ResourcePollRunable threadRunC = new ResourcePollRunable(poolInstance.acquire(), 3);
		ResourcePollRunable threadRunD = new ResourcePollRunable(poolInstance.acquire(), 4);
		ResourcePollRunable threadRunE = new ResourcePollRunable(poolInstance.acquire(), 5);
		threadRunC.run();
		threadRunB.run();
		threadRunA.run();
		threadRunD.run();
		threadRunE.run();
		
		
/*		for (int i = 0; i < 10; i++) {
			System.out.println("XXX : " + i);
			ResourceExample instance = poolInstance.acquire();
			ResourcePollRunable threadRun = new ResourcePollRunable(instance, i);
			threadRun.run();
			if(threadRun.isDone()){
				poolInstance.recycle(instance);
			}
		}
*/		
	}
	
	
}
