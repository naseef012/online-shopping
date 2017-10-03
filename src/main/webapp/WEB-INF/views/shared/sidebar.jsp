<%--
  Created by IntelliJ IDEA.
  User: Naseef M Abdus Sattar
  Date: 9/30/2017
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="/onlineshopping"/>
<p class="lead">Shop Name</p>

<div class="list-group">
    <c:forEach items="${categories}" var="category">
        <a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name}">${category.name}</a>
    </c:forEach>
</div>