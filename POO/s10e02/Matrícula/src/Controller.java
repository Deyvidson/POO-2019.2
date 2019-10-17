import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Aluno {
	private String nomeAluno;
	ArrayList<String> materias_do_aluno;
	
	public Aluno(String nome){
		this.nomeAluno = nomeAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nome) {
		this.nomeAluno = nomeAluno;
	}	
	public void showMat() {
		System.out.println(this.materias_do_aluno);
	}
	public void add_mat(String nome){
		this.materias_do_aluno.add(nome);
	}
	public void rem_mat(String nome){
		this.materias_do_aluno.remove(nome);
	}
}

class Materia{
	private String nomeMat;
	ArrayList<String> alunos_da_materia;
	
	public Materia(String nomeMat) {
		this.nomeMat = nomeMat;
	}
	public String getNomeMat() {
		return nomeMat;
	}
	public void setNomeMat(String nomeMat) {
		this.nomeMat = nomeMat;
	}
	
	public void showAluno() {
		System.out.println(this.alunos_da_materia);
	}
	public void add_aluno(String nome){
		this.alunos_da_materia.add(nome);
	}
	public void rem_aluno(String nome){
		this.alunos_da_materia.remove(nome);
	}
		
}
class Escola{
	ArrayList<Aluno> alunos;
	ArrayList<Materia> materias;
	Map<String, String> map;
	
	public Escola(String nome) {
		alunos = new ArrayList<Aluno>();
		materias = new ArrayList<Materia>();
		map = new HashMap<>();

	}
	public Escola() {
		alunos = new ArrayList<Aluno>();
		materias = new ArrayList<Materia>();
		map = new HashMap<>();

	}
	public void cadAluno(String nome) {
		Aluno aluno = new Aluno(nome);
		this.alunos.add(aluno);
	}
	
	public void cadMat(String nome) {
		Materia materia = new Materia(nome);
		this.materias.add(materia);
	}
	public void addAluno(String aluno, String materia) {
		for(Aluno x : this.alunos){
			if(aluno == x.getNomeAluno()){
				for(Materia y : this.materias){
					if(materia == y.getNomeMat()){
						this.map.put(aluno , materia);
						x.add_mat(materia);
						y.add_aluno(aluno);
					}else{
						System.out.println("Matéria não encontrada!");
						return;
					}
				}
			}else{
				System.out.println("Aluno não encontrado!");
				return;
			}
		}
	}

	public void removeAluno(String nomeAluno, String nomeMateria) {
		for(Aluno x : this.alunos) {
			if(nomeAluno == x.getNomeAluno()) {
				for(Materia y : this.materias){
					if(nomeMateria == y.getNomeMat()){
						this.map.remove(nomeAluno);
						x.rem_mat(nomeMateria);
						y.rem_aluno(nomeAluno);
					}else{
						System.out.println("Matéria não encontrada!");
						return;
					}
				}
			}else{
				System.out.println("Aluno não encontrado!");
				return;
			}
		}
	}
	public void show_aluno(){
		for(String key : map.keySet()){
			System.out.println(key);
			return;
		}
	}
	public void show_materias(){
		for(String values : map.values()){
			System.out.println(values);
			return;
		}
	}
}

public class Controller {

	public static void main(String[] args) {
		Escola escola = new Escola();
		Scanner scan = new Scanner(System.in);

		while (true) {
            System.out.println("criarAluno, criarMat, matricular, remover, show, end");
            String line = scan.nextLine();
            String vet[] = line.split(" ");
                
            if(vet[0].equals("criarAluno")) {
                escola.cadAluno(vet[1]);
            }
            else if(vet[0].equals("criarMat")) {
                escola.cadMat(vet[1]);
            }
            else if(vet[0].equals("matricular")) {
                escola.addAluno(vet[1], vet[2]);
            }
            else if(vet[0].equals("remover")){
                escola.removeAluno(vet[1], vet[2]);
			}
			else if(vet[0].equals("show")){
                if(vet[1].equals("alunos")){
					escola.show_aluno();
				}
			}
			else if(vet[0].equals("show")){
                if(vet[1].equals("materias")){
					escola.show_materias();
				}
			}
			else if(vet[0].equals("end")){
                break;
			}
            else{
                System.out.println("Comando inválido!");
            }
        }
	}

}
