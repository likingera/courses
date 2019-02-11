$(document).ready(function() {


    $.ajax({
            url: "http://18.130.253.44/getCourses.php?action=getUnpaid",  
            
            dataType: "jsonp",
            jsonpCallback: 'courses',
            success: function(result){
       
                

                $.each(result.courses, function(i, course) {
                     
                    $("tbody").append("<tr class='coursedata bgclass'><td class='anchortd'><a class='anchortag' href='#'>+</a></td><td>"+ course.id +"</td><td>"+ course.start+"</td><td>"+ course.end+"</td><td>"+ course.qualification+"</td></tr>");

                    $("tbody").append("<tr class='studentdata'><td/><td>Student ID</td><td>Name</td></tr>");
                    $.each(course.students, function(j, student) {
                        
                        $("tbody").append("<tr class='studentdata stubgclass'><td></td><td>"+ student.id +"</td><td>"+ student.name+"</td></tr>");

                    
                    });

                     $(".studentdata").hide();
                });

            }

});

 


 $(document).on( 'click' ,'.anchortag', function(){
            $(this).text($(this).text()=='+' ? '-':'+');
        $(this).parent('.anchortd').parent('.coursedata').nextUntil('.coursedata').fadeToggle();

 });

    $(".anchortag").click(function() {
         
    });
});