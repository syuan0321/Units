package com.syuan0321.unitseed.Semaphore;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.sun.xml.internal.ws.Closeable;

/**
 * Blockingqueue for a thread-safe resource pool VS ThreadPoolExecutor
 * 
 * 
 * 
 * **/

public abstract class ResourcePool {
	private final BlockingQueue<ResourceExample> pool;
	private ResourcePool(int poolSize){ 
		this.pool  = new ArrayBlockingQueue<ResourceExample>(poolSize); 
	}
	
	public ResourceExample acquire(){
		ResourceExample resource = pool.poll();//take first element of queue [FIFO]. poll()<==>take() [return null VS if no then wait infinetely till get it] ; offer() <==> take();
		return resource == null ? create() : resource;
	}
	
	public void recycle(ResourceExample resource){
		if(!pool.offer(resource)){//try to store resource back in queue, if successful then retur true
			close(resource);
		}
	}
	
	
	protected abstract ResourceExample create();
	protected abstract void close(ResourceExample resource);
}
