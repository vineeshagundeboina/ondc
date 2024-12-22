<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="${pageContext.request.contextPath}/dashboard" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="userName" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Login">
    </form>
    <div>${error}</div>
    <br>
    <form action="${pageContext.request.contextPath}/register" method="get">
        <input type="submit" value="Register">
    </form>
</body>
</html>