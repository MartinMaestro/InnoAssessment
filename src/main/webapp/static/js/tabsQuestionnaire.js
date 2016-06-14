function showAssessments(dimensionId) {
	putAssesstmentsByDimension(dimensionId);
}

function putButton(dimensionId) {
	buttons = document.getElementsByTagName('input');
	for (i = 0; i < buttons.length; i++) {
		if (buttons[i].id.substr(0, 6) == 'btnDim') {
			if (buttons[i].id.substr(6, 1) == dimensionId) {
				buttons[i].style.border = '2px solid #568FBD';
			} else {
				buttons[i].style.border = 'none';
			}
		}
		if (buttons[i].id.substr(0, 11) == 'btnUploads_') {
			buttons[i].value = 'Add Files';
		}

	}
}

function putAssesstmentsByDimension(dimensionId) {
	putButton(dimensionId);
	capas = document.getElementsByTagName('div');
	for (i = 0; i < capas.length; i++) {
		switch (capas[i].id.substr(0, 3)) {
		case 'al_':
			if (capas[i].id.substr(3, 1) == dimensionId) {
				capas[i].style.display = 'block';
			} else {
				capas[i].style.display = 'none';
			}
			break;
		case 'sf_':
			capas[i].style.display = 'none';
			break;
		default:
			capas[i].style.display = 'block';
		}
	}
}

function openWindow(doc, name) {
	window.open(doc, name, 'width=600, height=380');
}
var num = 1;
var fileproduct = new Array();
var filedimension = new Array();
var filefactor = new Array();
function evento(evt) {
	return (!evt) ? event : evt;
}
function addField(uploadfiles) {
	var nDiv = document.createElement('div');
	nDiv.className = 'file'
	nDiv.id = 'file' + num;
	var nField = document.createElement('input');
	nField.name = 'filestoupload_' + uploadfiles + '[]';
	nField.type = 'file';
	fileproduct[num] = '';
	filedimension[num] = '';
	filefactor[num] = '';
	var newlink = document.createElement('button');
	newlink.name = nDiv.id;
	newlink.onclick = delField;
	newlink.innerHTML = 'Delete';
	nDiv.appendChild(nField);
	nDiv.appendChild(newlink);
	var container = document.getElementById(uploadfiles);
	container.appendChild(nDiv);
	num++;
}
function delField(evt) {
	evt = evento(evt);
	nField = rObj(evt);
	div = document.getElementById(nField.name);
	div.parentNode.removeChild(div);
}
function rObj(evt) {
	return evt.srcElement ? evt.srcElement : evt.target;
}
var n = 1;
function addFieldUrl(layer, id) {
	var newDiv = document.createElement('div');
	newDiv.id = 'url' + n;
	var newField = document.createElement('input');
	newField.name = 'urlstoupload_' + id + '_' + n;
	newField.id = 'urlstoupload_' + id + '_' + n;
	newField.type = 'url';
	var newlink = document.createElement('button');
	newlink.name = newDiv.id;
	newlink.onclick = delField;
	newlink.innerHTML = 'Delete';
	newDiv.appendChild(newField);
	newDiv.appendChild(newlink);
	var container = document.getElementById(layer);
	container.appendChild(newDiv);
	n++;
}

var j = 0;

function showDivUploads(divId, btnId) {
	var div = document.getElementById(divId);
	var btn = document.getElementById(btnId);
	if (div.style.display == 'none') {
		div.style.display = 'block';
	} else {
		div.style.display = 'none';
	}
	if (btn.value == 'Add Files') {
		btn.value = 'Hide Add Files';
	} else {
		btn.value = 'Add Files';
	}
}
function showFiles() {
	var container = document.getElementsByTagName('input')
	for (var i = 0; i < container.length; i++) {
		var node = container[i];
		if (node.getAttribute('type') == "file") {
			for (var j = 0; j < node.files.length; j++) {
				alert('File name: ' + node.files[j].name);
			} // end for
		} // end if
	} // end for
	return true;
}
function openLayer(id, nameContainer, dimName) {
	if (document.getElementById(id)) {
		var layer = document.getElementById(id);
		layer.style.display = "block";
	} else {
		createNewLayer(id, nameContainer, dimName);
	}
}