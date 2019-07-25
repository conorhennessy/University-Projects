var numberOutput;
var storedOpr;
var storedNum;

function number(num) {
    numberOutput = document.getElementById("output");
    //if (numberOutput.textContent === "0" || (parseInt(numberOutput.textContent) !== storedNum && storedNum != null)){
    if (numberOutput.textContent === "0" || (parseFloat(numberOutput.textContent) === storedNum)) {
        numberOutput.textContent = num;
    } else if (numberOutput.textContent !== "0") {
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
    if (opr === storedOpr){
        equal();
    }
    if (opr != storedOpr && numberOutput.textContent != storedNum){
        equal();
    }
    if (storedOpr == null || opr !== storedOpr) {
        storedNum = parseFloat(numberOutput.textContent);
        storedOpr = opr;
    }
}

function equal() {
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