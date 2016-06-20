function generateRadioChartData(productName, dimensions, lineValues){
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
				"categories": {}
		}
	};
	
	return  dimensions.length === 2? generate2DimensionChartData(dimensions, lineValues, chartData):generateFullDimensionChartData(dimensions, lineValues, chartData);
}

function createCategorie(label){
    return {
                "label": label
            };        		
}

function createValue(value){
	return {
		"value": value.toString()
	}
}

function generateFullDimensionChartData(dimensions, lineValues, chartData){
	var category = [];
	var optimalUpperLimitImpact = [];
	var upperLimitImpact = [];
	var optimumAchievableImpact = [];
	var maximumAchievableImpact = [];
	var realDimensionImpact = [];
	var minimumAchievableImpact = [];
	var lowerLimitImpact = [];
	var dataset = {
			"Optimum Upper Limit Impact": optimalUpperLimitImpact,
			"Upper Limit Impact": upperLimitImpact,
			"Optimum Achievable Impact": optimumAchievableImpact,
			"Maximum Achievable Impact": maximumAchievableImpact,
			"Real Dimension Impact": realDimensionImpact,
			"Minimum Achievable Impact": minimumAchievableImpact,
			"Lower Limit Impact": lowerLimitImpact
	};
	var fullDimensionsDataset = [
			            {
			                "seriesname": "Optimum Upper Limit Impact",
			                "alpha": "25",
			                "data": optimalUpperLimitImpact
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
			            }];        	
	chartData.dataSource.dataset = fullDimensionsDataset;
	chartData.dataSource.categories.category = category;
	
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

function generate2DimensionChartData(dimensions, lineValues, chartData){
	var category = [];
	var dataset = {
			"Real Dimension Impact": "Real Impact",
			"Optimum Achievable Impact": "Less Fav. Impact",
			"Maximum Achievable Impact": "Most Fav. Impact",
			"Upper Limit Impact": "Max. Impact"
	};
	var datasetArray = ["Real Dimension Impact","Optimum Achievable Impact","Maximum Achievable Impact","Upper Limit Impact"];
	var datasetsByDimensions = {};
	
	datasetArray.forEach(function(impactType){
		category.push(createCategorie(dataset[impactType]));
	});
	chartData.dataSource.categories.category = category;	
	
	chartData.dataSource.dataset = [];
	dimensions.forEach(function(dimension){
		datasetsByDimensions[dimension.id.toString()] = [];
		chartData.dataSource.dataset.push({
			"seriesname": dimension.name,
			"data": datasetsByDimensions[dimension.id.toString()]
		});
	});
	
	datasetArray.forEach(function(impactType){
		datasetArray.forEach(function(lineValue){
			if(impactType === lineValue.evaluationResultType){
				datasetsByDimensions[lineValue.dimensionId.toString()].push(createValue(lineValue.percentageValue));
			}
		});
	});
	
	return chartData;
}

