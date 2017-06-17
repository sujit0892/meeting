$(document).ready(function(){
  
    $("form").submit(function(e){
        var values = {};
		$.each($("form").serializeArray(), function(i, field) {
		    values[field.name] = field.value;
		});
		 
		writeXML(values);
         
       
    });
});

function writeXML(values) {
	var XML = new XMLWriter();
	
    XML.BeginNode("meeting");
    XML.Node("name", values["conference-name"]);
    XML.Node("venue", values["venue"]);

    XML.BeginNode("time");
XML.Node("start-date", values["start-date"]); 
XML.Node("end-date", values["end-date"]);  
	XML.EndNode();

    XML.Node("description", values["description"]);


	XML.EndNode();
    
	var blob = new Blob([XML.ToString()], {type: "application/xml;charset=utf-8"});
  	saveAs(blob, values["conference-name"]+".xml");
      
     
}
