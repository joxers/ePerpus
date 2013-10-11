<%@include file="taglib_includes.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="App.Title"></spring:message> </title>
<script type="text/javascript" src="js/contacts.js"></script>
</head>
<body style="font-family: Arial; font-size:smaller;">
	<center>
	<form action="searchBuku.do" method="post">		
			<table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="1024">
			<tr>
				<td>Enter Book Name</td> 
				<td><input type="text" name="judul"/>
					&nbsp;&nbsp;<input type="submit" value="Search"/>
					&nbsp;&nbsp;<input type="button" value="New Book" onclick="javascript:go('saveBuku.do');"/>
					&nbsp;&nbsp;&nbsp;&nbsp;<a href="/ePerpus">Beranda</a>
					
			</td></tr>
		</table>
	</form>
	
	<table style="border-collapse: collapse;" border="1" bordercolor="#006699" width="1024">
		<tr bgcolor="lightblue">
			<th>Id</th>
			<th>Judul</th>			
			<th>Tanggal Beli</th>	
			<th>Kategori</th>	
			
			<th>Penerbit</th>	
			
			<th width="100">Tindakan</th>
		</tr>
		<c:if test="${empty SEARCH_BUKU_RESULTS_KEY}">
		<tr>
			<td colspan="4">No Results found</td>
		</tr>
		</c:if>
		<c:if test="${! empty SEARCH_BUKU_RESULTS_KEY}">
			<c:forEach var="buku" items="${SEARCH_BUKU_RESULTS_KEY}">		
		    <tr>
				<td><c:out value="${buku.idBuku}"></c:out></td>
				<td><c:out value="${buku.judul}"></c:out></td>
				<td><c:out value="${buku.tglBeli}"></c:out> </td>
				<td><c:out value="${buku.kategori.kategori}"></c:out> </td>
				<td><c:out value="${buku.penerbit}"></c:out> </td>
				
				<td>
					&nbsp;<a href="updateBuku.do?idBuku=${buku.idBuku}">Edit</a>
					&nbsp;&nbsp;<a href="javascript:deleteBuku('deleteBuku.do?idBuku=${buku.idBuku}');">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</c:if>				
	</table>	
	</center>
		
</body>
</html>