//проверка подключения и версии
$(document).ready(function(){
    console.log(jQuery.fn.jquery);
    });
 //************
 function order(){
	 let click = "click";
     let str = "click="+click;
     	   $.ajax({
             type:"POST",
             url:"Info24",
             data: str,
             success: function(answer){
              console.log("tuuu");
              alert(answer);
             }  
             });
             }
           
     function orderUser(user){
	 let click = "orderUser";
     let str = "click="+click+"&user="+user;
     	   $.ajax({
             type:"POST",
             url:"Order24",
             data: str,
             success: function(answer){
              console.log("tuuu");
              window.location="Order24";
             }  
             });
             }
             
     function show(info){
	 let click = "show";
     let str = "click=" + click+ "&infoOr=" + info;
     	   $.ajax({
             type:"GET",
             url:"Info24",
             data: str,
             success: function(answer){
              console.log("tuuu");
              window.location="Info24";
             }  
             });
             }
                   
     function change(orId){
	 let click = "change";
	 let id=orId;
     let str = "click=" + click + "&id="+ id;
     	   $.ajax({
             type:"POST",
             url:"Order24",
             data: str,
             success: function(answer){
             console.log("tuuu");
             window.location="Order24";
             }  
             });
             }
  