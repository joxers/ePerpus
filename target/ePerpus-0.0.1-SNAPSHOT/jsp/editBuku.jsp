<%@include file="taglib_includes.jsp"%>

<html>
<head>
<script type="text/javascript" src="js/contacts.js"></script>
<title><spring:message code="App.Title"></spring:message></title>
</head>
<body style="font-family: Arial; font-size: smaller;">

	<table bgcolor="lightblue" width="750" height="200" align="center"
		style="border-collapse: collapse;" border="1" bordercolor="#006699">
		<tr>
			<td align="center"><h3>Edit Buku Form</h3></td>
		</tr>
		<tr valign="top" align="center">
			<td align="center"><form:form action="updateBuku.do"
					method="post" commandName="editBuku">
					<table width="500" style="border-collapse: collapse;" border="0"
						bordercolor="#006699" cellspacing="2" cellpadding="2">
						<tr>
							<td width="100" align="right">ID</td>
							<td width="150"><form:input path="idBuku" readonly="true" /></td>
							<td align="left"></td>
						</tr>
						<tr>
							<td width="100" align="right">Judul</td>
							<td><form:input path="judul" /></td>
							<td align="left"><form:errors path="judul"
									cssStyle="color:red"></form:errors></td>
						</tr>
							<tr>
							<td width="100" align="right">Tanggal Beli</td>
							<td><form:input path="tglBeli" /></td>
							<td align="left"><form:errors path="tglBeli"
									cssStyle="color:red"></form:errors></td>
						</tr>
							<tr>
							<td width="100" align="right">Penerbit</td>
							<td><form:input path="penerbit" /></td>
							<td align="left"><form:errors path="penerbit"
									cssStyle="color:red"></form:errors></td>
						</tr>
						<td></td>
						</tr>


						<tr valign="bottom">
							<td colspan="3" align="center"><input type="button"
								value="Delete"
								onclick="javascript:deleteBuku('deleteBuku.do?idBuku=${editBuku.idBuku}');">
								&nbsp;&nbsp; <input type="submit" name="" value="Save">
								&nbsp;&nbsp; <input type="button" value="Back"
								onclick="javascript:go('viewAllBuku.do');"></td>
						</tr>

					</table>
				</form:form></td>
		</tr>
	</table>
</body>
</html>
