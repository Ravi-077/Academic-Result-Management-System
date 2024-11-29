
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Menudemo extends HttpServlet {
    
    public void doGet(HttpServletRequest request ,HttpServletResponse response)throws IOException,ServletException
    {
        PrintWriter out=response.getWriter();
        /*
     HttpSession session=request.getSession();
     String s1=(String)session.getAttribute("uname");
        if(s1!=null)
             */
     Cookie ck[]=request.getCookies();
     if(ck!=null)
     {
out.println("<html>");
out.println("<head>");
out.println("<link rel='stylesheet' href='Demo18.css'>");
out.println("</head>");
out.println("<body>");
out.println("<div id='mymenu'>");
out.println("<ul>");
out.println("<li >Home</li>");
out.println("<li><a href='insertdemo.html'>Insert</a></li>");
out.println("<li><a href='Showdemo1'>ShowAll</a></li>");
out.println("<li><a href='Search.html'>Search</a></li>");
out.println("<li><a href='Update.html'>Update</a></li>");
out.println("<li><a href='Logoutdemo'>logout</a></li>");
out.println("<li>about</li>");
out.println("<li>Contact</li>");
out.println("</ul>");

out.println("<center>");
//out.println("<h1>Welcome </h1>"+s1);
out.println("</center>");
out.println("</div>");
out.println("<div id='mydata'>");
out.println("</body>");
out.println("</html>");
        }
        else
        {
            response.sendRedirect("Logindemo.html");
        }
        
        }}