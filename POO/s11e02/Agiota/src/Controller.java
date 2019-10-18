import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class Cliente{
	private String nome;
	private String id;
	private double saldoCli;
	
	public Cliente(String nome) {
		this.nome = nome;
		this.saldoCli = 0;
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
	
	
}

class Agiota{
	private double saldo;
	Map<String, Cliente> map; 
	ArrayList<Cliente> hist;

	public Agiota(double saldo) {
		this.saldo = saldo;
		map = new TreeMap<>();
		hist = new ArrayList<Cliente>();
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
				hist.add(key);
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

}

public class Controller {

	public static void main(String[] args) {
		
	}

}
