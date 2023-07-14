<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Batch"%>
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
        <%
            Object obj = session.getAttribute("batchList");
            List<Batch> myBatchList = (List<Batch>)obj;

            if(myBatchList.size() > 0)
            {
                Iterator<Batch> bi= myBatchList.iterator();
                while(bi.hasNext())
                {
                    Batch tempBatch = bi.next();
                    %>
                    <tr>
                        <td><%=tempBatch.getBatchId() %></td>
                        <td><%=tempBatch.getBatchDay() %></td>
                        <td><%=tempBatch.getBatchTime() %></td>
                    </tr>
                    <%
                }
            }
        %>
    
</table>
</body>
</html>