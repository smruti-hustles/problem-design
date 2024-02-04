//This is a jdbc program implementing
import java.util.*;
import java.sql.*;
public class Main{
public static void main(String args[])throws Exception{
    Scanner sc=new Scanner(System.in);
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank");
    Statement st=con.createStatement();
   
     System.out.print("1.create\n2.withdraw\n3.Deposite\n4.check balance\n");
    System.out.print("Enter your choice = ");
    int ch=sc.nextInt();
   
    switch(ch){
        case 1:
            System.out.println("Enter student name,password,balance");
            String name1=sc.next();
            String pass1=sc.next();
            int amt1=sc.nextInt();
           
            PreparedStatement ps1=con.prepareStatement("inser into table values(?,?,?,?)");
            ps1.setInt(1,2);
            ps1.setString(2,pass1);
            ps1.setString(3,name1);
            ps1.setInt(4,amt1);
            ps1.execute();
            System.out.println("Account is created");
            break;
        case 2: System.out.println("Going to withdraw the money");
        System.out.print("Enter account no = ");
        int acc=sc.nextInt();
        ResultSet rs1=st.executeQuery("select * from table");
        while(rs1.next()){
            if(rs1.getInt(1)==acc){
                 System.out.println("Enter your atm pin");
                 String pin=sc.next();
                 if(rs1.getString(2.equals(pin))){
                     System.out.println("Correct pin, you account details are matching now  please enter the amt that u wanna withdraw");
                    int with=sc.nextInt();
                    if(with>0 && rs1.getInt(4)>with){
                        System.out.println("Withdraw is sucessful");
                        int k=rs1.getInt(4)-with
                        System.out.println("The balance is "+k);
                       
                        PreparedStatement ps2=con.prepareStatement("update table set balance=? where acc=?");
                        ps2.setInt(1,k);//it is showing the remaining balance in the account
                        ps2.setInt(2,acc);
                        ps2.executeUpdate();
                    }
                    else{
                        System.out.println("Insufficient balance");
                    }
                     
                 }
                 else{
                     System.out.println("your acount details does not match please enter correct pin");
                 }
            }
        }
       
            break;
        case 3:
            System.out.println("Going to deposite money");
        System.out.print("Enter account no = ");
        int acc2=sc.nextInt();
        ResultSet rs2=st.executeQuery("select * from table");
        while(rs2.next()){
            if(rs2.getInt(1)==acc2){
                 System.out.println("Enter your atm pin");
                 String pin2=sc.next();
                 if(rs2.getString(2.equals(pin2))){
                     System.out.println("Correct pin, you account details are matching now  please enter the amt that u wanna withdraw");
                    int depo=sc.nextInt();

                        System.out.println("deposite is sucessful");
                        int k2=rs2.getInt(4)-depo;
                        System.out.println("The balance is "+k2);
                       
                        PreparedStatement ps3=con.prepareStatement("update table set balance=? where acc=?");
                        ps3.setInt(1,k2);//it is showing the remaining balance in the account
                        ps3.setInt(2,acc2);
                        ps3.executeUpdate();
                    }
                   
            }
        }
        break;
    case 3:     System.out.println("Lets check your balance");
        System.out.print("Enter account no = ");
        int acc3=sc.nextInt();
        ResultSet rs3=st.executeQuery("select * from table");
        while(rs3.next()){
            if(rs3.getInt(1)==acc3){
                 System.out.println("Enter your atm pin");
                 String pin3=sc.next();
                 if(rs2.getString(2.equals(pin3))){
                   
                        System.out.println("balance is "+rs3.getInt(4));
                       
       
            break;
        default:System.out.print("Invalid choice");
                break;
      }
   
   }
}
