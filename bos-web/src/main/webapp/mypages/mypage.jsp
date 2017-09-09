<%--
  Created by IntelliJ IDEA.
  User: 13718
  Date: 2017/9/9
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>

<html>
<head>

</head>
<body class="easyui-layout">
    <div style="height: 100px" data-options="region:'north'">北部区域

        <div class="easyui-tabs" data-options="fit:true">
            <!-- 使用子div表示每个面板 -->
            <div data-options="iconCls:'icon-cut'" title="面板一">1111</div>
            <div data-options="closable:true" title="面板二">2222</div>
            <div title="面板三">3333</div>
        </div>

    </div>
    <div style="width: 200px" data-options="region:'west'">西部区域

        <div class="easyui-accordion" data-options="fit:true">
            <div data-options="iconCls:'icon-cut'" title="面板零">111</div>
            <div data-options="iconCls:'icon-cut'" title="面板一">222</div>
            <div data-options="iconCls:'icon-cut'" title="面板二">444</div>
        </div>

    </div>
    <div data-options="region:'center'">中心区域 <p><big>东西区域看宽度，南北区域看高度</big></p>

        <div class="easyui-tabs" data-options="fit:true">
            <div data-options="iconCls:'icon-cut'" title="面板零">111</div>
            <div data-options="iconCls:'icon-cut'" title="面板一">222</div>
            <div data-options="iconCls:'icon-cut'" title="面板二">444</div>
        </div>

    </div>

    <div style="width: 100px" data-options="region:'east'">东部区域</div>
    <div style="height: 50px" data-options="region:'south'">南部区域</div>



</body>



























</html>
