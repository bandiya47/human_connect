<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
      request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/reset.css">
        <style>
            .tempDiv{
                text-align: center;
                margin: auto;
                width: 980px;
                /* background-color:red; */
            }
            .tempDiv h2{
                font-size: 25px;
                border-top:2px solid black;
                border-bottom:2px solid black;
                padding: 5px;
                margin: 10px 0px 30px 0px;
            }
            .tempDiv .tempTable{
                margin: 5px auto;
                border-top: 2px solid black;
                border-bottom: 2px solid black;
                width: 980px;
            }
            .tempDiv .tempTable tr td{
                padding: 5px;
                border-bottom: 1px solid black;
            }
            .tempDiv .tempTable .tempTd{
                border-right: 1px solid black;
            }
            .tempDiv .tempDiv2{
                padding: 10px;
                border: 2px solid black;
                margin: 20px auto;
                width: 960px;
            }
            .tempDiv button{
                width: 300px;
            }
        </style>
    </head>
    <html>
    <body>
	<c:set var="vTitle" value="${param.vTitle }" />
	<c:set var="vStartDate" value="${param.vStartDate }" />
	<c:set var="vEndDate" value="${param.vEndDate }" />
	<c:set var="vStartTime" value="${param.vStartTime }" />
	<c:set var="vLastTime" value="${param.vLastTime }" />
	<c:set var="vRStartDate" value="${param.vRStartDate }" />
	<c:set var="vREndDate" value="${param.vREndDate }" />
	<c:set var="vWorkingDay" value="${param.vWorkingDay }" />
	<c:set var="vServiceCode" value="${param.vServiceCode }" />
	<c:set var="vRegAmnt" value="${param.vRegAmnt }" />
	<c:set var="vUploadFilePath" value="${param.vUploadFilePath }" />
    <c:set var="vInfo" value="${param.vInfo }" />
    
    
    <form name="centerRegCheck" method="post" action="volunteerReg" encType="UTF-8">
        <div class="tempDiv">
    <input type="hidden" name="vTitle" value=<c:out value="${vTitle}" />>
    <input type="hidden" name="vStartDate" value=<c:out value="${vStartDate}" />>
    <input type="hidden" name="vEndDate" value=<c:out value="${vEndDate}" />>
    <input type="hidden" name="vStartTime" value=<c:out value="${vStartTime}" />>
    <input type="hidden" name="vLastTime" value=<c:out value="${vLastTime}" />>
    <input type="hidden" name="vRStartDate" value=<c:out value="${vRStartDate}" />>
    <input type="hidden" name="vREndDate" value=<c:out value="${vREndDate}" />>
    <input type="hidden" name="vWorkingDay" value=<c:out value="${vWorkingDay}" />>
    <input type="hidden" name="vServiceCode" value=<c:out value="${vServiceCode}" />>
    <input type="hidden" name="vRegAmnt" value=<c:out value="${vRegAmnt}" />>


        <h2><c:out value="${vTitle}" /></h2>
        <table class="tempTable">
            <tr>
                <td class="tempTd">봉사기간</td>
                <td><c:out value="${vStartDate}" /> ~ <c:out value="${vEndDate}" /></td>
                <td class="tempTd">봉사시간</td>
                <td><c:out value="${vStartTime}" /> ~ <c:out value="${vLastTime}" /></td>
            </tr>
            <tr>
                <td class="tempTd">모집기간</td>
                <td><c:out value="${vRStartDate}" /> ~ <c:out value="${vREndDate}" /></td>
                <td class="tempTd">활동요일</td>
                <td><c:out value="${vWorkingDay}" /></td>
            </tr>
            <tr>
                <td class="tempTd">모집인원</td>
                <td><c:out value="${vRegAmnt}" />명</td>
                <td class="tempTd">신청인원</td>
                <td><input type="text" name="vreg_amnt"></td>
            </tr>
            <tr>
                <td class="tempTd">봉사분야</td>
                <td>산책</td>
                <td class="tempTd">봉사자유형</td>
                <td>성인</td>
            </tr>
            <tr>
                <td class="tempTd">센터명</td>
                <td colspan="3">휴먼보호센터</td>
            </tr>
            <tr>
                <td class="tempTd">봉사장소</td>
                <td colspan="3">충남 천안시 어쩌구 저쩌꾸</td>
            </tr>
            <tr>
                <td class="tempTd">첨부파일</td>
                <td colspan="3"><input type="file" name="vreg_upload_file_path"></td>
            </tr>
        </table>
        <div class="tempDiv2">
            <textarea name="vreg_info"></textarea>
        </div>
        <input type="submit" value="제출하기">
    </div>
</form>
</body>
    </html>
</html>