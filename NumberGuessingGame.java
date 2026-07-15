import java.util.Scanner;
import java.util.Random;
public class Game{
       public static void main(String[] args){
            Random ra = new Random();
            Scanner sc = new Scanner(System.in);
            System.out.println("the number genrate by computer in range from 1 to 100 : ");
            int a = ra.nextInt(0,100)+1;

            while(true){
                System.out.println("enter the number in range (1 to 100) :");
                int b = sc.nextInt();
                if(a==b){

                    System.out.println("your guess is right ");
                    break;
                }else if(a>b){
                    System.out.println("your guessed number is lower than the number selected by computer");

                }else{
                    System.out.println("your guessed number is higher than the number selected by computer");

                }
            }

    }

}