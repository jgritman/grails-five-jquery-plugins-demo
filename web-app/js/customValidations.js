// custom validations for this project

(function() {

	var isMoney = function(value, element) {
	  if (!value) {
	    return true;
	  }
	  $(element).formatCurrency({colorize: true});
	  return /^(\(|-)?\$?(((\d|\,)*(\.\d{1,2})+)|(\d|\,)+)\)?$/.test($(element).val());
	}, "Please enter a valid dollar amount.");

	$.validator.addMethod("money", isMoney);

	$.validator.addMethod("positiveMoney", function(value, element) {
		if (!isMoney(value, element)) {
			return false;
		}
		var firstChar = $(element).val().substring(0,0);
		return firstChar != '(' && firstChar != '-';
	}, "Please enter a positive dollar amount.");
	
}());

