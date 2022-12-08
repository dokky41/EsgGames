<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>

	<!-- 여기까지 -->

	<br>
	<br>
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">내 정보 삭제</h1>
	</div>
<br>

<form action="${pageContext.request.contextPath }/member/deleteMeInfo" method="post">
<input type="hidden" name="userid" value="${membervo.userid }">


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
												aria-label="Start date: activate to sort column ascending"
												style="width: 70px;">회원가입일</th>
											<th tabindex="0" aria-controls="dataTable" rowspan="1"
												colspan="1"
												aria-label="Start date: activate to sort column ascending"
												style="width: 70px;">권한</th>
									</thead>
									<tbody>
										<tr class="even" style="text-align: center;">
											<td class="sorting_1">${membervo.username}</td>
											<td>${membervo.userid}</td>
											<td>${membervo.useremail}</td>
											<td>${membervo.phNum }</td>
											<td><fmt:formatDate value="${membervo.regdate }"
													pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<td><input type="submit" value="탈퇴"></td>
										</tr>
									</tbody>
								</table>
</form>
	<br>
	<br>
	