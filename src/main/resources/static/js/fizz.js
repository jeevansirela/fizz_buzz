$(document).ready(function(){
	$('.myForm').submit(function(e){
	    e.preventDefault();
	    $.ajax({
	        url:'/fizz',
	        type:'post',
	        data:{"number":$('.myForm #number').val()},
	        success:function(response){
	        	var t0 = performance.now();
	        	var s="";
	        	for(var i=0;i<response.length;i++){
	        		if(i==0){
	   					document.getElementById("fizz_string").innerHTML=response[i];
	        		}else{
	        			s=s+", "+response[i];
	        		}
	        		if(s.length==1048576){
	        			var textnode=document.createTextNode(s);
	        			document.getElementById("fizz_string").appendChild(textnode);
	        			s="";
	        		}
	        	}
	        	var textnode=document.createTextNode(s);
    			document.getElementById("fizz_string").appendChild(textnode);
	        	var t1 = performance.now();
	        	console.log(t1-t0+"ms");
	        },
	        error: function(response){
	        	var textnode=document.createTextNode("Java Heap Error. Please decrease the number");
	        	document.getElementById("fizz_string").appendChild(textnode);
	        }
	    });
	});
});