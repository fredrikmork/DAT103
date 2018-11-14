package no.hvl.dat103.DiningPhilosophers;

import java.util.concurrent.Semaphore;

public class DiningPhilosophersJAVA {

	public static void main(String[] args) {
		PhilosopherJAVA[] filo = new PhilosopherJAVA[5];
		Semaphore chopstick[] = new Semaphore[filo.length];

		for (int i = 0; i < chopstick.length; i++) {
			chopstick[i] = new Semaphore(1);
		}
		for (int i = 0; i < filo.length; i++) {
			if (i == filo.length -1) {
				filo[i] = new PhilosopherJAVA(chopstick[(i + 1) % filo.length], chopstick[i]);
				filo[i].start();
			} else {
				filo[i] = new PhilosopherJAVA(chopstick[i], chopstick[(i + 1) % filo.length]);
				filo[i].start();
			}
			

		}
	}
}
