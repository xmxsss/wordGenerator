<%--
  Created by IntelliJ IDEA.
  User: min
  Date: 2/21/18
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:fn="http://java.sun.com/jsp/jstl/functions">

<head>
    <title>results</title>
    <%--<script language="JavaScript" src="jquery-3.3.1.js"></script>--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<script type="application/javascript">
    $(document).ready(function () {
        /* $.ajax({
            url: "/WordGenerator/handleInput?page=1&Num=2222",
            type: "get",
            dataType: "json",
            success: function (data) {
                alert(data.list);
            }
        });*/
        $.getJSON("inputNumber.jsp", function(data){
            alert(data.toString());
        });
        $.getJSON("/WordGenerator/handleInput/5", function (data) {
            alert(data.list);
            generateTable(data.list);
        });

    });
    function generateTable(list) {
        var i=0;
        //$("#d1").innerText=list;
        for(var i=0;i<list.length;i++) {
            if(i%10==0)
                $("#d1").append("</br>");
            $("#d1").append(list[i] + " ");
        }
    }
</script>
<body>
Results:<br/>
<div id="d1"></div>
<%--<table id="restable" border="1">
</table>--%>
</body>
</html>
