import java.util.Scanner;
 class Cacatua{

    int barriga = 1;
    int maxBarriga = 5;
    int carinho = 0;
    int atencao = 5;
    boolean mimada = false;
    int suaMoral = 0;

    void alimentar(int qtd){
        System.out.println("Muito bem, humano");
        barriga += qtd;
        suaMoral += 1;
        if(barriga>maxBarriga){
            System.out.println("Cacatua explodiu de tanto comer");
        }
    }
    void esperar(){
        if(barriga>0) {System.out.println("Cacatua foi brincar com os cachorros");
        barriga -= 1;
        }else if(barriga<=0){
            System.out.println("Cacatua morreu de fome, seu monstro");
        }
    }
    void darCarinho(){
        System.out.println("Muito bem, faça carinho na sua ave");
        carinho += 1;
        suaMoral += 1;
        if(carinho>5){
            System.out.println("Calma, parsa, vc tá mimando sua cacatua demais. Agora ela quer dominar sua casa");
            mimada = true;
        }
    }

    void sairComAmigos(){
        System.out.println("Você saiu e deixou sua cactua sozinha... Cuidado");
        atencao -= 1;
        suaMoral -=1;
        if(atencao<0){
            System.out.println("Cacatua morreu de tristeza");
        }
    }
    

    void bronca(){
        if(mimada){
            if(suaMoral>=5){
            System.out.println("Muito bem, às vezes é necessário falar mais grosso com ela");
            }else{
                System.out.println("Ela tá cagando e andando pra você...");
            }
        }else{
            System.out.println("Desnecessária essa bronca aí...");
        }
    }
}
    public class Trabalho{


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cacatua doris = new Cacatua();
        
        System.out.println("Alimentar; Esperar; Carinho; Bronca; Sair com amigos; end");

        while(true) {
            String line = scanner.nextLine();
            String[] vet = line.split(" ");

            if(vet[0].equals("alimentar")){
                doris.alimentar(Integer.parseInt(vet[1]));
            }if(vet[0].equals("esperar")){
                doris.esperar();
            }if(vet[0].equals("carinho")){
                doris.darCarinho();
            }if(vet[0].equals("bronca")){
                doris.bronca();
            }if(vet[0].equals("sair")){
                doris.sairComAmigos();
            }if(vet[0].equals("end")){
                break;
            }

        }
    }
}