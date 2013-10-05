function go(url)
{
	window.location = url;
}

function newBuku()
{
	window.location = "saveBuku.do";
}
function newKategori()
{
	window.location = "saveKategori.do";
}

function deleteBuku(url)
{
	var isOK = confirm("Apakah Bibeh yakin akan menghapus data ini, hmm... ?");
	if(isOK)
	{
		go(url);
	}
}
function deleteKategori(url)
{
	var isOK = confirm("Apakah Bibeh yakin akan menghapus Kategori ini, hmm... ?");
	if(isOK)
	{
		go(url);
	}
}
