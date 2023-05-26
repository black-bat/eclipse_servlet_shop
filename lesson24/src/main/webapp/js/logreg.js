//проверка подключения и версии
$(document).ready(function(){
    console.log(jQuery.fn.jquery);
    });
 //************
 function regTo(){
	  let login=$('#lgn').val();
	   let password=$('#pass').val();
	   let email=$('#eml').val();
        	let str = "lgn="+login+"&pass="+password+"&eml="+email;
     	   $.ajax({
             type:"POST",
             url:"Reg",
             data: str,
             success: function(answer){
                alert(answer);
                 console.log("tuuu");
             }  
             });
             }
             
function logTo(){
	  let login=$('#lgn').val();
	  let password=$('#pass').val();
      let str = "lgn="+login+"&pass="+password;
     	   $.ajax({
             type:"POST",
             url:"Log",
             data: str,
             success: function(answer){
                alert(answer);
              if(answer!="ENTER"){
				  window.location="Reg";
			  }else{
				   window.location="Catalog24";
			  }
                 console.log("tuuu");
             }  
             });
             }