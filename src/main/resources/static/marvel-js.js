async function getHero(){
    const id = document.getElementById("id").value;
    const request = await fetch('http://localhost:8080/API/Marvel/getHeroID/'+id, { // se detiene hasta obtener el resultado para seguir
        method: 'POST',
        headers: {
            'Accept': 'aplicattion/json', // indica que va a usar json y que el contenido va a ser json
            'Content-Type': 'application/json'
        },
        //body: JSON.stringify({a:1,b:'Textual content'})
        // no es necesario porque toda la informacion va a ir por la URL
    });
    const hero = await request.json(); // convierte el resultado en JSON

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