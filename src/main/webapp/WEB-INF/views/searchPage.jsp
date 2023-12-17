<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>    
<head>
    <link href="<c:url value="/resources/css/searchPage.css"/>" rel='stylesheet' />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div id="con">
        <div id="container">
            <div id="logo" onclick='location.href="<c:url value='/'/>"'><h1><b id="yy">tonic</b><b id="jj">bank</b></h1></div>

			<fieldset id="search">
	        	<form action="search" method="get" onsubmit="return formCheck(this);">
		            <input id="searcht" name="keyword" type="text" value="${ph.sc.keyword}" placeholder="검색어를 입력하세요" autocomplete="off">
		            <button id="searchBtn" type="submit">검색</button>
	        	</form>
	        </fieldset>

            <div id="side">
	            <p>토닉뱅크를 더 안전하게 이용하세요</p>
	            <c:set var="loginoutLink" value="${empty sessionScope.userId? '/login/login' :'/login/logout' }"/>
				<c:set var="loginout" value="${empty sessionScope.userId?'로그인':'로그아웃' }"/>
	            <input type="submit" class="side" id="my" name="tabs" value="마이페이지">
	            <c:if test="${empty sessionScope.userId }">
	            	<input type="submit" class="side" id="h" name="tabs" onclick="location.href='<c:url value="/signUp/join"/>'" value="회원가입">
            	</c:if>
	            <input type="submit" class="side" id="h" name="tabs" onclick="location.href='<c:url value="${loginoutLink }"/>'" value="${loginout }" checked>
	            <c:if test="${not empty sessionScope.userId }">
					<input type="submit" class="side" id="l" name="tabs" value="${sessionScope.nick}">
				</c:if>
	        </div>
			
        	<div id="result">
            	<h2>전체검색결과 총 ?건</h2>
            	<div class="result" style="margin-top: 0px;">
                	<h4>자유게시판 (총 <b>${ph.totalCnt }</b>건)<a>더보기</a></h4>
					<ul>
		   				<c:choose>
							<c:when test="${ empty list }">
								<div class="emptyList">
									<p>게시물이 없습니다.</p>
								</div>
							</c:when>
							<c:otherwise>
			        			<c:forEach var="board" items="${ list }" begin="0" end="5">
			        				<fmt:formatDate var="today" value="${now}" pattern="yyyy.MM.dd" />
									<fmt:formatDate var="reg_date" value="${board.createdDate}" pattern="yyyy.MM.dd" />
				                	<li onclick="location.href='<c:url value="/community/read${ph.sc.queryString}&communityId=${board.communityId}"/>'">
			                			<a class="resultList">
				                			<div>
						                		<span class="listTitle">${board.title }</span>
					                		</div>
					                		<div>
						                		<span class="listContent">${board.content }</span>
					                		</div>
					                		<div>
						                		<span class="listCategory">${board.category }</span>
						                		<c:choose>
													<c:when test="${ today <= reg_date }">
														<span>
															<fmt:formatDate value="${board.createdDate}" pattern="HH:mm" />
														</span>
													</c:when>
													<c:otherwise>
														<span>
															<fmt:formatDate value="${board.createdDate}" pattern="yyyy.MM.dd" />
														</span>
													</c:otherwise>
												</c:choose>
					                		</div>
										</a>
									</li>
		        				</c:forEach>
							</c:otherwise>
		   				</c:choose>
					</ul>
            	</div>

            <div class="result">
                <h4>카테고리>성분명 (총 <b>?</b>건)<a>더보기</a></h4>
                <div>
                <img src="/tonicbank/resources/img/slide1.jpg" alt="" class="img">
                <ul>
                    <li>브랜드명:</li>
                    <li>상품명:</li>
                    <li>가격:</li>
                    <li>성분:</li>
                    <li>효능:</li>
                    <li>후기(<a>1</a>)</li>

                </ul>
                </div>
            </div>
                
            <div class="result">
                <h4>카테고리>브랜드명 (총 <b>?</b>건)<a>더보기</a></h4>
                <div>
                <img src="/tonicbank/resources/img/slide1.jpg" alt="" class="img">
                <ul>
                    <li>브랜드명:</li>
                    <li>상품명:</li>
                    <li>가격:</li>
                    <li>성분:</li>
                    <li>효능:</li>
                    <li>후기(<a>1</a>)</li>

                </ul>
                </div>
            </div>
        </div>

        
        
        <footer>
            <div id="ft">
            <ul>
                <li class="ft">회사소개</li>
                <li class="ft">개인정보처리방침</li>
                <li class="ft">여행약관</li>
                <li class="ft">저작권정책</li>
                <li class="ft">Q&A</li>
                <li class="ft" id="fta">사이트맵</li>
                
            </ul>
            <p id="ad">(우)26464 충청북도 청주시 **동 **로 *** (TEL)043-1234-5678 사업자 등록번호: 202-81-50707</p>
                <p><a href="#" title="f"></a><a href="#" title="i"></a><a href="#" title="k"></a></p>
        </div>
        </footer>
  

    
    
    
    </div>
    </div>
    <script>
	    function formCheck(frm){
			if (frm.keyword.value.trim() === "") {
		        alert("검색어를 입력하세요");
		        return false;
		    }
			return true;
		}
    </script>
</body>
</html>