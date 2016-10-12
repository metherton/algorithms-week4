var readline = require('readline');
var lineNumber = 0;
var firstLine, secondLine;

process.stdin.setEncoding('utf8');

var rl = readline.createInterface({
    input: process.stdin,
    terminal: false
});

rl.on('line', readLine);

function readLine(line) {
    if (line !== "\n") {
        if (lineNumber === 0) {
            firstLine = line.toString().split(' ');
            lineNumber++;
        } else {
            secondLine = line.toString().split(' ');
            console.log(BINARY_SEARCH.calculate(firstLine.map(strToInt), secondLine.map(strToInt)));
            process.exit();
        }
    }
}

function strToInt(item) {
    return parseInt(item,10)
}

var BINARY_SEARCH = {} || BINARY_SEARCH;

BINARY_SEARCH.calculate = function(firstLine, secondLine) {
    console.log('first',firstLine);
    console.log('secibd',secondLine);
    return 0;
};