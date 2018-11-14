package no.hvl.dat103.ReadersWriters;

import no.hvl.dat103.Semaphore.Semaphore;
import no.hvl.dat103.Semaphore.Number;

public class Read extends Thread {
	Semaphore rw_mutex;
	Semaphore mutex;
	Number read_count;
	
	public Read (Semaphore rw_mutex, Semaphore mutex, Number read_count) {
		this.rw_mutex = rw_mutex;
		this.mutex = mutex;
		this.read_count = read_count;
	}

	@Override
	public void run() {
		while (true) {
			try {
				// Acquire section
				mutex.waitS();
				int rc = read_count.increase();
				if (rc == 1) {
					rw_mutex.waitS();
				}
				mutex.signal();
				// Reading section
				System.out.println("Thread " + currentThread().getName() + " is reading");
				sleep(100);
				System.out.println("Thread " + currentThread().getName() + " has finished reading");
				// Releasing section
				mutex.waitS();
				rc = read_count.decrease();
				if (rc == 0) {
					rw_mutex.signal();
				}
				mutex.signal();
				sleep(75);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
