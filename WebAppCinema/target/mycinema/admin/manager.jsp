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
                       <th colspan="3" scope="col"><a href="${pageContext.servletContext.contextPath}/allUsers/index.jsp"><img src="images/u2.jpg" width="223" height="68" align=left alt=""/></a><span style="text-align: left"></span></th>
                       <th align="left" scope="col"></th>


                       <th scope="col">
                         <img src="images/u6.png" alt="" width="48" height="26" class="5" align="right">

                         <a href="${pageContext.servletContext.contextPath}/myaccount"><img src="images/u5.png" width="23" height="26" class="5" align="right"></a>

                         <a href="${pageContext.servletContext.contextPath}/allUsers/login.jsp"><img src="images/u7.png" width="24" height="26" class="5" align="right" ></a>
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
      <tr>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
        <th scope="col"><h1>
          <p><span style="text-align: center; color: #D7AF72;"> Movie Manager</span></p>
        </th>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
      </tr>
      <tr>

      </tr>
   <tr>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
       <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
      </tr>
     <c:set var="seanceList" value="${selectedSeances}"/>
     <c:set var="movieList" value="${selectedMovies}"/>
     <c:set var="restMovies" value="${restMovies}"/>
     <c:set var="dateList" value="${selectedDates}"/>
 <c:set var="f" value="${0}"/>
            <c:forEach items="${movieList}" var="movie">
      <tr>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>

        <th bgcolor="#242424" scope="col"><section>
        <h1><c:out value="${movie.title}"/></h1>
        <p><c:out value="${movie.description}"/></p>
        <p><c:out value="${movie.duration}"/></p>
        <p><c:out value="${movie.director}"/></p>
        <p><c:out value="${movie.starring}"/></p>
        <p><c:out value="${movie.minAge}"/></p>

        <p> <c:forEach items="${dateList}" var="date">
<c:forEach items="${seanceList}" var="seance1">
         <c:if test="${seance1.movie.id==movie.id}">

          <c:if test="${seance1.seanceDate==date}">
                  <c:set var="f" value="${1}"/>
                </c:if>
                </c:if>
          </c:forEach>
         <c:if test="${f==1}">

        <p><c:out value="${date}"/>:
        <c:forEach items="${seanceList}" var="seance">
<c:if test="${seance.movie.id==movie.id}">

          <c:if test="${seance.seanceDate==date}">
         <c:out value="${seance.seanceTime}"/>
</c:if>
 </c:if>

</c:forEach>

<c:set var="f" value="${0}"/>
 </c:if>
</c:forEach>
 </p>




     </br>
       <a href="${pageContext.servletContext.contextPath}/admin/addseance?id=${movie.id}">ADD SEANCE ></a>


               </section>
        </th>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
      </tr>
       <tr>
              <th scope="col">&nbsp;</th>
              <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
              <th scope="col">&nbsp;</th>
              <th scope="col">&nbsp;</th>
            </tr>
 </c:forEach>




       <c:forEach items="${restMovies}" var="movie">
      <tr>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>

        <th bgcolor="#242424" scope="col"><section>
        <h1><c:out value="${movie.title}"/></h1>
        <p><c:out value="${movie.description}"/></p>
        <p><c:out value="${movie.duration}"/></p>
        <p><c:out value="${movie.director}"/></p>
        <p><c:out value="${movie.starring}"/></p>
        <p><c:out value="${movie.minAge}"/></p>

        </br>
       <a href="${pageContext.servletContext.contextPath}/admin/addseance?id=${movie.id}">ADD SEANCE ></a>


               </section>
        </th>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
      </tr>
       <tr>
              <th scope="col">&nbsp;</th>
              <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
              <th scope="col">&nbsp;</th>
              <th scope="col">&nbsp;</th>
            </tr>
 </c:forEach>
    </tbody>
  </table>
</div>





</body>

</html>