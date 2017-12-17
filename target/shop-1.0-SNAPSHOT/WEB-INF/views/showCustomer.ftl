<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>User Info</h1>
<table>
    <tr>
        <td>Id</td>
        <td>${customer.id}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${customer.firstName}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${customer.email}</td>
    </tr>
</table>
<br>
<a href="/customers">Back</a>
</body>
</html>