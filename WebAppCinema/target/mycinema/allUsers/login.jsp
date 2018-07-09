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
          <p>-<span style="text-align: center"> Log In - </span></p>
        <span style="text-align: left" >Registered Members</span></h1>
          <span style="text-align: left"></span>
          <p>Do you have an account to our website? If yes, please log in.</p>
        </p></th>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
      </tr>

      <tr>
        <th scope="col">&nbsp;</th>
        <th scope="col">&nbsp;</th>
        <th scope="col">
   <form name="loginForm" method="post" action="${pageContext.servletContext.contextPath}/login">
          Username: <input type="text" name="login"/> <br/>
          Password: <input type="password" name="password"/> <br/>
          <input type="submit" value="Login" />
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
              <th scope="col"><h1>


               <div class="btn">
                     	<a href="createaccount.jsp">СREATE AN ACCOUNT</a>
               </div>

              </th>
              <th scope="col">&nbsp;</th>
              <th scope="col">&nbsp;</th>
            </tr>

    </tbody>
  </table>
</div>





</body>

</html>