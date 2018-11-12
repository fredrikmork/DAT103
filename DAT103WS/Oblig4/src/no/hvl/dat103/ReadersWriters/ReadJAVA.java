package no.hvl.dat103.ReadersWriters;

import java.util.concurrent.Semaphore;

public class ReadJAVA extends Thread{
	Semaphore rw_mutex = new Semaphore(1);
	Semaphore mutex = new Semaphore(1);
	int read_count = 0;
	
	@Override
	public void run() {
		while (true) {
			try {
				// Acquire section
				mutex.acquire();
				read_count++;
				if (read_count == 1) {
					rw_mutex.acquire();
				}
				mutex.release();
				// Reading section
				System.out.println("Thread " + currentThread().getName() + " is reading");
				sleep(150);
				System.out.println("Thread " + currentThread().getName() + " has finished reading");
				// Releasing section
				mutex.acquire();
				read_count--;
				if (read_count == 0) {
					rw_mutex.release();
				}
				mutex.release();

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
