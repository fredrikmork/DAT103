package no.hvl.dat103.ReadersWriters;

import java.util.concurrent.Semaphore;

public class WriteJAVA extends Thread{
	Semaphore rw_mutex = new Semaphore(1);
	Semaphore mutex = new Semaphore(1);
	int read_count = 0;
	
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
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
