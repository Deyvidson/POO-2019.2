import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

class Cliente{
	private String nome;
	private String id;
	private double saldoCli;
	ArrayList<Transacao> transacaoCli;
	
	public Cliente(String nome) {
		this.nome = nome;
		this.saldoCli = 0;
		transacaoCli = new ArrayList<Transacao>();
	}

	public double getSaldoCli() {
		return saldoCli;
	}

	public void setSaldoCli(double saldoCli) {
		this.saldoCli = saldoCli;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void addTrans(Transacao transacao) {
		transacaoCli.add(transacao);
	}
	
	
}
class Transacao{
	private int id;
	private double saldo;
	Map<Cliente, double> transacao;
	
	public Transacao(Cliente cliente, double valor) {
		this.id = 0;
		this.saldo = saldo;
		transacao = new TreeMap<Cliente, double>();
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void addTrans(Cliente cliente, double valor) {
		transacao.put(cliente, valor);
	}
}

class Agiota{
	private double saldo;
	Map<String, Cliente> map; 
	Map<String, Transacao> hist;

	public Agiota(double saldo) {
		this.saldo = saldo;
		map = new TreeMap<String, Cliente>();
		hist = new TreeMap<String, Transacao>();
	}
	public Agiota() {
		this.saldo = saldo;
		map = new TreeMap<>();
		hist = new TreeMap<String, Transacao>();
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void addCli(String id, Cliente cliente) {
		Cliente key = map.get(id);
		if(key == null) {
			map.put(id, cliente);
			hist.put(id);
		}else {
			throw new RuntimeException("Cliente" + " " + key + " já existe, parsa");
		}
	}
	public void emprestar(String id, double valor) {
		Cliente key = map.get(id);
		if(key != null){
			if(valor <= this.saldo) {
				key.setSaldoCli(key.getSaldoCli() + valor);
				this.saldo -= valor;
				hist.add(0 - key);

			}else {
				System.out.println("Valor muito alto!");
				return;
			}
		}
		throw new RuntimeException("Cliente" + " " + id + " não existe, parsa");
	}
	public void matar(String id) {
		Cliente key = map.get(id);
		if(key != null) {
			map.remove(id);
		}else {
			throw new RuntimeException("Cliente" + " " + id + " não existe, parsa");			
		}
	}
	public void receber(String id, double valor) {
		Cliente key = map.get(id);
		if(key != null) {
			
		}
		else {
			throw new RuntimeException("Cliente" + " " + id + " não existe, parsa");	
		}

}

public class Controller {

	public static void main(String[] args) {
		Sacnner scan = new Scanner(System.in);
		Agiota agiota = new Agiota();
		
		while(true) {
			System.out.println("cad, emprestar, receber, matar, show, end");
			String line = scan.nextLine();
			String[] vet = line.split(" ");
			
			if(vet[0].equals("cad")) {
                agiota.addCli(vet[1], new Cliente(vet[2]));
            }
            else if(vet[0].equals("emprestar")) {
                agiota.emprestar(vet[1], vet[2]);
            }
            else if(vet[0].equals("receber")) {
                
            }
            else if(vet[0].equals("show")) {
            	
            }
            else if(vet[0].equals("matar")) {
               agiota.matar(vet[1]);
			}
			else if(vet[0].equals("end")) {
               
            }
            else{
                System.out.println("Comando inválido!");
            }
		}
	}

}
}