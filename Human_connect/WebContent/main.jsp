<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HumanConnect</title>
 <link rel="stylesheet" type="text/css" href="./css/style.css">
    
</head>

<body>
<jsp:include page="nevi.jsp" />

<!--여기부터 아래 내용 메인-->
<div class="main">
    <div class="mainFirstStack">
        <div class="mainFirstSide">
            <div>보호소에서 바로 봉사신청하기</div>
            <div>뱃지안내문</div>
        </div>
        <div class="mainFirstMiddle">
            <div><img src="./img/sole.png" alt="" class="">봉사 신청내역</div>
            <div>
                <table>
                    <tr>
                        <th>보호소</th>
                        <th>날짜</th>
                        <th>시간</th>
                        <th>역할</th>
                    </tr>
                    <tr>
                        <td>보호소</td>
                        <td>날짜</td>
                        <td>시간</td>
                        <td>역할</td>
                    </tr>
                </table>
            </div>
            <div><a href="">전체보기></a></div>
            <div><img src="./img/sole.png" alt="" class="">입양 신청내역</div>
            <div>
                <table>
                    <tr>
                        <th>보호소</th>
                        <th>날짜</th>
                        <th>시간</th>
                    </tr>
                    <tr>
                        <td>보호소</td>
                        <td>날짜</td>
                        <td>시간</td>
                    </tr>
                </table>
            </div>
            <div><a href="">전체보기></a></div>
        </div>
    </div>

<!--두번째-->
    <div class="mainSecondStack">
        <div class="mainSecondSide">
            <div>
            <p>이지/봉사 <br>이지가이드<br> 바로가기</p>
            </div>

        </div>
        <div class="mainSecondMiddle">
            <div><img src="./img/sole.png" alt="" class="">보호동물 목록</div>
                <div><!--슬라이드쇼 들어갈 부분-->
                    <div></div>
                    <div></div>
                    <div></div>
                </div>
            <div><a href="">전체보기></a></div>
        </div>
    </div>

<!--세번째-->
    <div class="mainThirdStack">
        <div class="mainThridSide">
            <div>
            <p>공지사항<br>바로가기</p>
            </div>
        </div>
        <div class="MainThirdMiddle">
            <div><img src="./img/sole.png" alt="" class="">모집마감일이 임박한 봉사정보</div>
                <div>
                    <table>
                        <tr>
                            <th>보호소</th>
                            <th>날짜</th>
                            <th>시간</th>
                            <th>역할</th>
                        </tr>
                        <tr>
                            <td>보호소</td>
                            <td>날짜</td>
                            <td>시간</td>
                            <td>역할</td>
                        </tr>
                    </table>
                </div>
            <div><a href="">전체보기></a></div>
        </div>
    </div>
</div>

</body>
</html>