@WebServlet("/saveAttendance")
public class AttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "school_admin", "school_password");

            stmt = conn.prepareStatement("INSERT INTO students (name, date, status) VALUES (?, ?, ?)");
            stmt.setString(1, name);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setString(3, status);

            int rowsAffected = stmt.executeUpdate();

            response.setContentType("text/html");
            if (rowsAffected > 0) {
                response.getWriter().println("<h2>Attendance saved successfully!</h2>");
            } else {
                response.getWriter().println("<h2>Failed to save attendance.</h2>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error: " + e.getMessage() + "</h2>");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
