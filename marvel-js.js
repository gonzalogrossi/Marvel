async function getHero(){
    const id = document.getElementById("id").value;
	const url ='http://localhost:8080/API/Marvel/getHeroID/'+document.getElementById("id").value
    const request = await fetch(url ,{
	method: 'GET',
	headers: {
		'Accept': 'application/json',
		'Content-Type': 'application/json'
	}
	});
	const hero = await request.json();

   document.getElementById("id").value=hero.id;
   document.getElementById("name").value=hero.name;
   document.getElementById('description').value=hero.description;

    var listComics = "";
    hero.comics.forEach(comics => {
        listComics+= '<tr><td>'+comics+'</td></tr>'
    });
    document.getElementById("tableComics").innerHTML = listComics;
	}
	
function Clear(){
	document.getElementById("id").value="";
	document.getElementById("name").value="";
	document.getElementById('description').value="";
	document.getElementById("tableComics").innerHTML = "";
	
}
