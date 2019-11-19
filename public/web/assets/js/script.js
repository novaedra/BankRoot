var btnContainer = document.getElementById("dropdown-content");
var btns = btnContainer.getElementsByClassName("btnClient");
var colorNote = {"A": "#006638", "B": "#7DB338", "C": "#FDC12A", "D": "#EE7A22", "E": "#E83C25", "F": "red"};

for (var i = 0; i < btns.length; i++) { //ajouter classe active a l'élément cliquer
    btns[i].addEventListener("click", function () {
        var current = document.getElementsByClassName("active");
        if (current.length > 0) {
            current[0].className = current[0].className.replace(" active", "");
        }
        this.className += " active";
    });
}

function showClientDetail(clientID) { //masquer tout les détail client puis inverser l'état du détail client choisit

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

    var note = client.querySelector("span#note");
    note.style.backgroundColor = colorNote[note.innerHTML]; //changement couleur note en fonction de cell-ci

    if (window.innerWidth < 640) { //fermer la liste si un client est choisit (uniquement en format portrait)
        showClientList();
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
    formunlock = document.getElementById("formAdmin");
    formunlock.classList.remove("detailAdmin");
    console.log(formunlock);
    for (var i = 0; i < formunlock.length; i++) {
        formunlock[i].removeAttribute('readonly');
    }
    submitButton = document.getElementById('validationAdmin');
    submitButton.removeAttribute('disabled');
    submitButton.style.display = "block";
}