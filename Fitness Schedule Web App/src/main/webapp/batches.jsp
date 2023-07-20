<%@page import="com.dao.BatchDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Batch"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/main.css">
    <meta charset="UTF-8">
    <title>Display Batches</title>
</head>
<body>
    <div>
        <nav>
            <ul><a href="index.html">Home</a></ul>
            <ul><a href="addBatch.html">Add Batch</a></ul>
            <ul><a href="addParticipant.html">Add Participant</a></ul>
            <ul><a href="updateBatch.html">Update Batch</a></ul>
            <ul><a href="updateParticipant.html">Update Participant</a></ul>
            <ul><a href="batches.jsp">View Batches</a></ul>
            <ul><a href="participants.jsp">View Participants</a></ul>
            <ul><a href="batchParticipants.jsp">View Batch Participants</a></ul>
        </nav>
    </div>
    <%
        List<Batch> batchList = BatchDao.getAllBatches(); 
        request.setAttribute("batchList",batchList);  
    %>
    <h2>BATCH JSP PAGE</h2>
        <table border=1 solid>
            <tr>
                <th>Batch Id</th>
                <th>Day</th>
                <th>Time</th>
                <th>Action</th>
            </tr>
            <c:forEach var="batch" items="${batchList}"> 
            <tr>
                <td>${batch.getBatchId()}</td>
                <td>${batch.getBatchDay()}</td>
                <td>${batch.getBatchTime()}</td>
                <td>
                    <a href="deleteBatch?id=<c:out value='${batch.getBatchId()}'/>">Delete</a> or 
                    <a href="updateBatch?id=<c:out value='${batch.getBatchId()}'/>">Update</a>
                </td>
            </tr>
            </c:forEach>
        </table> 
</body>
</html>