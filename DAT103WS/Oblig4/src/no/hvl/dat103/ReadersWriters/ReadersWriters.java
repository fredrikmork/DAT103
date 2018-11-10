package no.hvl.dat103.ReadersWriters;

public class ReadersWriters {
	//Mutual exclusion for both reader and writer
	public static void main(String[] args) {
		Read read = new Read();
		Write write = new Write();
		read.start();
		write.start();
	}

}
