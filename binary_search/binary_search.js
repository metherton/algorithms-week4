var readline = require('readline');
var lineNumber = 0;
var listOfNumbers, keysToSearch;

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
            return low - 1;
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
    var numberOfItems = listOfNumbers.slice(0,1);
    var items = listOfNumbers.slice(1,listOfNumbers.length);
    return bs(items, 0, items.length - 1, 3);
};