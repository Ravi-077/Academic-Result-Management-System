
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Showdemo1 extends HttpServlet
{
	public void doGet(HttpServletRequest request ,HttpServletResponse  response) throws IOException,ServletException
	{
	PrintWriter out=response.getWriter();
	out.println("<html>");
	out.println("<head>");
        out.println("<link rel='stylesheet' href='Demo18.css'>");
	out.println("</head>");
	out.println("<body>");
	out.println("<div id='mydata'>");
	try
	{
		

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ravidb?useSSL=false","root","root");
			Statement st=con.createStatement();
			String q="select * from insmarks";
			ResultSet rs=st.executeQuery(q);
			
			out.println("<center>");
			out.println("<table cellpadding=12>");
			out.println("<tr>");
			out.println("<td>RNO</td>");
			out.println("<td>Name</td>");
			out.println("<td>physics</td>");
			out.println("<td>chemistry</td>");
			out.println("<td>maths</td>");
			out.println("</tr>");
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</center>");
			out.println("</div>");
			
			con.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
	out.println("</html>");
	out.println("</head>");
	out.close();
	}
}
