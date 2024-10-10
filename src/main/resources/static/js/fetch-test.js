/**
 * 
 */
function fetchTest() {
	const testList = document.getElementById('testList_id');
	const loading = document.getElementById('loading_id');
	const error = document.getElementById('error_id');
	
	testList.innerHTML = '';
	loading.style.display = 'block';
	error.style.display = 'none';
	
	fetch('/main/tests/api')
	.then(response => {
		if(!response.ok) {
			throw new Error('Network response was not ok');
		}
		return response.json();
	})
	.then(test => {
		loading.style.display = 'none';
		test.forEach(tst => {
			const li = document.createElement('li');
			li.innerHTML = `<a href="/tests/${tst.id}">${tst.testname} (${tst.id})</a>`;
			testList.appendChild(li);
		})
	})
	.catch(error => {
		console.error('Fetch error : ', err);
		loading.style.display = 'none';
		error.style.display = 'block';
	})
}
document.addEventListener('DOMContentLoaded', fetchTest);