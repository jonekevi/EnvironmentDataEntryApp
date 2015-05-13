<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Environment Details</title>
<%-- I used this tutorial to help me make my table: http://javastoreroom.blogspot.com/2013/06/struts2-pagination-using-display-tag.html --%>

<style type="text/css">
.odd{
	background-color: gray;
}
span{
	margin-left:560px;
	margin-bottom:15px;
	color:maroon;
}
.pagebanner{
	display: none;
}
.pagelinks{
	color: maroon;
	margin-left: 150px;
	margin-top:20px;
}
#txt_filter{
	display: none;
}
	.exportlinks
{
	margin-left: 451px;
}
.export{
	margin-left: 0px;
}
</style>
 



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Environment Table</title>
</head>
<body>
<display:table id="Environments" name="environments" pagesize="15" cellpadding="2px;" style="margin-left:150px;margin-top:20px;table-layout:auto;" requestURI ="">
<display:column property="os" title="Operating System"></display:column>
<display:column property="osVersion" title="Version"></display:column>
<display:column property="notes" title="notes"></display:column>
</display:table>
<s:form action="return">
	<s:submit align="right" value="Return" />
</s:form>
</body>
</html>