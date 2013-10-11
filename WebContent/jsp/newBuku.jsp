<%@include file="taglib_includes.jsp" %>

<html>
<head>
	<script type="text/javascript" src="js/contacts.js"></script>
	<title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="200" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
	<tr>
		<td align="center"><h3>New Book Form</h3></td>
	</tr>
	<tr valign="top" align="center">
    <td align="center">
 		<form:form action="saveBuku.do" method="post" commandName="newBuku">
	    	
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">	
					<tr>
						<td width="100" align="right">Judul</td>
						<td width="150">
						<form:textarea rows="5" cols="40" path="judul"/></td>
						<td align="left">
						<form:errors path="judul" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					<tr>
						<td width="100" align="right">Tanggal Beli</td>
						<td width="150">
						<form:input path="tglBeli"/></td>
						<td align="left">
						<form:errors path="tglBeli" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					<tr>
					<td width="100" align="right">Kategori</td>
					<td>
										 	
					<%-- <form:select path="kategori"> --%>
					<%--     <form:options items="${kategoris}" itemLabel="kategori" /> --%>
					<%-- </form:select> --%>
					<form:select path="kategori.idKategori" cssStyle="width: 150px;">    
							<option value="-1">Select a type</option>
							<c:forEach items="${kategoris}" var="kategori">
								<option value="${kategori.idKategori}">${kategori.kategori}</option>
							</c:forEach>
						</form:select>




                    </td>
                    </tr>
					<tr>
						<td width="100" align="right">Penerbit</td>
						<td width="150">
						<form:input path="penerbit"/></td>
						<td align="left">
						<form:errors path="penerbit" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td colspan="3" align="center">
						<input type="submit" name="" value="Save">
						&nbsp;&nbsp;
						<input type="reset" name="" value="Reset">
						&nbsp;&nbsp;
						<input type="button"  value="Back" onclick="javascript:go('viewAllBuku.do');">
						</td>
					</tr>					
				</table>			
		</form:form>
    </td>    
  </tr>
</table>
</body>
</html>
