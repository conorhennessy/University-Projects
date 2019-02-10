function wordCount() {
    var url = document.getElementById("url").value;




    //The drawing and creation of the table
    var parent = document.getElementById("wordCount");

    //If table already exists remove it to allow for creating a new one.
    if (document.contains(document.getElementById("countTable"))) {
        document.getElementById("countTable").remove();
    }

    var table = document.createElement("table");
    table.id = "countTable";
    parent.appendChild(table);

    var head1Title = "Word";
    var head2Title = "Count";


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

    for (var i = 0 ; i < counter ; i++){
        var row = document.createElement("tr");
        var c1Data = document.createElement("td");
        var c2Data = document.createElement("td");

        c1Data.innerText = "test";
        c2Data.innerText = "test";

        if (i % 2 == 1) row.setAttribute("class", "odd");
        else row.setAttribute("class", "even");


        row.appendChild(c1Data);
        row.appendChild(c2Data);
        tBody.appendChild(row);
    }
    table.appendChild(tBody);
}