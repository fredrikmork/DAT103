package no.hvl.dat103.ReadersWriters;

import java.util.concurrent.Semaphore;

public class ReaderWriterJAVATEST {

	public static void main(String[] args) {
		Semaphore rw_mutex = new Semaphore(1);
		Semaphore mutex = new Semaphore(1);
		int read_count = 0;

		//Java's semaphore
		ReadJAVA readJAVA = new ReadJAVA(rw_mutex, mutex, read_count);
		ReadJAVA readJAVA2 = new ReadJAVA(rw_mutex, mutex, read_count);
		ReadJAVA readJAVA3 = new ReadJAVA(rw_mutex, mutex, read_count);
		WriteJAVA writeJAVA = new WriteJAVA(rw_mutex);
		readJAVA.start();
		readJAVA2.start();
		readJAVA3.start();
//		read4.start();
		writeJAVA.start();

	}

}
