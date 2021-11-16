<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function ajaxTest() {
		$.ajax({ //$는 무조건 제이쿼리 문법
			url : "ajax_result", //"ajax_result"(서버로 부터 받아오기) //"ajax" :컨트롤러 경로,
			type : "GET",
			success : function(data){ //data : 서버 성공시 전달받는 값 
				$("#count").text(data)
				console.log("성공")
				},
			error : function(){alert('통신 실패')}
			})
		}

</script>

</head>
<body>ajax.jsp
	<h1>일</h1> <h1>일</h1> <h1>일</h1> <h1>일</h1>
	<h1>일</h1> <h1>일</h1> <h1>일</h1> <h1>일</h1>
	<button type="button" onclick="ajaxTest()">클릭</button>
	<label id = "count">0</label>

</body>
</html>