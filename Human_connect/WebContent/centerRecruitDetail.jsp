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
        <h2>������û����</h2>
        <div class="tempDiv4">
        <h3>2025�� 00�� 00�� �������� ���մϴ�</h3>
        <div class="tempDiv5">
            
            <select name="����">
                <option value="��ü">��ü</option>
                <option value="����">����</option>
                <option value="����">����</option>
                <option value="���">���</option>
            </select>
        </div>
            
        <div class="tempDiv3">
        <table class="tempTable">
            <tr>
                <td class="tempTd">���̵�</td>
                <td class="tempTd">�̸�</td>
                <td>��ȭ��ȣ</td>
            </tr>
            <tr>
                <td>÷������</td>           
            </tr>
        </table>
        <table class="tempTable2">
            <tr>
                <td>
                    <button class="tempButton1 rejectButton1" id="rejectButton1">o</button> 
                    <button class="tempButton2">x</button>
                        <div class="rejectDive" id="rejectDive">
                            <input class="rejectInput" type="text" placeholder="��������">
                            <input type="submit" value="Ȯ��">
                        </div>
                </td>
            </tr>
            <tr>
                <td><button>�󼼳��뺸��</button></td>           
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