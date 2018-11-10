package no.hvl.dat103.BoundedBuffer;

public interface BufferIF {
	public void consume(Integer item);
	public Integer remove();
	public int antall();
}
