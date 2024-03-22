<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="trip" value="${pageContext.request.contextPath}"> </c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enjoy Trip</title>
<!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap Icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Google fonts-->
    <link
      href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic"
      rel="stylesheet"
      type="text/css"
    />
    <!-- SimpleLightbox plugin CSS-->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
      <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="/">Enjoy Trip</a>
        <button
          class="navbar-toggler navbar-toggler-right"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarResponsive"
          aria-controls="navbarResponsive"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ms-auto my-2 my-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="/map/map.html">지역별여행지</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/plan/plan.html">나의여행계획</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/hotplace/hotplace.html">핫플자랑하기</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/share/share.html">여행정보공유</a>
            </li>
            <li id="join-nav" class="nav-item">
              <a class="nav-link" href="#join" data-bs-toggle="modal" data-bs-target="#join"
                >회원가입</a
              >
            </li>
            <li id="login-nav" class="nav-item">
              <a class="nav-link" href="#login" data-bs-toggle="modal" data-bs-target="#login"
                >로그인</a
              >
            </li>
            <li id="mypage-nav" class="nav-item d-none">
              <a class="nav-link" href="/mypage/mypage.html">마이페이지</a>
            </li>
            <li id="logout-nav" class="nav-item d-none">
              <a class="nav-link" href="/">로그아웃</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Modal -->
    <div class="modal fade" id="join" tabindex="-1" aria-labelledby="joinLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header text-center">
            <h1 class="modal-title w-100 fs-5" id="joinLabel">Join Us</h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <div class="row gx-4 justify-content-center m-2">
              <div class="col-lg-8">
                <!-- * * * * * * * * * * * * * * *-->
                <!-- * * SB Forms share Form * *-->
                <!-- * * * * * * * * * * * * * * *-->
                <!-- This form is pre-integrated with SB Forms.-->
                <!-- To make this form functional, sign up at-->
                <!-- https://startbootstrap.com/solution/share-forms-->
                <!-- to get an API token!-->
                <form id="joinForm" data-sb-form-api-token="API_TOKEN">
                  <!-- Name input-->
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="name"
                      type="text"
                      placeholder="Enter your name..."
                      data-sb-validations="required"
                    />
                    <label for="name">이름</label>
                    <div class="invalid-feedback" data-sb-feedback="name:required">
                      이름은 필수 항목입니다.
                    </div>
                  </div>
                  <!-- ID input-->
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="id"
                      type="text"
                      placeholder="Enter your id..."
                      data-sb-validations="required"
                    />
                    <label for="id">아이디</label>
                    <div class="invalid-feedback" data-sb-feedback="id:required">
                      아이디는 필수 항목입니다.
                    </div>
                  </div>
                  <!-- password input-->
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="password"
                      type="password"
                      placeholder="Enter your password..."
                      data-sb-validations="required"
                    />
                    <label for="password">비밀번호</label>
                    <div class="invalid-feedback" data-sb-feedback="password:required">
                      비밀번호는 필수 항목입니다.
                    </div>
                  </div>
                  <!-- Email address input-->
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="email"
                      type="email"
                      placeholder="name@example.com"
                      data-sb-validations="required,email"
                    />
                    <label for="email">이메일</label>
                    <div class="invalid-feedback" data-sb-feedback="email:required">
                      이메일은 필수 항목입니다.
                    </div>
                    <div class="invalid-feedback" data-sb-feedback="email:email">
                      유효하지 않은 이메일입니다.
                    </div>
                  </div>
                  <!-- Region number input-->
                  <div class="input-group mb-3">
                    <label class="input-group-text" for="region">지역</label>
                    <select
                      class="form-select"
                      id="region"
                      style="height: calc(3.5rem + 2px); line-height: 1.25"
                    >
                      <option selected>선택...</option>
                      <option value="seoul">서울</option>
                      <option value="incheon">인천</option>
                      <option value="daejeon">대전</option>
                      <option value="daegu">대구</option>
                      <option value="gwangju">광주</option>
                      <option value="busan">부산</option>
                      <option value="ulsan">울산</option>
                      <option value="sejong">세종시</option>
                      <option value="gyeonggi">경기도</option>
                      <option value="gangwon">강원도</option>
                      <option value="chungbuk">충청북도</option>
                      <option value="chungnam">충청남도</option>
                      <option value="gyeongbuk">경상북도</option>
                      <option value="gyeongnam">경상남도</option>
                      <option value="jeonbuk">전라북도</option>
                      <option value="jeonnam">전라남도</option>
                      <option value="jeju">제주도</option>
                    </select>
                  </div>
                  <!-- Submit success message-->
                  <!---->
                  <!-- This is what your users will see when the form-->
                  <!-- has successfully submitted-->
                  <div class="d-none" id="submitSuccessMessage">
                    <div class="text-center mb-3">
                      <div class="fw-bolder">환영합니다!</div>
                      <a href="#" data-bs-toggle="modal" data-bs-target="#login">로그인 바로가기</a>
                    </div>
                  </div>
                  <!-- Submit error message-->
                  <!---->
                  <!-- This is what your users will see when there is-->
                  <!-- an error submitting the form-->
                  <div class="d-none" id="submitErrorMessage">
                    <div class="text-center text-danger mb-3">Error sending message!</div>
                  </div>
                  <!-- Submit Button-->
                  <div class="d-grid">
                    <button class="btn btn-primary btn-xl disabled" id="submitButton" type="submit">
                      Sign up
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div
      class="modal fade"
      id="login"
      tabindex="-1"
      aria-labelledby="loginLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header text-center">
            <h1 class="modal-title w-100 fs-5" id="loginLabel">Log In</h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <div class="row gx-4 justify-content-center m-2">
              <div class="col-lg-8">
                <form id="loginForm">
                  <!-- ID input-->
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="logined-id"
                      type="text"
                      placeholder="Enter your id..."
                      required
                    />
                    <label for="logined-id">아이디</label>
                  </div>
                  <!-- password input-->
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="logined-password"
                      type="password"
                      placeholder="Enter your password..."
                      required
                    />
                    <label for="logined-password">비밀번호</label>
                  </div>
                  <div class="d-none" id="loginFailMessage">
                    <div class="text-center text-danger mb-3">로그인 실패. 다시 시도하세요.</div>
                  </div>
                  <!-- Submit Button-->
                  <div class="d-grid">
                    <p class="text-center">
                      <a
                        id="findPwdLink"
                        href="#"
                        class="link-secondary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
                        data-bs-toggle="modal"
                        data-bs-target="#findPwd"
                        >비밀번호 찾기</a
                      >
                    </p>
                    <button class="btn btn-primary btn-xl" id="loginButton" type="submit">
                      Log In
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Modal -->
    <div
      class="modal fade"
      id="findPwd"
      tabindex="-1"
      aria-labelledby="findPwdLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header text-center">
            <h1 class="modal-title w-100 fs-5" id="findPwdLabel">Find Password</h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <div class="row gx-4 justify-content-center m-2">
              <div class="col-lg-8">
                <form id="findPwdForm">
                  <div class="form-floating mb-3">
                    <input
                      class="form-control"
                      id="find-id"
                      type="text"
                      placeholder="Enter your id..."
                      required
                    />
                    <label for="find-id">아이디</label>
                  </div>
                  <div id="pwdFindMsg">
                    <div id="idNotExist" class="d-none text-center text-danger mb-3">
                      존재하지 않는 아이디입니다.
                    </div>
                    <div id="foundPwd" class="d-none text-center text-info mb-3">
                      ~ 님의 비밀번호는 [ <span class="text-dark">1234</span> ] 입니다.
                    </div>
                  </div>
                  <!-- Submit Button-->
                  <div class="d-grid">
                    <button class="btn btn-primary btn-xl" id="findPwdBtn" type="submit">
                      비밀번호 찾기
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- SimpleLightbox plugin JS-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <!-- * *                               SB Forms JS                               * *-->
    <!-- * * Activate your form at https://startbootstrap.com/solution/share-forms * *-->
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
  </body>
</html>