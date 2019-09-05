
public class Controller {

	public static void main(String[] args) {
		Ponta ponta = new Ponta(0.7f);
		Lapiseira c1 = new Lapiseira("BIC", ponta);
		
		c1.status();
		c1.escrever();
		c1.setPonta(ponta);
		c1.escrever();
		c1.status();

	}

}
