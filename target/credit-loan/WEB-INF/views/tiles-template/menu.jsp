<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
  <div class="navbar-header">
    <a class="navbar-brand" href=<c:url value="/" />><i class="fa fa-home fa-fw"></i><spring:message code="home" /></a>
  </div>

  <ul class="navbar-brand">
    <sec:authorize access="hasRole('ROLE_OPERATOR')">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
          <i class="fa fa-sign-in fa-fw"></i> <spring:message code="home.message_1" /> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-alerts">
          <li>
            <a href=<c:url value="/clients/private_persons" />>
              <i class="fa fa-users fa-fw"></i> <spring:message code="home.message_2" />
            </a>
          </li>
          <li class="divider"></li>
          <li>
            <a href=<c:url value="/clients/private_persons" />>
              <i class="fa fa-bank fa-fw"></i> <spring:message code="home.message_4" />
            </a>
          </li>
        </ul>
      </li>
    </sec:authorize>
  </ul>
</nav>