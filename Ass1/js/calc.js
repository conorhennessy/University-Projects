var numberOutput;
var storedOpr;
var storedNum;

function number(num) {
    console.log("NUM BUTTON PRESSED > num: " + num + "\n storedOpr: " + storedOpr + "\n storedNum: " + storedNum);

    numberOutput = document.getElementById("output");
    //if (numberOutput.textContent === "0" || (parseInt(numberOutput.textContent) !== storedNum && storedNum != null)){
    if (numberOutput.textContent === "0" || (parseFloat(numberOutput.textContent) === storedNum)) {
        console.log("Plan 1");
        numberOutput.textContent = num;
    } else if (numberOutput.textContent !== "0") {
        console.log("Plan 2");
        numberOutput.textContent = numberOutput.textContent + "" + num;
    }
}

function clearCalc(){
    storedOpr = null;
    storedNum = null;
    document.getElementById("output").textContent = "0";
}

function decimal() {
    if (!numberOutput.textContent.includes(".") ){
        numberOutput.textContent = numberOutput.textContent + ".";
    }
}

function operator(opr) {
    console.log("INITIAL VALUES > OPR: "+ opr + "\n storedOpr: "+ storedOpr + "\n storedNum: " + storedNum);

    if (opr === storedOpr){
        equal();
        console.log("Plan A");
    }
    if (storedOpr == null || opr !== storedOpr) {
        storedNum = parseFloat(numberOutput.textContent);
        storedOpr = opr;
        console.log("Plan B");
    }
    console.log("BUTTON PRESSED > OPR: "+ opr + "\n storedOpr: "+ storedOpr + "\n storedNum: " + storedNum);
}

function equal() {
    console.log("evaluating");
    if (storedOpr === '+'){
        numberOutput.textContent = parseFloat(numberOutput.textContent) + parseFloat(storedNum);
    }
    if (storedOpr === '-'){
        numberOutput.textContent = parseFloat(storedNum) - parseFloat(numberOutput.textContent);
    }
    if (storedOpr === '*'){
        numberOutput.textContent = parseFloat(storedNum) * parseFloat(numberOutput.textContent);
    }
    if (storedOpr === '/'){
        numberOutput.textContent = parseFloat(storedNum) / parseFloat(numberOutput.textContent);
    }
    storedNum = null;
    storedOpr = null;
}