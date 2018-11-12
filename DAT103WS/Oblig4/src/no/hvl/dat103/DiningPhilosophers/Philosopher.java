package no.hvl.dat103.DiningPhilosophers;

public class Philosopher extends Thread {
	Semaphore left;
	Semaphore right;
	
	public Philosopher(Semaphore left, Semaphore right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void run() {
		while (true) {
			try {
				left.waitS();
				right.waitS();
				System.out.println("Filosof: " + currentThread().getName() + " spiser litt.");
				sleep(100);
				System.out.println("Filosof: " + currentThread().getName() + " tenker litt.");
				left.signal();
				right.signal();
				sleep(50);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
