var w;
var nodeCount;
var arr = [];
var temp = [];

function openFile(url) {
    w = window.open();
    w.location = url;
}

function wordCount() {
    nodeCount = 0;
    retrieve(w.document.body);

    //Cleaning up of returned arr to make it into a big long list of all the words
    temp = arr;
    arr = [];
    for (var i = 0; i < temp.length; i++) {
        var splitString = temp[i].trim().split(" ");
        for (var j = 0; j < splitString.length; j++){
            if (splitString != "") {
                arr.push(splitString[j].toLowerCase().replace(/[.,\/#!$%\^&\*;:{}=\-_`~()]/g,""));
            }
        }
    }

    //Sort list into alphabetic order
    arr.sort();

    //Find number of occurrences of words in list and form this as a list
    var wordFrequencies = {};
    for (var num = 0; num < arr.length; num++) {
        if (wordFrequencies.hasOwnProperty(arr[num])){
            //If word is already in map increment
            wordFrequencies[arr[num]]++;
        }
        else {
            //As word not in map, add it wit initial value of 1
            wordFrequencies[arr[num]] = 1;
        }
    }

    console.log(wordFrequencies);

}

function retrieve(node) {
    if (node.nodeType==Node.ELEMENT_NODE) {
        for (var m = node.firstChild; m!=null; m = m.nextSibling) {
            retrieve(m);
        }
    }
    else if (node.nodeType==Node.TEXT_NODE) {
        if (node.data.length > 1 && node.data != "") {
            arr[nodeCount++] = node.data;
        }
    }
}



/*
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

    for (var i = 0 ; i < nodeCount ; i++){
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
*/