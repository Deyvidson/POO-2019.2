import java.util.Scanner;

import jdk.jshell.Diag;

class Unicornio{
    int numPassageiros;
    int maxPass;
    int carinhometro;
    int maxCarinho;
    int desgaste;
    int km;
    int distancia;

    void voar(int qtd){
        if(numPassageiros>0){
            distancia += qtd;
            if(distancia/10 <= carinhometro){
                System.out.println("Voando pelas nuvens...");
                carinhometro -= distancia/10;
            }else{
                System.out.println("Ah, sem carinho eu num quero não");
            }
        }if(numPassageiros<=0){
            System.out.println("Não gosto de voar sozinho...");
        }
    }
    void subir(int qtd){
        
        if(qtd>maxPass){
            System.out.println("Não consigo levar esse número de pessoas");
        }else if(qtd<=maxCarinho){
            numPassageiros += qtd;
            System.out.println("Passageiros abordo");
        }
    }
    void darAmor(int qtd){

    }
    void brigar(){
    }

}

public class Exercicio{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Unicornio uni = new Unicornio();
        uni.maxPass = 2;
        uni.maxCarinho = 10;
        uni.carinhometro = 3;        

        while(true){
            System.out.println("Sua acão: ");

            String line = scanner.nextLine();
            String[] vet = line.split(" ");
            if(vet[0].equals("voar")){
                uni.voar(Integer.parseInt(vet[1]));;
            }
            if(vet[0].equals("subir")){
                uni.subir(Integer.parseInt(vet[1]));
            }
            if(vet[0].equals("end")){
                break;
            }
            

        }
    }
}