package no.hvl.dat103.BoundedBuffer;

import java.util.LinkedList;

public class Buffer implements BufferIF{
	private final static int SIZE = 10;
	private LinkedList<Integer> buffer = new LinkedList<Integer>();
	Semaphore mutex = new Semaphore(1);
	Semaphore empty = new Semaphore(SIZE);
	Semaphore full = new Semaphore(0);

	/**
	 * 
	 * @param produce
	 *            an item in next_produced
	 */
	public void add(Integer item) {
		try {
			empty.waitS();
			mutex.waitS();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Add next_produced to the buffer
		buffer.add(item);
		mutex.signal();
		full.signal();
	}

	/**
	 * 
	 * @return siste også slettede elementet i listen
	 */
	public Integer remove() {
		try {
			full.waitS();
			mutex.waitS();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int tilbake = buffer.removeFirst();
		mutex.signal();
		empty.signal();
		return tilbake;
	}

	/**
	 * 
	 * @return antallet i listen, som ikke kan overstige variabelen SIZE
	 */
	public int antall() {
		return buffer.size();
	}

}
