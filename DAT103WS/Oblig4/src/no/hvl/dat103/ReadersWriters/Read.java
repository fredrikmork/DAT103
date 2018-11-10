package no.hvl.dat103.ReadersWriters;

public class Read extends Thread {
	Semaphore rw_mutex = new Semaphore(1);
	Semaphore mutex = new Semaphore(1);
	int read_count = 0;

	@Override
	public void run() {
		while (true) {
			try {
				// Acquire section
				mutex.waitS();
				read_count++;
				if (read_count == 1) {
					rw_mutex.waitS();
				}
				mutex.signal();
				// Reading section
				System.out.println("Thread " + currentThread().getName() + " is reading");
				sleep(150);
				System.out.println("Thread " + currentThread().getName() + " has finished reading");
				// Releasing section
				read_count--;
				if (read_count == 0) {
					rw_mutex.signal();
				}
				mutex.signal();

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
