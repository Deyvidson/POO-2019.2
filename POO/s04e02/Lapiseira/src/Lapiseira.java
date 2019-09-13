
public class Lapiseira {
	Ponta ponta;
	String modelo;
	float maxTamanho = 0.9f;
	
	public Lapiseira(String modelo, Ponta ponta){
		this.modelo = modelo;
	//	this.ponta = ponta;
	}
	public void setPonta(Ponta ponta){
		this.ponta = ponta;
		System.out.println(this.ponta.getDurabilidade());
		if(ponta.getPonta()>maxTamanho) {
			System.out.println("Não cabe");
		}
	}
	public void escrever(){
		if(ponta != null){
			if(ponta.getPonta()<=maxTamanho){
				System.out.println("Escrevendo...");
				int tam = this.ponta.desgaste();
				if(tam < 0){
					System.out.println("Precisa de uma ponta nova");
				}
			}
		} else{
			System.out.println("Precisa de uma ponta");
		}
	}
	public void status(){
		//double p1 = this.ponta.getPonta();
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Ponta: " + this.ponta);
	}
}

