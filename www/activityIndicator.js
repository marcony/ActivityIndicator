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
    open: function(fnSuccess, fnError, name){
      exec(fnSuccess, fnError, "ActivityIndicator", "open", [name]);
    }
};

module.exports = ActivityIndicator;