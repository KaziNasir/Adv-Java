<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>List of Employees</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    /* Set font family and background color for the page */
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f0f0;
      margin: 0;
      padding: 0;
    }

    /* Style the heading */
    h1 {
      text-align: center;
      margin-top: 20px;
      margin-bottom: 20px;
      color: #444;
      font-weight: 600;
      font-size: 2rem;
    }

    /* Style the table */
    table {
      width: 100%;
      max-width: 960px;
      margin: 0 auto;
      border-collapse: collapse;
      border: 1px solid #ccc;
      background-color: #fff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    /* Style the table header */
    thead th {
      background-color: #f0f0f0;
      border: 1px solid #ccc;
      padding: 10px;
      text-align: left;
      font-weight: 600;
      font-size: 1.2rem;
    }

    /* Style the table rows */
    tbody td {
      border: 1px solid #ccc;
      padding: 10px;
      text-align: left;
      font-size: 1rem;
    }

    /* Style the table alternate rows */
    tbody tr:nth-child(even) {
      background-color: #f8f8f8;
    }

    /* Style the link */
    a {
      color: #007bff;
      text-decoration: none;
    }

    /* Style the link on hover */
    a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <h1>List of Employees</h1>

  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Joining Date</th>
        <th>Type</th>
        <th>Annual Leave</th>
        <th>Sick Leave</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${employees}" var="employee">
        <tr>
          <td>${employee.id}</td>
          <td>${employee.name}</td>
          <td>${employee.joiningDate}</td>
          <td>${employee.isStaff ? 'Staff' : 'non-Staff'}</td>
          <td>${employee.annualLeaves}</td>
          <td>${employee.sickLeaves}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
