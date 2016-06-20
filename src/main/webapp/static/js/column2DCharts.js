function generate2DChartData(dimension, tabId, lineValues){
	var dataset = {};
	
	lineValues.forEach(function(lineValue){
		if(dimension.id === lineValue.dimensionId){
			dataset[lineValue.evaluationResultType] = lineValue.value;
		}
	});
	
	var chartData = {
	        "type": "column2d",
	        "renderAt": "chart" + tabId,
	        "width": "600",
	        "height": "450",
	        "dataFormat": "json",
	        "dataSource": {
				"chart": {
			        "caption": dimension.name,
		        	"yAxisMaxValue": (Math.round(dataset["Upper Limit Impact"]*110)/100).toString(), 
		        	"yAxisMinValue": "0"   				
				},
			    "data": [
			             {
			                 "label": "Maximum Achievable Impact",
			                 "value": dataset["Maximum Achievable Impact"].toString()
			             },
			             {
			                 "label": "Optimum Achievable Impact",
			                 "value": dataset["Optimum Achievable Impact"].toString()
			             },
			             {
			                 "label": "Minimum Achievable Impact",
			                 "value": dataset["Minimum Achievable Impact"].toString()
			             }
			     ],
				 "trendlines": [{
			                 "line": [
			                     {
			                         "startvalue": dataset["Optimum Upper Limit Impact"].toString(),
			                         "color": "FF0000",
			                         "displayvalue": "Optimum Upper Limit Impact",
			                         "showOnTop": "1",
			                         "thickness": "3"
			                     }, 
			                     {
			                         "startvalue": dataset["Real Dimension Impact"].toString(),
			                         "color": "91C728",
			                         "displayvalue": "Real Dimension Impact",
			                         "showOnTop": "1",
			                         "thickness": "3"
			                     },
			                     {
			                         "startvalue": dataset["Lower Limit Impact"].toString(),
			                         "color": "FF0000",
			                         "displayvalue": "Lower Limit Impact",
			                         "showOnTop": "1",
			                         "thickness": "3"
			                     }
			                  ]			             
			             }]		
		}
	};
	
	return chartData;
}
