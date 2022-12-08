<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/admin/admin.css"/>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<!-- 여기까지 -->

<br>
<br>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">메일 전송</h1>
</div>

<form action="/member/mailSend" method="post">
<input type="hidden" name="mSender" value="${membervo.userid }">
    <div>
        <label for="name">받는사람</label>
        <input type="text" name="mReceiver" />
    </div>
    <div>
        <label for="mail">Subject</label>
        <input type="text" name="mSubject" />
    </div>
    <div>
        <label for="msg">Content</label>
        <textarea id="msg" name="mContent"></textarea>
    </div>
    
    <div class="button">
        <button type="submit">전송</button>
    </div>
</form>




<br>
<br>
