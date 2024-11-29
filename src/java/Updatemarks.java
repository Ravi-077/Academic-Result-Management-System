import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

public class Updatemarks extends HttpServlet 
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
            PrintWriter out =response.getWriter();
            String s3=request.getParameter("t1");
            String s4=request.getParameter("t2");
            String s5=request.getParameter("t3");
            String s6=request.getParameter("t4");
            String s7=request.getParameter("t5");
            String s8=request.getParameter("t6");
                 try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql:///srs?useSSL=false","root","root");
                    Statement st=con.createStatement();
                    String q="update insdata set Name='"+s3+"', DBMS='"+s5+"',TOC='"+s6+"',DA='"+s7+"',IWT='"+s8+"' where RNO='"+s4+"' ";
                    System.out.println(q);
                    int affectedRow=st.executeUpdate(q); 
                    if(affectedRow>0)
                    {
                    response.sendRedirect("menu.html");
                    }
                    else
                    {
                    out.println("Updation failed");}
                }
                catch(Exception e)
                {
                    out.println(e);
                }
    }
}