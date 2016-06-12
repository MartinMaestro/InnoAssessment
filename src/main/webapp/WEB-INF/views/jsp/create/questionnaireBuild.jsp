<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon" href="<c:url value='/static/images/vitruvio.png' />" />
<script type='text/javascript'>
            function showSubmit() {
                        var btnsubmit = document.getElementById('btn_submit');
                        btnsubmit.style.display = "block";
            }
            function showDiv(element) {
                        var form = document.getElementById('form');
                        var divs = form.getElementsByTagName('div');
                        for (i = 0, total = divs.length; i < total; i++) {
                                    if ((divs[i]).id == element)
                                                divs[i].style.display = "block";
                                    else
                                                divs[i].style.display = "none";
                        }
            }
            function showDiv2(element) {
                        var layer = document.getElementById(element);
                                    if (layer.style.display == "block")
                                                layer.style.display = "none";
                                    else
                                                layer.style.display = "block";
            }
            function openWindow (doc, name) {
                        window.open (doc, name,'width=600, height=380');
            }
            var num = 1;
            var fileproduct = new Array();
            var filedimension = new Array();
            var filefactor = new Array();
            function evento (evt) {
                        return (!evt) ? event : evt;
            }
            function addField (uploadfiles) {
                        var nDiv = document.createElement ('div');
                        nDiv.className = 'file'
                        nDiv.id = 'file' + num;
                        var nField = document.createElement ('input');
                        nField.name = 'filestoupload_' +  uploadfiles + '[]';
                        nField.type = 'file';
                        fileproduct [num] = '';
                        filedimension [num] = '';
                        filefactor [num] = '';
                        var newlink = document.createElement ('button');
                        newlink.name = nDiv.id;
                        newlink.onclick = delField;
                        newlink.innerHTML = 'Delete';
                        nDiv.appendChild (nField);
                        nDiv.appendChild (newlink);
                        var container = document.getElementById (uploadfiles);
                        container.appendChild (nDiv);
                        num++;
            }
            function delField (evt){
                        evt = evento (evt);
                        nField = rObj (evt);
                        div = document.getElementById (nField.name);
                        div.parentNode.removeChild (div);
            }
            function rObj (evt) {
                        return evt.srcElement ?  evt.srcElement : evt.target;
            }
            var n = 1;
            function addFieldUrl (layer, id) {
                        var newDiv = document.createElement ('div');
                        newDiv.id = 'url' + n;
                        var newField = document.createElement ('input');
                        newField.name = 'urlstoupload_' + id + '_' + n;
                        newField.id = 'urlstoupload_'+ id + '_' + n ;
                        newField.type = 'url';
                        var newlink = document.createElement ('button');
                        newlink.name = newDiv.id;
                        newlink.onclick = delField;
                        newlink.innerHTML = 'Delete';
                        newDiv.appendChild (newField);
                        newDiv.appendChild (newlink);
                        var container = document.getElementById (layer);
                        container.appendChild (newDiv);
                        n++;
            }
            function changeTabs1(dimId,btnId, divId, dim) {
            	  
            	/*
            	for(var i = 0; i < dim; i++) {
                                    document.getElementById('pesta' + i).style.display = 'none';
                                    document.getElementById('btn' + i).style.border = 'none';
                        }
                        document.getElementById(divId).style.display='block';
                        document.getElementById(btnId).style.border='2px solid #568FBD';
                 */
                               
                        showAssessments(dimId);
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
            function showDivUploads (divId, btnId) {
                        var div = document.getElementById (divId);
                        var btn = document.getElementById (btnId);
                        if (div.style.display == 'none'){
                                    div.style.display = 'block';
                        } else {
                                    div.style.display = 'none';
                        }
                        if (btn.value == 'Add Files'){
                                    btn.value = 'Hide Add Files';
                        }else{
                                    btn.value = 'Add Files';
                        }
            }
        function showFiles (){
            var container = document.getElementsByTagName('input')
            for (var i = 0; i <container.length; i++){
                var node = container[i];
                if (node.getAttribute('type') == "file") {
                    for (var j = 0; j < node.files.length; j++) {
                        alert ('File name: ' + node.files[j].name);
                    } // end for 
                } // end if 
            } // end for 
            return true;
        }
            function openLayer(id, nameContainer, dimName) {
                        if(document.getElementById(id)){
                                    var layer = document.getElementById(id);
                                    layer.style.display = "block";
                        } else {
                                    createNewLayer (id, nameContainer, dimName);
                        }
            }
            var chartValues = new Array();
            var chartDivs = new Array();
            function showDivChart (divId, i) {
                        FusionCharts.setCurrentRenderer ('javascript');
                        var myChart = new FusionCharts ('Column2D','chart' + i, '600', '450');
                        myChart.setXMLData (chartValues [divId]);
                        myChart.render (chartDivs [divId]);
            }
            
            function showAssessments(dimensionId) {
            	reloadPage('dimensionId='+dimensionId);
            }

            function reloadPage(param){
            	var url = window.location.href;    
            	if (url.indexOf('?') > -1){
            	 	var res = url.substring(0,url.indexOf('?'))
            	 	url = res + '?' + param
            	}else{
            	   	url += '?' + param
            	}
            	window.location.href = url;
            }
    </script>
    <script language='Javascript' src='js/FusionCharts.js'></script>
    <script language='Javascript' src='js/overlib.js'>
<!-- overLIB (c) Erik Bosrup --></script>
    </head>
    <body>
        <div class="myheader">
            Product innovation assessment questionnaire
            <img src="images/syst_logo.png" alt="" />
        </div>
        <!-- form id = 'questionnaire' action = 'processquestionnaire.php' method = 'post' enctype='multipart/form-data'  -->>
            <fieldset name='date_evaluation'>
                <legend>Evaluation Date</legend><p />
                Model: <b>${questionnaireDetail.modelName}</b> 
                - Questionnaire: <b>${questionnaireDetail.name}</b>
                Date: <input name='evaluation_date' value='${fecha}'/>
                Time: <input name='evaluation_time' value='${hora}'/>
                <input type='hidden' name='model' value='questionnaireDetail.modelId' />
                <input type='hidden' name='questionnaire' value='questionnaireDetail.Id' />
            </fieldset>
            <fieldset name='product_information'>
                <legend>Product details</legend><p />
                <select name="product" id = "idProduct">
                <c:forEach items="${productList}" var="product" varStatus="status">
  					<option value="${product.id}">${product.name}</option>
				</c:forEach> 
				</select>               
            </fieldset>
         
            <input type = 'hidden' name = 'numdim' value = '4' >
            <div id='pestanas'>
                <div id='dTabs' style='padding-left: 1%;'>
                    <input id='btn0' type='button' class='tab' style='border: 2px solid #568FBD;' onClick="changeTabs1(1,'btn0','pesta0', 4)" value='Organization' >
                    <input id='btn1' type='button' class='tab' style='border: none;' onClick="changeTabs1(2,'btn1','pesta1', 4)" value='Market' >
                    <input id='btn2' type='button' class='tab' style='border: none;' onClick="changeTabs1(3,'btn2','pesta2', 4)" value='Environment' >
                    <input id='btn3' type='button' class='tab' style='border: none;' onClick="changeTabs1(4,'btn3','pesta3', 4)" value='Technology' >
                </div>
                <div id='cont' style='border: 1px solid #4682B4;border-radius: 8px;padding: 1%;margin-top: -0.9%;'>
                    <div id='pesta0' style='display:block;'>
                         <c:forEach items="${assessmentLineList}" var="assessmentLine">
                         Dimension: <b>${assessmentLine.modelItemDimensionName}</b> 
                        <fieldset name='${assessmentLine.id}'>
                            <legend>${assessmentLine.modelItemFactorName}<a onmouseover="return overlib('<b><i>${assessmentLine.modelItemFactorName}</i></b><br><br><b>Definition:</b><br>${assessmentLine.modelItemFactorDefinition}.<br><br><b>Interpretation:</b><br>${assessmentLine.modelItemInterpretation}<br><br><b>Help:</b><br> It should be rated with <i>Very high</i> when the team has the perception about the success of the project and with <i>Very low</i> it is not clear if the project is going to be finished.',ABOVE, WIDTH, 500, FGCOLOR, '#FFF4CB', BGCOLOR, '#174A75', TEXTCOLOR, '#A68E34');" onmouseout='return nd();' style='position: relative;top: 1.5px;left: 4px;'><img src='images/icon_help.gif' alt='Help' height='16px' width='16px'></a></legend>
                            <table width='100%'>
                                <tr>
                                    <td>
                                <div style='text-align:center'>
                                    <input type = 'radio' name = '${assessmentLine.id}' id = 'opcion0' value = 'Unknown' checked = 'checked'>
                                    <label for = 'opcion0'>Unknown</label>
                                    <input type = 'radio' name = '${assessmentLine.id}' id = 'opcion9' value = 'Not Applicable' >
                                    <label for = 'opcion9'>Not Applicable</label>
                                    <input type = 'radio' name = '${assessmentLine.id}' id = 'opcion1' value = 'Very Few' >
                                    <label for = 'opcion1'>Very Few</label>
                                    <input type = 'radio' name = '${assessmentLine.id}' id = 'opcion2' value = 'Few' >
                                    <label for = 'opcion2'>Few</label>
                                    <input type = 'radio' name = '${assessmentLine.id}' id = 'opcion3' value = 'Medium' >
                                    <label for = 'opcion3'>Medium</label>
                                    <input type = 'radio' name = '${assessmentLine.id}' id = 'opcion4' value = 'High' >
                                    <label for = 'opcion4'>High</label>
                                    <input type = 'radio' name = '${assessmentLine.id}' id = 'opcion5' value = 'Very High' >
                                    <label for = 'opcion5'>Very High</label>
                                </div>
                                    </td>
                                    <td>
                                <div id='btnSee' style='text-align:center'>
                                    <input id='btnUploads_${assessmentLine.id}' type='button' value='Add Files' onclick= "showDivUploads('${assessmentLine.id}', 'btnUploads_${assessmentLine.id}');" />
                                </div>
                                    </td>
                                </tr>
                            </table>
                                    <div id='${assessmentLine.id}' style='display: none;'>
                                                <table width='100%'>
                                                <tr>
                                                            <td width='50%'>
                                                            <fieldset name='url' style='text-align: center;'>
                                                                        <legend>Add url</legend>
                                                                        <div id='${assessmentLine.id}_url'>
                                                                        <input type='url' id='urlstoupload_${assessmentLine.id}' name='urlstoupload_${assessmentLine.id}' multiple=''>
                                                                        </div>
                                                                        <a href='#' onclick="addFieldUrl('${assessmentLine.id}_url', '${assessmentLine.id}')">
                                                                                    <button type='button'>Add more</button>
                                                                        </a>
                                                            </fieldset>
                                                            </td>
                                                            <td>
                                                            <fieldset name='files' style='text-align: center;'>
                                                                        <legend>Add file</legend>
                                                                        <div id='${assessmentLine.id}files'>
                                                                        <input type='hidden' name='MAX_FILE_SIZE' value='5000000'>
                                                                        <input type='file' id='filestoupload_${assessmentLine.id}' name='filestoupload_${assessmentLine.id}[]'>
                                                                        </div>
                                                                        <a href='#' onclick="addField('${assessmentLine.id}_files')">
                                                                                    <button type='button'>Add more</button>
                                                                        </a>
                                                            </fieldset>
                                                            </td>
                                                </tr>
                                                </table>
                                    </div>
                        </fieldset>
                        </c:forEach>
                        
                        
                       
                    </div>                </div>
            </div>
            <button id='btn_submit' class = 'mybutton' style = 'display: block;' type="submit" value="Submit">Submit Questionnaire</button>
        <!--  /form-->>
    </body>
</html>