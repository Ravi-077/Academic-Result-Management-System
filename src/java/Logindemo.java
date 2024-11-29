import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Logindemo extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String s1 = request.getParameter("gmail");
        String s2 = request.getParameter("Password");
        String s3 = request.getParameter("rollno");
        
        out.println("<html>");
        out.println("<body>");
        
        try {
            // Step 1: Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Step 2: Establish Connection
            Connection con = DriverManager.getConnection("jdbc:mysql:///srs?useSSL=false", "root", "root");

            // Step 3: Determine user type
            if (s3 == null || s3.isEmpty()) {
                // Teacher login
                String query = "SELECT * FROM register WHERE gmail_id = ? AND Password = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, s1);
                ps.setString(2, s2);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    // Login successful
                    Cookie ck = new Cookie("uname", s1); // Set user email in cookie
                    ck.setMaxAge(60 * 60 * 4); // Cookie valid for 4 hours
                    response.addCookie(ck);
                    response.sendRedirect("menu.html");
                } else {
                    out.println("<h1>Invalid username or password</h1>");
                }
            } else {
                // Student login
                String query = "SELECT * FROM S_Register WHERE gmail = ? AND Password = ? AND RollNo = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, s1);
                ps.setString(2, s2);
                ps.setString(3, s3);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    // Login successful
                    Cookie ck = new Cookie("uname", s1); // Set user email in cookie
                    ck.setMaxAge(60 * 60 * 4); // Cookie valid for 4 hours
                    response.addCookie(ck);
                    response.sendRedirect("menu.html");
                } else {
                    out.println("<h1>Invalid username, roll number, or password</h1>");
                }
            }

            // Step 4: Close connection
            con.close();
        } catch (Exception e) {
            // Log the error (do not print to the user)
            e.printStackTrace();
            out.println("<h1>An error occurred. Please try again later.</h1>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}