// custom validations for this project

(function() {

	// these validations will not work unless keypress=false
	var isMoney = function(value, element) {
	  if (!value || element == document.activeElement) {
	    return true;
	  }
	  $(element).formatCurrency({colorize: true});
	  return /^(\(|-)?\$?(((\d|\,)*(\.\d{1,2})+)|(\d|\,)+)\)?$/.test($(element).val());
	};

	$.validator.addMethod("money", isMoney, "Please enter a valid dollar amount.");

	$.validator.addMethod("positiveMoney", function(value, element) {
		if (!isMoney(value, element)) {
			return false;
		}
		var firstChar = $(element).val().substring(0,1);
		return firstChar != '(' && firstChar != '-';
	}, "Please enter a positive dollar amount.");
	
}());

