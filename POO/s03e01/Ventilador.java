package s03e01;

class Ventilador{
    boolean estaLigado;
	int velocidade;
	boolean estaGirando;
	
	
	void ligar () {
		System.out.println("Ligando o ventilador");
	}
	/*
	void desligar ()
	void girar ()
	void pararDeGirar ()
	void aumentarVelocidade ()
	void diminuirVelocidade ()
	*/
	void showStatus() {
		System.out.println("Ligado: " + estaLigado + 
						   ", vel: " + 	velocidade + 
						   ", girando: " + estaGirando);
	}
}