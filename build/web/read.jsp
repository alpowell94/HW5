

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="\\home.iowa.uiowa.edu\ajpowell\NetBeansProjects\basketball\readCSS.css">
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    
    
    
    <body>
        <h1>MVP Candidates</h1>
   
    <th>BallerID</th>
    <th>Name</th>
    <th>Age</th>
    <th>College</th>
    <th>PPG</th>
    <th>RPG</th>
    <th>APG</th>
       
    <%= table %>
        
        <br><br>
        
        <a href ="add">Add A New Player</a>
    </body>
</html>
