var ActivityIndicator = {
    show: function (text) {
    	text = text || "Please wait...";
        cordova.exec(null, null, "ActivityIndicator", "show", [text]);
    },
    hide: function () {
        cordova.exec(null, null, "ActivityIndicator", "hide", []);
    }
    alertBox: function(message, title, buttonLabel) {
        var _title = (title || "Alert");
        var _buttonLabel = (buttonLabel || "OK");
        cordova.exec( null,null, "ActivityIndicator", "alert", [message, _title, _buttonLabel]);
    },
};

module.exports = ActivityIndicator;