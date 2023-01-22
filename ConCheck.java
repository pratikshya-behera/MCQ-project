import java.sql.*;

class ConCheck 
{
  public static void main(String args[])
  {
    try
    {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("oracle:jdbc:thin:@localhost:1521:xe","system","system");
      System.out.println("Registered..");
      con.close();
    }
    catch(Exception e){System.out.println(e);}
  }
}