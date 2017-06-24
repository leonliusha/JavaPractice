<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
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

else if(idCategory == "rlcPerPilot" && charCheck && isNumber)
   valueCheck = rlcPerPilotValidation(id,keychar);

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
    var reg = /^([0-9]{1,2}|100|0|[0-9]\.[0-9]?)$/;
    var value = document.getElementById(id).value;
    value = value + keychar;
    return reg.test(value);     
}


function rlcPerPilotValidation(id,keychar){
    var reg = /^[0-9]$/;
    var value = document.getElementById(id).value;
    value = value + keychar;
    return reg.test(value);
}

function overrideMaxRlcValidation(id,keychar){
    var reg = /^([1-9]\d{0,3}|0)$/;
    var value = document.getElementById(id).value;
    value = value + keychar;
    return reg.test(value);
}

function eligibilityFieldValidation(id,keychar){
    var reg = /^[0-9]{1,2}$/;
    var value = document.getElementById(id).value;
    value = value + keychar;
    return reg.test(value); 
}

function TFPLegValidation(id,keychar){
    var reg = /^([0-9]{1,2}|[0-9]{1,2}\.[0-9]{0,2})$/;
    var value = document.getElementById(id).value;
    value = value + keychar;
    return reg.test(value);
}

function TFPSolutionValidation(id,keychar){
    var reg = /^([0-9]{1,2}|[0-9]{1,2}\.[0-9]{0,2})$/;
    var value = document.getElementById(id).value;
    value = value + keychar;
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

}

</script>

<form>
Type some text (numbers not allowed):<br/>

Target Percentage RLC per year
<input type="text" id="targetPercentage" onkeypress="return onlyNumbers(event,'targetPercentage')" /><br/>

MAX #RLC allowed per pilot
<input type="text" id="rlcPerPilot" onkeypress="return onlyNumbers(event,'rlcPerPilot')" /><br/>

Override MAX # RLC
<input type="text" id="overrideMaxRlcMonthData1" onkeypress="return onlyNumbers(event,'overrideMaxRlcMonthData1')"/><br/>
<input type="text" id="overrideMaxRlcMonthData2" onkeypress="return onlyNumbers(event,'overrideMaxRlcMonthData2')"/><br/>



Eligibility Window
<input type="text" id="startMonthP1" onkeypress="return onlyNumbers(event,'startMonthP1')"/><br/>
<input type="text" id="startMonthP2" onkeypress="return onlyNumbers(event,'startMonthP2')"/><br/>


Max Avg TFP Leg
<input type="text" id="TFPLeg1" onkeypress="return onlyNumbers(event,'TFPLeg1')"/><br/>
<input type="text" id="TFPLeg2" onkeypress="return onlyNumbers(event,'TFPLeg2')"/><br/>

Max Avg TFP Solution
<input type="text" id="TFPSolution1" onkeypress="return onlyNumbers(event,'TFPSolution1')"/>
</form>

</html>






function targetPercentageValidation(id,keychar){
    var reg = /^([0-9]{1,2}|100|0|[0-9]{1,2}\.[0-9]?)$/;
    var value = document.getElementById(id).value;
    var selectedIndex = getSelected(document.getElementById(id));
    var startIndex = selectedIndex[0];
    var endIndex =selectedIndex[1];
    alert('start is:'+startIndex+'end is:'+endIndex);
    alert(value.replace(selectedIndex[0],selectedIndex[1],keychar));
    if(startIndex != endIndex)
      value = value.replace(startIndex,endIndex,keychar);
    else
      value = value + keychar;
    return reg.test(value);     
}


function getSelected(){
if(window.document.all){
  if (window.getSelection) {                 
   return window.getSelection().toString();     
  }else if (document.getSelection) {         
   return document.getSelection();     
  }else if (document.selection) {                
   return document.selection.createRange().text;     
  }
}else{
  var e=arguments[0];
  if (e.selectionStart != undefined && e.selectionEnd != undefined) {
   var start = e.selectionStart;         
   var end = e.selectionEnd; 
if(start=="")
  alert('start is empty');  
   //return e.value.substring(start, end); 
   return new Array(start,end);    
  }else{
  return "";  // Not supported on this browser
  }
}
}

String.prototype.replace=function(start,end,replacement){
    var before = this.slice(0,start);
    var after = this.slice(end);
    return before+replacement+after;
}
</body>
</html>