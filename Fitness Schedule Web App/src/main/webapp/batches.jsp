<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Batch"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Batches</title>
</head>
<body>
    <h2>BATCH JSP PAGE</h2>
    <table>
    <tr>
        <th>Batch Id</th>
        <th>Day</th>
        <th>Time</th>
    </tr> 
    </table>  
        <c:forEach var="batch" items="${batchList}" >
          ${batch}
        </c:forEach>
    

</body>
</html>