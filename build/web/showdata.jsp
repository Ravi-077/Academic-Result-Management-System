   <%@ page import ="java.sql.*"%> 
   <%
        String show=request.getParameter("show");
        if(show!=null&&show.equals("View"))
            {
        out.println("<html>");
	out.println("<head>");
        out.println("<link rel='stylesheet' href='view.css'>");
	out.println("</head>");
	out.println("<body>");
	out.println("<div id='mydata'>"); 
	try
        {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///srs?useSSL=false","root","root");
			Statement st=con.createStatement();
			String q="select * from insdata";
			ResultSet rs=st.executeQuery(q);
			
			out.println("<center>");
			out.println("<table cellpadding=12 border=2 >");
			out.println("<tr>");
			out.println("<td>Name</td>");
			out.println("<td>Roll No.</td>");
			out.println("<td>DBMS</td>");
			out.println("<td>TOC</td>");
			out.println("<td>DA</td>");
			out.println("<td>IWT</td>");
			out.println("</tr>");
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
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
        %>
        
        
        
         <%
        String rno=request.getParameter("rno");
        String delete=request.getParameter("delete");
        
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql:///srs?useSSL=false","root","root");
        Statement st=con.createStatement();
        String q="delete from insdata where RNO='"+rno+"' ";
        st.executeUpdate(q);
        response.sendRedirect("showdata.jsp");
        con.close();
    }
    catch(Exception e)
    {
    out.println(e);
    }
    %>