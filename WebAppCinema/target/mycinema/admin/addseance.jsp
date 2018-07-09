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
        <th scope="col">&nbsp;</th>
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
         <c:set var="movie" value="${movieDTO}"/>
         <c:set var="seanceList" value="${seanceDTOList}"/>

         <c:set var="dateList" value="${selectedDates}"/>

          <tr>
            <th scope="col">&nbsp;</th>
            <th scope="col">&nbsp;</th>

            <th bgcolor="#242424" scope="col"><section>
            <h1><span style="text-align: center; color: #D7AF72;"><c:out value="${movie.title}"/></h1>
            <p><c:out value="${movie.description}"/></p>
            <p><c:out value="${movie.duration}"/></p>
            <p><c:out value="${movie.director}"/></p>
            <p><c:out value="${movie.starring}"/></p>
            <p><c:out value="${movie.minAge}"/></p>
             </br>

              <c:forEach items="${dateList}" var="date">
              <p><c:out value="${date}"/>:
               <c:forEach items="${seanceList}" var="seance">
                    <c:if test="${seance.seanceDate==date}">
                    <c:out value="${seance.seanceTime}"/>
                    </c:if>
                 </c:forEach>
                 </p>
               </c:forEach>



<form name="CreateSeanceForm" method="post" action="${pageContext.servletContext.contextPath}/admin/createseance">
Hall:
             <select name="selectedHall" >
               <option value="1">YELLOW 10X20</option>
               <option value="2">RED 15X15</option>
               <option value="3">INDIGO 10X20</option>
              </select>

                 Date: <input type="date" name="seanceDate">
                 Time: <input type="time" name="seanceTime">
                 Price: <input type="number" name="price">
                  <input type="hidden" name="id_movie" value="${movie.id}"/>
                  <input type="submit" value="Add Seance" />

</form>





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



    </tbody>
  </table>
</div>





</body>

</html>