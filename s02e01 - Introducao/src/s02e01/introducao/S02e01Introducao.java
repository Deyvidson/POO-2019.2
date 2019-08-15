
package s02e01.introducao;

import static java.time.Clock.system;

public class S02e01Introducao {

    public static void main(String[] args) {
        int i;
        int cont = 0;
        /*for (i=150;i<=300;i++){
            System.out.println(i);
        }*/
        /*for (i=1;i<=1000;i++){
            cont += i;}
        System.out.println(cont);*/
        for (i=1;i<=100;i++){
            if(i%3==0){
                System.out.println(i);
            }             
        }
    }
    
}
