
public class Lapiseira {
	Ponta ponta;
	String modelo;
	float maxTamanho;
	
	public Lapiseira(String modelo, Ponta ponta){
		this.modelo = modelo;
		this.maxTamanho = 0.7f;
	}
	public void setPonta(Ponta ponta){
		this.ponta = ponta;
		if(ponta.getPonta()>maxTamanho) {
			System.out.println("Não cabe");
		}
	}
	public void escrever(){
		if(ponta != null){
			if(ponta.getPonta()<=maxTamanho){
				System.out.println("Escrevendo...");
			}
		} else{
			System.out.println("Precisa de uma ponta");
		}
	}
	public void status(){
		System.out.println("Modelo: " + modelo);
		System.out.println("Ponta: " + ponta);
	}
}

