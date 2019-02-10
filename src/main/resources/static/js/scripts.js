$(document).ready(function() {

 
 $(".studentdata").hide();

    $(".anchortag").click(function() {


        

         $(this).text($(this).text()=='+' ? '-':'+');


        console.debug($(this).parent('.coursedata').nextUntil('.coursedata'));
        $(this).parent('.anchortd').parent('.coursedata').nextUntil('.coursedata').fadeToggle();
    });
});