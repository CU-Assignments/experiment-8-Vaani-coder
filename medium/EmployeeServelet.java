@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db", "admin_user", "secure_password");

            if (idParam != null) {
                int id = Integer.parseInt(idParam);
                stmt = conn.prepareStatement("SELECT * FROM employees WHERE id = ?");
                stmt.setInt(1, id);
                rs = stmt.executeQuery();

                response.setContentType("text/html");
                if (rs.next()) {
                    response.getWriter().println("<h2>Employee Found:</h2>");
                    response.getWriter().println("<p>ID: " + rs.getInt("id") + "</p>");
                    response.getWriter().println("<p>Name: " + rs.getString("name") + "</p>");
                    response.getWriter().println("<p>Department: " + rs.getString("department") + "</p>");
                } else {
                    response.getWriter().println("<h2>No employee found with ID: " + id + "</h2>");
                }
            } else {
                stmt = conn.prepareStatement("SELECT * FROM employees");
                rs = stmt.executeQuery();

                response.setContentType("text/html");
                response.getWriter().println("<h2>Employee List:</h2>");
                while (rs.next()) {
                    response.getWriter().println("<p>ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                            ", Department: " + rs.getString("department") + "</p>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error: " + e.getMessage() + "</h2>");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
