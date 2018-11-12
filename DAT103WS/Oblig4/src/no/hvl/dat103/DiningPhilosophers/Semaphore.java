package no.hvl.dat103.DiningPhilosophers;

public class Semaphore {
	// Allow for both counting or mutex semaphores
	private int count;

	public Semaphore(int n) {
		count = n;
	}

	public void waitS() throws InterruptedException {
		while (count <= 0) {
			Thread.sleep(50);
		}
		count--;
	}

	public void signal() {
		count++;
	}
}
