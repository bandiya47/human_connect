<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
      request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/volunteerRegList.css">
	<style>
	</style>
</head>
<body>
	<div class="tempDiv">
	<h2>봉사신청내역</h2>
		<div class="tempDiv4">
			<div class="tempDiv5">           
				<select name="구분">
					<option value="전체">전체</option>
					<option value="승인">승인대기</option>
					<option value="거절">승인완료</option>
					<option value="대기">승인거절</option>
				</select>
			</div>
				
			<div class="tempDiv3">
				<table class="tempTable">
					<tr>
						<td>&lt;ㅇㅇ센터&gt;</td>
					<tr>
					<tr>
						<td class="tempTd">봉사기간</td>
						<td class="tempTd">봉사시간</td>
						<td class="tempTd">봉사카테고리</td>
					</tr>
				</table>
				<div class="tempTable2">
					<div>  <!--승인 결과에 따라 한가지 button만 표출하도록 구현 필요-->
						<button class="cancelButton1">취소하기</button>
						<button class="approvalCompletion">승인완료</button>
						<button class="volunteerRejected">승인거절</button>
						<button class="volunteerCompletion">봉사완료</button>
						<div class="volunteerDetail" id="volunteerDetail1">
							<button onclick="toggleModal('volunteerDetail1')">상세내용보기</button>
						</div>
						<!-- 모달 -->
						<div id="myModal" class="modal">
							<div class="modal-content">
								<span class="close" onclick="closeModal()">&times;</span>
								<div id="modalContent">
									<!-- 여기에 직접 내용을 입력 -->
									<p>detail 내용 입력</p>
									<p>detail 내용 입력</p>
									<p>detail 내용 입력</p>
									<p>detail 내용 입력</p>
									<p>detail 내용 입력</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="tempDiv2">
			< <button>1</button>
				<button>2</button>
				<button>3</button>
				<button>4</button>
				<button>5</button>
				<button>6</button>
				<button>7</button>
				<button>8</button>
				<button>9</button>>
		</div>
	</div>
		<script type="text/javascript" src="jquery-1.11.0.min.js"></script>
		<script>
        // 모달을 열기 위한 함수
		function toggleModal(contentId) {
        const modal = document.getElementById("myModal");
        modal.style.display = "block";
    }

    // 모달을 닫기 위한 함수
    function closeModal() {
        const modal = document.getElementById("myModal");
        modal.style.display = "none";
    }

    // 모달 외부 클릭 시 닫기
    window.onclick = function(event) {
        const modal = document.getElementById("myModal");
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }
	</script>
</body>
</html>