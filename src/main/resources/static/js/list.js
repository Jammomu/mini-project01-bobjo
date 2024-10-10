function fetchMessages() {
	const foodList = document.getElementById('foodList_id');
	const loading = document.getElementById('loading_id');
	const error = document.getElementById('error_id');
	
	loading.style.display = 'block';
	error.style.display = 'none';
	foodList.innerHTML = '';
	
	fetch('/food/list/api')
		.then(response => {
			// 응답 결과를 json으로 변환
			if(!response.ok) {
				throw new Error('Network response was not ok');
			}
			return response.json();
		})
		.then(foods => {
			// 변환된 결과를 li요소로 만들어 화면에 추가
			loading.style.display = 'none';
			foods.forEach(food => {
				const li = document.createElement('li');
				li.innerHTML = `<a href="/food/detail/${food.id}">
					  <img src="${food.foodimage}"/>
					  <span> ${food.foodname}</span>
				</a>`;
				foodList.appendChild(li);
			})
		})
		.catch(error => {
			console.error('Fetch error:', err);
			loading.style.display = 'none';
			error.style.display = 'block';
		})
}

// 문서가 모두 로딩되면 fetchMessage() 함수를 실행
document.addEventListener('DOMContentLoaded', fetchMessages);
