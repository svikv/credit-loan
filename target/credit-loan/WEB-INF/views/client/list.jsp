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
        <h3><spring:message code="client.list.client" /></h3>
        <div class="row">
          <button type="button" class="btn btn-success" onclick="location.href='<c:url value="/clients/private_persons/create"/>'">
            <spring:message code="client.list.create" />
          </button>
        </div>
        </button>
      </div>
      <div class="panel-body">
        <div class="table-responsive">
          <table class="table table-hover table-bordered table-striped" id="clientTable">
            <thead>
              <tr>
                <th class="col-md-2"><spring:message code="client.list.th1" /></th>
                <th class="col-md-2"><spring:message code="client.list.th2" /></th>
                <th class="col-md-2"><spring:message code="client.list.th3" /></th>
                <th class="col-md-2"><spring:message code="client.list.th4" /></th>
                <th class="col-md-2"><spring:message code="client.list.th5" /></th>
                <th class="col-md-1"><spring:message code="client.list.th6" /></th>
                <th class="col-md-1"><spring:message code="client.list.th7" /></th>
              </tr>
            </thead>

            <tbody>
            <c:forEach items="${clients}" var="client">
              <tr>
                <td>
                  <a href=<c:url value="/clients/private_persons/modify/${client.id}" />>
                      ${client.firstName}
                  </a>
                </td>
                <td><c:out value="${client.lastName}" /></td>
                <td class="td-centered"><c:out value="${client.identificationNumber}" /></td>
                <td class="td-centered"><c:out value="${client.phone}" /></td>
                <td><c:out value="${client.email}" /></td>

                <td class="td-centered">
                  <a href=<c:url value="/creditLines/private_persons/get/${client.id}" />>
                    <span class="fa fa-credit-card-alt fa-lg"></span>
                  </a>
                </td>

                <td class="td-centered">
                  <a href=<c:url value="/clients/private_persons/delete/${client.id}" />>
                    <span class="fa fa-trash fa-lg"></span>
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

<script src=<c:url value="/resources/js/client/client.js" />></script>
<script src=<c:url value="/resources/dist/js/select2.min.js" />></script>
<script src=<c:url value="/resources/bower_components/bootstrap-dataTables/js/jquery.dataTables.min.js" />></script>
<script src=<c:url value="/resources/bower_components/bootstrap-dataTables/js/dataTables.bootstrap.min.js" />></script>

