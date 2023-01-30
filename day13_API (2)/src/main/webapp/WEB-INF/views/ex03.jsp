<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="${cpath }/resources/js/function.js"></script>
<style>
	#root {
		width: 80%;
		margin: auto;
	}
</style>
<body>

<h1>ex03 - CORS 정책에 의해 자바스크립트에서 호출할 수 없을 경우</h1>
<hr>

<div id="root">
	<canvas id="myChart"></canvas>
</div>

<script>
	// 실제로는 fetch 호출이 가능하지만, 연습을 위해 CORS로 막혔다고 가정하고 진행
// 	const url = 'https://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa?serviceKey=K7G5hCA%2FRqnmALDK%2F7POZXDGSgTgQFRIcOqpF8HUf9rqLn17QSaJ4Q0Ox732h%2BF%2FgxuyB3bXrdEWApNVwrOtWA%3D%3D&pageNo=1&numOfRows=10&dataType=JSON&regId=11H20201&tmFc=202301270600'
		
	const root = document.getElementById('root')
	const url = '${cpath}/getMidFcst'		
	fetch(url)
	.then(resp => resp.json())
	.then(json => {
		const item = json.response.body.items.item[0]
		console.log(item)
		for(let key in item) {
			if(key.includes('High') || key.includes('Low')) {
				delete item[key]
			}
		}
		
		
		const arr = []
		const date = new Date()
		
		for(let i = 3; i < 11; i++) {
			const d = new Date(date.getFullYear(), date.getMonth(), date.getDate() + i)
			arr.push({
				index: i,
				label: getYYYYMMDD(d),
				taMin: item['taMin' + i],
				taMax: item['taMax' + i],
			})
		}
		console.log(arr)
		
		
		
		
		
		
		
		const context = document.getElementById('myChart')
		const labels = arr.map(e => e.label)
		const data = {
			labels: labels,
			datasets: [
				{
					label: '최저기온',
					data: arr.map(e => e.taMin),
					backgroundColor: 'lightskyblue',
					pointRadius: 5,
					borderWidth: 3,
				},
				{
					label: '최고기온',
					data: arr.map(e => e.taMax),
					backgroundColor: 'lightpink',
					pointRadius: 5,
					borderWidth: 3,
				},
			]
		}
		const config = {
            type: 'bar',
            data: data,
            options: {}
        }
        const myChart = new Chart(context, config)
		
	})
</script>

</body>
</html>



