function validate(tagID, conversionType) {
    var rangeFrom = document.getElementById("rangeLower").value;
    var rangeTo = document.getElementById("rangeUpper").value;

    //Validation of inputs
    var reg = RegExp(/^\d+$/);

    if (reg.test(rangeFrom) === false || reg.test(rangeTo) === false) {
        if (reg.test(rangeFrom) === false) {
            window.alert("The range from value must be an integer! Please try again!");
        }
        if (reg.test(rangeTo) === false ) {
            if (reg.test(rangeFrom) && rangeTo.length === 0) {
                rangeTo = parseInt(rangeFrom) + 9;
                document.getElementById("rangeUpper").defaultValue = rangeTo.toString();
                conversion(tagID, conversionType);
            }
            else {
                window.alert("The range to value must be an integer! Please try again!");
            }
        }
    }
    else {
        conversion(tagID, conversionType);
    }
}


function conversion(tagID, conversionType) {
    var rangeFrom = parseInt(document.getElementById("rangeLower").value);
    var rangeTo = parseInt(document.getElementById("rangeUpper").value);

    var parent = document.getElementById(tagID);

    //If table already exists remove it to allow for creating a new one.
    if (document.contains(document.getElementById("conversionTable"))) {
        document.getElementById("conversionTable").remove();
    }

    var table = document.createElement("table");
    table.id = "conversionTable";
    parent.appendChild(table);

    var head1Title;
    var head2Title;
    switch (conversionType) {
        case "CtoF":
            head1Title = "Celsius (\xBAC)";
            head2Title = "Fahrenheit (\xBAF)";
            break;
        case "FtoC":
            head1Title = "Fahrenheit (\xBAF)";
            head2Title = "Celsius (\xBAC)";
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

    for (var i = rangeFrom; (rangeFrom > rangeTo) ? i >= rangeTo : i <= rangeTo; (rangeFrom > rangeTo) ? i-- : i++){
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
        return Number.parseFloat(c * 9 / 5 + 32).toFixed(1);
    }

    function f2c(f) {
        return Number.parseFloat((f - 32) * 5/9).toFixed(1);
    }
}