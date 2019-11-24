<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>樱诺商城</title>
<<<<<<< Updated upstream

</head>
<body>
<h1>首页</h1>
<img src="${pageContext.request.contextPath}/static/images/books_library_shelves_1280x720.jpg" alt="">
=======
    <link rel="stylesheet" href="static/libs/bootstrap-4.3.1-dist/css/bootstrap.css">
    <style>
        .container{
            width: 1080px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">菜鸟教程</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">iOS</a></li>
                <li><a href="#">SVN</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Java
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
    <%@include file="WEB-INF/views/head.jsp"%>
    <div class="container bg-secondary">

    </div>
    <script src="static/js/jquery-3.4.1.js"></script>
    <script src="static/libs/bootstrap-4.3.1-dist/js/bootstrap.js"></script>
··</body>
</html>
