<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<spring:message code="welcome"/> ${name} <br/>

Your todos: <a href="/list-todos">goto</a>

</div>
<%@ include file="common/footer.jspf"%>