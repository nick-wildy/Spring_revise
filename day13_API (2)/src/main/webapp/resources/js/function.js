function getHTMLfromDTO(dto) {
	let tag = ``
	tag += `<details class="item">`
	tag += `<img class="MAIN_IMG" src="${dto.MAIN_IMG_NORMAL}" height="250">`
	
	for(let key in dto) {
		if(key == 'TITLE') {
			tag += `<summary class="${key}">${dto[key]}</summary>`
		}
		else if(key == 'HOMEPAGE_URL') {
			tag += `<div><a href="${dto[key]}" target="_blank">홈페이지</a></div>`
		}
		else if(key == 'ITEMCNTNTS') {
			tag += `<details>`
			tag += `	<summary>상세내용</summary>`
			tag += `	${dto[key]}`
			tag += `</details>`
		}
		else {
			tag += `<div class="${key}">${dto[key]}</div>`
		}
	}
	tag += `</details>`
	return tag
}

async function getDataList() {
	const url = 'https://apis.data.go.kr/6260000/FestivalService/getFestivalKr?serviceKey=K7G5hCA%2FRqnmALDK%2F7POZXDGSgTgQFRIcOqpF8HUf9rqLn17QSaJ4Q0Ox732h%2BF%2FgxuyB3bXrdEWApNVwrOtWA%3D%3D&pageNo=1&numOfRows=20&resultType=json'
	return await fetch(url)
	.then(resp => resp.json())
	.then(json => {
		const arr = json.getFestivalKr.item
//		console.log(arr)
//		arr.forEach(dto => root.innerHTML += getHTMLfromDTO(dto))
		return arr
	})
}


function getYYYYMMDD(date) {
	const yyyy = date.getFullYear()
	let mm = date.getMonth() + 1
	let dd = date.getDate()
	
	mm = mm < 10 ? '0' + mm : mm
	dd = dd < 10 ? '0' + dd : dd
	
	const ret = `${yyyy}-${mm}-${dd}`
	return ret
}
















