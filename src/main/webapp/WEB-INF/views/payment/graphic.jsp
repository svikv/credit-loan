<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href=<c:url value="/resources/dist/css/select2.min.css" /> rel="stylesheet" />
<link href=<c:url value="/resources/dist/css/select2-bootstrap.css" /> rel="stylesheet" />
<link href=<c:url value="/resources/bower_components/bootstrap-dataTables/css/dataTables.bootstrap.min.css" />
              rel="stylesheet" />
<link href=<c:url value="/resources/dist/css/graphic.css" /> rel="stylesheet" />

<div class="row">
  <div class="col-md-12">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3><spring:message code="payment.graphic.message" /></h3>
      </div>

      <div id="outer">
        <div class="inner">
          <canvas id="canvas" height="400" width="400"></canvas>
        </div>
      </div>
    </div>
  </div>
</div>

<div id="data" class="hidden">
  <c:forEach var="payment" items="${payments}">
    <span class="x">${payment.monthPeriod}</span>
    <span class="y">${payment.paymentAmount}</span>
  </c:forEach>
</div>

<script src=<c:url value="/resources/js/graphic/graphic.js" />></script>
<script src=<c:url value="/resources/js/graphic/Chart.js" />></script>
<script src=<c:url value="/resources/dist/js/select2.min.js" />></script>
