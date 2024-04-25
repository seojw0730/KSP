 	<link href="${pageContext.request.contextPath}/resource/css/reset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resource/css/core.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resource/css/home/memberlist.css" rel="stylesheet">  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/common/common_star.jsp"/>
<script>
$(loadedHandler)
	function loadedHandler() {
		$(".sort").on("click", sortHandler);
		$(".sortname").on("click", sortNameHandler);
	}
	
	function sortHandler(event){
		var sortstate = event.target.value;
		var sortname = event.target.name;
		$.ajax({
			url : "${pageContext.request.contextPath}/member/list3"
			, method : "get"
			, data : { "sortby" : sortname,
						"value" : sortstate}
			, datatype : "json"
			, error : ajaxErrorHandler
			, success : function(result){
				}
		});
	}
		
	function sortNameHandler() {
		$(".sort-name0").toggle();
		$(".sort-name1").toggle();
	}
</script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>

 		    	<c:choose>
	<c:when test="${ssslogin.mem_admin < 2 }">
		<div class="alert">열람 권한이 없습니다.</div>
	</c:when>
	<c:when test="${empty ssslogin}">
		<div class="alert">열람 권한이 없습니다.</div>
	</c:when>
		<c:otherwise>
		    <section class="search-member">
		        <div class="check-title">
		            회원 관리
		        </div>
		        <div class="wrap-checkmember">
		            <div class="check-head">
		            	<form id="sort">
			                <button type="button" class="sort sortname sort-name0" name="MEMBER_NAME" value="0">이름 ↑</button>
			                <button type="button" class="sort sortname sort-name1" name="MEMBER_NAME" value="1" style="display: none;">이름 ↓</button>
			                <button type="button" class="sort sortid sort-id0" name="MEMBER_ID" value="0">아이디 ↑</button>
			                <button type="button" class="sort sortid sort-id1" name="MEMBER_ID" value="1" style="display: none;">아이디 ↓</button>
			                <button type="button" class="sort sortpwd sort-pwd0" name="MEMBER_PWD" value="0">비밀번호 ↑</button>
			                <button type="button" class="sort sortpwd sort-pwd1" name="MEMBER_PWD" value="1" style="display: none;">비밀번호 ↓</button>
			                <button type="button" class="sort sortemail sort-email0" name="MEMBER_EMAIL" value="0">이메일 주소 ↑</button>
			                <button type="button" class="sort sortemail sort-email1" name="MEMBER_EMAIL" value="1" style="display: none;">이메일 주소 ↓</button>
			                <button type="button" class="sort sortaddress sort-address0" name="MEMBER_ADDRESS" value="0">주소 ↑</button>
			                <button type="button" class="sort sortaddress sort-address1" name="MEMBER_ADDRESS" value="1" style="display: none;">주소 ↓</button>
			                <button type="button" class="sort sortgrade sort-grade0" name="MEMBER_ADMIN" value="0">등급 ↑</button>
			                <button type="button" class="sort sortgrade sort-grade1" name="MEMBER_ADMIN" value="1" style="display: none;">등급 ↓</button>
		                	<div style="padding-top:3px;">비고</div>
		                </form>
		            </div>
		        <c:choose>
		        	<c:when test="${empty map.dtoList}">
		        			<p style="padding: 10px; border-bottom: 2px solid white;">일치하는 회원이 없습니다.</p>
		        	</c:when>
		        	<c:otherwise>
			        	<c:forEach items="${map.dtoList }" var="member">
			   				<div class="check-main">
			   				<form class="memberlist" method="post" action="${pageContext.request.contextPath}/member/info" target="_blank">
				                <div>${member.mem_name}</div>
				                <div><input type="text" name="memberid" value="${member.mem_id}" readonly></div>
				                <div>${member.mem_pwd}</div>
				                <div>${member.mem_email}</div>
				                <div>${member.mem_address}</div>
				                <div><input type="text" name="memberadmin" value="${member.mem_admin}" readonly></div>
				                <div><button type="submit" name="goinfo" class="goinfo">상세 조회</button></div>
				            </form>
		            		</div>
			        	</c:forEach>
		        	</c:otherwise>
		        </c:choose>
		        </div>
		        <c:choose>
		        	<c:when test="${searchStatus == 0}">
		        		<div class="pagenum">
				        	<c:if test="${map.startPageNum > 1}">
					            <div><a href="${pageContext.request.contextPath}/member/list?page=${map.startPageNum-1}"> &lt; &lt; </a></div>
				        	</c:if>
				        	<c:forEach begin="${map.startPageNum }" end="${map.endPageNum}" var="page">
				        		<c:if test="${map.currentPageNum == page}">
					            	<div style="color: red; font-weight: bold;">${page}</div>
				        		</c:if>
				        		<c:if test="${map.currentPageNum != page}">
					            	<div><a href="${pageContext.request.contextPath}/member/list?page=${page}">${page}</a></div>
				        		</c:if>
				        	</c:forEach>
				        	<c:if test="${map.startPageNum < map.totalPageCount}">
					            <div><a href="${pageContext.request.contextPath}/member/list?page=${map.endPageNum+1}"> &gt; &gt; </a></div>
				        	</c:if>
		        		</div>
		        	</c:when>
		        <c:otherwise>
		        <div class="pagenum">
		        	<c:if test="${map.startPageNum > 1}">
			            <div><a href="${pageContext.request.contextPath}/member/list?${searchword}&page=${map.startPageNum-1}"> &lt; &lt; </a></div>
		        	</c:if>
		        	<c:forEach begin="${map.startPageNum }" end="${map.endPageNum}" var="page">
		        		<c:if test="${map.currentPageNum == page}">
			            	<div style="color: red; font-weight: bold;">${page}</div>
		        		</c:if>
		        		<c:if test="${map.currentPageNum != page}">
			            	<div><a href="${pageContext.request.contextPath}/member/list?${searchword}&page=${page}">${page}</a></div>
		        		</c:if>
		        	</c:forEach>
		        	<c:if test="${map.startPageNum < map.totalPageCount}">
			            <div><a href="${pageContext.request.contextPath}/member/list?${searchword}&page=${map.endPageNum+1}"> &gt; &gt; </a></div>
		        	</c:if>
		        </div>
		        </c:otherwise>
		        </c:choose>
		        <div class="searchbar">
		            <form id="searchmem-keyword" method="get" action="${pageContext.request.contextPath}/member/list3">
		                <select class="category" name="category">
		                    <option value="MEMBER_NAME" selected>이름</option>
		                    <option value="MEMBER_ID">아이디</option>
		                    <option value="MEMBER_PWD">비밀번호</option>
		                    <option value="MEMBER_EMAIL">이메일 주소</option>
		                    <option value="MEMBER_ADDRESS">주소</option>
		                    <option value="MEMBER_GRADE">등급</option>
		                </select>
		                <input type="text" name="search" class="search">
		                <button type="submit" name="btn-search" class="btn-search">검색</button>
		            </form>
		        </div>
		    </section>
	    </c:otherwise>
    </c:choose>
</body>
</html>