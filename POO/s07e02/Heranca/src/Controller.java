import java.util.ArrayList;
import java.util.Scanner;

class Pessoa{
	protected String nome;
	private int paciencia;
	
	public Pessoa(String nome){
		this.nome = nome;
		this.paciencia = 5;
	}
	public String getConversar() {
		return ": kk eae men";
	}
	public String toString() {
		return this.nome + getConversar();
	}
}

class Crossfiteiro extends Pessoa{
	
	public Crossfiteiro(String nome) {
		super("eh o tall doh " + nome + "hh: ");
		
	}
	public String getConversar() {
		return  "bora pro crossfit, man, é mó bom, vc tem que conhecer, vai mudar sua vida. Bora lá, vai ser massa";
		
	}
	public void malhar() {
		System.out.println("BIIUURRLLL");
	}
	@Override
	public String toString(){
		return this.nome + getConversar();
	}
	public void show(){
		System.out.println(this.nome);
		return;
	}
}

public class Controller {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Pessoa> sala = new ArrayList<Pessoa>();
		sala.add(new Pessoa("jonas"));
		sala.add(new Crossfiteiro("jonata"));
		sala.add(new Crossfiteiro("marco"));
		
		while(true){
			System.out.println("init, in, remove, end: ");
        	String line = scanner.nextLine();
        	String[] vet = line.split(" ");
		}
			
		
	}

}