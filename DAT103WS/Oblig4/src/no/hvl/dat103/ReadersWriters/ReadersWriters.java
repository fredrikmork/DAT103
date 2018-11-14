package no.hvl.dat103.ReadersWriters;

import no.hvl.dat103.Semaphore.Semaphore;
import no.hvl.dat103.Semaphore.Number;

public class ReadersWriters {
	//Mutual exclusion for both reader and writer
	public static void main(String[] args) {
		Semaphore rw_mutex = new Semaphore(1);
		Semaphore mutex = new Semaphore(1);
		Number read_count = new Number();
		
		//Vår semafor
		Read read = new Read(rw_mutex, mutex, read_count);
		Read read2 = new Read(rw_mutex, mutex, read_count);
		Read read3 = new Read(rw_mutex, mutex, read_count);
		Read read4 = new Read(rw_mutex, mutex, read_count);
		
		Write write = new Write(rw_mutex);
		//Java's semaphore
//		ReadJAVA readJAVA = new ReadJAVA(rw_mutex, mutex, read_count);
//		WriteJAVA WriteJAVA = new WriteJAVA(rw_mutex);
		read.start();
		read2.start();
//		read3.start();
//		read4.start();
		write.start();
		//readJAVA.start();
		//WriteJAVA.start();
	}

}
