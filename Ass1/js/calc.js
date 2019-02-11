var numberOutput;

function number(num){
    numberOutput = document.getElementById("output");

    if (numberOutput.textContent == "0"){
        numberOutput.textContent = num;
    } else {
        numberOutput.textContent = numberOutput.textContent + "" + num;
    }
    console.log("number");
}

function clear(){
    document.getElementById("output").textContent = "0";
    console.log("clear");
}