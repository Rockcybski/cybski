<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JqPlot Examples</title>
<link href="<c:url value="/css/jquery.jqplot.min.css"/>" rel="stylesheet" type="text/css" /> 
<script src="<c:url value="/scripts/jquery.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/scripts/jquery.jqplot.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/scripts/jqplot.json2.js"/>" type="text/javascript"></script>
<script src="<c:url value="/scripts/jqPlotCreator.js"/>" type="text/javascript"></script>
</head>
<body>
	<div id="global">
		<table>
			<tr>
				<td nowrap="nowrap" valign="top">
					<a href="javascript:createSingerDataRenderer();">Singer Data Renderer</a><br/>
					<a href="javascript:createAjaxJsonDataRenderer();">Ajax Json Data Renderer</a>
					<a href="javascript:createAnimatedCharts();">Animated Charts</a>
				</td>
				<td>
					<div id="chart" style="height:300px; width:500px;"></div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>