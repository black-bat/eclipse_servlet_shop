//проверка подключения и версии
$(document).ready(function(){
    console.log(jQuery.fn.jquery);
    });
 //************
 
 function add(id){
        	let str = "id="+id;
     	    $.ajax({
             type:"POST",
             url:"Catalog24",
             data: str,
             success: function(answer){
             alert(answer);
             console.log("tuuu");
             }  
             });
             }
             
            function dellProduct(id){
        	let str = "id="+id;
     	    $.ajax({
             type:"POST",
             url:"Cart24",
             data: str,
             success: function(answer){
              console.log("tuuu");
              window.location="Cart24";
             }  
             });
             }
       
         function filter(str){
	    $.ajax({
        type:"GET",
        url:"Filter",
        data: str,
        success: function(answer){
            console.log("tuuu");
             console.log(info)
        }  
        })
        }
        
         function filter1(){
	   let act1="filter";
	   let info= "milk";
	   let str="act="+act1+  "&info="+info;
           filter(str);
        }
        
         function filter2(){
	   let act1="filter";
	   let info= "meat";
	   let str="act="+act1+  "&info="+info;
           filter(str);
        }
        
         function filter3(){
	   let act1="filter";
	   let info= "berries";
	   let str="act="+act1+  "&info="+info;
           filter(str);
        }
        
         function filter4(){
	   let act1="filter";
	   let info= "fruits";
	   let str="act="+act1+  "&info="+info;
           filter(str);
        }
        
         function filter5(){
	   let act1="filter";
	   let info= "vegetables";
	   let str="act="+act1+  "&info="+info;
           filter(str);
        }
        
           function filter6(){
	   let act1="filter";
	   let info= "nuts";
	   let str="act="+act1+  "&info="+info;
           filter(str);
        }
        
            function filter7(){
	   let act1="filter";
	   let info= "drinks";
	   let str="act="+act1+  "&info="+info;
           filter(str);
        }
        
        function filter8(){
	   let act1="filter";
	   let info= "fish";
	   let str="act="+act1+  "&info="+info;
           filter(str);
        }
        
        function filterTitle(){
	  let title=$('#search').val();
      let str = "search="+title;
     	   $.ajax({
             type:"POST",
             url:"Filter",
             data: str,
             success: function(answer){
                console.log("tuuu");
             }  
             });
             }