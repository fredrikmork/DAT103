package no.hvl.dat103.ReadersWriters;

import java.util.concurrent.Semaphore;

public class WriteJAVA extends Thread{
	Semaphore rw_mutex;
	
	
	public WriteJAVA (Semaphore rw_mutex) {
		this.rw_mutex = rw_mutex;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				rw_mutex.acquire();
				// Writing section
				System.out.println("Thread " + currentThread().getName() + " is writing");
				sleep(100);
				System.out.println("Thread " + currentThread().getName() + " has finished writing");
				rw_mutex.release();
				sleep(75);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
