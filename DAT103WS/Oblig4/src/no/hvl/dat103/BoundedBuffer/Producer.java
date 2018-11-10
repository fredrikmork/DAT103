package no.hvl.dat103.BoundedBuffer;

import java.util.Random;

public class Producer extends Thread{
	
	private BufferIF buffer;
	Random rand = new Random();
	
	public Producer(BufferIF buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		while (true) {
			Integer item = rand.nextInt(100);
	        buffer.consume(item);
			System.out.println("Produced: " + item + "\tAntall på lager: " + buffer.antall());
	        try {
	            Thread.sleep(40);
	        } catch (InterruptedException e) {
	            // ignore
	        }
		}	
	}
}
