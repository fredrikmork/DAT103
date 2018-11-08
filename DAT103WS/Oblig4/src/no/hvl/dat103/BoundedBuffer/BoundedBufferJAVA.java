package no.hvl.dat103.BoundedBuffer;

public class BoundedBufferJAVA {

	public static void main(String[] args) {
		BufferIF buffer = new BufferJAVA();
		Consumer consumer = new Consumer(buffer);
		Producer producer = new Producer(buffer);
		producer.start();
		consumer.start();
	}

}
