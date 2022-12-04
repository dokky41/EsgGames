/**
 * 
 */
//Daum postcode API
function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
<!-- Daum postcode API -->

function checkId(){
		
		var userid = $('#id').val(); //id값이 "id"인 입력란의 값을 저장
		var checkUserId = $("#checkId1");
  		var reId = /^[a-z0-9]{4,12}$/;
		
		if(!reId.test(userid)){
			checkUserId.css("display","inline-block");
     		checkUserId.html("<font color='red'><b>아이디는 영문, 숫자로 4-12 글자 입니다.</b></font>");
     	}else{
     	
		$.ajax({
			url:'idCheck', //Controller에서 요청받을주소
			type:'post', //post방식으로 전달
			data:{userid:userid},
			success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다
				if(cnt==0){ //cnt가 0이면 사용가능한 아이디
					checkUserId.html("<font color='green'><b>사용 가능한 아이디 입니다.</b></font>");
					checkUserId.prepend('<input type="hidden" name="chk" id="chk" value="0">');
				}else{ //cnt가 1일 경우 -> 이미 존재하는 아이디
					checkUserId.html("<font color='red'><b>이미 사용중인 아이디 입니다.</b></font>");
					checkUserId.prepend('<input type="hidden" name="chk" id="chk" value="1">');
				}
				
			},
			error:function(){
				alert("에러입니다.");
			}
		});
		
		};
	};
	
	

var result = '${param.cc}';
if(result == "error"){
	alert('아이디 중복입니다.');
	location.href='/member/Register';
}



function checkPwd(){
	var pwd1 = $("#pw").val();
	var checkSpan = $("#checkPwd1");
	var reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,12}$/;
	
 	if(!reg.test(pwd1)){
 		$('.pw_ok1').css("display","inline-block");
 		checkSpan.html("<font color='red'><b>8~12자의 영문 대소문자와 숫자</b></font>");
 	}else{
 		$('.pw_ok1').css("display","inline-block");
 		checkSpan.html("<font color='green'><b>사용가능한 비밀번호</b></font>");
 		result_pwd = true;
 	}
};

/* 비밀번호 재입력 일치 검사 메서드 */
function checkPwd2(){
  var pwd1 = document.getElementById("pw").value;
  var pwd2 = document.getElementById("pw2").value;
  var checkSpan = document.getElementById("checkPwd2");
  if(pwd2 != ""){
	   	if(pwd2 == pwd1){
	   		$('.pw_ok2').css("display","inline-block");
	    	checkSpan.innerHTML = "<font color='green'><b>비밀번호가 일치합니다.</b></font>";
	    	result_pwd = true;
	    }else{
	   		$('.pw_ok2').css("display","inline-block");
	   		checkSpan.innerHTML = "<font color='red'><b>비밀번호가 일치하지 않습니다.</b></font>";
	   		
	   	}
  }
}

function checkName(){
	var name = $("#name").val();
	var checkSpan3 = $("#checkName");
	var regName = /^[가-힣]{2,4}$/;
	
 	if(!regName.test(name)){
 		$('.name_ok').css("display","inline-block");
 		checkSpan3.html("<font color='red'><b>형식이 맞지 않습니다.</b></font>");
 	}else{
 		$('.name_ok').css("display","inline-block");
 		checkSpan3.html("<font color='green'><b>사용가능한 성명</b></font>");
 	}
}	
	
	
	
	
function checkForm(){
	
	var regId = /^[a-z0-9]{4,12}$/; // id 유효성검사
	var regPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,12}$/; // 비번 유효성검사
	var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; // 메일 유효성검사
	var regName = /^[가-힣]{2,4}$/; // 이름 유효성검사
    var regTel = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/; // 전화번호 유호성검사
	
    var id = document.getElementById("id");
    var pw = document.getElementById("pw");
    var name = document.getElementById("name");
    var email = document.getElementById("email");
    var tel = document.getElementById("phNum");
    var pwd1 = document.getElementById("pw").value;
    var pwd2 = document.getElementById("pw2").value;

	if($("#id").val()=="") { // 아이디 공백 검사
	    alert("아이디를 입력하지 않으셨습니다.");
		$("#id").focus();
		return false;
	} else if(!regId.test(id.value)){ // 아이디 유효성검사
		alert("아이디는 4~12자의 영문 소문자와 숫자로만 입력하여 주세요.");
		$("#id").focus();
		return false;
	} else if(document.getElementById("chk").value == "1"){ // 아이디 중복 검사
		alert("이미 가입된 아이디 입니다.");
		$("#id").focus();
		return false;
	} else if($("#pw").val()==""){ // 비밀번호 공백 검사
    	alert("비밀번호를 입력하지 않으셨습니다.");
    	$("#pw").focus();
    	return false;
    } else if(!regPw.test(pw.value)){ // 비밀번호 유효성검사 
		alert("비밀번호는 8~12자의 영문 대소문자와 숫자, 특수문자를 사용해주세요.");
		$("#pw").focus();
		return false;
	} else if($("#pw").val()!=$("#pw2").val()) { // 비밀번호 확인 검사
        alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
        $("#pw").focus();
        return false;
	} else if($("#name").val()==""){ // 이름 공백 검사
	    alert("이름을 입력하지 않으셨습니다.");
		$("#name").focus();
		return false;
    } else if(!regName.test(name.value)){ // 이름 유효성검사
		alert("한글만 입력해주세요.");
    	$("#name").focus();
		return false;
	} else if($("#email").val()==""){ // 이메일 공백 검사
		alert("메일주소를 입력하지 않으셨습니다.");
		$("#email").focus();
		return false;
	} else if(!regEmail.test(email.value)){ // 이메일 유효성 검사
		alert("올바른 이메일 형식이 아닙니다.");
		return false;
	} else if($("#phNum").val()==""){ // 전화번호 공백 검사
		alert("전화번호를 입력하지 않으셨습니다.");
		$("#phNum").focus();
		return false;
	} else if(!regTel.test(tel.value)){ // 전화번호 유효성 검사
		alert("숫자로만 입력하세요.");
		$("#phNum").focus();
		return false;
	} else if($("#ppnum").val()==""){
       alert('인증번호를 입력하세요');
       return false;
    } else if($("#ppnum").val()!=$("#injungN").val()){
       alert('인증번호가 틀립니다');
       return false;
    }
    else {
    	alert("회원가입이 완료되었습니다.")
    } 
}	
	
	


function aatest() {

var phNum = document.getElementById('phNum').value;
	
	alert('인증번호를 아래에 입력해주세요');
			
	var time = 180; //기준시간 작성
var min = ""; //분
var sec = ""; //초

//setInterval(함수, 시간) : 주기적인 실행
var x = setInterval(function() {
	//parseInt() : 정수를 반환
	min = parseInt(time/60); //몫을 계산
	sec = time%60; //나머지를 계산

	document.getElementById("demo").innerHTML = min + "분" + sec + "초";
	time--;

	//타임아웃 시
	if (time < 0) {
		clearInterval(x); //setInterval() 실행을 끝냄
		document.getElementById("demo").innerHTML = "인증만료";
	}
}, 1000);		
			
			
			
	$.ajax({
		url:'inju', //Controller에서 요청받을주소
		type:'post', //get방식으로 전달
		data:{phNum:phNum},
		success:function(inNum){ //컨트롤러에서 넘어온 cnt값을 받는다
			
			document.getElementById('ppnum').value=inNum;
			
			setTimeout(function() {
			  alert('인증만료');
			  document.getElementById('ppnum').value='#dd312!@#!@#!@SDSACZC';
			}, 180000);
		},
		error:function(){
			alert("에러입니다.");
		}
	});
	
	
};
	




	