/**
 * 
 */

if("${membervo.userid}"=='')
{
alert('로그인이 필요합니다');
location.href="login";
}
 
 
 
var IMP = window.IMP; // 생략 가능
IMP.init("imp49919207"); // 예: imp00000000

		
function requestPay() {
			
			//정보가져오기
			const number = document.getElementById('pnumber').value;
			const puserid = document.getElementById('puserid').value;
			const puseremail = document.getElementById('puseremail').value;
			const pusername = document.getElementById('pusername').value;
			const paddress = document.getElementById('paddress').value;
			const chargeNum = document.getElementById('chargeNum').value;
			//정보가져오기
			
			alert(puserid);
			alert('결제를 시작합니다.');
				   // IMP.request_pay(param, callback) 결제창 호출
			      IMP.request_pay({ // param
			    	  pg: $("#payment-select option:selected").val(),
 			          pay_method: "card",
			          merchant_uid: chargeNum,  //고유 id
			          name: 'ESG 마일리지 충전',  //상품이름
			          amount: number, //가격
			          buyer_email: puseremail,
			          buyer_name: pusername,
			          buyer_addr: paddress,
			      }, function (rsp) { // callback
			          if (rsp.success) {
			              // 결제 성공 시 로직,
			             alert('결제성공');
			             $.ajax({
			 				type:"GET",
			 				url :"myPointCharge",
			 				data : {
			 					"chargeNum" : chargeNum,
			 					"userid" : puserid,
						        "userpoint" : number,
						        "chargeSort" : $("#payment-select option:selected").val()
			 				},
			 				contentType: "application/json",
			 				success : function(data){
			 					alert('성공');
			 					
			 					
			 				}
			 			
			 			}); //ajax끝
			 			 location.href="/member/myinfo";
			 			
			          } else {
			         	
			              // 결제 실패 시 로직, 뒤로가기
			              alert('결제실패');
			              //결제 실패시 뒤로가기
			              location.href="/member/myinfo";
			          }
			      });
			}
			
			
		
	    function cancelPay() {
	    	
	    	alert('예약목록창으로 이동');
	    	location.href="/member/myinfo";
	    	
	    }