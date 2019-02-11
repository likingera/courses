$(document).ready(function() {


 $(".studentdata").hide();

    $(".anchortag").click(function() {

        $(this).text($(this).text()=='+' ? '-':'+');
        $(this).parent('.anchortd').parent('.coursedata').nextUntil('.coursedata').fadeToggle();
    });
});