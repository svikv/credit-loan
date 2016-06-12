<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<head>
  <title><spring:message code="creditLine.create.create"/><c:out value="${clientid}" /></title>
</head>

  <div class="row">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3><spring:message code="creditLine.create.create"/><c:out value="${clientid}" /></h3>
      </div>
      <div class="panel-body">
        <div class="row"></div>
        <form:form cssClass="form-horizontal" action="" method="POST" modelAttribute="creditLine">
          <form:hidden path="id" />
          <fieldset>
            <div class="row">

              <div class="form-group">
                <form:label path="amount" cssClass="col-sm-2 control-label">
                  <p class="text-left"><spring:message code="creditLine.create.form1" /></p>
                </form:label>
                <div class="col-sm-4">
                  <form:input path="amount" cssClass="form-control" cssErrorClass="error" />
                  <form:errors path="amount" cssClass="help-block with-errors" />
                </div>
              </div>

              <div class="form-group">
                <form:label path="period" cssClass="col-sm-2 control-label">
                  <p class="text-left"><spring:message code="creditLine.create.form2" /></p>
                </form:label>
                <div class="col-sm-4">
                  <form:select path="period" cssClass="form-control" items="${periods}" cssErrorClass="error" />
                  <form:errors path="period" cssClass="help-block with-errors" />
                </div>
              </div>

              <div class="form-group">
                <form:label path="rate" cssClass="col-sm-2 control-label">
                  <p class="text-left"><spring:message code="creditLine.create.form3" /></p>
                </form:label>
                <div class="col-sm-4">
                  <form:select path="rate" cssClass="form-control" items="${rates}" cssErrorClass="error" />
                  <form:errors path="rate" cssClass="help-block with-errors" />
                </div>
              </div>

              <div class="form-group">
                <form:label path="repayType" cssClass="col-sm-2 control-label">
                  <p class="text-left"><spring:message code="creditLine.create.form4" /></p>
                </form:label>
                <div class="col-sm-4">
                  <form:select path="repayType" cssClass="form-control" items="${repayTypes}" cssErrorClass="error" />
                  <form:errors path="repayType" cssClass="help-block with-errors" />
                </div>
              </div>

              <div class="form-group">
                <div class="hidden">
                  <form:label path="openingDate" cssClass="col-sm-2 control-label">
                    <p class="text-left">Opening Date: *</p>
                  </form:label>
                  <div class="col-sm-4">
                    <form:input path="openingDate" cssClass="form-control" cssErrorClass="error" />
                    <form:errors path="openingDate" cssClass="help-block with-errors" />
                  </div>
                </div>
              </div>

              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10"></div>
              </div>
              <div class="row">
                <button type="submit" class="btn btn-success">
                  <spring:message code="creditLine.create.save" />
                </button>
                <button type="button" class="btn btn-danger" onclick="location.href='<c:url value="/creditLines/private_persons/create/${clientid}"/>'">
                  <spring:message code="creditLine.create.reset" />
                </button>
                <button type="button" class="btn btn-default" onclick="location.href='<c:url value="/creditLines/private_persons/get/${clientid}"/>'">
                  <spring:message code="creditLine.create.cancel" />
                </button>
              </div>
            </div>
          </fieldset>
        </form:form>
      </div>
    </div>
  </div>