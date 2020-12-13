<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

Hi ${name}, todos number: ${number} <br/>

<table class="table table-striped">

<caption>Your todos are</caption>
<thead>
<tr> 
<th>Description</th>
<th>Target date</th>
<th>Is completed?</th>
<th>Action</th>
</tr> 
</thead>

<tbody>
<c:forEach items="${todos}" var="todo">
<tr> 
<td>${todo.desc}</td>

<td>
<fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy" />
</td>

<td>${todo.done}</td>
<td>
<a href="/update-todo?id=${todo.id}" class="btn btn-info">Update</a>
<a href="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
</td>
</tr> 
</c:forEach>
</tbody>

</table>

</br>
<div>
<a class="btn btn-success" href="/add-todo">Add</a>
</div>

</div>
<%@ include file="common/footer.jspf" %>
