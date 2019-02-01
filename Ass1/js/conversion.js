function conversion(tagId, conversionType) {
    var rangeFrom = document.getElementById("rangeLower").value;
    var rangeTo = document.getElementById("rangeUpper").value;

    var parent = document.getElementById(tagId);

    var table = document.createElement("table");
    parent.appendChild(table);

    
    switch (conversionType) {
        case "CtoF":
            var head1Title = "Celsius (\xBAC)";
            var head2Title = "Fahrenheit (\xBAF)";
            break;
        case "FtoC":
            var head1Title = "Fahrenheit (\xBAF)";
            var head2Title = "Celsius (\xBAC)";
            break;
    }


    var tHead = document.createElement("thead");
    var hRow = document.createElement("tr");
    var head1 = document.createElement("th");
    head1.innerText = head1Title;
    var head2 = document.createElement("th");
    head2.innerText = head2Title;

    tHead.appendChild(hRow);
    hRow.appendChild(head1);
    hRow.appendChild(head2);
    table.appendChild(tHead);



    var tBody = document.createElement("tbody");

    for (var i = rangeFrom; i <= rangeTo; i++){
        var row = document.createElement("tr");
        var c1Data = document.createElement("td");
        var c2Data = document.createElement("td");

        c1Data.innerText = i;

        switch (conversionType) {
            case "CtoF":
                c2Data.innerText = c2f(i);
                break;
            case "FtoC":
                c2Data.innerText = f2c(i);
                break;
        }


        if (i % 2 == 1) row.setAttribute("class", "odd");
        else row.setAttribute("class", "even");


        row.appendChild(c1Data);
        row.appendChild(c2Data);
        tBody.appendChild(row);
    }
    table.appendChild(tBody);



    function c2f(c) {
        return Math.round((c * 9 / 5 + 32) * 10) / 10;
    }

    function f2c(f) {
        return Math.round(((f - 32) * 5/9) * 10) / 10;
    }
}