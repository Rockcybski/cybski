var clearChat = function(){
	$("#chart").html("");
};

var createSingerDataRenderer = function(){
	//clear
	clearChat();
	// Our data renderer function, returns an array of the form:
	  // [[[x1, sin(x1)], [x2, sin(x2)], ...]]
	  var sineRenderer = function() {
	    var data = [[]];
	    for (var i=0; i<13; i+=0.5) {
	      data[0].push([i, Math.sin(i)]);
	    }
	    return data;
	  };
	  // we have an empty data array here, but use the "dataRenderer"
	  // option to tell the plot to get data from our renderer.
	  $.jqplot('chart',[],{
	      title: 'Sine Data Renderer',
	      dataRenderer: sineRenderer
	  });
};

var createAjaxJsonDataRenderer = function(){
	//clear
	clearChat();
	  // it could contact any source and pull data, however.
	  // The options argument isn't used in this renderer.
	  //[[x1, x2, x3, x4, x4]]
	  var ajaxDataRenderer = function(url, plot, options) {
	    var ret = null;
	    $.ajax({
	      // have to use synchronous here, else the function 
	      // will return before the data is fetched
	      async: false,
	      url: url,
	      type:"post",
	      dataType:"json",
	      success: function(data) {
	        ret = data;
	      }
	    });
	    return ret;
	  };
	  // The url for requiring json data
	  var jsonurl = "jqPlot/json4AjaxJsonDataRenderer";
	  // passing in the url string as the jqPlot data argument is a handy
	  // shortcut for our renderer.  You could also have used the
	  // "dataRendererOptions" option to pass in the url.
	  $.jqplot('chart', jsonurl,{
	    title: "AJAX JSON Data Renderer",
	    dataRenderer: ajaxDataRenderer,
	    dataRendererOptions: {
	      unusedOptionalUrl: jsonurl
	    }
	  });
};

var createAnimatedCharts = function(){
	clearChat();
};