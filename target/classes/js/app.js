
//Require the chart.js
const Chart = require('chart.js');

//Require the jQuery
const $ = require('jquery');

//Require the bootstrap javascript
require('bootstrap');

$('.resentful-input').on('keyup', function(){
	if($(this).value == $(this).data('oldValue')) {
		$(this).removeClass('is-invalid is-valid');
		$(this).addClass('border-info')
	}
});