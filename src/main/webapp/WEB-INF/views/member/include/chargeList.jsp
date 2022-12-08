<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>

	<!-- 여기까지 -->

	<br>
	<br>
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">마일리지 내역</h1>
	</div>
<br>




	<table width="100%" cellspacing="0" role="grid"
		aria-describedby="dataTable_info" style="width: 100%; padding-right: 10px;" border="1"
		bordercolor="#e3e6f0">
		<thead>
			<tr role="row">
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-sort="ascending"
					aria-label="Name: activate to sort column descending"
					style="width: 55px;">충전번호</th>
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-label="Position: activate to sort column ascending"
					style="width: 65px;">아이디</th>
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-label="Office: activate to sort column ascending"
					style="width: 45px;">충전방법</th>
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-label="Age: activate to sort column ascending"
					style="width: 65px;">충전금액</th>
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-label="Start date: activate to sort column ascending"
					style="width: 70px;">날짜</th>
<!-- 				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" -->
<!-- 					aria-label="Start date: activate to sort column ascending" -->
<!-- 					style="width: 70px;">권한</th> -->
		</thead>
		<tbody>
		
			<c:forEach items="${mile }" var="mile">
							
				<tr class="even" style="text-align: center;">
					<td class="sorting_1">${mile.chargeNum}</td>
					<td>${mile.userid}</td>
					<td>${mile.chargeSort}</td>
					<td>${mile.userpoint }</td>
					<td><fmt:formatDate value="${mile.date }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
<!-- 					<td class="sorting_1"> -->
					
<%-- 					<c:if test="${today - rgsde > 2}"> --%>
<!-- 					<button onclick="aa()">환불</button> -->
<%-- 					</c:if> --%>
					
<!-- 					</td> -->
				</tr>
				
				
				
	<script>
	var exPrice =  $("#exPrice input[type=number]").value;

	function aa(){
		var result = confirm("정말로 환전 하시겠습니까?");
		
		if(result){ //result == true 
				 
			$.ajax({
			   	url : "${pageContext.request.contextPath}/member/exChangeDB", // 예: http://www.myservice.com/payments/cancel
			      type : "POST",
			      contentType : "application/json",
			      data : {
			    	  userid : "${mile.userid}",
			    	  exPrice : '11',
			    	  username : "${membervo.username}",
			    	  chargeNum : "${mile.chargeNum}"
			      },
			      "dataType": "json"
			      
			    });
				  
				  alert('환불성공')
				  location.href="${pageContext.request.contextPath}/member/myinfo?sort=chargeList&userid=${membervo.userid}";
			  }else{
				  return;		  
			  }
		
		
	}

</script>
				
			</c:forEach>
			
			
			<c:if test="${ mile == '[]' }">
			<tr class="even" style="text-align: center;">
				<td>해당없음</td>
				<td>해당없음</td>
				<td>해당없음</td>
				<td>해당없음</td>
				<td>해당없음</td>
			</tr>
		</c:if>
			
			
		</tbody>
	</table>

	<br>
	<br>
	