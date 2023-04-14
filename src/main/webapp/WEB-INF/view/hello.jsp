<%--<%@ page contentType="text/html; charset=utf-8" isELIgnored="false" %>--%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>메인</title>
</head>
<body>
<h3>
    <c:choose>
        <c:when test="${greeting eq null}">
        you are guest
        </c:when>
        <c:otherwise>
            Hello, <c:out value="${greeting}"/>
        </c:otherwise>
    </c:choose>
</h3>
</body>
</html>
