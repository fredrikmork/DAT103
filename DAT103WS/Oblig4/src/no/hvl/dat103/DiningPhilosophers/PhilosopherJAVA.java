package no.hvl.dat103.DiningPhilosophers;

import java.util.concurrent.Semaphore;

public class PhilosopherJAVA extends Thread {
	Semaphore left;
	Semaphore right;
	
	public PhilosopherJAVA(Semaphore left, Semaphore right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void run() {
		while (true) {
			try {
				left.acquire();
				right.acquire();
				System.out.println("Filosof: " + currentThread().getName() + " spiser litt.");
				sleep(100);
				System.out.println("Filosof: " + currentThread().getName() + " tenker litt.");
				left.release();
				right.release();;
				sleep(50);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
