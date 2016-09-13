<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<head>
  <c:set var="title" value="Create" />
  <c:if test="${isUpdate}">
    <c:set var="title" value="Update" />
  </c:if>

  <title>${title}</title>
</head>

<div class="row">
  <div class="panel panel-default">
    <div class="panel-heading">
      <h3>${title}</h3>
    </div>
    <div class="panel-body">
      <div class="row"></div>
      <form:form cssClass="form-horizontal" action="" method="POST" modelAttribute="client">
        <form:hidden path="id" />
        <fieldset>
          <div class="row">

            <div class="form-group">
              <form:label path="firstName" cssClass="col-sm-2 control-label">
                <p class="text-left">First Name: *</p>
              </form:label>
              <div class="col-sm-4">
                <form:input cssClass="form-control" path="firstName" cssErrorClass="error" />
                <form:errors path="firstName" cssClass="help-block with-errors" />
              </div>
            </div>

            <div class="form-group">
              <form:label path="lastName" cssClass="col-sm-2 control-label">
                <p class="text-left">Last Name: </p>
              </form:label>
              <div class="col-sm-4">
                <form:input cssClass="form-control" path="lastName" cssErrorClass="error" />
                <form:errors path="lastName" cssClass="help-block with-errors" />
              </div>
            </div>

            <div class="form-group">
              <form:label path="identificationNumber" cssClass="col-sm-2 control-label">
                <p class="text-left">Identification Number: *</p>
              </form:label>
              <div class="col-sm-4">
                <form:input cssClass="form-control" path="identificationNumber" cssErrorClass="error" />
                <form:errors path="identificationNumber" cssClass="help-block with-errors" />
              </div>
            </div>

            <div class="form-group">
              <form:label path="phone" cssClass="col-sm-2 control-label">
                <p class="text-left">Phone: *</p>
              </form:label>
              <div class="col-sm-4">
                <form:input cssClass="form-control" path="phone" cssErrorClass="error" />
                <form:errors path="phone" cssClass="help-block with-errors" />
              </div>
            </div>

            <div class="form-group">
              <form:label path="email" cssClass="col-sm-2 control-label">
                <p class="text-left">Email: </p>
              </form:label>
              <div class="col-sm-4">
                <form:input cssClass="form-control" path="email" cssErrorClass="error" />
                <form:errors path="email" cssClass="help-block with-errors" />
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10"></div>
            </div>
            <div class="row">
              <button type="submit" class="btn btn-success">Save</button>
              <button type="button" class="btn btn-danger" onclick="location.href='<c:url value="/clients/private_persons/create "/>'">Reset</button>
              <button type="button" class="btn btn-default" onclick="location.href='<c:url value="/clients/private_persons "/>'">Cancel</button>
            </div>
          </div>
        </fieldset>
      </form:form>
    </div>
  </div>
</div>