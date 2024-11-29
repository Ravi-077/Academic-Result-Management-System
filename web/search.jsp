<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search page</title>
    <link rel="stylesheet" href="search.css">
</head>
<body>
    <div class="para">
        *********Search Student Marks And Result*********
    </div>
    <div class="container">
        <form action="search.jsp" method="get">
        <table>     
                <tr>
                    <td>
                        Enrollment No.
                    </td>
                    
                    <td>
                    <input type="text" name="r1" placeholder="Enter Roll NO.">
                    </td>
                    <tr>
            <th colspan="2"><input type="submit" name="r2" value="Search"><br>
                </tr>
        </table>
        </form>
  
                <%
                    String s1=request.getParameter("r1");
                    String s2=request.getParameter("r2");
                    if(s2!=null)
                    {
                     try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql:///srs?useSSL=false","root","root");
                    Statement st=con.createStatement();
                    String q=" select*from insdata  where RNO='"+s1+"' ";
                    ResultSet rs=st.executeQuery(q);
                    if(rs.next())
                    {
                      %>
                      <center>
                      <form action="Updatemarks">
                      <table cellpadding="10">
                          <tr>
                              <td>Name</td>
                              <td><input type="text" name="t1" value="<%= rs.getString(1) %>"></td>
                          </tr>
                          <tr>
                              <td>Roll no.</td>
                              <td><input type="text" name="t2" value="<%= rs.getString(2) %>"></td>    
                          </tr>
                          
                          <tr>
                          <td> DBMS </td>
                          <td><input type="text" name="t3" value="<%=rs.getString(3)%>"></td>
                          </tr>
                          
                          <tr>
                              <td>TOC</td>
                              <td><input type="text" name="t4" value="<%=rs.getString(4)%>"></td>
                              </tr>
                              
                              <tr>
                              <td>DA</td>
                              <td><input type="text" name="t5" value="<%=rs.getString(5)%>"></td>
                              </tr>
                              
                              <tr>
                              <td>IWT</td>
                              <td><input type="text" name="t6" value="<%=rs.getString(6)%>"></td>
                              </tr>
                                  
                              <tr>
                                 <th colspan="2"><input type="submit" name="t7" value="Update"></th>
                              </tr>
                      </table>
                      </form>
                                  <center>
                                  <%
                    }     
                    }
                    catch(Exception e)
                            {
                            out.println(e);
                            }
            }
               %>
        </body>
</html>
            