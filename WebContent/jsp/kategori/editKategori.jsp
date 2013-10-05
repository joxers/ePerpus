<%@include file="../taglib_includes.jsp"%>

<html>
<head>
<script type="text/javascript" src="js/contacts.js"></script>
<title><spring:message code="App.Title"></spring:message></title>
</head>
<body style="font-family: Arial; font-size: smaller;">

	<table bgcolor="lightblue" width="750" height="200" align="center"
		style="border-collapse: collapse;" border="1" bordercolor="#006699">
		<tr>
			<td align="center"><h3>Edit Kategori Form</h3></td>
		</tr>
		<tr valign="top" align="center">
			<td align="center"><form:form action="updateKategori.do"
					method="post" commandName="editKategori">
					<table width="500" style="border-collapse: collapse;" border="0"
						bordercolor="#006699" cellspacing="2" cellpadding="2">
						<tr>
							<td width="100" align="right">ID</td>
							<td width="10"><form:input path="idKategori" readonly="true" /></td>
							<td align="left"></td>
						</tr>
						<tr>
						<td width="100" align="right">Kategori</td>
						<td width="150">
						<form:input path="kategori"/></td>
						<td align="left">
						<form:errors path="kategori" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
						
						</tr>


						<tr valign="bottom">
							<td colspan="3" align="center"><input type="button"
								value="Delete"
								onclick="javascript:deleteKategori('deleteKategori.do?idKategori=${editKategori.idKategori}');">
								&nbsp;&nbsp; <input type="submit" name="" value="Save">
								&nbsp;&nbsp; <input type="button" value="Back"
								onclick="javascript:go('viewAllKategori.do');"></td>
						</tr>

					</table>
				</form:form></td>
		</tr>
	</table>
</body>
</html>
