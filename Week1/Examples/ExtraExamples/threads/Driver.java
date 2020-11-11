package com.revature.threads;

public class Driver {

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnableThread(), "Thread1");
		Thread t2 = new Thread(new ThreadThread(), "Thread2");
		//at this point, the threads are in the "new" state
		
		System.out.println("BEGNINING OF THREAD EXAMPLE");
		
		t1.start();
		t2.start();
		//at this point, the threads are "runnable"
		for(int i = 0; i<50; i++) {
			System.out.println("\t\t\t\t" + Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("MAIN THREAD DONE");
	}
	
	/*
	 * -sleep(): puts at thread into the sleeping status (can be interrupted)
	 * -notify: wakes up, at random, a single blocked thread
	 * -notifyAll: wakes up all blocked threads
	 * -isDaemon: checks to see if a thread is a daemon thread.
	 * 		-A daemon thread is any low priority thread that executes in
	 * the background (i.e. garbage collector). May continue running after
	 * the app ends
	 * -join(): Will force thread to wait for others to terminate before 
	 * terminating itself
	 * -isAlive(): checks to see if the thread has not yet been terminated
	 * -start(): fork the thread into a multi-threading state
	 */

}
