<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring"
    uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee</title>
</head>

<body>

    <div style="text-align: right;">
        <a href="${pageContext.request.contextPath}/employee?lang=en">
            English
        </a>

        |

        <a href="${pageContext.request.contextPath}/employee?lang=hi">
            हिन्दी
        </a>
    </div>

    <h1 style="color: blue; text-align: center;">
        <spring:message code="title"/>
    </h1>

    <p>
        <b><spring:message code="name"/> :</b>
        ${employeeName}
    </p>

    <p>
        <b><spring:message code="department"/> :</b>
        ${departmentName}
    </p>

    <p>
        <spring:message code="welcome"/>
    </p>

</body>
</html>