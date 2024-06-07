<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}"  /> --%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="jakarta.servlet.http.HttpServletRequest"%>
<%@ page import="dc.human.gbnb.humanConnect.dto.UserDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Volunteer List</title>
    <link rel="stylesheet" type="text/css" href="./css/volunteerList.css">
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
					<td>지역 
						<select onchange="selectRegion(this)">
							<option value="">행정구역 선택</option>
							<option value="all">전체</option>
							<option value="seoul">서울특별시</option>
							<option value="kyungki">경기도</option>
							<option value="chungnam">충청남도</option>
							<option value="chungbuk">충청북도</option>
							<option value="kangwon">강원도</option>
							<option value="jeonnam">전라남도</option>
							<option value="jeonbuk">전라북도</option>
							<option value="kyungnam">경상남도</option>
							<option value="kyungbuk">경상북도</option>
							<option value="jeju">제주시</option>
						</select> 
						<select id="volunteerListSelectCity">
							<option value="">도시 선택</option>
						</select>
					</td>
				</tr>
			</table>

			<div class="volunteerListVolRecruitList">
				<p>구인 리스트</p>
				<table>
					<c:forEach items="${volunteerList}" var="volunteerList">
						<tr>
							<td>
								봉사 제목 : ${volunteerList.v_title } 
							</td>
						<tr>
							<td>
								봉사 번호 : ${volunteerList.v_no }
								센터 아이디 : ${volunteerList.c_id }
							</td>
						</tr>
						<tr>
							<td>
								봉사 날짜 : ${volunteerList.v_start_date } ~ ${volunteerList.v_end_date } 
								봉사 시간 : ${volunteerList.v_start_time } ~ ${volunteerList.v_last_time }
							</td>
						</tr>
						<tr>
							<td>
								모집 날짜 : ${volunteerList.v_rstart_date } ~ ${volunteerList.v_rend_date }
								모집 분야 : ${volunteerList.service_code }
							</td>
						</tr>
						<tr>
							<td>
								모집 인원 : ${volunteerList.v_max_amnt } 
								신청 인원 : ${volunteerList.v_reg_amnt } 
								모집 상태 : ${volunteerList.v_state }
							</td>
						</tr>
							
					</c:forEach>
				</table>
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

<script type="text/javascript"  src="./js/volunteerList.js" >
</script> 
</body>
</html>

