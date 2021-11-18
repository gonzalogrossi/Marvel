async function getHero(){
    const id = document.getElementById("id").value;
    fetch("http://localhost:8080/API/Marvel/getHeroID/"+id)
  .then(response => response.json())
  .then(hero => showHeroDetails(hero));

	showHeroDetails = hero => {

    const idHero = document.querySelector('#name_txt');
    const name = document.querySelector('#description_txt');
    const description = document.querySelector('#heroID_response');

    idHero.value = hero.id;
    name.value = hero.name;
    description.value = hero.description;

    var listComics = "";
    hero.comics.forEach(comics => {
        listComics+= '<tr><td>${comics}</td></tr>'
    });
    document.getElementById("tableComics").innerHTML = listComics;
	}
}