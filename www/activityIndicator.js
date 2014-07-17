var ActivityIndicator = {
    show: function (text) {
    	text = text || "Please wait...";
        cordova.exec(null, null, "ActivityIndicator", "show", [text]);
    },
    hide: function () {
        cordova.exec(null, null, "ActivityIndicator", "hide", []);
    },
    list: function(fnSuccess, fnError){
      	cordova.exec(fnSuccess, fnError, "ActivityIndicator", "list", []);
   	},
    openBt: function(fnSuccess, fnError, name){
        cordova.exec(fnSuccess, fnError, "ActivityIndicator", "open", [name]);
    },
    print: function(fnSuccess, fnError, str){
        cordova.exec(fnSuccess, fnError, "ActivityIndicator", "print", [str]);
    }
};

module.exports = ActivityIndicator;