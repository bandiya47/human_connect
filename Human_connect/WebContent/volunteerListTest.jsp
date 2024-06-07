<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="jakarta.servlet.http.HttpServletRequest"%>
<%@ page import="dc.human.gbnb.humanConnect.dto.UserDTO"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Volunteer List</title>
	<style>
		
	</style>
	</head>
<body>
	<!--전체 div-->
	<div class="volunteerListWholeContainer">
		<div>
			<div class="volunteerListCategoryContainer">
				<button onclick="addFilter('청소/배식')">청소/배식</button>
				<button onclick="addFilter('산책')">산책</button>
				<button onclick="addFilter('목욕')">목욕</button>
				<button onclick="addFilter('사진')">사진</button>
				<button onclick="addFilter('미용')">미용</button>
				<button onclick="addFilter('이동')">이동</button>
				<button onclick="addFilter('의료')">의료</button>
			</div>
			<div id="volunteerListFilterContainer"></div>

			<table class="voluntteerListFilterInput">
				<tr>
					<td>봉사기간 <input name="wantDay" type="date"></td>
					<td>봉사명 <input name="volSearchInput" type="search"></td>
					<td>센터명 <input name="ctrSearchInput" type="search"></td>
					<td>지역 <select onchange="selectRegion(this)">
							<option>행정구역 선택</option>
							<option value="a">전체</option>
							<option value="b">서울특별시</option>
							<option value="c">경기도</option>
							<option value="d">충청남도</option>
							<option value="e">충청북도</option>
							<option value="f">강원도</option>
							<option value="g">전라남도</option>
							<option value="h">전라북도</option>
							<option value="i">경상남도</option>
							<option value="j">경상북도</option>
							<option value="k">제주시</option>
					</select> <select id="volunteerListSelectCity">
							<option>도시 선택</option>
					</select>
					</td>
				</tr>
			</table>

			<div id="volunteerListFilterContainer" class="volunteerListVolRecruitList">
				<p>구인 리스트</p>

				<c:forEach items="${regList}" var="vol">
					<c:choose>
						<c:when test='${empty regList }'>
							<tr align='center'>
								<td colspan=6>조회된 데이터가 없습니다</td>
							</tr>
						</c:when>
						<c:otherwise>
							<table>
								<tr>
									<td>제목</td>
									<td>${vol.vTitle }</td>
									<td>봉사분야</td>
									<td>${vol.ServiceCode }</td>
									<td>시작일</td>
									<td>${vol.vStartDate}</td>
								</tr>
								<tr>
									<td>종료일</td>
									<td>${vol.vEndDate}</td>
									<td>활동요일</td>
									<td>${vol.vWorkingDay }</td>
								</tr>
							</table>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>
		<div class="tempDiv2">
			<
			<button>1</button>
			<button>2</button>
			<button>3</button>
			<button>4</button>
			<button>5</button>
			<button>6</button>
			<button>7</button>
			<button>8</button>
			<button>9</button>
			>
		</div>
	</div>

    <script>
	</script>
</body>
</html>

