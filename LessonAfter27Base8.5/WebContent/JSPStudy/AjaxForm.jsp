<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax user</title>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('form').on('change', '#username', function(event) {
			event.preventDefault();
			/* Act on the event */
			var username = $(this).val();
			$.ajax({
				url : '/LessonAfter27Base8.5/AjaxForm',
				type : 'get',
				dataType : 'json',
				data : {
					message : 'usernametest',
					username : username,
				},
			}).done(function(json) {
				iterator(json);
				console.log("success");
			}).fail(function() {
				console.log("error");
			}).always(function() {
				console.log("complete");
			});

		});
		function iterator (argument) {
            // body... 
            if(argument != null && argument.length > 0){
                for (var i = 0; i < argument.length; i++) {
                    console.log(argument[i])    
                }
            }
        }
	})
</script>
</head>
<body>
	<form action="">
		name:<input value="" name="username" id="username" /><br /> name:<input
			value="" name="userpsd" id="userpsd" /><br />
		<button type="subbmit">subbmit</button>
		<button type="reset">reset</button>
	</form>
</body>
</html>