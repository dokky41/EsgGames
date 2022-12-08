<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


	<!-- 여기까지 -->

	<br>
	<br>
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">마일리지 환전소</h1>
	</div>
<br>

	<table width="100%" cellspacing="0" role="grid"
		aria-describedby="dataTable_info" style="width: 100%; padding-right: 10px; font-size: 25px;" border="1"
		bordercolor="#e3e6f0">
		<thead>
			<tr role="row">
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-sort="ascending"
					aria-label="Name: activate to sort column descending"
					style="width: 55px;">이름</th>
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-label="Position: activate to sort column ascending"
					style="width: 65px;">아이디</th>
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-label="Office: activate to sort column ascending"
					style="width: 45px;">잔액</th>
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-label="Office: activate to sort column ascending"
					style="width: 25px;">환전금액</th>
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-label="Age: activate to sort column ascending"
					style="width: 65px;">권한</th>
		</thead>
		<tbody>
				<tr class="even" style="text-align: center;">
					<td class="sorting_1">${membervo.username}</td>
					<td>${membervo.userid}</td>
					<td>${membervo.userpoint}</td>
					<td><input type="number" name="exPrice" id="exPrice"></td>
					<td><button onclick="aa()">환전</button></td>
				</tr>
		</tbody>
	</table>



	<br>
	<br>
	
	<br>
	<br>
	
	<h1 class="h3 mb-0 text-gray-800">마일리지 환전내역</h1>
	
	<table width="100%" cellspacing="0" role="grid"
		aria-describedby="dataTable_info" style="width: 100%; padding-right: 10px; font-size: 25px;" border="1"
		bordercolor="#e3e6f0">
		<thead>
			<tr role="row">
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-sort="ascending"
					aria-label="Name: activate to sort column descending"
					style="width: 55px;">이름</th>
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-label="Position: activate to sort column ascending"
					style="width: 65px;">아이디</th>
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-label="Office: activate to sort column ascending"
					style="width: 45px;">잔액</th>
				<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
					aria-label="Age: activate to sort column ascending"
					style="width: 65px;">권한</th>
		</thead>
		<tbody>
				<tr class="even" style="text-align: center;">
					<td class="sorting_1">${membervo.username}</td>
					<td>${membervo.userid}</td>
					<td>${membervo.userpoint}</td>
					<td><button>환전</button></td>
				</tr>
		</tbody>
	</table>