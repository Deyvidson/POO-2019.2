
public class Ponta {
	double ponta;
	int durabilidade = 5;
	
	public Ponta(double ponta){
		this.ponta = ponta;
	}
	public double getPonta() {
		return this.ponta;
	}
	public int getDurabilidade(){
		return this.durabilidade;
	}
	public void setDurabilidade(int durabilidade){
		this.durabilidade = durabilidade;
	}public int desgaste(){
		this.durabilidade -= 1;
		return this.durabilidade;
	}
}
