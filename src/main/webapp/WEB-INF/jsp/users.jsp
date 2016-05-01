<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>user name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                    ${user.name}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>