<%@include file="../taglib_includes.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="App.Title"></spring:message> </title>
<script type="text/javascript" src="../js/contacts.js"></script>
</head>
<body style="font-family: Arial; font-size:smaller;">
	<center>
	<form action="searchKategori.do" method="post">		
			<table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="800">
			<tr>
				<td>Enter Kategori Name</td> 
				<td><input type="text" name="kategori"/>
					&nbsp;&nbsp;<input type="submit" value="Search"/>
					&nbsp;&nbsp;&nbsp;&nbsp;<a href="/ePerpus/saveKategori.do">New Kategori</a>
					&nbsp;&nbsp;&nbsp;&nbsp;<a href="/ePerpus">Beranda</a>
					
			</td></tr>
		</table>
	</form>
	
	<table style="border-collapse: collapse;" border="1" bordercolor="#006699" width="800">
		<tr bgcolor="lightblue">
			<th>Id</th>
			<th>Kategori</th>			
			<th width="100">Tindakan</th>
		</tr>
		<c:if test="${empty SEARCH_KATEGORI_RESULTS_KEY}">
		<tr>
			<td colspan="4">No Results found</td>
		</tr>
		</c:if>
		<c:if test="${! empty SEARCH_KATEGORI_RESULTS_KEY}">
			<c:forEach var="kategori" items="${SEARCH_KATEGORI_RESULTS_KEY}">		
		    <tr>
				<td><c:out value="${kategori.idKategori}"></c:out></td>
				<td><c:out value="${kategori.kategori}"></c:out></td>
				
				<td>
					&nbsp;<a href="updateKategori.do?idKategori=${kategori.idKategori}">Edit</a>
					&nbsp;&nbsp;<a href="javascript:deleteKategori('deleteKategori.do?idKategori=${kategori.idKategori}');">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</c:if>				
	</table>	
	</center>
		
</body>
</html>