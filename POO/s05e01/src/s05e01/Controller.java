package s05e01;

public class Controller {

	public static void main(String[] args) {
		Conta conta = new Conta("Jorge");
		System.out.println("Titular: " + conta.getTitular());
		conta.setTitular("Marcos");
		conta.setNumero(10);
		System.out.println("Titular: " + conta.getTitular());
		System.out.println("Número: " + conta.getNumero());
		conta.depositar(1500);
		System.out.println("Saldo: " + conta.getSaldo());
		conta.saca(1000);
		System.out.println("Saldo: " + conta.getSaldo());
	
	}

}
