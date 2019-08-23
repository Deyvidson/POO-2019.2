import java.util.Scanner;

class Peixe{
    int barriga = 0;
    int maxBarriga = 5;

    void alimentar(int qtd){
        System.out.println("Nhami Nhami");
        barriga += qtd;
        if(barriga>maxBarriga){
            System.out.println("Peixe explodiu de tanto comer");
        }
    }
    void esperar(){
        System.out.println("Dando rolê pelo aquiário");
        barriga -= 1;
        if(barriga<0){
            System.out.println("O peixe morreu de fome");
        }
    }
    void status(){
        System.out.println("O peixe está com a barriga: " + barriga);
    }
}

public class Entradas{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Peixe nemo = new Peixe();
        
        System.out.println("feed; wait; show; end");

        while(true) {
            String line = scanner.nextLine();
            String[] vet = line.split(" ");

            if(vet[0].equals("feed")){
                nemo.alimentar(Integer.parseInt(vet[1]));
            }if(vet[0].equals("wait")){
                nemo.esperar();
            }if(vet[0].equals("show")){
                nemo.status();
            }if(vet[0].equals("end")){
                break;
            }
        }
    }
}
