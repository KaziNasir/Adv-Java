<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Employee</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <style>
        body {
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            background-color: #f5f5f5;
        }
        h1 {
            text-align: center;
            margin-top: 2rem;
            color: #333;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 2rem;
            border-radius: 5px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.2);
        }
        label {
            display: block;
            margin-bottom: 0.5rem;
            color: #333;
        }
        input[type="text"], input[type="date"], input[type="email"] {
            width: 100%;
            padding: 0.5rem;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 1rem;
        }
        input[type="radio"] {
            margin-right: 0.5rem;
        }
        button[type="submit"] {
            background-color: #008CBA;
            color: #fff;
            border: none;
            border-radius: 4px;
            padding: 0.5rem 1rem;
            cursor: pointer;
        }
        button[type="submit"]:hover {
            background-color: #00698C;
        }
    </style>
</head>
<body>

<h1>Create Employee</h1>

<form:form action="store" modelAttribute="employee">
    <label for="employee_name">Name:</label>
    <form:input path="name" id="employee_name"/>
    <form:errors path="name"/>
    <br>
    <label for="employee_isStaff">Type:</label>
    <div>
        <label for="staff_type">Staff:</label>
        <form:radiobutton path="isStaff" id="staff_type" value="true"/>
        <label for="non_staff_type">Non-Staff:</label>
        <form:radiobutton path="isStaff" id="non_staff_type" value="false"/>
    </div>
    <form:errors path="isStaff"/>
    <br>
    <label for="employee_joiningDate">Joining Date:</label>
    <form:input path="joiningDate" type="date" id="employee_joiningDate"/>
    <form:errors path="joiningDate"/>
    <br>
    <br>
    <button type="submit">Submit</button>
</form:form>

</body>
</html>
