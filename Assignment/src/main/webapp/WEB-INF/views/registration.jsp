<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration</title>
    <style>
        body {
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        select,
        input[type="submit"] {
            width: 100%;
            padding: 8px;
            border-radius: 4px;
            background-color: #4285f4;
            color: #fff;
            font-weight: bold;
            border: none;
            cursor: pointer;
        }
        input[type="submit"] {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div>
    <h2>Income Tax Calculator</h2>
</div>

<form method="post" action="calculatedTax">
    <br><br>
    <label for="Category">Category:</label>
    <select name="Category" id="Category">
        <option value="General">General</option>
        <option value="Female/ Senior citizen">Female/ Senior citizen</option>
        <option value="Freedom Fighter">Freedom Fighter</option>
        <option value="Disabled">Disabled</option>
    </select>

    <br><br>

    <label for="Basic_salary">Basic salary:</label>
    <input type="text" name="Basic_salary" id="Basic_salary"/>

    <br><br>

    <label for="House_rent">House rent:</label>
    <input type="text" name="House_rent" id="House_rent"/>

    <br><br>

    <label for="Medical_allowance">Medical allowance:</label>
    <input type="text" name="Medical_allowance" id="Medical_allowance"/>

    <br><br>

    <label for="Incentive">Incentive/OT:</label>
    <input type="text" name="Incentive" id="Incentive"/>

    <br><br>

    <label for="Festival_Bonus">Festival Bonus:</label>
    <input type="text" name="Festival_Bonus" id="Festival_Bonus"/>

    <br><br>

    <label for="Conveyance">Conveyance:</label>
    <input type="text" name="Conveyance" id="Conveyance"/>

    <br><br>

    <input type="submit" value="Calculate Tax">
</form>

</body>
</html>
