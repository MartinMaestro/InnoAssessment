function radioChart(productName, dimensions, lineValues){

	var category = [];
	var optimalUpperLimitImpactData = [];
	var upperLimitImpact = [];
	var optimumAchievableImpact = [];
	var maximumAchievableImpact = [];
	var realDimensionImpact = [];
	var minimumAchievableImpact = [];
	var lowerLimitImpact = [];
	var dataset = {
			"Optimum Upper Limit Impact": optimalUpperLimitImpactData,
			"Upper Limit Impact": upperLimitImpact,
			"Optimum Achievable Impact": optimumAchievableImpact,
			"Maximum Achievable Impact": maximumAchievableImpact,
			"Real Dimension Impact": realDimensionImpact,
			"Minimum Achievable Impact": minimumAchievableImpact,
			"Lower Limit Impact": lowerLimitImpact
	};
	var chartData = {
            "type": "Radar",
            "renderAt": "chartId1",
            "width": "1000",
            "height": "700",
            "dataFormat": "json",
            "dataSource": {
    			"chart": {
    		        "caption": productName, 
    		        "bgColor": "FFFFFF", 
   		        	"bgAlpha": "50",
   		        	"anchoralpha": "50", 
   		        	"radarborderalpha": "50", 
   		        	"radarborderthickness": "2", 
   		        	"radarfillcolor": "FFFFFF", 
   		        	"yAxisMaxValue": "100", 
   		        	"bordercolor": "000000", 
   		        	"captionpadding": "20", 
   		        	"showlabels": "1", 
   		        	"drawanchors": "0", 
   		        	"showlimits": "1", 
   		        	"legendborderalpha":"1"     				
    			},
    			"categories": {
    					"category": category
    				},
    			"dataset": [
    			            {
    			                "seriesname": "Optimum Upper Limit Impact",
    			                "alpha": "25",
    			                "data": optimalUpperLimitImpactData
    			            },
    			            {
    			                "seriesname": "Upper Limit Impact",
    			                "alpha": "25",
    			                "data": upperLimitImpact
    			            },
    			            {
    			                "seriesname": "Optimum Achievable Impact",
    			                "alpha": "25",
    			                "data": optimumAchievableImpact
    			            },
    			            {
    			                "seriesname": "Maximum Achievable Impact",
    			                "alpha": "25",
    			                "data": maximumAchievableImpact
    			            },
    			            {
    			                "seriesname": "Real Dimension Impact",
    			                "alpha": "40",
    			                "data": realDimensionImpact
    			            },
    			            {
    			                "seriesname": "Minimum Achievable Impact",
    			                "alpha": "30",
    			                "color": "646464",
    			                "data": minimumAchievableImpact
    			            },
    			            {
    			                "seriesname": "Lower Limit Impact",
    			                "color": "000000",
    			                "data": lowerLimitImpact
    			            }]
    	}
	};        	
	
	dimensions.forEach(function(dimension){
		category.push(createCategorie(dimension.name));
		lineValues.forEach(function(lineValue){
			if(dimension.id === lineValue.dimensionId){
				dataset[lineValue.evaluationResultType].push(createValue(lineValue.percentageValue));
			}
		});
	});
	
	return chartData;
}