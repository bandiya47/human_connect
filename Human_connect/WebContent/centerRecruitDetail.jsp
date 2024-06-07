<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
                border-bottom:2px solid black;
                padding: 5px;
                margin: 10px 0px 30px 0px;
                text-align: left;
                font-size: 18px;
                font-weight: bold;
            }
            .tempDiv h3{

                padding-top: 5px;


                font-size: 20px;
                font-weight: bold;
            }
            .tempDiv .tempTable{
                margin: 2px auto;
                width: 300px;
                float: left;
            }
            .tempDiv .tempTable tr td{
                padding: 5px;
            }
            .tempDiv .tempTable .tempTd{
                border-right: 1px solid black;
            }
            .tempDiv .tempDiv2{
                padding: 10px;

                margin: 20px auto;
                width: 960px;
            }
            .tempDiv .tempDiv2 button{
                background-color: rgb(252,236,203);
                border: none;
                cursor: pointer;
            }

            .tempDiv .tempTable2{
                margin-left: auto;
                width: 200px;
                border: 1px solid black;
            }

            .tempDiv .tempTable2 .tempButton1{
                background-color: rgb(194, 241, 200);
                border: 1px solid rgb(194, 241, 200);
                margin: 5px;
                cursor: pointer;

            }

            .tempDiv .tempTable2 .tempButton2{
                background-color: rgb(246, 198, 173);
                border: 1px solid rgb(246, 198, 173);
                margin: 5px;
                cursor: pointer;
            }
            .tempDiv3{
                margin: auto;
                border: 1px solid black;
                width: 850px;
                padding: 5px;
                margin-bottom: 5px;
            }
            .tempDiv4{
                border: 1px solid black;
                padding: 5px;
            }
            .tempDiv5{
                width: 850px;
                margin: auto;
                text-align: right;
                margin-bottom: 5px;
            }
            .rejectDive {
                display: none;
                
            }
            .existDive{
                display:inline;
                width: 50px;
            }
            .rejectInput{
                width: 50px
            }
        </style>
                <script type="text/javascript"  src="jquery-1.11.0.min.js"></script>
                <script>
                    $(document).ready(function() {
                        $(".tempButton2").click(function() {
                            if($("#rejectDive").hasClass("rejectDive")) {
                                $("#rejectDive").removeClass("rejectDive");
                                $("#rejectDive").addClass("existDive");
                            }
                            if($("#rejectButton1").hasClass("rejectButton1")) {
                                $("#rejectButton1").removeClass("rejectButton1");
                                $("#rejectButton1").addClass("rejectDive");
                            }

                        });
                    });
                </script>
    </head>
    <html>
        <div class="tempDiv">
        <h2>모집신청내역</h2>
        <div class="tempDiv4">
        <h3>2025년 00월 00일 목욕봉사자 구합니다</h3>
        <div class="tempDiv5">
            
            <select name="구분">
                <option value="전체">전체</option>
                <option value="승인">승인</option>
                <option value="거절">거절</option>
                <option value="대기">대기</option>
            </select>
        </div>
            
        <div class="tempDiv3">
        <table class="tempTable">
            <tr>
                <td class="tempTd">아이디</td>
                <td class="tempTd">이름</td>
                <td>전화번호</td>
            </tr>
            <tr>
                <td>첨부파일</td>           
            </tr>
        </table>
        <table class="tempTable2">
            <tr>
                <td>
                    <button class="tempButton1 rejectButton1" id="rejectButton1">o</button> 
                    <button class="tempButton2">x</button>
                        <div class="rejectDive" id="rejectDive">
                            <input class="rejectInput" type="text" placeholder="거절사유">
                            <input type="submit" value="확인">
                        </div>
                </td>
            </tr>
            <tr>
                <td><button>상세내용보기</button></td>           
            </tr>
        </table>
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

    </html>
</html>