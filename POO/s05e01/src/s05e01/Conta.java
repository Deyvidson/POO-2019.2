package s05e01;

public class Conta {
	private String titular;
	private int numero;
	private double saldo;
	static int identificador = 0;
	
	public Conta(String titular){
		this.titular = titular;
		this.identificador += 1;
		this.numero = identificador;
	}
	public Conta() {
		this.titular ="";
		this.identificador += 1;
		this.numero = identificador;
	}
	void depositar(double deposito) {
		this.saldo += deposito;
	}
	void saca(double valor) {
		if(valor > this.saldo) {
			System.out.println("Não posso sacar esse valor!");
		}else {
			this.saldo = this.saldo - valor;
		}
	}
	public String getTitular() {
		return this.titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return this.saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int numero){
		this.numero = numero;
	}
}
