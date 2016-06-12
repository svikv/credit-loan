<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title><spring:message code="label.title" /></title>

  <!-- Bootstrap Core CSS -->
  <link href=<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" /> rel="stylesheet">

  <!-- Custom CSS -->
  <link href=<c:url value="/resources/dist/css/sb-admin-2.css" /> rel="stylesheet">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<a href="login?locale=en">En </a> | <a href="login?locale=ru">Ru </a> | <a href="login?locale=uk">Uk </a>
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title"><spring:message code="label.message" /></h3>
          </div>

          <div class="panel-body">
            <c:if test="${not empty param.error}">
              <div class="alert alert-danger">
                <strong><spring:message code="login.error.title1" /></strong> <spring:message code="login.error.title2" />
              </div>
            </c:if>

            <c:if test="${not empty param.logout}">
              <div class="alert alert-success">
                <strong><spring:message code="login.success.title1" /></strong> <spring:message code="login.success.title2" />
              </div>
            </c:if>

            <form role="form" action="${pageContext.request.contextPath}/loginCheck" method="POST">
              <fieldset>
                <div class="form-group">
                  <spring:message code="label.username" var="userName"/>
                  <input class="form-control" type="email" name="username" placeholder="${userName}" autofocus>
                </div>

                <div class="form-group">
                  <spring:message code="label.password" var="passWord"/>
                  <input class="form-control" type="password" name="password" placeholder="${passWord}" value="">
                </div>

                <spring:message code="label.submit" var="labelSubmit"/>
                <input type="submit" class="btn btn-lg btn-success btn-block" value="${labelSubmit}" />
              </fieldset>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>