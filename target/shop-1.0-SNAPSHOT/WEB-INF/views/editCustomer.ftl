<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
</head>
<body>
    <form name="Customer" action="/updateCustomer" method="post">
        <p>Id</p>
        <input title="Id" type="text" name="id" value="${customer.id}">
        <p>Name</p>
        <input title="Name" type="text" name="firstName" value="${customer.firstName}">>
        <p>Email</p>
        <input title="Email" type="text" name="email" value="${customer.email}">>

        <input type="submit" VALUE="OK">
    </form>
</body>
</html>