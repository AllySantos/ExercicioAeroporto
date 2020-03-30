package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class Principal {

	public static void main(String[] args) {
		Semaphore s = new Semaphore(2);
		
		
	
		for(int i = 0; i<6; i++) {
			ThreadAeroporto aviao1 = new ThreadAeroporto(s, "PISTA 1");
			ThreadAeroporto aviao2 = new ThreadAeroporto(s, "PISTA 2");
			
			aviao1.start();
			aviao2.start();
		}
	}
}
