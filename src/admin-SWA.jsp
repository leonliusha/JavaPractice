<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">


<%@ page import="com.swa.eip.launcher.EipCredential, com.swa.linechecksolver.domain.HealthCheckItem"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<HTML>

<HEAD>
	<META Http-Equiv="Cache-Control" Content="no-cache">
	<%= EipCredential.getSwaHttpHead( session )%>
	<META http-equiv="Content-Style-Type" content="text/css">
	<link rel=stylesheet href="stylesheets/LineCheckSolver.css" type="text/css">
	<script type="text/javascript" language="javascript" src="javascript/stringFunctions.js"></script>
	<script language="javascript">
<!--
var currentTab = "conn";
function tabClick(divName) {    
	if (divName == "connTimes") {
	
		currentTab = "conn";
		
		document.getElementById("connTab").className = "tab";
		document.getElementById("emailTab").className = "backgroundTab";
		document.getElementById("optParamsTab").className = "backgroundTab";
		document.getElementById("remindTab").className = "backgroundTab";
		document.getElementById("healthCheckTab").className = "backgroundTab";
		document.getElementById("randomLineCheckTab").className = "backgroundTab";
		
		document.getElementById("connTimes").style.display = "";
		document.getElementById("optParams").style.display = "none";
		document.getElementById("email").style.display = "none";
		document.getElementById("remindDiv").style.display = "none";
		document.getElementById("healthCheckDiv").style.display = "none";
		document.getElementById("randomLineCheckDiv").style.display = "none";
	}
	
	else if (divName == "email") {
	
		currentTab = "email";

		document.getElementById("connTab").className = "backgroundTab";
		document.getElementById("emailTab").className = "tab";
		document.getElementById("optParamsTab").className = "backgroundTab";
		document.getElementById("remindTab").className = "backgroundTab";
		document.getElementById("healthCheckTab").className = "backgroundTab";
		document.getElementById("randomLineCheckTab").className = "backgroundTab";
		
		document.getElementById("connTimes").style.display = "none";
		document.getElementById("email").style.display = "";
		document.getElementById("optParams").style.display = "none";
		document.getElementById("remindDiv").style.display = "none";
		document.getElementById("healthCheckDiv").style.display = "none";
		document.getElementById("randomLineCheckDiv").style.display = "none";
	}
	
	else if (divName == "optParams") {
	
		currentTab = "opt";

		document.getElementById("connTab").className = "backgroundTab";
		document.getElementById("emailTab").className = "backgroundTab";
		document.getElementById("optParamsTab").className = "tab";
		document.getElementById("remindTab").className = "backgroundTab";
		document.getElementById("healthCheckTab").className = "backgroundTab";
		document.getElementById("randomLineCheckTab").className = "backgroundTab";
		
		document.getElementById("connTimes").style.display = "none";
		document.getElementById("email").style.display = "none";
		document.getElementById("optParams").style.display = "";
		document.getElementById("remindDiv").style.display = "none";
		document.getElementById("healthCheckDiv").style.display = "none";
		document.getElementById("randomLineCheckDiv").style.display = "none";
	}
	else if (divName == "remindDiv") {
	
		currentTab = "remind";

		document.getElementById("connTab").className = "backgroundTab";
		document.getElementById("emailTab").className = "backgroundTab";
		document.getElementById("optParamsTab").className = "backgroundTab";
		document.getElementById("remindTab").className = "tab";
		document.getElementById("healthCheckTab").className = "backgroundTab";
		document.getElementById("randomLineCheckTab").className = "backgroundTab";
		
		document.getElementById("connTimes").style.display = "none";
		document.getElementById("email").style.display = "none";
		document.getElementById("optParams").style.display = "none";
		document.getElementById("remindDiv").style.display = "";
		document.getElementById("healthCheckDiv").style.display = "none";
		document.getElementById("randomLineCheckDiv").style.display = "none";
		
	}
	else if (divName == "healthCheck") {	
		currentTab = "healthcheck";

		document.getElementById("connTab").className = "backgroundTab";
		document.getElementById("emailTab").className = "backgroundTab";
		document.getElementById("optParamsTab").className = "backgroundTab";
		document.getElementById("remindTab").className = "backgroundTab";
		document.getElementById("healthCheckTab").className = "tab";
		document.getElementById("randomLineCheckTab").className = "backgroundTab";
		
		document.getElementById("connTimes").style.display = "none";
		document.getElementById("email").style.display = "none";
		document.getElementById("optParams").style.display = "none";
		document.getElementById("remindDiv").style.display = "none";
		document.getElementById("healthCheckDiv").style.display = "";
		document.getElementById("randomLineCheckDiv").style.display = "none";
		//updateThis('healthcheck');
	}
	else if (divName == "randomLineCheck") {
	    //retrieveRandomLineCheck();
	    currentTab = "randomLineCheck";

        document.getElementById("connTab").className = "backgroundTab";
        document.getElementById("emailTab").className = "backgroundTab";
        document.getElementById("optParamsTab").className = "backgroundTab";
        document.getElementById("remindTab").className = "backgroundTab";
        document.getElementById("healthCheckTab").className = "backgroundTab";
        document.getElementById("randomLineCheckTab").className = "tab";

        document.getElementById("connTimes").style.display = "none";
        document.getElementById("email").style.display = "none";
        document.getElementById("optParams").style.display = "none";
        document.getElementById("remindDiv").style.display = "none";
        document.getElementById("healthCheckDiv").style.display = "none";
        document.getElementById("randomLineCheckDiv").style.display = "";
    }
}


function checkKey() { 
	var keypress;
	if (event.keyCode) { 
		keypress = event.keyCode; 
	} 
	else { 
		keypress = event.which; 
	}
	var key = event.keyCode; 
	if (key == 13) { 
		if (currentTab == "conn") {
			updateThis("updateConnectParms");
		}
		else if (currentTab == "email") {
			updateThis("updateEmail");
		}
		else if (currentTab == "opt") {
			updateThis("updateOptParms");
		}
		else if (currentTab == "remindTab") {
			updateThis("updateRemind");
		}
	    else {
			// do nothing
		}
	} 
} 


var wasSubmitted = false;
function updateThis(which) {
	if (!wasSubmitted) {
		document.admin.style.cursor = 'wait';
		document.getElementById("action").value = which;
		document.admin.submit();
		wasSubmitted = true;
	}
}

function retrieveRandomLineCheck(){
    document.getElementById("action").value = 'retreiveRLC';
	document.admin.submit();
}

function restoreTFPsToDefaults() {
    var defaultTFPLeg = document.getElementById("defaultTFPLeg").innerHTML;
    var defaultTFPSolution = document.getElementById("defaultTFPSolution").innerHTML;
    for(var i = 1; i < 5; i++) {
        document.getElementById("TFPLeg" + i).value = defaultTFPLeg;
        document.getElementById("TFPSolution" + i).value = defaultTFPSolution;
    }
}

function submitRandomLineCheck(which){
  if(validateRLC()){
	document.getElementById("action").value = which;
	document.admin.submit();
  }
}

function validateRLC(){
	var hasInvalidFields = false;
    if(isEmpty(document.getElementById("targetPercentage").value)){
        rlcDisplayError('error1', "Error: A value is required in 'Target Percentage of RLC per year' field before continuing");
		rlcSetFieldInRed("targetPercentage");
		hasInvalidFields = true;
	}else{
        rlcSetFieldInNormal("targetPercentage");
        rlcClearErrorMessage('error1');
    }
    if(isEmpty(document.getElementById("minMonthsBeforeNextRLC").value)){
        rlcDisplayError('error2', "Error: A value is required in 'MIN # months before next RLC' field before continuing");
        rlcSetFieldInRed("minMonthsBeforeNextRLC");
        hasInvalidFields = true;
    }else{
        rlcSetFieldInNormal("minMonthsBeforeNextRLC");
        rlcClearErrorMessage('error2');
    }

	// validation on Eligibility Window fields.
    var hasInvalidEWFields = false;
    var startMonthP1 = document.getElementById("startMonthP1").value;
    var startMonthP2 = document.getElementById("startMonthP2").value;
    var startMonthP3 = document.getElementById("startMonthP3").value;
    var startMonthP4 = document.getElementById("startMonthP4").value;
    var endMonthP1 = document.getElementById("endMonthP1").innerText;
    var endMonthP2 = document.getElementById("endMonthP2").innerText;
    var endMonthP3 = document.getElementById("endMonthP3").innerText;
    var endMonthP4 = document.getElementById("endMonthP4").innerText;
    if(isEmpty(startMonthP1) || parseInt(startMonthP1,10)>parseInt(endMonthP1,10)){
        rlcDisplayError("error3", "Error: Please enter correct values in the Eligibility Period.");
        rlcSetFieldInRed("startMonthP1");
        hasInvalidEWFields = true;
    }else{
        rlcSetFieldInNormal("startMonthP1");
    }
    if(isEmpty(startMonthP2) ||  parseInt(startMonthP2,10)>parseInt(endMonthP1,10) || parseInt(startMonthP2,10)>parseInt(endMonthP2,10)){
        rlcDisplayError("error3", "Error: Please enter correct values in the Eligibility Period.");
        rlcSetFieldInRed("startMonthP2");
        hasInvalidEWFields = true;
    }else{
        rlcSetFieldInNormal("startMonthP2");
    }
    if(isEmpty(startMonthP3) || parseInt(startMonthP3,10)>parseInt(endMonthP1,10) || parseInt(startMonthP3,10)>parseInt(endMonthP3,10)){
        rlcDisplayError("error3", "Error: Please enter correct values in the Eligibility Period.");
        rlcSetFieldInRed("startMonthP3");
        hasInvalidEWFields = true;
    }else{
        rlcSetFieldInNormal("startMonthP3");
    }
    if(isEmpty(startMonthP4) || parseInt(startMonthP4,10)>parseInt(endMonthP1,10) || parseInt(startMonthP4,10)>parseInt(endMonthP4,10)){
        rlcDisplayError("error3", "Error: Please enter correct values in the Eligibility Period.");
        rlcSetFieldInRed("startMonthP4");
        hasInvalidEWFields = true;
    }else{
        rlcSetFieldInNormal("startMonthP4");
    }
    if(!hasInvalidEWFields) rlcClearErrorMessage('error3');

	if(hasInvalidFields || hasInvalidEWFields) return false;
    return true;
}

function rlcDisplayError(errorId, errorMessage){
    if(document.getElementById(errorId) == null){
        var node1 = document.createElement('div');
        node1.id = errorId;
        node1.innerHTML = "<p><font color='red'>" + errorMessage + "</font></p>";
        node1.style.display = 'inline';

        var rlcTable = document.getElementById('randomLineCheckTable');
        var tbody1 = document.createElement("tbody");
        var tr1 = document.createElement("tr");
        var td1 = document.createElement("td");

        var table = document.createElement("table");
        table.align="center";
        table.width="96%";
        var tbody = document.createElement("tbody");
        var tr_container = document.createElement("tr");
        var td_container = document.createElement("td");
        td_container.appendChild(node1);
        tr_container.appendChild(td_container);
        tbody.appendChild(tr_container);
        table.appendChild(tbody);

        td1.appendChild(table);
        tr1.appendChild(td1);
        tbody1.appendChild(tr1);

        rlcTable.appendChild(tbody1);
    } else {
        document.getElementById(errorId).style.display = '';
    }
}

function rlcClearErrorMessage(errorId){
	if(document.getElementById(errorId) != null){
		document.getElementById(errorId).style.display = 'none';
	}
}

function rlcSetFieldInRed(objId){
    var obj = document.getElementById(objId);
    obj.className = "redInput";
}

function rlcSetFieldInNormal(objId){
    var obj = document.getElementById(objId);
    obj.className = "";
}

function isEmpty(value){
    if(value==null || Trim(value)==""){
        return true;
    }else{
        return false;
    }
}

function prioritySettingStartMonthOnBlur(obj){
    var startMonth = obj.value;
    if(startMonth!=null && Trim(startMonth)!=''){
        var index = obj.id.substring(11);
        if(index==4) return;
        var nextEndMonthNum = parseInt(index,10) + 1;
        var lowerEndMonthTd = document.getElementById("endMonthP"+nextEndMonthNum);
        lowerEndMonthTd.innerHTML = (startMonth-1)<0 ? 0 : (startMonth-1);
    }
}

function movein(which) {
	if (which.className == "backgroundTab") {
		which.className = "backgroundTabFocus";
	}
	else if (which.className == "tab") {
		which.className = "tabFocus";
	}
}

function moveout(which) {
	if (which.className == "backgroundTabFocus") {
		which.className = "backgroundTab";
	}
	else if (which.className == "tabFocus") {
		which.className = "tab";
	}
}

function buttonIn(which) {
	which.className="buttonFaceHighlight";
	which.style.cursor="pointer";
}
function buttonOut(which) {
	which.className="buttonFace"
}

var connID = -1;
function addConnTableRow() {
	TableObj = document.getElementById('connTable'); 
	TRObj = TableObj.insertRow(TableObj.rows.length); 
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML="<input type='text' name='station_" + connID + "' size=5></input> connection time"
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML = "<input type='text' name='time_" + connID + "' size=5></input>" 
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML = "<select name='connAction_" + connID + "'>" +
									"<option value='3'>Add</option>" + 
									"<option value='0'>Ignore</option></select></td>";
	connID--;
}

var emailID = -1;
function addEmailTableRow() {
	TableObj = document.getElementById('emailTable'); 
	TRObj = TableObj.insertRow(TableObj.rows.length); 
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML = "&nbsp;" 
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML = "<input type='text' name='empID_" + emailID + "' size=8></input>" 
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML = "<input type='text' name='fName_" + emailID + "' size=12></input>" 
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML = "<input type='text' name='lName_" + emailID + "' size=12></input>" 
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML = "<input type='text' name='address_" + emailID + "' size=25></input>" 
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML="<select  name='action_" + emailID + "'>" +
							"<option value='3'>Add</option>" +
							"<option value='0'>Ignore</option></select>";
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML = "&nbsp;" 
	emailID--;
}



var remindID = -1;
function addRemindTableRow() {
	TableObj = document.getElementById('remindTable'); 
	TRObj = TableObj.insertRow(TableObj.rows.length); 
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML = "&nbsp;" 
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);

	
	TopicTextObj.innerHTML = "<textarea NAME='comments_" + remindID +"' COLS=64 ROWS=2></textarea>" 
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML="<select  name='remindAction_" + remindID + "'>" +
							"<option value='3'>Add</option>" +
							"<option value='0'>Ignore</option></select>";
	TopicTextObj = TRObj.insertCell(TRObj.cells.length);
	TopicTextObj.innerHTML = "&nbsp;" 
	remindID--;
}

function setConnEdit(which) {
	target = eval("document.admin.connAction_" + which);
	target.selectedIndex = 1;
}

function setEdit(which) {
	target = eval("document.admin.action_" + which);
	target.selectedIndex = 1;
}

function setRemindEdit(which) {
	target = eval("document.admin.remindAction_" + which);
	target.selectedIndex = 1;
}

function onlyNumbers(e,id)
{
var keynum;
var keychar;
var numReg;
var valueReg;
var valueCheck = true;
var isNumber=true;
var idCategory;
if(window.event)
    {
    keynum = e.keyCode;
    }
else if(e.which)
    {
    keynum = e.which;
    }

keychar = String.fromCharCode(keynum);

idCategory = idCategoryChecking(id);

if(idCategory=="overrideMaxRlcMonthData" || idCategory=="eligibilityField")
   numReg = /[a-z|A-Z|\.:;`~!@#$%^&*\"\'?\/\(\)\[\]\<\>{}+=,\-\|\\_]/;
else
   numReg = /[a-z|A-Z|:;`~!@#$%^&*\"\'?\/\(\)\[\]\<\>{}+=,\-\|\\_]/;

var charCheck =  !numReg.test(keychar);
if(/[\b]/.test(keychar))
   isNumber=false;

if(idCategory == "targetPercentage" && charCheck && isNumber)
   valueCheck = targetPercentageValidation(id,keychar);

else if(idCategory == "minMonthsBeforeNextRLC" && charCheck && isNumber)
      valueCheck = minRLCMonthValidation(id,keychar);

else if(idCategory == "overrideMaxRlcMonthData" && charCheck && isNumber)
   valueCheck = overrideMaxRlcValidation(id,keychar);

else if(idCategory == "eligibilityField" && charCheck && isNumber)
   valueCheck = eligibilityFieldValidation(id,keychar);

else if(idCategory == "TFPLeg" && charCheck && isNumber)
   valueCheck = TFPLegValidation(id,keychar);

else if(idCategory == "TFPSolution" && charCheck && isNumber)
   valueCheck = TFPSolutionValidation(id,keychar);

return charCheck && valueCheck;
}

function targetPercentageValidation(id,keychar){
    var reg = /^([0-9]{1,2}|100|0|[0-9]{1,2}\.[0-9]?)$/;
    var value = getModifiedValue(id,keychar);
    return reg.test(value);
}

function minRLCMonthValidation(id,keychar){
    var reg = /^\d{1,2}$/;
    var value = getModifiedValue(id,keychar);
    return reg.test(value);
}

function overrideMaxRlcValidation(id,keychar){
    var reg = /^([1-9]\d{0,3}|0)$/;
    var value = getModifiedValue(id,keychar);
    return reg.test(value);
}

function eligibilityFieldValidation(id,keychar){
    var reg = /^[0-9]{1,2}$/;
    var value = getModifiedValue(id,keychar);
    return reg.test(value);
}

function TFPLegValidation(id,keychar){
    var reg = /^([0-9]{1,2}|[0-9]{1,2}\.[0-9]{0,2})$/;
    var value = getModifiedValue(id,keychar);
    return reg.test(value);
}

function TFPSolutionValidation(id,keychar){
    var reg = /^([0-9]{1,2}|[0-9]{1,2}\.[0-9]{0,2})$/;
    var value = getModifiedValue(id,keychar);
    return reg.test(value);

}

function idCategoryChecking(id){
 if(id.indexOf("overrideMaxRlcMonthData")>-1)
   return "overrideMaxRlcMonthData";
 else if(id.indexOf("startMonthP")>-1)
   return "eligibilityField";
 else if(id.indexOf("targetPercentage")>-1)
   return "targetPercentage";
 else if(id.indexOf("TFPLeg")>-1)
   return "TFPLeg";
 else if(id.indexOf("TFPSolution")>-1)
   return "TFPSolution";
 else if(id.indexOf("minMonthsBeforeNextRLC")>-1)
   return "minMonthsBeforeNextRLC";
}

function getSelected(){
if(window.getSelection){
	if(document.activeElement){
		var start = document.activeElement.selectionStart;
		var end = document.activeElement.selectionEnd;
		return new Array(start,end);
	}
}
else{
	if(document.selection.createRange){
		var range = document.selection.createRange();
		var e = arguments[0];
		var dummy_range = e.createTextRange();
		dummy_range.setEndPoint("EndToEnd",range);
		e.selectionStart = dummy_range.text.length - range.text.length;
		e.selectionEnd = e.selectionStart + range.text.length;
		return new Array(e.selectionStart,e.selectionEnd);
	}
}


}
//override String method
String.prototype.replace=function(start,end,replacement){
    var before = this.slice(0,start);
    var after = this.slice(end);
    return before+replacement+after;
}

function getModifiedValue(id,keychar){
	var value = document.getElementById(id).value;
    var selectedIndex = getSelected(document.getElementById(id));
    var startIndex = selectedIndex[0];
    var endIndex =selectedIndex[1];
    value = value.replace(startIndex,endIndex,keychar);
    return value;
}

function decimalEndCheck(obj){
    var value = obj.value;
    var reg = /^\d*\.$/
    if(value!=null && Trim(value)!="" && reg.test(value)){
        obj.value = obj.value + "0";
    }
}

//the following code is for Copy/Paste validation
function pasteHandler(id){
 setTimeout(function(){valueChecking(id);},50);
}

function valueChecking(id){
 if(!valueValidation(id))
  document.getElementById(id).value = "";
}

//this function could be used by Copy-Paste and onBlur validation
function valueValidation(id){
	var idCategory= idCategoryChecking(id);
	if(idCategory == "targetPercentage"){
	  var reg = /^([0-9]{1,2}|100|0|[0-9]{1,2}\.[0-9]?)$/;
	  var value = document.getElementById(id).value;
	  return reg.test(value);
	}
	else if(idCategory == "overrideMaxRlcMonthData"){
	   var reg = /^([1-9]\d{0,3}|0)$/;
	   var value = document.getElementById(id).value;
	   return reg.test(value);
	}
	else if(idCategory == "eligibilityField"){
	   var reg = /^[0-9]{1,2}$/;
	   var value = document.getElementById(id).value;
	   return reg.test(value);
	}
	else if(idCategory == "TFPLeg" || idCategory == "TFPSolution") {
		var reg = /^([0-9]{1,2}|[0-9]{1,2}\.[0-9]{0,2})$/;
		var value = document.getElementById(id).value;
		return reg.test(value);
	}
	else if(idCategory == "minMonthsBeforeNextRLC"){
        var reg = /^\d{1,2}$/;
        var value = document.getElementById(id).value;
        return reg.test(value) && (value >= 4);
	}
}

//-->
</script>
</head>
   <% 
   	  String whatTab = "remindDiv"; 
   	  pageContext.setAttribute("STATUS_OK",HealthCheckItem.STATUS_OK);

   	  String rlcClicked = (String) request.getAttribute("RANDOM_LINE_CHECK_CLICKED");
   %>
   
   <c:choose>
	    <c:when test="${healthCheck['mq'].status != STATUS_OK}"> <% whatTab = "healthCheck"; %> </c:when>
	    <c:when test="${healthCheck['loadedLegs'].status != STATUS_OK}"> <% whatTab = "healthCheck"; %> </c:when>
   		<c:when test="${healthCheck['primaryDb'].status != STATUS_OK}"> <% whatTab = "healthCheck"; %> </c:when>
   		<c:when test="${healthCheck['swiftDb'].status != STATUS_OK}"> <% whatTab = "healthCheck"; %> </c:when>
        <c:when test="${healthCheck['missingStations'].status != STATUS_OK}"> <% whatTab = "healthCheck"; %> </c:when>
        <c:when test="${healthCheck['missingPilots'].status != STATUS_OK}"> <% whatTab = "healthCheck"; %> </c:when>
        <c:when test='${param.tab == "remind"}'> <% whatTab = "remindDiv"; %> </c:when>
        <c:otherwise> <% whatTab = "connTimes"; %> </c:otherwise>
    </c:choose>
    
<body bgcolor="white"  onload="tabClick('<%= whatTab %>')" onKeyPress="checkKey()">
    

<form name="admin" method="post" action="ControllerServlet">
<input name="action" id="action" type="hidden" value="">

<%@ page import=" 
	com.swa.linechecksolver.domain.*,
	com.swa.linechecksolver.shared.*,
	com.swa.linechecksolver.email.*" 
%>
<%
//	Optimizer opt = (Optimizer) session.getAttribute("optimizer");
	SystemParameters sp = (SystemParameters) session.getAttribute("parameters");
//	StationList stationList = opt.getStationList();
	int parmsSize = sp.size();
%>



<div class="pageTitle">
	Administrative Functions
</div>
<p>
<div>
	Please select the appropriate tab:
</div>
<p>
<table width="716" cellpadding="0" cellspacing="0" bgcolor="white">
	<tr>
		<td>
			<table id="connTab"
				onmouseover="movein(this)" 
				onmouseout="moveout(this)"
				onClick="tabClick('connTimes')">
			<tr><td>
				Connection Times
			</td></tr></table>
		</td>
		<td>
			<table id="emailTab"
				onmouseover="movein(this)" 
				onmouseout="moveout(this)"
				onClick="tabClick('email')">
			<tr><td>
				Email Addresses
			</td></tr></table>
		</td>
		
		<%-- New tab for reminder bullet points --%>
		
		<td>
			<table id="remindTab"
				onmouseover="movein(this)" 
				onmouseout="moveout(this)"
				onClick="tabClick('remindDiv')">
			<tr><td>
				Reminders
			</td></tr></table>
		</td>
		
		<td>
			<table id="optParamsTab"
				onmouseover="movein(this)" 
				onmouseout="moveout(this)"
				onClick="tabClick('optParams')">
			<tr><td>
				Optimization Parameters
			</td></tr></table>

		</td>
		
		<td>
			<table id="healthCheckTab"
				onmouseover="movein(this)"
				onmouseout="moveout(this)"
				onClick="tabClick('healthCheck')">
			<tr><td>
				Health Check
			</td></tr></table>

		</td>
		<td>
            <table id="randomLineCheckTab"
                onmouseover="movein(this)"
                onmouseout="moveout(this)"
                onClick="tabClick('randomLineCheck')">
            <tr><td>
                Random Line Check
            </td></tr></table>

        </td>
		<%-- ***here
		<td>
			<table id="tab4" class=hiddenTab>
				<tr><td>
					&nbsp;
				</td></tr>
			</table>
		</td>
		--%>
	</tr>
</table>



<table class="mainFrame">
<!--table width="800" class="mainFrame"-->
<!-- =========================================  CONNECTION TIMES =============================================== -->
<!-- =========================================  CONNECTION TIMES =============================================== -->
<!-- =========================================  CONNECTION TIMES =============================================== -->
	<tr><td>
		<div id="connTimes" STYLE="display:none;">
			<table width="100%"	cellpadding="0" cellspacing="0" border="0">
			
			
				<tr>
					<td class="frameBodyHeader">
						&nbsp;
					</td>
				</tr>
				
				
				<tr>
				  <td align="center">
				  
					<table ID="connHeader" width="98%" cellpadding="0" cellspacing="0" >
						<tr>
							<td width="*" class="frameBodyHeader">
					    		<b>Station Name</b>
							</td>
							<td width="55" class="frameBodyHeader">
								<b>Value</b>
							</td>
							<td width="62" class="frameBodyHeader">
								<b>Action</b>
							</td>
						</tr>
					</table>
					
					
					
					
					
					
					<table ID="connTable" width="98%" cellpadding="0" cellspacing="0">						
						
						
						<!-- GET DEFAULT TIME AND DISPLAY AT TOP OF TABLE -->
						<%
						for (int i = 0; i < parmsSize; i++) {
							SystemParameter parameter = sp.get(i);
							if (parameter.getParameterName().equals("DEFAULT_CONNECT_TIME")) {
						%>
						<tr>
							<td width="*">
					    		<%= parameter.getParameterDescription() %>
							</td>
							<td width="55">
								<input type="text" 
									size="5" 
									name="<%= parameter.getParameterName() %>" 
									value="<%= parameter.getParameterValue() %>" 
									onfocus='setConnEdit(<%= parameter.getParameterID() %>)'>
							</td>
							<td width="40">
								<select name='connAction_<%= parameter.getParameterID() %>'>
								  <option value='<%= LineCheckConstants.ADMIN_ACTION_IGNORE %>'>Ignore</option>
								  <option value='<%= LineCheckConstants.ADMIN_ACTION_EDIT %>'>Edit</option>
								</select>
							</td>
						</tr>
						<%
							}
						}
						%>
						<!-- DISPLAY REST OF CONNECTION TIMES -->
						<%
						for (int i = 0; i < parmsSize; i++) {
							SystemParameter parameter = sp.get(i);
							if ((parameter.getParameterType() == LineCheckConstants.ADMIN_CONNECT_PARAM) &&
								(!parameter.getParameterName().equals("DEFAULT_CONNECT_TIME"))) {
						%>
						<tr>
							<td width="*">
					    		<%= parameter.getParameterDescription() %> connection time
							</td>
							<td width="55">
								<input type="text" 
									size="5" 
									name="<%= parameter.getParameterName() %>" 
									value="<%= parameter.getParameterValue() %>" 
									onfocus='setConnEdit(<%= parameter.getParameterID() %>)'>
							</td>
							<td width="40">
								<select name='connAction_<%= parameter.getParameterID() %>'>
								  <option value='<%= LineCheckConstants.ADMIN_ACTION_IGNORE %>'>Ignore</option>
								  <option value='<%= LineCheckConstants.ADMIN_ACTION_EDIT %>'>Edit</option>
								  <option value='<%= LineCheckConstants.ADMIN_ACTION_DELETE %>'>Delete</option>
								</select>
							</td>
						</tr>
						<%
							}
						}
						%>
				    </table>
				  </td>
				</tr>
				<tr><td class="frameBodyHeader">&nbsp;</td></tr>
				<tr>
				  <td>
					<table width='100%' cellpadding='0' cellspacing='0'>
					  <tr>
					  	<td width="350" class="frameBodyHeader">
					  		&nbsp;
					  	</td>
					    <td width="125" align="right" class="frameBodyHeader">
							<table>
								<tr>
									<td class="buttonFace"
										onclick="addConnTableRow()"
										onMouseOver="buttonIn(this)"
										onMouseOut="buttonOut(this)">
										Add New
									</td>
								</tr>
							</table>						    
						</td>
					    <td width="125" align="right" class="frameBodyHeader">
							<table>
								<tr>
									<td class="buttonFace"
										onClick="updateThis('updateConnectParms')"
										onMouseOver="buttonIn(this)"
										onMouseOut="buttonOut(this)">
										Submit
									</td>
								</tr>
							</table>					    
						</td>

					  </tr>
					</table>
				  </td>
				</tr>	
				<tr><td class="frameBodyHeader">&nbsp;</td></tr>
			</table>
		</div>
	</td></tr>






<!-- =========================================  EMAIL =============================================== -->

<!-- =========================================  EMAIL =============================================== -->

<!-- =========================================  EMAIL =============================================== -->



	<tr><td>

		<div id="email" STYLE="display:none">

			<table width="100%"	cellpadding="0" cellspacing="0" border="0">

				<tr><td class="frameBodyHeader">&nbsp;</td></tr>

				<tr><td><table ID="emailTable" 

							width="100%"

							cellpadding="0" 

							cellspacing="0" 

							border="0">

							<tr>

								<td class="frameBodyHeader" width="12">

									&nbsp;

								</td>

								<td class="frameBodyHeader">

									Emp ID

								</td>

								<td class="frameBodyHeader">

									First Name

								</td>

								<td class="frameBodyHeader">

									Last Name

								</td>

								<td class="frameBodyHeader">

									Email Address

								</td>

								<td class="frameBodyHeader">

									Action

								</td>

								<td class="frameBodyHeader"width="12">

									&nbsp;

								</td>

							</tr>



					

							<%
														  	EmailRecipients recips = (EmailRecipients) session.getAttribute("emailRecipients");

														  	if ((recips != null) || (recips.size() != 0)) {

															  	int recipSize = recips.size();

																for (int i = 0; i < recipSize; i++) {

															EmailRecipient recip = recips.get(i);
												%>

							

								<tr>

									<td width='12' class="frameBodyHeader">

										&nbsp;

									</td>

									<td class="frameBodyText">

										<input type='text' name='empID_<%= recip.getEmailID() %>' 

												size=8 value='<%= recip.getEmployeeID() %>' 

												onfocus='setEdit(<%= recip.getEmailID() %>)'>

									</td>

									<td class="frameBodyText">

										<input type='text' name='fName_<%= recip.getEmailID() %>' 

												size='12' value='<%= recip.getFirstName() %>' 

												onfocus='setEdit(<%= recip.getEmailID() %>)'>

									</td>

									<td class="frameBodyText">

										<input type='text' name='lName_<%= recip.getEmailID() %>' 

												size='12' value='<%= recip.getLastName() %>' 

												onfocus='setEdit(<%= recip.getEmailID() %>)'>

									</td>

									<td class="frameBodyText">

										<input type='text' name='address_<%= recip.getEmailID() %>' 

												size='25' value='<%= recip.getEmailAddress() %>' 

												onfocus='setEdit(<%= recip.getEmailID() %>)'>

									</td>

									<td class="frameBodyText">

										<select name='action_<%= recip.getEmailID() %>'>

										  <option value='<%= LineCheckConstants.ADMIN_ACTION_IGNORE %>'>Ignore</option>

										  <option value='<%= LineCheckConstants.ADMIN_ACTION_EDIT %>'>Edit</option>

										  <option value='<%= LineCheckConstants.ADMIN_ACTION_DELETE %>'>Delete</option>

										</select>

									</td>

									<td width="12" class="frameBodyHeader">

										&nbsp;

									</td>

								</tr>



							<%

								}

							}

							%>





						</table>						

					</td>

				</tr>

				

				<tr><td class="frameBodyHeader">&nbsp;</td></tr>

				<tr>
				  <td>
					<table width='100%' cellpadding='0' cellspacing='0'>
					  <tr>
					  	<td width="350" class="frameBodyHeader">
					  		&nbsp;
					  	</td>
					    <td width="125" align="right" class="frameBodyHeader">
							<table>
								<tr>
									<td class="buttonFace"
										onClick="addEmailTableRow()"
										onMouseOver="buttonIn(this)"
										onMouseOut="buttonOut(this)">
											Add New
									</td>
								</tr>
							</table>						    
						</td>
					    <td width="125" align="right" class="frameBodyHeader">
							<table>
								<tr>
									<td class="buttonFace"
										onClick="updateThis('updateEmail')"
										onMouseOver="buttonIn(this)"
										onMouseOut="buttonOut(this)">
											Submit
									</td>
								</tr>
							</table>					    
						</td>

					  </tr>
					</table>
				  </td>
				</tr>	
				<tr><td class="frameBodyHeader">&nbsp;</td></tr>
			</table>
		</div>
	</td></tr>


<%-- ================================== REMINDERS TAB  ================================================== --%>
<%-- ================================== REMINDERS TAB  ================================================== --%>
<%-- ================================== REMINDERS TAB  ================================================== --%>
<tr><td>

		
        <div id="remindDiv" STYLE="display:none">

            <table width="100%"	cellpadding="0" cellspacing="0" border="0">

                <tr><td class="frameBodyHeader">&nbsp;</td></tr>

                <tr>
                    <td>
                        <table ID="remindTable"  width="100%"  cellpadding="0" cellspacing="0"  border="0">

							<tr> 
								<td class="frameBodyHeader" width="12"> &nbsp; </td> <td colspan="2"><b>Reservation confirmation reminder notes.</b></td>
							</tr>
							
							<tr><td> &nbsp; </td></tr>

                            <tr>
                                <td class="frameBodyHeader" width="12"> &nbsp; </td> 

                                <td class="frameBodyHeader"> Remember Note: </td>

                                <td class="frameBodyHeader"width="12">&nbsp; </td>

                            </tr>
                            
							<%--   Loop through reminder notices   --%>
							
   							<c:forEach var="item" items="${reminders}" varStatus="row">										

	                            <tr>

	                                <td width='12' class="frameBodyHeader"> &nbsp; </td>

	                                <td class="frameBodyText">

										<textarea  NAME="comments_<c:out value='${row.index}'/>" cols="62" rows="2"
										 onfocus="setRemindEdit(<c:out value='${row.index}'/>)"><c:out value='${item.notice}'/></textarea>

	                                </td>
										<td class="frameBodyText">

										<select name='remindAction_<c:out value="${row.index}"/>'>

										  <option value='<%= LineCheckConstants.ADMIN_ACTION_IGNORE %>'>Ignore</option>

										  <option value='<%= LineCheckConstants.ADMIN_ACTION_EDIT %>'>Edit</option>

										  <option value='<%= LineCheckConstants.ADMIN_ACTION_DELETE %>'>Delete</option>

										</select>

									</td>
	                                <td width="12" class="frameBodyHeader"> &nbsp;</td>
	
	                            </tr>

							</c:forEach>

                        </table>						

                    </td>
                    
                    

                </tr>

                <tr><td class="frameBodyHeader">&nbsp;</td></tr>

                <tr>
                    <td>
                        <table width='100%' cellpadding='0' cellspacing='0'>
                            <tr>
                                <td width="350" class="frameBodyHeader">
                                    &nbsp;
                                </td>
                                <td width="125" align="right" class="frameBodyHeader">
                                    <table>
                                        <tr>
                                            <td class="buttonFace"
                                                onClick="addRemindTableRow()"
                                                onMouseOver="buttonIn(this)"
                                                onMouseOut="buttonOut(this)">
                                                Add New
                                            </td>
                                        </tr>
                                    </table>						    
                                </td>
                                <td width="125" align="right" class="frameBodyHeader">
                                    <table>
                                        <tr>
                                            <td class="buttonFace"
                                                onClick="updateThis('updateRemind')"
                                                onMouseOver="buttonIn(this)"
                                                onMouseOut="buttonOut(this)">
                                                Submit
                                            </td>
                                        </tr>
                                    </table>					    
                                </td>

                            </tr>
                        </table>
                    </td>
                </tr>	
                <tr><td class="frameBodyHeader">&nbsp;</td></tr>
            </table>
        </div>
        
	</td></tr>








<!-- =========================================  OPT PARAMS =============================================== -->

<!-- =========================================  OPT PARAMS =============================================== -->

<!-- =========================================  OPT PARAMS =============================================== -->







	<tr><td>

		<div id="optParams" STYLE="display:none">

		<table width="100%"	cellpadding="0" cellspacing="0" border="0">

				

			<tr><td colspan="5" class="frameBodyHeader">&nbsp;</td></tr>

			

			<tr>

				<td width="12" class="frameBodyHeader">&nbsp;</td>

				<td width="580" class="frameBodyHeader">

					<b>Parameter Description</b>

				</td>

				<td width="50" align="center" class="frameBodyHeader">

					<b>Value</b>

				</td>

				<td width="12" class="frameBodyHeader">&nbsp;</td>

			</tr>

			

			

			<%

			for (int i = 0; i < parmsSize; i++) {

				SystemParameter parameter = sp.get(i);

				if (parameter.getParameterType() == LineCheckConstants.ADMIN_OPT_PARAM) {

			%>

			<tr>

				<td width="12" class="frameBodyText">&nbsp;</td>

				<td class="frameBodyText">

		    		<%= parameter.getParameterDescription() %>

				</td>

				<td align="right" class="frameBodyInput">

					<input type="text" size="8" 

						name="<%= parameter.getParameterName() %>" 

						value="<%= parameter.getParameterValue() %>">

				</td>

				<td width="12" class="frameBodyText">&nbsp;</td>

			</tr>

			<%

				}

			}

			%>

			

			<tr><td colspan="4" class="frameBodyText">&nbsp;</td></tr>

			

			<tr>

				<td colspan="4" class="frameBodyText">
					<table width='100%' cellpadding='0' cellspacing='0'>
					  <tr>
					  	<td width="475" class="frameBodyText">
					  		&nbsp;
					  	</td>
					    <td width="125" align="right" class="frameBodyText">
							<table>
								<tr>
									<td class="buttonFace"
										onClick="updateThis('updateOptParms')"
										onMouseOver="buttonIn(this)"
										onMouseOut="buttonOut(this)">
											Submit
									</td>
								</tr>
							</table>						    
						</td>
					  </tr>
					</table>

				</td>

			</tr>		



			<tr><td colspan="4" class="frameBodyText">&nbsp;</td></tr>



		</table>

		</div>

	</td>

  </tr>

<!-- =========================================  HEALTH CHECK =============================================== -->

<!-- =========================================  HEALTH CHECK =============================================== -->

<!-- =========================================  HEALTH CHECK =============================================== -->







	<tr><td>

		<div id="healthCheckDiv" STYLE="display:none">

		<table width="100%"	cellpadding="0" cellspacing="0" border="0">
			<tr><td class="frameBodyHeader">&nbsp;</td></tr>
			<jsp:include page="healthcheck.jsp" />
		</table>

		</div>

	</td>

  </tr>		


<!-- =========================================  RANDOM LINE CHECK =============================================== -->

<!-- =========================================  RANDOM LINE CHECK =============================================== -->

<!-- =========================================  RANDOM LINE CHECK =============================================== -->

<tr><td>

		<div id="randomLineCheckDiv" STYLE="display:none">

		<table id="randomLineCheckTable" name="randomLineCheckTable" width="100%"	cellpadding="0" cellspacing="0" border="0">
			<tr><td class="frameBodyHeader">&nbsp;</td></tr>
			<jsp:include page="randomlinecheck.jsp" />
		</table>

		</div>

	</td>

  </tr>

</table>
<!-- /div -->
</form>



<jsp:include page="/eipSessionJsp/EipSessionInclude.jsp"/>

</body>
</html>









