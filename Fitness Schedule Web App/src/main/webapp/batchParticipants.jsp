<%@page import="com.bean.BatchParticipants"%>
<%@page import="com.dao.BatchParticipantDao"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/bp.css">
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <div>
        <nav>
            <ul><a href="index.html">Home</a></ul>
            <ul><a href="addBatch.html">Add Batch</a></ul>
            <ul><a href="addParticipant.html">Add Participant</a></ul>
            <ul><a href="batches.jsp">View/Edit Batches</a></ul>
            <ul><a href="participants.jsp">View/Edit Participants</a></ul>
        </nav>
    </div>
    <%
        String id = request.getParameter("id");
        int batchId = Integer.parseInt(id);
        
        List<BatchParticipants> batchParticipantList = BatchParticipantDao.getBatchParticipant(batchId);
        request.setAttribute("batchParticipantList", batchParticipantList);
    %>
    <h2>Batch Participants List</h2><br>
    <div id="batchDisplay">
        <table border=1 solid>
            <tr>
                <th>Batch Id</th>
                <th>Participant Id</th>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
            <c:forEach var="batchParticipant" items="${batchParticipantList}">
            <tr>
                <td>${batchParticipant.getBatchId()}</td>
                <td>${batchParticipant.getParticipantId()}</td>
                <td>${batchParticipant.getParticipantLastName()}</td>
                <td>${batchParticipant.getParticipantFirstName()}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
  
</body>
</html>