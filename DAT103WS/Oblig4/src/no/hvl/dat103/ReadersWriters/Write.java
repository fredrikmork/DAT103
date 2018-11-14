package no.hvl.dat103.ReadersWriters;

import no.hvl.dat103.Semaphore.Semaphore;

public class Write extends Thread {
	Semaphore rw_mutex;
	
	public Write (Semaphore rw_mutex) {
		this.rw_mutex = rw_mutex;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				rw_mutex.waitS();
				// Writing section
				System.out.println("Thread " + currentThread().getName() + " is writing");
				sleep(100);
				System.out.println("Thread " + currentThread().getName() + " has finished writing");
				rw_mutex.signal();
				sleep(75);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

		}
	}

}
