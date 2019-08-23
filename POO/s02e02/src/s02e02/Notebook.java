package s02e02;

public class Notebook {
	int bateria;
	boolean precisa_carga;
	boolean ligado;
	boolean ter_internet;
	
	void ligar() {
		if(ligado) {
			System.out.println("Pc já tá ligado");
		}
		else {
			ligado = true;
				System.out.println("Ligando o pc...");
		}
	}
	
	void verificar_bateria() {
		if(bateria>20) {
			System.out.println("Notebook possui carga suficiente");
			precisa_carga = true;
		}
		else {
			precisa_carga = false;
			System.out.println("Notebook precisa de carga");
		}
	}
	
	void carregar() {
		if(precisa_carga==false) {
			System.out.println("Carregando  notebook...");
		}
	}
	void fazer_pesquisa() {
		if(ligado && ter_internet) {
			System.out.println("Fazendo pesquisa pelas interwebs");
		}
	}
	void desligar() {
		if(ligado) {
			System.out.println("Desligando o pc...");
			ligado = false;
		}
		else {
			System.out.println("Pc já está desligado");
		}
	}
	
	
	public static void main(String[] args) {
		Notebook dell = new Notebook();
		dell.bateria = 10;
		dell.ligado = false;
		dell.ter_internet = true;
		
		dell.ligar();
		dell.verificar_bateria();
		dell.carregar();
		dell.fazer_pesquisa();
		dell.desligar();
		
	}
}
