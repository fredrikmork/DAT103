package no.hvl.dat103.ReadersWriters;

public class ReadersWriters {
	//Mutual exclusion for both reader and writer
	public static void main(String[] args) {
		
		//Vår semafor
		Read read = new Read();
		Write write = new Write();
		//Java's semaphore
		ReadJAVA readJAVA = new ReadJAVA();
		WriteJAVA WriteJAVA = new WriteJAVA();
		read.start();
		write.start();
		//readJAVA.start();
		//WriteJAVA.start();
	}

}
