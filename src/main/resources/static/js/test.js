/**
 * 
 */
document.getElementById('testForm').addEventListener('submit', function(e) {
	e.preventDefault();
	
	const test = {
		testname: document.getElementById('testList_id').value
	};
	
	fetch('/main/create', {
		method : 'POST',
		headers : {
			'Content-Type' : 'application/json'
		},
		body : JSON.stringify(test)
	})
	.then(response => {
        if (response.ok) {
            alert('목록이 성공적으로 생성되었습니다.');
            document.getElementById('testForm').reset();
        } else {
            alert('목록 생성에 실패했습니다.');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('오류가 발생했습니다.');
    });
});