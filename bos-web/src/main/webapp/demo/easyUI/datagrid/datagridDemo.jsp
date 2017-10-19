<%--
  Created by IntelliJ IDEA.
  User: 13718
  Date: 2017/9/27
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table class="easyui-datagrid">
    <thead>
    <tr>
        <th data-options="field:'code'">Code</th>

        <th data-options="field:'name'">Name</th>

        <th data-options="field:'price'">Price</th>

    </tr>

    </thead>

    <tbody>

    <tr>

        <td>001</td>

        <td>name1</td>

        <td>2323</td>

    </tr>

    <tr>

        <td>002</td>

        <td>name2</td>

        <td>4612</td>

    </tr>

    </tbody>

</table>




<table class="easyui-datagrid" style="width:400px;height:250px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true">
    <thead>

    <tr>

        <th data-options="field:'code',width:100">Code</th>

        <th data-options="field:'name',width:100">Name</th>

        <th data-options="field:'price',width:100,align:'right'">Price</th>

    </tr>

    </thead>

</table>


</body>
</html>
