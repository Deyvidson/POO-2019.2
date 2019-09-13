
public class Controller {

	public static void main(String[] args) {
		Ponta ponta1 = new Ponta(0.7);
		Ponta ponta2 = new Ponta(0.7);
		Lapiseira c1 = new Lapiseira("BIC", ponta1);
		
		c1.status();
		c1.escrever();
		c1.setPonta(ponta1);
		c1.escrever();
		c1.status();
		c1.escrever();
		c1.escrever();
		c1.escrever();
		c1.escrever();
		c1.escrever();
		c1.setPonta(ponta2);
		c1.escrever();
		c1.escrever();

	}

}
