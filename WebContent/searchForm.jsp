<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

</style>
<link rel="stylesheet" type="text/css" href="searchForm.css">
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<s:form action="enterData" method="post" validation="true">
	<s:textfield label="Enter Operating System" key="os" />
	<s:textfield label="Enter Operating System Version" key="osVer" />
	<s:textarea label="Notes" key="notes" cols="40" rows="10"/>
	<s:submit value="Submit"/>
	<s:submit value="View Table" action="skipData"/>
</s:form>
</body>
</html>