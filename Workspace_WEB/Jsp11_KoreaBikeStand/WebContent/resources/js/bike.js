
$(function(){ // window.onload 기능이다. 시작하자마자 켜지는 기능
	getJsonData();
});

function getJsonData(){ // 원래 $.ajax인데 json url에 요청해서 json 파일을 가져오는 것이다. 정리하면 비동기 통신으로 해당 url(bike.json)에 요청해서 데이터를 가져오는 것이 성공하면 mydata가 값이 된다.
	$.getJSON("resources/json/bike.json", function(mydata){ // 서버로부터 http get방식 데이터 요청, function(mydata)는 요청해서 받아온 값
		$.ajax({
			url: "bike.do", // 통신할 서버
			method: "post", // post방식
			data: {"command": "getdata", "mydata": JSON.stringify(mydata)}, // 요청과 함께 서버로 데이터를 *****전송할 data, string 또는 map
			dataType: "json", // ***** 받아올 값, 원래 문자열("")인데 json 객체로 바꿔준다.
			success: function(msg){ // 통신에 성공했을 때, 원래 msg는 문자열인데 위에 dataType을 json으로 사용하였기 때문에 msg는 json Object가 되었다.
				var $tbody = $("tbody");
				
				var list = msg.result;
				for (var i = 0; i < list.length; i++) {
					var $tr = $("<tr>");
					
					$tr.append($("<td>").append(list[i].name));
					$tr.append($("<td>").append(list[i].addr));
					$tr.append($("<td>").append(list[i].latitude));
					$tr.append($("<td>").append(list[i].longitude));
					$tr.append($("<td>").append(list[i].bike_count));
					
					$tbody.append($tr);
				}
			},
			error: function(){ // 통신에 실패했을 때 
				alert("통신 실패");
			}
		});
	});
}