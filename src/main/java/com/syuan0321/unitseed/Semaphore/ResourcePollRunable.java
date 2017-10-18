package com.syuan0321.unitseed.Semaphore;

public class ResourcePollRunable implements Runnable {
	private ResourceExample resourceExample;
	private int idx;
	private boolean done;
	
	public ResourcePollRunable(ResourceExample resourceExample, int index) {
		this.resourceExample = resourceExample;
		this.idx = index;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Thread No. " + idx + " is running. " + resourceExample.getStatus() );
			Thread.sleep(1000);
			this.done = true;
			System.out.println("Thread No. " + idx + " is done and rdy to check out. ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isDone(){
		return this.done;
	}
	
}