<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>

    <body>
        <h1>Employee Login Form</h1>
        <form action="login" method="post">
            <table style="with: 100%">
                <tr>
                    <td>User Name</td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
            </table>
            <input type="submit" value="Submit" />
            <tr>
            <p><span style="color:red">${error}</span></p>
            </tr>
        </form>
    </body>

    </html>