// JavaScript source code
document.addEventListener("DOMContentLoaded", function(event) {
    var userLang = navigator.language || navigator.userLanguage;    
    document.getElementById("pageTitle").innerHTML = 'Learning Portal';
    var menu = document.getElementsByClassName("menu-item-text");
    if (userLang == "en" || userLang == "en-US") {        
        menu[0].textContent = "Start";
        menu[1].textContent = "My Playlists";
        menu[2].textContent = "My Library";
        menu[3].textContent = "Links";
    } else {
        menu[0].textContent = "Start"; // "Lerninhalte suchen";
        menu[1].textContent = "Meine Playlists"; // "Trendthemen";
        menu[2].textContent = "Meine Bibliothek";
        menu[3].textContent = "Links";        
    }
});