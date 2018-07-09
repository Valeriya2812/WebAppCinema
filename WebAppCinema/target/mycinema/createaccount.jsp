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
        <th colspan="3" scope="col"><a href="index.jsp"><img src="images/u2.jpg" width="223" height="68" align=left alt=""/></a><span style="text-align: left"></span></th>
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
               <p>-<span style="text-align: center"> Create An Account - </span></p>
             <span style="text-align: left" >New Members</span></h1>
               <span style="text-align: left"></span>
               <p>Take a minute and join to us</p>
             </p></th>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
           </tr>
           <form name="NewAccountForm" method="post" action="${pageContext.servletContext.contextPath}/newaccount">
     	  <tr>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
             <th scope="col">
              <input type="text" name="name" placeholder="name">

               </th>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
           </tr>
     	 <tr>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
             <th scope="col"><input type="text" name="surname" placeholder="surname"></th>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
           </tr>
     	  <tr>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
             <th scope="col"><input type="email" name="email" placeholder="email">

               </th>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
           </tr>
            <c:set var="warn" value="${warn}"/>
           <tr>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
             <th scope="col"><input type="text" name="login" placeholder="login">
                <c:out value="${warn}"/>
               </th>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
           </tr>
        <tr>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
             <th scope="col"><input type="password" name="password" placeholder="password">
               </th>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
           </tr>
         <tr>
     		<tr>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
             <th scope="col">
             <input type="number" name="age" placeholder="age">  </th>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
           </tr>
         <tr>
             <tr>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
             <th scope="col"><input type="submit" value="Create" />
               </th>
             <th scope="col">&nbsp;</th>
             <th scope="col">&nbsp;</th>
           </tr>
            </form>
    </tbody>
  </table>
</div>





</body>

</html>