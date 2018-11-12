package no.hvl.dat103.ReadersWriters;

public class Write extends Thread {
	Semaphore rw_mutex = new Semaphore(1);
	Semaphore mutex;

//	public Write (Semaphore rw_mutex, Semaphore mutex) {
//		this.rw_mutex = rw_mutex;
//		this.mutex = mutex;
//	}
	
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
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

		}
	}

}
