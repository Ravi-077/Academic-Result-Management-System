import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Regisdemo extends HttpServlet
{
	public void doPost(HttpServletRequest request ,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("Name");
		String s2=request.getParameter("gmail");
		String s3=request.getParameter("Password");
		String s4=request.getParameter("rollno");
		out.println("<html>");
		out.println("<body>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///srs?useSSL=false","root","root");
			Statement st=con.createStatement();
                        
                        if(s4==null||s4.isEmpty())
                        {
			String q="insert into register  values('"+s1+"','"+s2+"','"+s3+"')";
			st.executeUpdate(q);
                        }
                        else
                        {
                        String q1="insert into S_Register  values('"+s1+"','"+s4+"','"+s2+"','"+s3+"')";
			st.executeUpdate(q1);
                        }
			response.sendRedirect("login.html");
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body>");
		out.println("</html>");
	}	
}