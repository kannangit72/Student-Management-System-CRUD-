import java.sql.*; 

public class JDBC2 {

	public static void main(String[] args) throws Exception {
	   readrecord();
	}

	public static void readrecord() throws Exception {
		
		String url="jdbc:mysql://localhost:3306/jdbcdemo2";
		String username="root";
		String password="root";
		String query="select * from employee";
		
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery(query);
        
		while(rs.next()) {
		System.out.println("ID is "+ rs.getInt(1));
		System.out.println("Name is "+rs.getString(2));
		System.out.println("Salary is "+rs.getInt(3));
		System.out.println();
		}
		con.close();
	}
	
public static void deleterecord() throws Exception {
		
		String url="jdbc:mysql://localhost:3306/jdbcdemo2";
		String username="root";
		String password="root";
		int id=4;
		String query="delete from employee where emp_id="+id;
		
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		int rs =st.executeUpdate(query);
        
		System.out.println("Number of Rows Affected : "+rs);
		con.close();
	}

public static void insertrecord() throws Exception {
	
	String url="jdbc:mysql://localhost:3306/jdbcdemo2";
	String username="root";
	String password="root";
	
	int id=4;
	String name="Varun";
	int salary=300000;
	
	String query="insert into employee values(?,?,?);";
	
	Connection con = DriverManager.getConnection(url, username, password);
	PreparedStatement pst=con.prepareStatement(query);
	pst.setInt(1,id);
	pst.setString(2,name);
	pst.setInt(3, salary);
	int rs =pst.executeUpdate();
    
	System.out.println("Number of Rows Affected : "+rs);
	con.close();
}
public static void updaterecord() throws Exception {
	
	String url="jdbc:mysql://localhost:3306/jdbcdemo2";
	String username="root";
	String password="root";
	int id=1;
	String query="update employee set salary=200000 where emp_id="+id;
	
	Connection con = DriverManager.getConnection(url, username, password);
	Statement st = con.createStatement();
	int rs =st.executeUpdate(query);
    
	System.out.println("Number of Rows Affected : "+rs);
	con.close();
}


}
