import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Amigo{
	private String nome;
	private int amigozidade;
	private int idade;
	
	public Amigo(String nome, int idade) {
		this.nome = "";
		this.idade = 0;
	}

}

public class Array {
	
	public static void showArray(ArrayList<Integer> array) {
		for(Integer elem : array){
			System.out.print(elem + " ");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int i;
		ArrayList<Amigo> amigos = new ArrayList<Amigo>(Arrays.asList(new Amigo("Coringa", 45)));
		Amigo lex = new Amigo("Lex", 40);
		amigos.add(0, lex);
		
		showArray(lista);
	
		lista.set(0, 99);
		showArray(lista);
		
		System.out.println("Informe o índice que você quer remover: ");
		i = ler.nextInt();
		
		lista.remove(i);
		showArray(lista);
		

		while(lista.contains(4)) {
			lista.remove(Integer.valueOf(4));
		}
		showArray(lista);
		
		for(Integer elem : lista){
			elem+=1;
			System.out.print(elem + " ");
		}
		System.out.print("\n");
		
		
		
	}	
}


