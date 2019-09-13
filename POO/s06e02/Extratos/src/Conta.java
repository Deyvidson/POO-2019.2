import java.util.ArrayList;
import java.util.Scanner;


class Operacao{
	double valor;
	String data;
	String tipo;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Operacao(String tipo, double valor, String data) {
		this.valor = valor;
		this.data = data;
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String toString() {
		return this.tipo + ": " + this.data + ": " + this.valor + " reais";
	}
	
}



public class Conta {
	int id;
	double saldo;
	private ArrayList<Operacao> operacoes;
	
	public Conta(int id) {
		this.id = id;
		this.saldo = 100;
		this.operacoes = new ArrayList<Operacao>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public ArrayList<Operacao> getOperacoes() {
		return operacoes;
	}
	
	public void addOperacao(String tipo, double valor, String data){
		this.operacoes.add(new Operacao(tipo, valor, data));	
	}
	public String toString() {
		return "" + this.getOperacoes();
	}
	
	
	public static void main(String[] args) {
		Conta bb = new Conta(10);
		bb.addOperacao("deposito", 55, "30/07");
		bb.addOperacao("saque", 10, "31/07");
		bb.addOperacao("saque", 5, "30/08");
		System.out.println(bb + " ");
	}
	
	
}
