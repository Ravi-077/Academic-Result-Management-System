import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Insertdemo extends HttpServlet 
{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException ,ServletException
    {
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<body>");
        String s1=request.getParameter("u1");
        String s2=request.getParameter("u2");
        String s3=request.getParameter("u3");
        String s4=request.getParameter("u4");
        String s5=request.getParameter("u5");
        String s6=request.getParameter("u6");
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql:///srs?useSSL=false","root","root");
           Statement st=con.createStatement();
           String q="insert into insdata values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
           st.executeUpdate(q); 
           response.sendRedirect("menu.html");
           out.println("</body>");
           out.println("</html>");
           con.close();
        }
        catch(Exception e)
        {
            out.println(e);
        }
    out.println("</body>");
    out.println("</html>");
    out.close();
    }
}

