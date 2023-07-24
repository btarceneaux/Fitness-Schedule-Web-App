<%@page import="java.util.List"%>
<%@page import="com.dao.BatchDao"%>
<%@page import="com.bean.Batch"%>
<%@page import="com.bean.Participant"%>
<%@page import="com.dao.ParticipantDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/updateParticipant.css">
    <meta charset="UTF-8">
    <title>Update Participant</title>
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
        Object obj = session.getAttribute("participantId"); 
        int participantId = (int)obj;
        
        Participant myParticipant = ParticipantDao.getParticipantById(participantId); 
        request.setAttribute("myParticipant",myParticipant); 
        
        List<Batch> batchList = BatchDao.getAllBatches();
        request.setAttribute("batchList", batchList);
    %>
    <h2>Update Participant</h2>
    <div id="updateParticipantDisplay">
        <form action="updateExistingParticipant?id=<c:out value='${myParticipant.getUserId()}'/>" method="post">
            <label>First Name  : </label>
            <input type="text" name="firstName" value="<c:out value='${myParticipant.getFirstName()}'/>"><br><br>
            <label>Last Name  : </label>
            <input type="text" name="lastName" value="<c:out value='${myParticipant.getLastName()}'/>"><br><br>
            <label>Email : </label>
            <input type="text" name="emailAddress" value="<c:out value='${myParticipant.getEmail()}'/>"><br><br>
            <label>Password :</label>
            <input type="password" name="password" value="<c:out value='${myParticipant.getPassword()}'/>"><br><br>
            <label>Batch :</label>
            <select name="batchId" id="batchId">
            <option></option>
            <c:forEach var="batch" items="${batchList}">
                <option>${batch.getBatchId()} ${batch.getBatchDay()} ${batch.getBatchTime()}</option>
            </c:forEach>
            </select><br><br>
            <div id="buttonContainer">
                <button type="submit">Submit</button>
            </div>
        </form>
    </div>

</body>
</html>