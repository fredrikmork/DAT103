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
				sleep((int)(Math.random()*100));
				right.signal();
				left.signal();
				System.out.println("Filosof: " + currentThread().getName() + " tenker litt.");
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
