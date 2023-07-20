<%@page import="com.bean.Batch"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Batch</title>
</head>
<body>
    <%
        Object obj = session.getAttribute("batchId"); 
        int myBatchId = (int)obj;
        request.setAttribute("myBatchId", myBatchId);
    %>
    <h2>Update Batch</h2>
    <div class="add">
        <form action="updateExistingBatch" method="post">
            <b>Batch ID</b><br>
            <input type="text" value="<c:out value='${myBatchId}'/>" readonly><br>
             <b>Please Select A Day : </b>
            <select name="day" id="day">
                <option value="Sunday" class="optionDay">Sunday</option>
                <option value="Monday" class="optionDay">Monday</option>
                <option value="Tuesday" class="optionDay">Tuesday</option>
                <option value="Wednesday" class="optionDay">Wednesday</option>
                <option value="Thursday" class="optionDay">Thursday</option>
                <option value="Friday" class="optionDay">Friday</option>
                <option value="Saturday" class="optionDay">Saturday</option>
            </select><br><br>
            <b>Please Select A Time : </b>
            <select name="time" id="time">
                <option value="8:00am">8:00am</option>
                <option value="9:00am">9:00am</option>
                <option value="10:00am">10:00am</option>
                <option value="11:00am">11:00am</option>
                <option value="12:00pm">12:00pm</option>
                <option value="1:00pm">1:00pm</option>
                <option value="2:00pm">2:00pm</option>
                <option value="3:00pm">3:00pm</option>
                <option value="4:00pm">4:00pm</option>
                <option value="5:00pm">5:00pm</option>
                <option value="6:00pm">6:00pm</option>
            </select>
            <br><br>
            <input type="submit" id="add-submit">
        </form>
    </div>
</body>
</html>