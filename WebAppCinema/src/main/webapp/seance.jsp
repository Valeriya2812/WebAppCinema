<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Документ без названия</title>
<style type="text/css">
@import url("css/style.css");
</style>
<link rel="stylesheet" href="css/style.css">
</head>

<body style="color: #FFFFFF; background: #000000; font-family: Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif; font-style: normal; font-size: 16px;">
<table width="90%">
  <tbody>
    <tr>    </tr>
  </tbody>
</table>
<span style="text-align: left" scope="col"></span>
<div class="5">
  <table width="100%">
    <tbody>
      <tr>
        <th colspan="3" scope="col"><a href="allUsers/index.jsp"><img src="images/u2.jpg" width="223" height="68" align=left alt=""/></a><span style="text-align: left"></span></th>
        <th align="left" scope="col"></th>


        <th scope="col">
          <img src="images/u6.png" alt="" width="48" height="26" class="5" align="right">

          <a href="${pageContext.servletContext.contextPath}/allUsers/myaccount"><img src="images/u5.png" width="23" height="26" class="5" align="right"></a>

          <a href="allUsers/login.jsp"><img src="images/u7.png" width="24" height="26" class="5" align="right" ></a>
        </th>
      </tr>
      <tr>
      <p>        </tr>
    </tbody>
  </table>
  <span style="text-align: center"></span>
  <table width="90%">
    <tbody>
      <tr>
      </tr>
    </tbody>
  </table>
  <span style="text-align: center"></span>
  <table width="90%">
    <tbody>
      <tr>
      </tr>
    </tbody>
  </table>
  <span style="text-align: center"></span>
  <table width="90%">
    <tbody>
      <tr>
      </tr>
      <tr>
      </tr>
      <tr>
      </tr>
      <tr>
      </tr>
    </tbody>
  </table>
  <table width="100%">
    <tbody>
     <c:set var="placeList" value="${placeDTOList}"/>
     <c:set var="movie_id" value="${movie_id}"/>
      <c:set var="hall" value="${hall}"/>




      <tr>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
<th scope="col">&nbsp;</th>
        <th scope="col">
        <h1>
                  <p>-<span style="text-align: center">  <c:out value="${hall}"/> HALL- </span></p></h1>
               <p> <span style="text-align: center" >Please, choose free place</span></p>


         <c:forEach items="${placeList}" var="place">
        <c:if test="${place.column==0}">
            <div class="all-btn">
         </c:if>
         <c:if test="${place.free==true}">


                    <div class="btn">
                 	<a href="${pageContext.servletContext.contextPath}/ticket?id=${place.id}">${place.column+1}</a>
                    </div>

                  </c:if>

          <c:if test="${place.free==false}">

                        <div class="btn">
                 	<a href="${pageContext.servletContext.contextPath}/ticket?id=${place.id}" class="disabled">${place.column+1}</a>
                        </div>

                  </c:if>
<c:if test="${place.column==place.seance.hall.countOfColumns}">
            </div>
         </c:if>
                   </c:forEach>
                    <div ><a href="${pageContext.servletContext.contextPath}/movie?id=${movie_id}">Choose another seance</a></div >
                            <div > <a href="${pageContext.servletContext.contextPath}/movies">Choose another movie</a></div >



        </th>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
      </tr>



    </tbody>
  </table>
</div>





</body>

</html>