package openproject;

import java.sql.*;
public class DB_control {
	static final String id = "";
	static final String pass = "";
	String url = "";
	Connection conn = null;
	Statement st = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
   DB_control() {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url,id,pass);
         st = conn.createStatement();
         System.out.println("Connect");
      }
      catch(ClassNotFoundException e)
      {
         System.out.println(e.getMessage());
      }
      catch (SQLException e)
      {
         System.out.println("SQLException: " + e.getMessage());
         System.out.println("SQLState: " + e.getSQLState());
      }
   }
   public void insert_user_info(String[] u_arr) {
	   String sql = "insert into userlist(Id, Password, name, phone, email) values (?,?,?,?,?)";
	   try {
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, u_arr[0]);
		   pstmt.setString(2, u_arr[1]);
		   pstmt.setString(3, u_arr[2]);
		   pstmt.setString(4, u_arr[3]);
		   pstmt.setString(5, u_arr[4]);
		   pstmt.executeUpdate();
	   }
	   catch(SQLException e) {
		   e.printStackTrace();
	   }
   }
   public boolean check(String id) {
	   String sql = "select count(Id) from userlist where Id='"+id+"'";
	   try {
		   rs=st.executeQuery(sql);
		   if(rs.next())
		   {
			   if(rs.getInt("count(Id)")==1)
				   return false;
			   else 
				   return true;
		   }
	   }
	   catch(SQLException e) {
		   e.printStackTrace();
	   }
	   return true;
   }
   public boolean login(String id, String password) {
	   String sql = "select count(Id) from userlist where Id='"+id+"' and Password='"+password+"'";
	   try {
		   rs=st.executeQuery(sql);
		   if(rs.next())
		   {
			   if(rs.getInt("count(Id)")==1)
				   return true;
			   else 
				   return false;
		   }
	   }
	   catch(SQLException e) {
		   e.printStackTrace();
	   }
	   return false;
   }
   public void insert_user_info2(String[] u_arr, String id) {

	   String sql = "update userlist set gender='"+u_arr[0]+"', age='"+u_arr[1]+"', job='"+u_arr[2]+"', hobby1='"+u_arr[3]+"', hobby2='"+u_arr[4]+"', type='"+u_arr[5]+"', "
	   		+ "food='"+u_arr[6]+"', movie='"+u_arr[7]+"', music='"+u_arr[8]+"', hate1='"+u_arr[9]+"', hate2='"+u_arr[10]+"', comment='"+u_arr[11]+"' where Id='"+id+"'";
	   try {
		   st.executeUpdate(sql);
	   }
	   catch(SQLException e) {
		   e.printStackTrace();
	   }
   }
   public String matching(String[] u_arr) {
	   String sql = "select Id from userlist where gender='"+u_arr[0]+"' and age='"+u_arr[1]+"'and job='"+u_arr[2]+"' and hobby1='"+u_arr[3]+"' "
	   		+ "and hobby2='"+u_arr[4]+"' and movie='"+u_arr[5]+"' and music='"+u_arr[6]+"'";
	   try {
		   rs=st.executeQuery(sql);
		   return sql;
		   }
	   catch(SQLException e) {
		   e.printStackTrace();
	   }
	   return null;
   }
   public ResultSet matching2(String sql) {
	   try {
		   rs=st.executeQuery(sql);
		   return rs;
		   }
	   catch(SQLException e) {
		   e.printStackTrace();
	   }
	   return null;
   }
   public ResultSet profile(String id) {
	   String sql = "select * from userlist where Id='"+id+"'";
	   try {
		   rs=st.executeQuery(sql);
		   return rs;
	   }
	   catch(SQLException e) {
		   e.printStackTrace();
	   }
	   return null;
   }
}
