package s03e01;

public class Trabalho{
    
    public static void main (String [] args){
		Ventilador arno = new Ventilador();
		arno.estaLigado = false;
		arno.velocidade = 0;

		arno.showStatus();
		arno.ligar();
		arno.girar();
		arno.pararDeGirar();
		arno.aumentarVelocidade();
		arno.diminuirVelocidade();
		arno.desligar();
	   }
}
