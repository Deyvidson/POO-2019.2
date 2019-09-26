import java.util.ArrayList;
import java.util.Scanner;

class Passageiro{
	String nome;
	int idade;
	
	public Passageiro(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String toString() {
		return this.nome + ": " + this.idade;
	}
}

class Topic{
	int maxCapacidade;
	int preferencial;
	ArrayList<Passageiro> pref;
	ArrayList<Passageiro> comum;
	
	public Topic(int maxCapacidade, int preferencial) {
		this.maxCapacidade = maxCapacidade;
		this.preferencial = preferencial;
		pref = new ArrayList<Passageiro>();
		comum = new ArrayList<Passageiro>();	
		for(int i = 1; i <= preferencial; i++) {
			pref.add(null);
		}
		for(int i = 1; i <= maxCapacidade - preferencial; i++) {
			comum.add(null);
		}
	}
	public void inPref(int posicao, Passageiro passageiro) {
		for(Passageiro x : pref) {
			if(x == null) {
				pref.set(posicao, passageiro);
				return;
			}
			posicao += 1;
			
			if(posicao == pref.size() ) {
				posicao = 0;
				
				if(x != null) {
					for(Passageiro y : comum) {
						if(y == null) {
							comum.set(posicao, passageiro);
							return;
						}
						posicao += 1;
					}
				}
				if(pref.size() == this.preferencial) {
					System.out.println("Topic está lotada, parceiro!");
					return;
				}
			}
		}
	}

	public void inComum(int posicao, Passageiro passageiro) {
		for(Passageiro x : comum) {
			if(x == null) {
				comum.set(posicao, passageiro);
				return;
			}
			posicao += 1;
			
			if(posicao == comum.size()) {
				posicao = 0;
				
				if(x != null) {
					for(Passageiro y : pref){
						if(y == null) {
							pref.set(posicao, passageiro);
							return;
						}
						posicao += 1;
					}
				}
				if(comum.size() == maxCapacidade - preferencial) {
					System.out.println("Topic lotada, irmão!");
					return;
				}
			}
		}
	}
	
	public void removerPass(String nome) {
		for (int i = 0; i < this.pref.size(); i++) {
			Passageiro x = this.pref.get(i);
			if (x != null) {
				if(x.getNome().equals(nome)){
					this.pref.set(i, null);
					if(x.getNome().equals(nome)){
						if(x == null){
						System.out.println("Já foi removido!");
						return;
						}
					}
				}
			}
			if (x == null){
				System.out.println("Não encontrado");
				return;
			}
		}
		for (int i = 0; i < this.comum.size(); i++) {
			Passageiro y = this.comum.get(i);
			if (y != null) {
				if(y.getNome().equals(nome)){
					this.comum.set(i, null);
					if(y.getNome().equals(nome)){
						if(y == null){
						System.out.println("Já foi removido!");
						return;
						}
					}
				}
			}
			if (y == null){
				System.out.println("Não encontrado");
				return;
			}
		}
	}
	

	public String toString() {
        String x = "[ ";
        for (Passageiro y: this.pref) {
            if (maxCapacidade >= preferencial) {
                if (y != null) {
                    x += " @" + y;
                } else {
                    x += " @ ";
                }
            }
        }
        for (Passageiro y : this.comum) {
            if (maxCapacidade >= preferencial) {
                if (y != null) {
                    x += " = " + y;
                } else {
                    x += " = ";
        
            	}

        	}
		}
		x += "]";
        return x;
	}
}

	


public class Controller {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Topic topic = new Topic(0, 0);
        
        while(true) {
			System.out.println("init, in, remove, end: ");
        	String line = scanner.nextLine();
        	String[] vet = line.split(" ");
        	
        	if(vet[0].equals("init")) {
        		topic = new Topic(Integer.parseInt(vet[1]), Integer.parseInt(vet[2]));
        	}
        	else if(vet[0].equals("in")) {
        		int pos = 0;
        		if(Integer.parseInt(vet[2]) >= 65) {
        			topic.inPref(pos, new Passageiro(vet[1], Integer.parseInt(vet[2])));
        			pos += 1;
        		}
        		else {
        			topic.inComum(pos, new Passageiro(vet[1], Integer.parseInt(vet[2])));
        			pos += 1;
        		}
        	}
        	else if(vet[0].equals("remove")) {
        		topic.removerPass(vet[1]);
			}
			else if(vet[0].equals("show")){
				System.out.println(topic);
				return;
			}
        	else if(vet[0].equals("end")) {
        		System.out.println("Encerrado!");
        		break;
			}
			
        	else {
        		System.out.println("Comando inválido!");
        	}
		}
	}
}

