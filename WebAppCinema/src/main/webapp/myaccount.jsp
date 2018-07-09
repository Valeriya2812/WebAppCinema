<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

           <a href="login.jsp"><img src="images/u7.png" width="24" height="26" class="5" align="right" ></a>
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
          <c:set var="user" value="${user}" scope="session"/>
           <p><span style="text-align: center"> Welcome, <c:out value="${user.userName}"/>
            </span></p></h1>
         </th>
         <th scope="col">&nbsp;</th>
         <th scope="col">&nbsp;</th>
       </tr>
       <c:set var="placeList" value="${placeDTOList}"/>

       <tr>
         <th scope="col">&nbsp;</th>
         <th scope="col">&nbsp;</th>
         <th scope="col">




           </th>
         <th scope="col">&nbsp;</th>
         <th scope="col">&nbsp;</th>
       </tr>
       <c:forEach items="${placeList}" var="place">
    <tr>
         <th scope="col">&nbsp;</th>
         <th scope="col">&nbsp;</th>
         <th bgcolor="#242424" scope="col">
         <h3<span style="text-align: center"> Ticket </span></h3>
           <p>Movie: <c:out value="${place.seance.movie.title}"/></p>
                        <p>Seance: <c:out value="${place.seance.seanceDate}"/> <c:out value="${place.seance.seanceTime}"/> </p>
                        <p>Hall: <c:out value="${place.seance.hall.color}"/> </p>
                        <p>Row: <c:out value="${place.row+1}"/> Number of place: <c:out value="${place.column+1}"/> </p>
                        <p>Price: <c:out value="${place.seance.price}"/> </p>
           </th>
         <th scope="col">&nbsp;</th>
         <th scope="col">&nbsp;</th>
       </tr>
        </c:forEach>

     <tr>
         <tr>
         <th scope="col">&nbsp;</th>
         <th scope="col">&nbsp;</th>
         <th scope="col"><a href="${pageContext.servletContext.contextPath}/movies">MOVIES</a>
           </th>
         <th scope="col">&nbsp;</th>
         <th scope="col">&nbsp;</th>
       </tr>
     </tbody>
   </table>
 </div>





 </body>

 </html>
