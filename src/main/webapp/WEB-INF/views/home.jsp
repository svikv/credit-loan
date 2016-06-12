<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authorize access="hasRole('ROLE_OPERATOR')">
  <a href="home?locale=en">En </a> | <a href="home?locale=ru">Ru </a> | <a href="home?locale=uk">Uk </a>
  <div class="row">
    <div class="col-md-12">
      <h1 class="page-header"><spring:message code="home.message_1" /></h1>
    </div>
  </div>

  <div class="row">
  <div class="col-md-4">
    <div class="panel panel-blue cursorPointer" id="personBlock">
      <div class="panel-heading">
        <div class="row">
          <div class="col-xs-3">
            <i class="fa fa-users fa-3x"></i>
          </div>
          <div class="col-xs-7 text-center">
            <div class="huge"><spring:message code="home.message_2" /></div>
          </div>
        </div>
      </div>
      <a href=<c:url value="/clients/private_persons" />>
        <div class="panel-footer">
          <span class="pull-left"><spring:message code="home.message_3" /></span>
          <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
          <div class="clearfix"></div>
        </div>
      </a>
    </div>
  </div>

  <div class="col-md-4">
    <div class="panel panel-yellow cursorPointer" id="companyBlock">
      <div class="panel-heading">
        <div class="row">
          <div class="col-xs-3">
            <i class="fa fa-bank fa-3x"></i>
          </div>
          <div class="col-xs-7 text-center">
            <div class="huge"><spring:message code="home.message_4" /></div>
          </div>
        </div>
      </div>
      <a href=<c:url value="/clients/private_persons" />>
        <div class="panel-footer">
          <span class="pull-left"><spring:message code="home.message_3" /></span>
          <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
          <div class="clearfix"></div>
        </div>
      </a>
    </div>
  </div>
</sec:authorize>

<!-- Main page script -->
<script src=<c:url value="/resources/js/home.js" />></script>