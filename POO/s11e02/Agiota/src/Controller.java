import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

class Cliente{
	private int id;
	private String nome;
	private double divida;
	Map<Integer, Transacao> hist;

	public Cliente (String nome){
		this.id = id;
		this.nome = nome;
		hist = new TreeMap<Integer, Transacao>();
	}
	public Cliente(){
		this.id = id;
		this.nome = nome;
		hist = new TreeMap<Integer, Transacao>();
	}
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public double getDivida(){
		return this.divida;
	}
	public void setDivida(double divida){
		this.divida = divida;
	}
	public Map<Integer, Transacao> getHist() {
		return this.hist;
	}
	public String toString() {
		return "" + this.getId() +  this.getNome() + ":" + this.getHist();
	}
}

class Transacao {
	protected int id;
	private String idCli;
	private double valor;
	
	public Transacao(int id, String idCli, double valor) {
		this.id = id;
		this.idCli = idCli;
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getId() {
		return this.id;
	}
	public String getIdCli() {
		return this.idCli;
	}
	
	@Override
	public String toString() {
		return "id:" + this.getId() + " [" + this.getIdCli() + " " + this.getValor() +"]";
	}
	
}

class Agiota{
	protected double saldo;
	private int nextId;
	Map<String, Cliente>clientes;
	Map<Integer, Transacao>transacoes;

	public Agiota(double valorInicial){
		this.saldo = valorInicial;
		clientes = new TreeMap<String, Cliente>();
		transacoes = new TreeMap<Integer, Transacao>();
	}

	public double getSaldo(){
		return this.saldo;
	}
	public void setSaldo(double saldo){
		this.saldo = saldo;
	}

	public void addCli(String id, Cliente cliente){
		Cliente cli = clientes.get(id);
		if (cli == null) {
			clientes.put(id, cliente);		
		} else {
			throw new RuntimeException("Cliente " + cliente.getId() + " já existe, parsa");
		}
	}
	public void matar(String id) {
		Cliente key = clientes.get(id);
		if(key != null) {
			clientes.remove(id);
		}else {
			throw new RuntimeException("Cliente" + " " + id + " não existe, parsa");			
		}
	}
	public void emprestar(String id, double valor){
		Cliente key = clientes.get(id);
		if(key != null){
			if(valor <= this.saldo) {
				clientes.get(id).hist.put(nextId, new Transacao(nextId, id, valor));
				transacoes.put(nextId, new Transacao(nextId, id, valor));
				clientes.get(id).setDivida(clientes.get(id).getDivida() + valor);
				this.setSaldo(this.getSaldo() - valor);
				nextId ++;
			}else {
				System.out.println("Valor muito alto!");
				return;
			}
		}else{
			throw new RuntimeException("Cliente" + " " + id + " não existe, parsa");
		}
	}
	public void receber(String id, double valor){
		Cliente key = clientes.get(id);
		if(key != null) {
			clientes.get(id).hist.put(nextId, new Transacao(nextId, id, - valor));
			transacoes.put(nextId, new Transacao(nextId, id, - valor));
			clientes.get(id).setDivida(clientes.get(id).getDivida() - valor);
			this.setSaldo(this.getSaldo() + valor);
			nextId ++;
		}else {
			throw new RuntimeException("Cliente inexistente, meu benevolente");
		}
	}

	public void showCli(){
		for (String id : clientes.keySet()) {
			System.out.println(clientes.get(id).getId() + " : " + clientes.get(id).getNome() + " : " + clientes.get(id).getDivida());
		}
		System.out.println("Saldo atual: " + this.getSaldo());
	}
	public void showHist() {
		for (int id : this.transacoes.keySet()) {
			System.out.println(transacoes.get(id));
		}
	}

	public Map<String, Cliente> getClientes() {
		return clientes;
	}

	public Map<Integer, Transacao> getTransacoes() {
		return transacoes;
	}
}

public class Controller {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner x = new Scanner(System.in);
		System.out.println("Insira um valor inicial: ");
		double inicial = x.nextDouble();
		Agiota agiota = new Agiota(inicial);

		while(true) {
			System.out.println("addCli, emprestar, receber, matar, showCli, showHist end");
			String line = scan.nextLine();
			String[] vet = line.split(" ");
			
			if(vet[0].equals("addCli")) {
                agiota.addCli(vet[1], new Cliente(vet[2]));
            }
            else if(vet[0].equals("emprestar")) {
				String v = vet[2];
				double valor = Double.parseDouble(v);
                agiota.emprestar(vet[1], valor);
            }
            else if(vet[0].equals("receber")) {
				String v = vet[2];
				double valor = Double.parseDouble(v);
                agiota.receber(vet[1], valor);
            }
            else if(vet[0].equals("showCli")) {
            	agiota.showCli();
			}
			else if(vet[0].equals("showHist")) {
            	agiota.showHist();
            }
            else if(vet[0].equals("matar")) {
               agiota.matar(vet[1]);
			}
			else if(vet[0].equals("end")) {
			   System.out.println("Encerrado!");
				break;
            }
            else{
                System.out.println("Comando inválido!");
            }
		}
	}

}
