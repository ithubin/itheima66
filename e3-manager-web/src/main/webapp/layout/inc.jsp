<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/extBrowser.js" charset="utf-8"></script>

<!-- 引入my97日期时间控件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/My97DatePicker4.8b3/My97DatePicker/WdatePicker.js" charset="utf-8"></script>

<!-- 引入kindEditor插件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/jslib/kindeditor-4.1.10/themes/default/default.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/kindeditor-4.1.10/kindeditor-all-min.js" charset="utf-8"></script>

<!-- 引入jQuery -->
<script src="${pageContext.request.contextPath}/jslib/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>

<!-- 引入Highcharts -->
<script src="${pageContext.request.contextPath}/jslib/Highcharts-3.0.1/js/highcharts.js" type="text/javascript" charset="utf-8"></script>

<!-- 引入bootstrap样式 -->
<link href="${pageContext.request.contextPath}/jslib/bootstrap-2.3.1/css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- <script charset="utf-8" src="${pageContext.request.contextPath}/jslib/bootstrap-2.3.1/js/bootstrap.min.js" charset="utf-8"></script> -->

<!-- 引入EasyUI -->
<link id="easyuiTheme" rel="stylesheet" href="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.1/themes/<c:out value="${cookie.easyuiThemeName.value}" default="bootstrap"/>/easyui.css" type="text/css">
<!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.1/themes/icon.css" type="text/css"> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.1/jquery.easyui.min.js?v=201605551044" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js?v=201605661044" charset="utf-8"></script>
<!-- 修复EasyUI1.4.1中layout组件的BUG -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.1/plugins/jquery.layout.js" charset="utf-8"></script>

<!-- 引入EasyUI Portal插件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/jslib/jquery-easyui-portal/portal.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-portal/jquery.portal.js" charset="utf-8"></script>

<!-- 扩展EasyUI -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/extEasyUI.js?v=201305241044" charset="utf-8"></script>

<!-- 扩展EasyUI Icon -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/extEasyUIIcon.css?v=201305301906" type="text/css">

<!-- 扩展jQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/extJquery.js?v=201305301341" charset="utf-8"></script>
<!-- common -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/common.js?v=201606301342" charset="utf-8"></script>
