$(document).ready(function() {


    $.ajax({
            url: "http://18.130.253.44/getCourses.php?action=getUnpaid",  
            
            dataType: "jsonp",
            jsonpCallback: 'courses',
            success: function(result){
       
            console.debug("result"+result);
            }

});




 
 $(".studentdata").hide();

    $(".anchortag").click(function() {


        

         $(this).text($(this).text()=='+' ? '-':'+');


        console.debug($(this).parent('.coursedata').nextUntil('.coursedata'));
        $(this).parent('.anchortd').parent('.coursedata').nextUntil('.coursedata').fadeToggle();
    });
});