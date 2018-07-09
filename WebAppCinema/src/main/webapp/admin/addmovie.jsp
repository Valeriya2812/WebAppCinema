<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

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
               <p>-<span style="text-align: center"> Add A New Movie - </span></p>
             <span style="text-align: left" >New Movie</span></h1>


              <form name="NewMovie" method="post" action="${pageContext.servletContext.contextPath}/admin/newmovie">
              <span style="text-align: left">Title:</span>
               		 <p><input type="text" name="title"></p>
            <p><span style="text-align: left">Description:</span></p>
     			<textarea name="description"></textarea>
     		 <p><span style="text-align: left">Director:</span></p>
     			<textarea name="director"></textarea>
     		 <p><span style="text-align: left">Starring:</span></p>
     			<textarea name="starring"></textarea>
     			<p><span style="text-align: left">Duration: Min age:</span></p>
     			 <input type="number"  name="duration" placeholder="min">

     			 <input type="number" name="minAge" >
     			 <p><input type="submit" value="Add this movie >" /></p>





     			   </form>
            </th>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
           </tr>

    </tbody>
  </table>
</div>





</body>

</html>