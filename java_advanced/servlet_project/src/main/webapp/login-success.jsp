<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="ISO-8859-1">
            <title>Insert title here</title>
        </head>
        <body>
            <h1>You have logined successfully</h1>
            <table style="with: 100%">
                <tr>
                    <p>You user name: ${user.email}</p>
                </tr>
                <tr>
                    <p>You password: ${user.password}</p>
                </tr>
            </table>
        </body>
        </html>