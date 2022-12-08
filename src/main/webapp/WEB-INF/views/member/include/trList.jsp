<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>

	<!-- 여기까지 -->

	<br>
	<br>
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">거래 전체 내역</h1>
	</div>
<br>




<table width="100%" cellspacing="0" role="grid"
	aria-describedby="dataTable_info"
	style="width: 100%; padding-right: 10px;" border="1"
	bordercolor="#e3e6f0">
	<thead>
		<tr role="row">
			<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
				aria-sort="ascending"
				aria-label="Name: activate to sort column descending"
				style="width: 45px;">글번호</th>
			<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
				aria-label="Position: activate to sort column ascending"
				style="width: 55px;">판매자</th>
			<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
				aria-label="Position: activate to sort column ascending"
				style="width: 55px;">구매자</th>
			<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
				aria-label="Start date: activate to sort column ascending"
				style="width: 60px;">신청제목</th>
			<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
				aria-label="Start date: activate to sort column ascending"
				style="width: 60px;">신청날짜</th>
			<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
				aria-label="Age: activate to sort column ascending"
				style="width: 55px;">거래상태</th>
	</thead>
	<tbody>
	
		<c:forEach items="${tr}" var="tr">
			<tr class="even" style="text-align: center;">
				<td class="sorting_1">${tr.trConNum}</td>
				<td>${tr.trSender}</td>
				<td>${tr.trReceiver}</td>
				<td><a
					href="${pageContext.request.contextPath }/ydTrBoard/trLoaContent?num=${tr.trConNum}&page=1">
						${tr.trSubject }</a></td>
				<td><fmt:formatDate value="${tr.trDate }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>
				<c:if test="${tr.trState == 'yes' }">
				완료
				</c:if>
				
				
				<form action="${pageContext.request.contextPath }/member/trRefuse" method="get">
					<input type="hidden" name="trState" value="${tr.trState }">
					<input type="hidden" name="trBnum" value="${tr.trBnum }">
							
				<c:if test="${tr.trState == 'yet' }">
				
				<c:if test="${tr.trSender == membervo.userid }">
				<button onclick="location.href='/member/trRefuse?trState=${tr.trState}&trBnum=${trBnum}'">
				취소</button>
				</c:if>
				
				<c:if test="${tr.trReceiver == membervo.userid }">
				<button type="submit">승낙</button>
				<button onclick="location.href='/member/trRefuse?trState=${tr.trState}&trBnum=${trBnum}'">
				거부</button>
				</c:if>
				
				</c:if>
				
				<c:if test="${tr.trState == 'no' }">
				취소
				</c:if>
				
				</form>
				
				
				</td>
			</tr>
		</c:forEach>
		
		
		
		<c:if test="${ tr == '[]' }">
			<tr class="even" style="text-align: center;">
				<td>해당없음</td>
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
	