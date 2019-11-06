var btnContainer = document.getElementById("dropdown-content");
var btns = btnContainer.getElementsByClassName("btnClient");

for (var i = 0; i < btns.length; i++) { //ajouter classe active a l'élément cliquer
    btns[i].addEventListener("click", function() {
        var current = document.getElementsByClassName("active");
        if (current.length > 0) {
            current[0].className = current[0].className.replace(" active", "");
        }
        this.className += " active";
    });
}

function showClientDetail(clientID) { //masquer tout les détail client puis inverser l'état du détail client choisit

    var client = document.querySelectorAll('*[id^="client"]');
    for (j = 0; j < client.length; j++) {
        client[j].style.display = 'none';
    }
    document.getElementById(clientID).style.display === 'block' ? document.getElementById(clientID).style.display = 'none' : document.getElementById(clientID).style.display = 'block';

    if (screen.width < 640) { //fermer la liste si un client est choisit (uniquement en format large)
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