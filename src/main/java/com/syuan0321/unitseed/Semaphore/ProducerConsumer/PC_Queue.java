/**
 * Producer/Consumer Pattern using BlockingQueue
 * 
 * ArrayBlockingQueue VS LinkedBlockingQueue:
 * bounded vs unbounded
 * 
 * */

package com.syuan0321.unitseed.Semaphore.ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class PC_Queue {
	public static BlockingQueue<Integer> theQueue = new LinkedBlockingQueue<Integer>();
    public static void main(String args[]){

        ExecutorService pes = Executors.newFixedThreadPool(2);
        ExecutorService ces = Executors.newFixedThreadPool(2);

        pes.submit(new Producer(theQueue,1));
        pes.submit(new Producer(theQueue,2));
        ces.submit(new Consumer(theQueue,1));
        ces.submit(new Consumer(theQueue,2));
        pes.shutdown();
        ces.shutdown();
   }
}
class Producer implements Runnable {
   private int threadNo;
   public Producer(BlockingQueue<Integer> sharedQueue,int threadNo) {
       this.threadNo = threadNo;
   }
   @Override
   public void run() {
       for(int i=1; i<= 5; i++){
           try {
               int number = i+(10*threadNo);
               System.out.println("Produced:" + number + ":by thread:"+ threadNo);
               PC_Queue.theQueue.put(number);
           } catch (Exception err) {
               err.printStackTrace();
           }
       }
   }
}

class Consumer implements Runnable{
   private int threadNo;
   public Consumer (BlockingQueue<Integer> sharedQueue,int threadNo) {
       this.threadNo = threadNo;
   }
   @Override
   public void run() {
       while(true){
           try {
               int num = PC_Queue.theQueue.take();
               System.out.println("Consumed: "+ num + ":by thread:"+threadNo);
           } catch (Exception err) {
              err.printStackTrace();
           }
       }
   }   
}