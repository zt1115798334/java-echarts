"use strict";
var page = require('webpage').create();
page.open('https://www.baidu.com/', function () {
    page.render('baidu.png');
    phantom.exit();
});