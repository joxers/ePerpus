function go(url)
{
	window.location = url;
}

function newBuku()
{
	window.location = "saveBuku.do";
}

function deleteBuku(url)
{
	var isOK = confirm("Apakah anda yakin akan menghapus data ini ?");
	if(isOK)
	{
		go(url);
	}
}
