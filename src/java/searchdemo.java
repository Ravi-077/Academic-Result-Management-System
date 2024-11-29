
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class searchdemo extends HttpServlet
{ 
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
{
PrintWriter out=response.getWriter();
out.println("<html>");
out.println("<head>");
out.println("<link rel='stylesheet' href='Demo18.css'>");
out.println("</head>");
out.println("<body>");

out.println("<div id='mymenu'>");

out.println(" <ul> <li> Home </li> <li><a href='insertdemo.html'> Insert  </a> </li> <li> <a href='Searchdemo.html'>Search </a> </li> <li> <a href='show'> <a/> </li> <li> <a href='updatedemo.html'> Update </a> </li> <a href='deletedemo.html'> <li> Delete </a> </li><li><a href='Logindemo1.html'> LogOut </a> </li> <li> About </li> <li> Contact </li> </ul>");

out.println("</div>");

out.println("<div id='mydata'>");

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql:///ravidb?useSSL=false","root","root");
Statement st=con.createStatement();
String s1=request.getParameter("u1");
String q="select * from insmarks where URNO='"+s1+"' ";
ResultSet rs=st.executeQuery(q);
out.println("<center>");
out.println("<table cellpadding='12'>");

if(rs.next())
{
out.println("<tr>");
out.println("<td> RNO </td>");
out.println("<td>"+rs.getString(1)+"</td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td> Name </td>");
out.println("<td>"+rs.getString(2)+"</td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td> Physics </td>");
out.println("<td>"+rs.getString(3)+"</td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td> Chemishtry </td>");
out.println("<td>"+rs.getString(4)+"</td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td> Maths </td>");
out.println("<td>"+rs.getString(5)+"</td>");
out.println("</tr>");

out.println("<tr>");
out.println("<td> RNO </td>");
out.println("<td>"+rs.getString(1)+"</td>");
out.println("</tr>");
}
else
{
	
out.println("<h1> Invalid URNO");
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
out.println("</body>");
out.println("</html>");
out.close();
}

}

//set classpath=C:\Program Files\Apache Software Foundation\Tomcat 8.5\lib\servlet-api.jar;.;%classpath%rchdemo extends Htt