$(document).ready(function(){
	$('.myForm').submit(function(e){
	    e.preventDefault();
	    $.ajax({
	        url:'/fizz',
	        type:'post',
	        data:{"number":$('.myForm #number').val()},
	        success:function(response){
	        	for(var i=0;i<response.length;i++){
	   				if(i==0)
	   					$("#fizz_string").append(response[i]);
	   				else
	   					$("#fizz_string").append(", "+response[i]);
	        	}
	        },
	        error: function(response){
	        	$("#fizz_string").append("Java Heap Error. Please decrease the number");
	        }
	    });
	});
});