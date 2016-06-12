<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href=<c:url value="/resources/dist/css/select2.min.css" /> rel="stylesheet" />
<link href=<c:url value="/resources/dist/css/select2-bootstrap.css" /> rel="stylesheet" />
<link href=<c:url value="/resources/bower_components/bootstrap-dataTables/css/dataTables.bootstrap.min.css" />
              rel="stylesheet" />

<div class="row">
  <div class="col-md-12">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3><spring:message code="creditLine.list.message" /> <c:out value="${clientid}" /></h3>
        <div class="row">
          <button type="button" class="btn btn-success" onclick="location.href='<c:url value="/creditLines/private_persons/create/${clientid}"/>'">
            <spring:message code="creditLine.list.create" />
          </button>
        </div>
        </button>
      </div>
      <div class="panel-body">
        <div class="table-responsive">
          <table class="table table-hover table-bordered table-striped" id="creditLineTable">
            <thead>
              <tr>
                <th class="col-md-2"><spring:message code="creditLine.list.th1" /></th>
                <th class="col-md-2"><spring:message code="creditLine.list.th2" /></th>
                <th class="col-md-2"><spring:message code="creditLine.list.th3" /></th>
                <th class="col-md-1"><spring:message code="creditLine.list.th4" /></th>
                <th class="col-md-1"><spring:message code="creditLine.list.th5" /></th>
                <th class="col-md-1"><spring:message code="creditLine.list.th6" /></th>
                <th class="col-md-1"><spring:message code="creditLine.list.th7" /></th>
                <th class="col-md-1"><spring:message code="creditLine.list.th8" /></th>
                <th class="col-md-1"><spring:message code="creditLine.list.th9" /></th>
              </tr>
            </thead>

            <tbody>
            <c:forEach items="${creditLines}" var="creditline">
              <tr>
                <td><c:out value="${creditline.amount}" /></td>
                <td class="td-centered"><c:out value="${creditline.period}" /></td>
                <td class="td-centered"><c:out value="${creditline.rate}" /></td>
                <td class="td-centered"><c:out value="${creditline.repayType}" /></td>
                <td class="td-centered"><c:out value="${creditline.openingDate}" /></td>
                <td class="td-centered"><c:out value="${creditline.closingDate}" /></td>
                <td class="td-centered">${(creditline.status==true)?'closed':'open'}</td>

                <td class="td-centered">
                  <a href=<c:url value="/payments/private_persons/get/${creditline.id}?viewType=1" />>
                  <span class="fa fa-table fa-lg"></span>
                  </a>
                </td>

                <td class="td-centered">
                  <a href=<c:url value="/payments/private_persons/get/${creditline.id}?viewType=0" />>
                  <span class="fa fa-line-chart fa-lg"></span>
                  </a>
                </td>

              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>

<script src=<c:url value="/resources/js/creditLine/creditLine.js" />></script>
<script src=<c:url value="/resources/dist/js/select2.min.js" />></script>
<script src=<c:url value="/resources/bower_components/bootstrap-dataTables/js/jquery.dataTables.min.js" />></script>
<script src=<c:url value="/resources/bower_components/bootstrap-dataTables/js/dataTables.bootstrap.min.js" />></script>

