<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03 - js, for (of, in)</title>
</head>
<body>

<h1>javascript for문의 of와 in</h1>
<hr>
<form>
	<input type="text" name="n1" value="10">
	<input type="text" name="n2" value="20">
</form>
<script>
	const arr = [2, 7, 8, 4, 6]
	const ob = {
		name: '이지은',
		age: 31
	}
	
// 	for(let key of ob) {	// ob is not iterable
	for(let key in ob) {	// key - in
		console.log(key)
	}
	
	for(let num of arr) {	// of는 iterable 요소에 대하여 사용할 수 있다
		console.log(num)	// 순회 가능한 요소에 대하여 of
	}						// forEach - of
	
	arr.forEach(e => console.log(e))
	
	for(let i = 0; i < arr.length; i++) {
		const n2 = arr[i]
		console.log(n2)
	}
	const form = document.forms[0]
	const formData = new FormData(form)
	const keys = formData.keys()
	console.log({formData: formData})
	
	for(let key of formData.keys()) {	// ['n1', 'n2']
		console.log(key)
	}
	for(let value of formData.values()) {	// [10, 20]
		console.log(value)
	}
	

</script>

</body>
</html>