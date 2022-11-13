/**
 * 
 */

function checkId(){
		
		var userid = $('#reg_mb_id').val(); //id값이 "id"인 입력란의 값을 저장
		
		$.ajax({
			url:'idCheck', //Controller에서 요청받을주소
			type:'post', //post방식으로 전달
			data:{userid:userid},
			success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다
				if(cnt==0){ //cnt가 0이면 사용가능한 아이디
					$('.id_ok').css("display","inline-block");
					$('.id_already').css("display","none");
					$('.id_already').prepend('<input type="hidden" name="chk"  value="0">');
				}else{ //cnt가 1일 경우 -> 이미 존재하는 아이디
					$('.id_already').css("display","inline-block");
					$('.id_ok').css("display","none");
					$('.id_already').prepend('<input type="hidden" name="chk"  value="1">');
				}
				
			},
			error:function(){
				alert("에러입니다.");
			}
		});
	};
