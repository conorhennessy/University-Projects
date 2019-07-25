var days = ["M", "T", "W", "T", "F", "S", "S"];

function dateSelectionControl() {
    var w = window.open();
    var d = w.document;
    d.open();
    d.write('<hr>Hello World</hr>');
    var popup = document.getElementById('popup');
    d.write(popup.innerHTML);
    d.close();

    function reply(a) {
        alert(a);
    }
}