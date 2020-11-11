package com.revature.threads;

import java.io.IOException;

/*
 * There are two different ways to create a thread in Java
 * A thread is a simple flow of execution
 * Multithreading is when multiple threads branch out of the main thread and
 * execute concurrently
 * 
 * There are two ways to create a thread:
 * 1)Implementing the runnable interface
 * 2)Extending the Thread class
 */
public class RunnableThread implements Runnable{
	
	/*
	 * In either case for creating a thread, you must implement the run()
	 * method in order to designate what will be executed when you branch
	 * the thread off. The thread will fork and then execute everything that
	 * you wrote inside of the run() method. 
	 * In order to actually branch the thread off, you must call the start()
	 * method
	 * 
	 * 
	 */
	@Override
	public void run(){
		for(int i = 0; i <25; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			if(i==5)
//			throw new RuntimeException();
			
		}
		
	}
	
}
