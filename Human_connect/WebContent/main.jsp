<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<!--������� �Ʒ� ���� ����-->
<div class="main">
    <div class="mainFirstStack">
        <div class="mainFirstSide">
            <div>��ȣ�ҿ��� �ٷ� �����û�ϱ�</div>
            <div>�����ȳ���</div>
        </div>
        <div class="mainFirstMiddle">
            <div><img src="./img/sole.png" alt="" class="">���� ��û����</div>
            <div>
                <table>
                    <tr>
                        <th>��ȣ��</th>
                        <th>��¥</th>
                        <th>�ð�</th>
                        <th>����</th>
                    </tr>
                    <tr>
                        <td>��ȣ��</td>
                        <td>��¥</td>
                        <td>�ð�</td>
                        <td>����</td>
                    </tr>
                </table>
            </div>
            <div><a href="">��ü����></a></div>
            <div><img src="./img/sole.png" alt="" class="">�Ծ� ��û����</div>
            <div>
                <table>
                    <tr>
                        <th>��ȣ��</th>
                        <th>��¥</th>
                        <th>�ð�</th>
                    </tr>
                    <tr>
                        <td>��ȣ��</td>
                        <td>��¥</td>
                        <td>�ð�</td>
                    </tr>
                </table>
            </div>
            <div><a href="">��ü����></a></div>
        </div>
    </div>

<!--�ι�°-->
    <div class="mainSecondStack">
        <div class="mainSecondSide">
            <div>
            <p>����/���� <br>�������̵�<br> �ٷΰ���</p>
            </div>

        </div>
        <div class="mainSecondMiddle">
            <div><img src="./img/sole.png" alt="" class="">��ȣ���� ���</div>
                <div><!--�����̵�� �� �κ�-->
                    <div></div>
                    <div></div>
                    <div></div>
                </div>
            <div><a href="">��ü����></a></div>
        </div>
    </div>

<!--����°-->
    <div class="mainThirdStack">
        <div class="mainThridSide">
            <div>
            <p>��������<br>�ٷΰ���</p>
            </div>
        </div>
        <div class="MainThirdMiddle">
            <div><img src="./img/sole.png" alt="" class="">������������ �ӹ��� ��������</div>
                <div>
                    <table>
                    
                    
                      <c:forEach var="volList" items="${volList}" begin="0" end="1">
  						<form name="main" method="post" action="volunteerDetail" encType="UTF-8">
							<input type="hidden" name="v_no" value="${volList.v_no }" />>
						  <tr>
						  	<th><input type="submit" value="${volList.v_title}"></th>
						  	<th>��¥</th>
                            <th>�ð�</th>
                            <th>����</th>
						  </tr>

  						</from>
						    
						    </c:forEach>
                    
                    

                    </table>
                </div>
            <div><a href="">��ü����></a></div>
        </div>
    </div>
</div>

</body>
</html>