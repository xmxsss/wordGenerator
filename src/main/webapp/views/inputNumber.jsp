<%--
  Created by IntelliJ IDEA.
  User: min
  Date: 2/21/18
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:fn="http://java.sun.com/jsp/jstl/functions">
<html>
<head>
    <title>input</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<script type="application/javascript">
    var num = $("#input").val();
    function sendInput() {
        /*document.welcome.action = "{pageContext.request.contextPath}/handleInput";
        document.welcome.submit();*/
        var num = $("#input").val();
        var page = $("#p").val();
        //alert(page);
        //alert(num);
        $.getJSON("/WordGenerator/handleInput?page=" + page + "&text=" + num, function (data) {
            //alert(data.list);
            if(!data.error=="") {
                alert(data.error);
            }
            else {
                $("#p").val(data.page);
                $("#total").val(data.totalPage);
                generateTable(data.list, data.totalPage);
            }
        });
    }
    function jump(pNum) {
        var num = $("#input").val();
        $("#d1").clear;
        $("#d2").clear;
        $.getJSON("/WordGenerator/handleInput?page=" + pNum + "&text=" + num, function (data) {
            //alert(data.list);
            $("#p").val(data.page);
            //alert($("#p").val());
            generateTable(data.list, data.totalPage);
        });
    }
    function last() {
        var currentPage=$("#p").val();
        if(currentPage==1){
            alert("This is the first page!! You DUMBASS!!")
           jump(1);
        }
        else jump(currentPage-1);
    }
    function next(totalpage) {
        var currentPage=$("#p").val();
        if(currentPage==totalpage){
            alert("This is the last page!! You DUMBASS!!")
            jump(currentPage);
        }
        else jump(parseInt(currentPage)+1);
    }
</script>

<script>
    function generateTable(list, totalPage) {
        $("#d1").empty();
        $("#d2").empty();
        var i = 0;
        var currentPage = $("#p").val();
        //$("#d1").innerText=list;
        for (var i = 0; i < list.length; i++) {
            if (i % 10 == 0)
                $("#d1").append("</br>");
            $("#d1").append(list[i] + " ");
        }
        $("#d2").append("<button onclick='last()'>last</button>");
        for (var j = 1; j <=totalPage; j++) {
            $("#d2").append("<button onclick='jump("+j+")'>"+j+"</button>")
        }
        $("#d2").append("<button onclick='next("+totalPage+")'>next</button>");
    }
</script>

<body>
<div>
<input type="hidden" id="p" name="page" value="1">
<input type="hidden" id="total" name="totalPage">
<input name="text" id="input" type="text">
<button onclick="sendInput()">submit</button>
</div>
<div id="d1"></div>
<div id="d2"></div>
</body>
</html>
