package s03e01;

public class Ventilador{
    boolean estaLigado;
	int velocidade;
	boolean estaGirando;
	
	public void ligar () {
		if(estaLigado==false){
		System.out.println("Ligando o ventilador");
		estaLigado = true;
		}
	}
	
	public void desligar (){
		if(estaLigado){
			System.out.println("Desligando o ventilador");
			estaLigado = false;
		}
	}
	public void girar (){
		if(estaGirando==false){
			System.out.println("Ventilador agora está girando");
			estaGirando = true;
		}
		else{
			System.out.println("Já está girando");
		}
	}
	void pararDeGirar (){
		if(estaGirando){
			System.out.println("Parando de girar");
		}
		else{
			System.out.println("Já está parado");
		}
	}
	void aumentarVelocidade (){
		if(velocidade>=0 && velocidade<3){
			System.out.println("Ventilador na velocidade " + velocidade);
			velocidade += 1;
		}if(velocidade>3){
			System.out.println("Já está na velocidade máxima");
		}
	}
	void diminuirVelocidade (){
		if(velocidade<=3 && velocidade>0){
			System.out.println("Diminuindo a velocidade" + velocidade);
			velocidade -= 1;
		}if(velocidade < 0){
			System.out.println("O ventilador já está parado");
		}
	}
	
	public void showStatus() {
		System.out.println("Ligado: " + estaLigado + 
						   ", vel: " + 	velocidade + 
						   ", girando: " + estaGirando);
	}
}