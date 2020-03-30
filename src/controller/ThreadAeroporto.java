package controller;

import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread{

	Semaphore s;
	String pista;
	private static String[][] pista1;
	@Override
	public void run() {

		processoDecolagem();
		super.run();
	}
	public ThreadAeroporto(Semaphore s, String pista) {
		// TODO Auto-generated constructor stub
		this.s = s;
		this.pista = pista;
	}


	public void processoDecolagem() {
		
		try {
			s.acquire();
			manobra();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			s.acquire();
			taxiar();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			s.acquire();
			decolagem();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			s.acquire();
			afastamento();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void manobra() {
		int tempo = (int) ((Math.random() * 7) + 3);
		
		
		System.out.println(pista +  "\nAVIÃO: " + getId()+ " Tempo da fase de MANOBRA: " + tempo);
		if(pista == "PISTA 1") {
			//pista1 += ["alicia", "alicia",  "alicia"];
		}
		
		
		while(tempo > 0) {
			//System.out.println("Faltam " + tempo + " segundos");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempo--;
		}
		
		s.release();
		
	}
	
	public void taxiar() {
		int tempo = (int) ((Math.random() * 10) + 5);

		System.out.println(pista +  "\nAVIÃO: " + getId()+ " Tempo da fase de TAXIAR: " + tempo);
		
		
		
		while(tempo > 0) {
			//System.out.println("Faltam " + tempo + " segundos");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempo--;
		}
		
		s.release();
	}
	
	public void decolagem() {
		int tempo = (int) ((Math.random() * 4) + 1);

		System.out.println(pista +  "\nAVIÃO: " + getId()+ " Tempo da fase de DECOLAGEM: " + tempo);
		
		
		
		while(tempo > 0) {
			//System.out.println("Faltam " + tempo + " segundos");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempo--;
		}
		
		s.release();
	}
	
	public void  afastamento() {
		int tempo = (int) ((Math.random() * 8) + 3);

		System.out.println(pista +  "\nAVIÃO: " + getId()+ " Tempo da fase de AFASTAMENTO: " + tempo);
		
		
		
		while(tempo > 0) {
			//System.out.println("Faltam " + tempo + " segundos");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempo--;
		}
		
		s.release();
	}
	
}
