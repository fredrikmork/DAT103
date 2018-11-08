package no.hvl.dat103.BoundedBuffer;
import java.util.concurrent.Semaphore;
import java.util.LinkedList;

public class BufferJAVA implements BufferIF{
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
			empty.acquire();
			mutex.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Add next_produced to the buffer
		buffer.add(item);
		mutex.release();
		full.release();
	}

	/**
	 * 
	 * @return siste også slettede elementet i listen
	 */
	public Integer remove() {
		try {
			full.acquire();
			mutex.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int tilbake = buffer.removeFirst();
		mutex.release();
		empty.release();
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
