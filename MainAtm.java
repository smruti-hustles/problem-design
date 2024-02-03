//This is the basic atm application program which involves withdraw, deposite, balance enquiry cases
import java.util.*;
public class MainAtm{
    public static void main(String args[]){
    Atm a=new Atm();   

    Scanner sc=new Scanner(System.in);
    int ch;
    boolean status=true;
    while(status){
    System.out.print("1.withdraw\n2.Deposite\n3.check balance\n");
    System.out.print("Enter your choice = ");
    ch=sc.nextInt();
    
    switch(ch){
        case 1: a.withdraw();
            break;
        case 2: a.deposite();
            break;
        case 3: a.balance();
            break;
        default:System.out.print("Invalid choice");
                break;
      }
      System.out.println("Do you want to continue enter true or false");
    status=sc.nextBoolean();
    }
    
  }
}
class Atm{
        int amt=10000;
        int w,w1;
    Scanner sc=new Scanner(System.in);
    void withdraw(){
        System.out.println("Going to withraw....");
        System.out.print("Enter amount = ");
        w=sc.nextInt();
        if(w<amt && w%100==0){
            
                System.out.println("withdraw successful");
                System.out.println("Amount is = "+w);
                System.out.println("balance is = "+(amt-w));
                
                int x,y,z;
                x=w/500;
                System.out.println("500 notes are "+x);
                y=w%500;
                
                z=y/100;
                System.out.println("100 notes are "+z);
                 amt=amt-w;
            }
        else{
           System.out.println("invalid, low balnce"); 
        }
    }
   
    void deposite(){
        System.out.println("Going to deposite....");
        System.out.print("Enter amount = ");
        w1=sc.nextInt();
        
         System.out.println("deposite successful");
         System.out.println("balance is = "+(amt+w1));
         amt=amt+w1;
    }
    
      void balance(){
        System.out.println(amt);
    }
}
