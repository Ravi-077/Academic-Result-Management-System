
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Deletedata extends HttpServlet
{    
    public void doPost(HttpServletRequest request ,HttpServletResponse response)throws IOException,ServletException
    {
        PrintWriter out=response.getWriter();
        String s1=request.getParameter("rollno");
       try
       {
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql:///srs?useSSL=false","root","root");
       Statement st=con.createStatement();
       String q="DELETE from S_Register where rollno='"+s1+"'";
       st.executeUpdate(q);
      response.sendRedirect("Logindemo.html");
       }
       catch(SQLException |ClassNotFoundException e)
       {
           out.println(e);
       }
    }  
}