
function showDiv2(element) {
            var layer = document.getElementById(element);
                        if (layer.style.display == "block")
                                    layer.style.display = "none";
                        else
                                    layer.style.display = "block";
}

function changeTabs2(dim, n, jsonChartData) {
            for(var i = 0; i < dim; i++) {
                document.getElementById('pesta' + i).style.display = 'none';
                document.getElementById('pestaEdit' + i).style.display = 'none';
                document.getElementById('btn' + i).style.border = 'none';
                document.getElementById('btnEdit' + i).style.border = 'none';
            }
            document.getElementById('pesta' + n).style.display = 'block';
            document.getElementById('pestaEdit' + n).style.display = 'block';
            document.getElementById('btn' + n).style.border = '2px solid #568FBD';
            document.getElementById('btnEdit' + n).style.border = '2px solid #568FBD';
            showDivChart (n, jsonChartData);
}

var chartValues = new Array();
var chartDivs = new Array();
function showDivChart (divId, jsonChartData) {
            FusionCharts.setCurrentRenderer ('javascript');
            var myChart = new FusionCharts (jsonChartData);
            myChart.render (chartDivs [divId]);
}
