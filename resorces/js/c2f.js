function conversionTable(tagId, from, to) {
    var parent = document.getElementById(tagId);

    var table = document.createElement("table");
    parent.appendChild(table);

    var tHead = document.createElement("thead");
    var hRow = document.createElement("tr");
    var head1 = document.createElement("th");
    head1.innerText = "Celsius (\xBAC)";
    var head2 = document.createElement("th");
    head2.innerText = "Fahrenheit (\xBAF)";

    tHead.appendChild(hRow);
    hRow.appendChild(head1);
    hRow.appendChild(head2);
    table.appendChild(tHead);



    var tBody = document.createElement("tbody");

    for (var i = from; i <= to; i++){
        var row = document.createElement("tr");
        var cData = document.createElement("td");
        var fData = document.createElement("td");

        cData.innerText = i;
        fData.innerText = c2f(i);


        if (i % 2 == 1) row.setAttribute("class", "odd");
        else row.setAttribute("class", "even");

        row.appendChild(cData);
        row.appendChild(fData);
        tBody.appendChild(row);
    }
    table.appendChild(tBody);



    function c2f(c) {
        return c * 9 / 5 + 32;
    }
}