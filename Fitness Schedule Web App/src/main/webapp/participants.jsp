<%@page import="com.dao.ParticipantDao"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Participant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/main.css">
    <meta charset="UTF-8">
    <title>Display Participants</title>
</head>
<body>
    <div>
        <nav>
            <ul><a href="index.html">Home</a></ul>
            <ul><a href="addBatch.html">Add Batch</a></ul>
            <ul><a href="addParticipant.html">Add Participant</a></ul>
            <ul><a href="batches.jsp">View/Edit Batches</a></ul>
            <ul><a href="participants.jsp">View/Edit Participants</a></ul>
            <ul><a href="batchParticipants.jsp">View/Edit Batch Participants</a></ul>
        </nav>
    </div>
    <%
        List<Participant> participantList = ParticipantDao.getAllParticipants(); 
        request.setAttribute("participantList",participantList); 
    %>
    <h2>PARTICIPANT JSP PAGE</h2>
    <table border=1 solid>
        <tr>
            <th>Participant Id</th>
            <th>Last Name</th>
            <th>First Name</th>
            <th>Email Address</th>
            <th>Action</th>
        </tr>
        <c:forEach var="participant" items="${participantList}"> 
        <tr>
            <td>${participant.getUserId()}</td>
            <td>${participant.getLastName()}</td>
            <td>${participant.getFirstName()}</td>
            <td>${participant.getEmail()}</td>
            <td>
                <a href="deleteParticipant?id=<c:out value='${participant.getUserId()}'/>">Delete</a> or 
                <a href="updateParticipant?id=<c:out value='${participant.getUserId()}'/>">Update</a>
            </td>
        </tr>
        </c:forEach>
    </table> 
</body>
</html>