<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> <!-- 제이쿼리 쓰기 위해서 -->
<script type="text/javascript"> <!--함수 작성-->
 function ajaxGet(){
	 $.ajax({
		 url : "rest", type : "get", dataType:"json",   //url:경로, type:방식(get,put...)
		 success : function(data) { $("#label").text(data.execute)} <!--.은 클래스, 아이디(#)가 label인 곳에 text를 넣어라-->
	 })
 }	 
function ajaxPost() {
	  $.ajax({
		 url : "rest", type : "post", dataType:"json",
		 success : function(data) { $("#label").text(data.execute)}
	 })
}	
function ajaxPut() {
	  $.ajax({
		 url : "rest", type : "put", dataType:"json",
		 success : function(data) { $("#label").text(data.execute)}
	 })
}	
function ajaxDelete() {
	  $.ajax({
		 url : "rest", type : "delete", dataType:"json",
		 success : function(data) { $("#label").text(data.execute)}
	 })
}

</script>
</head>
<body>rest01.jsp<br>
<label id = "label"></label><br>
<button type="button" onclick="ajaxGet()">get호출</button>
<button type="button" onclick="ajaxPost()">post호출</button>
<button type="button" onclick="ajaxPut()">put호출</button>
<button type="button" onclick="ajaxDelete()">del호출</button>
</body>
</html>