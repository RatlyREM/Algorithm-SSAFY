<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/commons/header.jsp" %>


    <!-- Masthead-->
    <header id="mainhead" class="masthead">
      <div class="container px-4 px-lg-5 h-100">
        <div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
          <div class="col-lg-8 align-self-end">
            <h1 class="text-white font-weight-bold">
              Welcome To <br /><span class="text-warning">Enjoy Trip!</span>
            </h1>

            <hr class="divider" />
          </div>
          <div class="col-lg-8 align-self-baseline">
            <p class="text-white-75 mb-5">
              Enjoy Trip과 함께 우리 지역의 관광지를 알아보고 나만의 여행 계획을 만들어 보세요!
            </p>
            <a class="btn btn-primary btn-xl" data-bs-toggle="modal" data-bs-target="#join"
              >Join Us</a
            >
          </div>
        </div>
      </div>
    </header>

<%@ include file="/commons/footer.jsp" %>
</body>
</html>