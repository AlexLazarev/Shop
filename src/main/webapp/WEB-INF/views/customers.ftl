<!DOCTYPE html>
<html lang="en">
<body>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Email</td>
    </tr>
     <#list customers as customer>
        <tr>
            <td><a href="/customers/${customer.id}">${customer.id}</a></td>
            <td>${customer.firstName}</td>
            <td>${customer.email}</td>
            <td><a href="/delete/${customer.id}">delete</a> </td>
            <td><a href="/update/${customer.id}">update</a> </td>
        </tr>
     </#list>
</table>
</body>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
</html>