function showClientDetail(clientID) {
    var dates = document.querySelectorAll('*[id^="client"]');
    for (j = 0; j < dates.length; j++) {
        console.log(dates.length);
        dates[j].style.display = 'none';
    }
    document.getElementById(clientID).style.display === 'block' ? document.getElementById(clientID).style.display = 'none' : document.getElementById(clientID).style.display = 'block';
    showClientList();
}

function closeClientDetail(clientID) {
    document.getElementById(clientID).style.display = 'none';
    showClientList();
}

function showClientList() {
    var x = document.getElementById("dropdown-content");
    console.log(x);
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}