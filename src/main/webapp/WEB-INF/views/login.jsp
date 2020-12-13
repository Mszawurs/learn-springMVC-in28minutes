<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <p><font color="red">${errorMessage}</font></p>
    <form action="/login" method="POST">
        Name : <input name="name" type="text" /> 
        Password : <input name="password" type="password" /> 
        <input type="submit" value="Wysylaj"/>
    </form>
    
</div>

<%@ include file="common/footer.jspf"%>