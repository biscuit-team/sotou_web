<%--
  Created by IntelliJ IDEA.
  User: shuhzhang
  Date: 14-3-6
  Time: 上午10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="comment" items="${allComments}">
    <div>
        用户名:${comment.get("userName")}
        评论内容:${comment.get("content")}
        时间:${comment.get("time")}
    </div>

</c:forEach>
