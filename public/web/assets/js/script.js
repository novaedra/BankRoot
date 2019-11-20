function showClientDetail(clientID) { //masquer tout les détail client puis inverser l'état du détail client choisit

    var btnContainer = document.getElementById("dropdown-content");
    var btns = btnContainer.getElementsByClassName("btnClient");

    for (var i = 0; i < btns.length; i++) { //ajouter classe active a l'élément cliqué
        btns[i].addEventListener("click", function () {
            var current = document.getElementsByClassName("active");
            if (current.length > 0) {
                current[0].className = current[0].className.replace(" active", "");
            }
            this.className += " active";
        });
    }

    var client = document.getElementById(clientID);
    var hideclients = document.querySelectorAll('*[id^="client"]');

    if (client.style.display === "block") { //si le client est deja affiché alors on le cache
        for (j = 0; j < hideclients.length; j++) {
            hideclients[j].style.display = 'none'; //cacher tout les client
        }
    } else {
        for (j = 0; j < hideclients.length; j++) {
            hideclients[j].style.display = 'none'; //cacher tout les client
        }
        client.style.display = "block"; //afficher notre client choisit
    }

    if (window.innerWidth < 640) { //fermer la liste si un client est choisit (uniquement en format portrait)
        showClientList();
    }
    note();
}

function note() {
    console.log("ça charge");
    var note = document.querySelectorAll("span#note");
    console.log("les notes : " + note);
    var colorNote = {"A": "#006638", "B": "#7DB338", "C": "#FDC12A", "D": "#EE7A22", "E": "#E83C25", "F": "red"};

    for (j = 0; j < note.length; j++) {
        note[j].style.backgroundColor = colorNote[note[j].innerHTML]; //changement couleur note en fonction de sa valeur
    }

}

function closeClientDetail(clientID) { //fermer détail client
    document.getElementById(clientID).style.display = 'none';
}

function showClientList() { //inverser affichage liste client
    var x = document.getElementById("dropdown-content");
    if (x.style.display === "none") {
        x.style.display = "block";
        document.getElementById("menuDeroulant").style.transform = "rotate(180deg)";
    } else {
        x.style.display = "none";
        document.getElementById("menuDeroulant").style.transform = "rotate(0deg)";
    }
}

function change() {
    formunlock = document.getElementById("formAnimation");
    formunlock.classList.remove("detailAnimation");
    for (var i = 0; i < formunlock.length; i++) {
        formunlock[i].removeAttribute('readonly');
        formunlock[i].removeAttribute('disabled');
    }
    submitButton = document.getElementById('validation');
    submitButton.style.display = "block";
}