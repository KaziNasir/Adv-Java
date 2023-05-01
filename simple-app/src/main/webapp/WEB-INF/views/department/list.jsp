<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Departments</title>
</head>
<body>

<h1>Departments</h1>

<input type="button" value="Add Department" onclick="window.location.href='create';return false;">

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Department Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${departments}" var="department">
        <tr>
            <c:url var="updateLink" value="/departments/edit">
                <c:param name="departmentId" value="${department.id}" />
            </c:url>
            <c:url var="deleteLink" value="/departments/delete">
                <c:param name="departmentId" value="${department.id}" />
            </c:url>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
