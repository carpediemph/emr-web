<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${doctor.firstName}</title>
</head>
<body>
${doctor}
<form:form action="add" method="POST" modelAttribute="doctor">
Updated by: <form:input type="text" path="updatedBy"/>
First name: <form:input type="text" path="firstName"/>
Last name: <form:input type="text" path="lastName"/>
Specialization: <form:input type="text" path="specialization"/>
Gender: <form:input type="text" path="gender"/>
License number: <form:input type="text" path="licenseNumber"/>
Address: <form:input type="text" path="address"/>
Contact number: <form:input type="text" path="contactNumber"/>
Username: <form:input type="text" path="username"/>
Password: <form:input type="text" path="password"/>
Active?: <form:input type="text" path="active"/>
<button type="submit">Submit</button>
</form:form> 
</body>
</html>