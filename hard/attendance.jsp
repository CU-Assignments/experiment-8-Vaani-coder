<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Attendance Portal</title>
</head>
<body>
    <h2>Enter Attendance Details</h2>
    <form action="saveAttendance" method="post">
        Student Name: <input type="text" name="name"><br><br>
        Date: <input type="date" name="date"><br><br>
        Status: 
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>
        <input type="submit" value="Save">
    </form>
</body>
</html>
