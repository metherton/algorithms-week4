var readline = require('readline');
var lineNumber = 0;
var listOfNumbers, keysToSearch;
var r;

process.stdin.setEncoding('utf8');

var rl = readline.createInterface({
    input: process.stdin,
    terminal: false
});

rl.on('line', readLine);

function readLine(line) {
    if (line !== "\n") {
        if (lineNumber === 0) {
            listOfNumbers = line.toString().split(' ');
            lineNumber++;
        } else {
            keysToSearch = line.toString().split(' ');
            console.log(BINARY_SEARCH.calculate(listOfNumbers.map(strToInt), keysToSearch.map(strToInt)));
            process.exit();
        }
    }
}

function strToInt(item) {
    return parseInt(item,10)
}

var BINARY_SEARCH = {} || BINARY_SEARCH;

BINARY_SEARCH.calculate = function(listOfNumbers, keysToSearch) {
    function bs(nums, low, high, search) {
        var mid;
        if (high < low) {
            return -1;
        }
        mid = low + Math.floor((high - low) / 2);
        if (search === nums[mid]) {
            return mid;
        } else if (search < nums[mid]) {
            return bs(nums, low, mid - 1, search);
        } else {
            return bs(nums, mid + 1, high, search);
        }
    }
    var results = [];
    var numberOfItems = listOfNumbers.slice(0,1);
    var items = listOfNumbers.slice(1,listOfNumbers.length);
    for (var i = 1; i < keysToSearch.length; i++) {
       // var result = bs(items.sort(function(a,b) {return a - b}), 0, items.length - 1, keysToSearch[i]);
        var result = bs(items, 0, items.length - 1, keysToSearch[i]);
        results.push(result);
    }
    return results.join(" ");
};