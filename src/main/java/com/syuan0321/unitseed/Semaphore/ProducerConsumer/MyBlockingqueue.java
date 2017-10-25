/**
 * Blockingqueue is an implementation of ReentrantLock achievement, doesn't accept NULL element throw nullPointException
 * 
 * It is an interface, implementation class have:
 * 1.ArrayBlockingQueue、2.DelayQueue、 3.LinkedBlockingDeque、4.LinkedBlockingQueue、
 * 
 * 5.PriorityBlockingQueue [not FIFO, have compaire interface to determine order] 
 * 
 * 6.SynchronousQueue
 * 
 * Condition.await() VS Object.wait()/notify
 * Condition is interuptable, no synchronized block required.
 * 
 * */
package com.syuan0321.unitseed.Semaphore.ProducerConsumer;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingqueue<E> implements BlockingQueue<E>{
	/**this count is used to count how many elements in queue*/
	private int count;
	
    /** The queued items */
	private static final int DEFAULT_ITEM_CAPCITY = 10;
    private final Object[] items;	
    
    /** take/put idx*/
    int takeIndex,putIndex;
	
    /**daemon lock*/
    private final ReentrantLock mainLock;
    
    /** Condition for waiting takes */
    private final Condition notEmpty;
    /** Condition for waiting puts */
    private final Condition notFull;
    
	
	public MyBlockingqueue() {
		this.mainLock =  new ReentrantLock();
        this.notEmpty = this.mainLock.newCondition();
        this.notFull =  this.mainLock.newCondition();
		
        this.items  = new Object[DEFAULT_ITEM_CAPCITY];
	}

	public MyBlockingqueue(int capacity) {
		this.mainLock =  new ReentrantLock();
		this.notEmpty = this.mainLock.newCondition();
		this.notFull =  this.mainLock.newCondition();

		this.items  = new Object[capacity];
	}
	
	@Override
	public E poll() {
		final ReentrantLock localLock = this.mainLock;
		localLock.lock();
        try {
            return (count == 0) ? null : dequeue();
        } finally {
            localLock.unlock();
        }		
	}
	
	@Override
    public E take() throws InterruptedException {
        final ReentrantLock locakLock = this.mainLock;
        locakLock.lockInterruptibly();
        try {
            while (count == 0){
            	/*TODO
            	 * 
            	 * loop here and wait to next one is avaiable --Blokcing style
            	 */
            	//  notEmpty.await();
            }
            return dequeue();
        } finally {
            locakLock.unlock();
        }
    }
	
	@Override
    public boolean offer(E e) {
		if(e==null)throw new NullPointerException();
		
		final ReentrantLock localLock = this.mainLock;
        localLock.lock();
        try {
            if (count == items.length)
                return false;
            else {
                enqueue(e);
                return true;
            }
        } finally {
            localLock.unlock();
        }
    }
	
	@Override
    public void put(E e) throws InterruptedException {
		if(e==null)throw new NullPointerException();
        final ReentrantLock localLock = this.mainLock;
        localLock.lockInterruptibly();
        try {
            while (count == items.length){
            	/*TODO
            	 * 
            	 * loop here and wait to next one is avaiable --Blokcing style
            	 */
            	//  notFull.await();          	
            }
            enqueue(e);
        } finally {
            localLock.unlock();
        }
    }	
	
    /**
     * Extracts element at current take position, advances, and signals.
     * Call only when holding lock.
     */
    private E dequeue() {
        final Object[] items = this.items;
        @SuppressWarnings("unchecked")
        E x = (E) items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length)
            takeIndex = 0;
        count--;
        return x;
    }
    
    /**
     * Inserts element at current put position, advances, and signals.
     * Call only when holding lock.
     */
    private void enqueue(E x) {
        final Object[] items = this.items;
        items[putIndex] = x;
        if (++putIndex == items.length)
            putIndex = 0;
        count++;
    }    
	
	
	@Override
	public E remove() {
		return null;
	}


	@Override
	public E element() {
		return null;
	}

	@Override
	public E peek() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remainingCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int drainTo(Collection<? super E> c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int drainTo(Collection<? super E> c, int maxElements) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
