package no.hvl.dat103.BoundedBuffer;

public class Consumer extends Thread {

	private BufferIF buffer;

	public Consumer(BufferIF buffer) {
		this.buffer = buffer;
 
	}

	@Override
	public void run() {
		while (true) {
			Integer item = buffer.remove();
			System.out.println("Consumed: " + item + "\tAntall på lager: " + buffer.antall());
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// ignore
			}
		}

	}
}
