
function showDiv2(element) {
            var layer = document.getElementById(element);
                        if (layer.style.display == "block")
                                    layer.style.display = "none";
                        else
                                    layer.style.display = "block";
}

var j = 0;
function changeTabs2(divId, dim, n, btn) {
            for(var i = 0; i < dim; i++) {
                        document.getElementById(divId + i).style.display = 'none';
                        document.getElementById(btn + i).style.border = 'none';
            }
            document.getElementById(divId + n).style.display = 'block';
            document.getElementById(btn + n).style.border = '2px solid #568FBD';
            showDivChart (n, j);                        j++;
}

var chartValues = new Array();
var chartDivs = new Array();
function showDivChart (divId, i) {
            FusionCharts.setCurrentRenderer ('javascript');
            var myChart = new FusionCharts ('Column2D','chart' + i, '600', '450');
            myChart.setXMLData (chartValues [divId]);
            myChart.render (chartDivs [divId]);
}
