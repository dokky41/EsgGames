<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<br>
<br>
<!-- Begin Page Content -->
<div class="container-fluid" style="padding-right: 10px;">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">마이페이지</h1>
	</div>

	<br>

	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">

				<div class="row">
					<div class="col-sm-12 col-md-6">
						<div class="dataTables_length" id="dataTable_length"></div>
					</div>
					<div class="col-sm-12 col-md-6"></div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<form name="deleteform" method="post">
							<input type="hidden" value="" name="id">
							<table width="100%" cellspacing="0" role="grid"
								aria-describedby="dataTable_info" style="width: 100%;"
								border="1" bordercolor="#e3e6f0">
								<thead>
									<tr role="row">
										<th tabindex="0" aria-controls="dataTable" rowspan="1"
											colspan="1" aria-sort="ascending"
											aria-label="Name: activate to sort column descending"
											style="width: 69px;">이름</th>
										<th tabindex="0" aria-controls="dataTable" rowspan="1"
											colspan="1"
											aria-label="Position: activate to sort column ascending"
											style="width: 65px;">ID</th>
										<th tabindex="0" aria-controls="dataTable" rowspan="1"
											colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="width: 45px;">이메일</th>
										<th tabindex="0" aria-controls="dataTable" rowspan="1"
											colspan="1"
											aria-label="Age: activate to sort column ascending"
											style="width: 65px;">연락처</th>
										<th tabindex="0" aria-controls="dataTable" rowspan="1"
											colspan="1"
											aria-label="Age: activate to sort column ascending"
											style="width: 65px;">마일리지</th>
										<th tabindex="0" aria-controls="dataTable" rowspan="1"
											colspan="1"
											aria-label="Start date: activate to sort column ascending"
											style="width: 70px;">회원가입일</th>
								</thead>
								<tbody>
									<tr class="even" style="text-align: center;">
										<td class="sorting_1">${membervo.username}</td>
										<td>${membervo.userid}</td>
										<td>${membervo.useremail}</td>
										<td>${membervo.phNum }</td>
										<td>${membervo.userpoint }p</td>
										<td><fmt:formatDate value="${membervo.regdate }"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
									</tr>

								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</div>
<!-- 프리미엄 회원 내역 조회, 총 액수 출력 -->

<!-- End of Main Content -->

<!-- End of Content Wrapper -->



<!-- 여기까지 -->

<br>
<br>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">마일리지 내역</h1>
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
			</tr>
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
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">거래 신청내역</h1>
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
				aria-label="Age: activate to sort column ascending"
				style="width: 55px;">상품개수</th>
			<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
				aria-label="Start date: activate to sort column ascending"
				style="width: 60px;">신청제목</th>
			<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
				aria-label="Start date: activate to sort column ascending"
				style="width: 60px;">신청날짜</th>
	</thead>
	<tbody>
		<c:forEach items="${tr}" var="tr">
			<tr class="even" style="text-align: center;">
				<td class="sorting_1">${tr.trConNum}</td>
				<td>${tr.trSender}</td>
				<td>${tr.trReceiver}</td>
				<td>${tr.trCount}</td>
				<td><a
					href="${pageContext.request.contextPath }/ydTrBoard/trLoaContent?num=${tr.trConNum}&page=1">
						${tr.trSubject }</a></td>
				<td><fmt:formatDate value="${tr.trDate }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
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