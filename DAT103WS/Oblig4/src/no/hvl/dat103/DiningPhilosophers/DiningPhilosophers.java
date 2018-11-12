package no.hvl.dat103.DiningPhilosophers;

public class DiningPhilosophers {
	// Semaphore chopstick[5];
	// do {
	// wait(chopstick[i]);
	// wait(chopstick[(i+1) % 5]);
	//
	// /*eat for awhile*/
	//
	// signal(chopstick[i]);
	// signal(chopstick[(i+1) % 5]);
	//
	// /*think for awhile*/
	// } while(true);
	public static void main(String[] args) {
		Philosopher[] filo = new Philosopher[5];
		Semaphore chopstick[] = new Semaphore[filo.length];

		for (int i = 0; i < chopstick.length; i++) {
			chopstick[i] = new Semaphore(1);
		}
		for (int i = 0; i < filo.length; i++) {
			if (i == filo.length -1) {
				filo[i] = new Philosopher(chopstick[(i + 1) % filo.length], chopstick[i]);
				filo[i].start();
			} else {
				filo[i] = new Philosopher(chopstick[i], chopstick[(i + 1) % filo.length]);
				filo[i].start();
			}
			

		}
	}
}
