import java.util.ArrayList;

class Aluno {
	private String nomeAluno;
	ArrayList<Materia> materias;
	
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
		System.out.println(this.materias);
	}
}

class Materia{
	private String nomeMat;
	ArrayList<Aluno> alunos;
	
	public Materia(String nomeMat) {
		this.nomeMat = nomeMat;
	}
	public String getNomeMat() {
		return nomeMat;
	}
	public void setNomeMat(String nomeMat) {
		this.nomeMat = nomeMat;
	}
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	public void showAluno() {
		System.out.println(this.alunos);
	}
		
}
class Escola{
	ArrayList<Aluno> alunos;
	ArrayList<Materia> materias;
	
	public Escola(String nome) {
		alunos = new ArrayList<Aluno>();
		materias = new ArrayList<Materia>();
		
	}
	
	public void cadAluno(String nome) {
		Aluno aluno = new Aluno(nome);
		this.alunos.add(aluno);
	}
	
	public void cadMat(String nome) {
		Materia materia = new Materia(nome);
		this.materias.add(materia);
	}
	
	public void addMat(Materia materia) {
		materias.add(materia);
	}
	
	public void removeMat(String nome) {
		for(Materia x : materias) {
			if(nome == x.getNomeMat()) {
			this.materias.remove(nome);
			}
		}
	}
	
	public void removeAluno(String nome) {
		for(Aluno x : alunos) {
			if(nome == x.getNomeAluno()) {
				this.alunos.remove(nome);
			}
		}
	}
}

public class Controller {

	public static void main(String[] args) {
		
	}

}
