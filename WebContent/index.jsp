<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="./css/main.css" rel="stylesheet">
<script type="text/javascript" src="./js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./js/common.js"></script>
<!-- 20200527 HPI Kubota UNIXTIME処理 ADD START -->
<script type="text/javascript" >
	function timeSet()
	{
		date = new Date();
		unixtime_a = date.getTime() / 1000;
		unixtime_b = Math.floor(unixtime_a);
		document.getElementById("set-unix-time").value = unixtime_b;
	}
</script>
<!-- 20200527 HPI Kubota UNIXTIME処理 ADD END -->
<title>担当変更システム</title>
<s:head />
</head>
<body>
    <div id="header">

        <hr />
    </div>
    <div class="title">
        担当変更システム&nbsp;&nbsp;&nbsp;ログイン index.jsp
        <hr />
    </div>
    <br />
    <div class="main">
        <s:actionerror />
        <s:actionmessage/>
        <s:fielderror />
        <s:form action="NC001Init.action" theme="simple" name="fm1" >
            <table>
                <tr>
                    <td>従業員番号</td>
                    <td>：</td>
                    <td><s:textfield name="code" cssErrorStyle="background-color:red" style="ime-mode:disabled;" value="c883003"/></td><!-- c883003, 8830034 -->
                </tr>
                <!-- 20200522 HPI Kubota ログイン項目追加 ADD START -->
                <tr>
	                <td>発行日</td>
	                <td>：</td>
	                <!-- 20200527 HPI Kubota UNIXTIME処理 ADD START -->
	                <td><s:textfield id="set-unix-time"  name="loginday" cssErrorStyle="background-color:red" style="ime-mode:disabled;" value=""  /><button type="button" onclick="timeSet();">時間入力</button></td>
	                <!-- 20200527 HPI Kubota UNIXTIME処理 ADD END -->
                </tr>
                <tr>
                	<td>発行者</td>
                	<td>：</td>
                    <td><s:textfield name="username" cssErrorStyle="background-color:red"  value="CTSTAKEDA"/></td>
                </tr>
                <!-- 20200522 HPI Kubota ログイン項目追加 ADD END-->
                <tr>
                    <td>権限セット選択</td>
                    <td>：</td>
                    <td>
                      <input type="radio" name="jokenType" value="0" id="jokenType0" onclick="document.fm1.code.value = 'c198267';"><label for="jokenType0">営業所権限（複数なし）</label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td>
                      <input type="radio" name="jokenType" value="1" id="jokenType1" onclick="document.fm1.code.value = 'c873041';"><label for="jokenType1">営業所権限（複数あり）</label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td>
                      <input type="radio" name="jokenType" value="2" id="jokenType2" onclick="document.fm1.code.value = 'c283054';"><label for="jokenType2">支店権限</label>
                    </td>
                </tr>


                <tr>
                    <td></td>
                    <td></td>
                    <td>
                      <input type="radio" name="jokenType" value="5" id="jokenType5" onclick="document.fm1.code.value = 'c911117';" checked><label for="jokenType5">本部権限(JKN0162)</label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td>
                      <input type="radio" name="jokenType" value="3" id="jokenType3" onclick="document.fm1.code.value = 'c883003';" checked><label for="jokenType3">本部権限(JKN0163)</label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td>
                      <input type="radio" name="jokenType" value="4" id="jokenType4" onclick="document.fm1.code.value = 'c281106';"><label for="jokenType4">ワクチンG</label>
                    </td>
                </tr>
            </table>
            <br />
            <s:submit value="ログイン" />
            <br>
            <hr>
            <br>
            <br>
            ※本番環境ではClearTrustで認証しますが、開発環境ではClearTrustが無いので本画面で代用<br>
            　また、本来はユーザIDを入力しますが、本画面では従業員番号（数字７桁）で入力してください<br>
            　（入力チェックはしていませんので正しく入力願います）<br>
            <br>
            ※従業員番号を変更する場合は、一旦ブラウザを閉じた後、再度ログインし直してください<br>
            <s:token/>
        </s:form>
    </div>
    <div id="footer">
        <hr />
        <h5>COPYRIGHT (C) 2010-2014, HITACHI SOLUTIONS, Ltd.</h5>
    </div>
</body>
</html>