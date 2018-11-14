package no.hvl.dat103.Semaphore;

public class Number {
	private int number;
	
	public Number() {
		number = 0;
	}
	
	public Number(int number) {
		this.number = number;
	}
	
	public int increase() {
		number++;
		return number;
	}
	
	public int decrease() {
		number--;
		return number;
	}
}
