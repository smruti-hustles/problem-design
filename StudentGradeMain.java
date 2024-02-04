//Student grade system using jdbc
import java.util.*;
import java.sql.*;
public class StudentGradeMain
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details","root","tiger");
	    
		System.out.println("1.Enter student details\n2.update marks\n3.delete marks\n4.display result");
		System.out.println("Enter choice");
		int ch=sc.nextInt();
		switch(ch){
		    case 1:
		        System.out.println("Creating or entering student details");
		        System.out.println("Enter id,name,m1,m2,m3");
		        int id=sc.nextInt();
		        int name=sc.next();
		        int m1=sc.nextInt();
		        if(m1>0 && m1<=100)
		        {
		            int m2=sc.nextInt();
		            if(m2>0 && m2<=100){
		                int m3=sc.nextInt();
		                if(m3>0 && m3<=100){
		                    PreparedStatement ps=con.PreparedStatement("insert into student values(?,?,?,?,?)");
		                    ps.setInt(1,id);
		                    ps.setInt(1,name);
		                    ps.setInt(1,m1);
		                    ps.setInt(1,m2);
		                    ps.setInt(1,m3);
		                    ps.execute();
		                 }
		                else{
		                System.out.println("Invalid marks");  
		                }
		            }
		            else{
		              System.out.println("Invalid marks");  
		            }
		        }
		        else{
		            System.out.println("Invalid marks");
		           }
	         	}
	          }}
	
	         System.out.println("Student Created");
            	break;
        case 2:
            System.out.println("Going to update marks");
            System.out.println("Enter id");
            int id1=sc.nextInt();
            Statement st=con.createStatement();
            ResultSet rs1=st.executeQuery("select * from student");
            while(rs1.next()){
                if(rs1.getInt(1)==id1){
                    System.out.println("enter which mark you want to chnage");
                    int posi1=sc.nextInt();
                    Statement st1=con.createStatement();
                    System.out.println("enter mark");
                    int mark1=sc.nextInt();
                    if(mark1>0 && mark1<=100){
                        String query="update student set m"+posi1+"="+mark1+"where std_id="+id1;
                        st1.executeUpdate(query);
                        System.out.println("mark updated");
                        }
                    else{System.out.println("enter valid mark");   }
                }
            }
            break;
        case 3:
            System.out.println("Going to delete mark");
            System.out.println("Enter id");
            int id2=sc.nextInt();
            PreparedStatement ps2=con.prepareStatement("delete from student where sd_id=?;");
            ps2.setInt(1,id2);
            ps2.execute();
            System.out.println("Deleted Successfully");
            break;
        case 4:
            System.out.println("Going to display result");
            System.out.println("Enter id");
            int id3=sc.nextInt();
            Statement st=con.createStatement();
            ResultSet rs3=st.executeQuery("select * from student");
            while(rs3.next()){
                if(rs3.getInt(1)==id3){
                    
                    if(rs3.getInt(3)>0 && rs3.geInt(3)<=25)
                    System.out.println(rs3.getInt(3)+" F ");
                    else if(rs3.getInt(3)>25 && rs3.geInt(3)<=65)
                    System.out.println(rs3.getInt(3)+" C ");
                    else if(rs3.getInt(3)>65 && rs3.geInt(3)<=85)
                    System.out.println(rs3.getInt(3)+" B ");
                    else if(rs3.getInt(3)>85 && rs3.geInt(3)<=100)
                    System.out.println(rs3.getInt(3)+" A ");
                    
                     if(rs3.getInt(4)>0 && rs3.geInt(4)<=25)
                    System.out.println(rs3.getInt(4)+" F ");
                    else if(rs3.getInt(4)>25 && rs3.geInt(4)<=65)
                    System.out.println(rs3.getInt(4)+" C ");
                    else if(rs3.getInt(4)>65 && rs3.geInt(4)<=85)
                    System.out.println(rs3.getInt(4)+" B ");
                    else if(rs3.getInt(4)>85 && rs3.geInt(4)<=100)
                    System.out.println(rs3.getInt(4)+" A ");
                    
                     if(rs3.getInt(5)>0 && rs3.geInt(5)<=25)
                    System.out.println(rs3.getInt(5)+" F ");
                    else if(rs3.getInt(5)>25 && rs3.geInt(5)<=65)
                    System.out.println(rs3.getInt(5)+" C ");
                    else if(rs3.getInt(5)>65 && rs3.geInt(5)<=85)
                    System.out.println(rs3.getInt(5)+" B ");
                    else if(rs3.getInt(5)>85 && rs3.geInt(5)<=100)
                    System.out.println(rs3.getInt(5)+" A ");
                    
                    
                }
            }
            break;
            
        default:System.out.println("Invalid Option");  
            break;
           
        }    
		
	}
}
