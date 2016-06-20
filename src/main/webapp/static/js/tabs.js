
function showDiv2(element) {
            var layer = document.getElementById(element);
                        if (layer.style.display == "block")
                                    layer.style.display = "none";
                        else
                                    layer.style.display = "block";
}

function changeTabs2(divId, dim, n, btn, jsonChartData) {
            for(var i = 0; i < dim; i++) {
                        document.getElementById(divId + i).style.display = 'none';
                        document.getElementById(btn + i).style.border = 'none';
            }
            document.getElementById(divId + n).style.display = 'block';
            document.getElementById(btn + n).style.border = '2px solid #568FBD';
            showDivChart (n, jsonChartData);
}

var chartValues = new Array();
var chartDivs = new Array();
function showDivChart (divId, jsonChartData) {
            FusionCharts.setCurrentRenderer ('javascript');
            var myChart = new FusionCharts (jsonChartData);
            myChart.render (chartDivs [divId]);
}
