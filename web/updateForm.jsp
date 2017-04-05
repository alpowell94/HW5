
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Basketball"%>
<% Basketball basketball = (Basketball) request.getAttribute("basketball"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Player</title>
    </head>
    <body>
        <h1>Update A Player</h1>
        <form name="updateForm" action="updateBasketball" method="get">
           
            <table class="update">
                <tr>
                     <td class="right">Baller ID:</td>
                     <td><input type="text" name="id" value="<%= basketball.getBallerID() %>" /></td>
                </tr>
                 <tr>
                     <td class="right">Player Name:</td>
                     <td><input type="text" name="name" value="<%= basketball.getPlayerName() %>" /></td>
                </tr>
                <tr>
                     <td class="right">Age:</td>
                     <td><input type="text" name="age" value="<%= basketball.getAge() %>" /></td>
                </tr>
                <tr>
                     <td class="right">College:</td>
                     <td><input type="text" name="college" value="<%= basketball.getCollege() %>" /></td>
                </tr>
                <tr>
                     <td class="right">PPG:</td>
                     <td><input type="text" name="ppg" value="<%= basketball.getPpg() %>" /></td>
                </tr>
                <tr>
                     <td class="right">RPG:</td>
                     <td><input type="text" name="rpg" value="<%= basketball.getRpg() %>" /></td>
                </tr>
                <tr>
                     <td class="right">APG:</td>
                     <td><input type="text" name="apg" value="<%= basketball.getApg() %>" /></td>
                </tr>
            </table>
                <br>
                <input type="reset" name="reset" value="Clear" />
                <input type="submit" name="submit" value="Submit" />
            
                
                
                
    </body>
</html>
