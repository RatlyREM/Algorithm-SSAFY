/*!
 * Start Bootstrap - Creative v7.0.7 (https://startbootstrap.com/theme/creative)
 * Copyright 2013-2023 Start Bootstrap
 * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-creative/blob/master/LICENSE)
 */
//
// Scripts
//

window.addEventListener("DOMContentLoaded", (event) => {
  // Navbar shrink function
  var navbarShrink = function () {
    const navbarCollapsible = document.body.querySelector("#mainNav");
    if (!navbarCollapsible) {
      return;
    }
    if (window.scrollY === 0) {
      navbarCollapsible.classList.remove("navbar-shrink");
    } else {
      navbarCollapsible.classList.add("navbar-shrink");
    }
  };

  // Shrink the navbar
  navbarShrink();

  // Shrink the navbar when page is scrolled
  document.addEventListener("scroll", navbarShrink);

  // Activate Bootstrap scrollspy on the main nav element
  const mainNav = document.body.querySelector("#mainNav");
  if (mainNav) {
    new bootstrap.ScrollSpy(document.body, {
      target: "#mainNav",
      rootMargin: "0px 0px -40%",
    });
  }

  // Collapse responsive navbar when toggler is visible
  const navbarToggler = document.body.querySelector(".navbar-toggler");
  const responsiveNavItems = [].slice.call(
    document.querySelectorAll("#navbarResponsive .nav-link")
  );
  responsiveNavItems.map(function (responsiveNavItem) {
    responsiveNavItem.addEventListener("click", () => {
      if (window.getComputedStyle(navbarToggler).display !== "none") {
        navbarToggler.click();
      }
    });
  });

  // Activate SimpleLightbox plugin for portfolio items
  new SimpleLightbox({
    elements: "#portfolio a.portfolio-box",
  });
});

let logined = false;

const loginModal = new bootstrap.Modal(document.getElementById("login"));
const loginForm = document.querySelector("#loginForm");
loginForm.addEventListener("submit", (event) => {
  event.preventDefault();

  let id = document.querySelector("input[id='logined-id']").value;
  let pwd = document.querySelector("input[id='logined-password']").value;

  console.log(id + " " + pwd);
  if (id === "ssafy" && pwd === "1234") {
    logined = true;
    loginModal.hide();

    document.querySelector("#join-nav").classList.add("d-none");
    document.querySelector("#login-nav").classList.add("d-none");
    document.querySelector("#mypage-nav").classList.remove("d-none");
    document.querySelector("#logout-nav").classList.remove("d-none");

    document.querySelector("#loginFailMessage").classList.add("d-none");
    loginModal.hide();
  } else {
    document.querySelector("#loginFailMessage").classList.remove("d-none");
  }
});

document.querySelector("#findPwdLink").addEventListener("click", () => {
  document.querySelector("#find-id").value = "";
  document.querySelector("#foundPwd").classList.add("d-none");
  document.querySelector("#idNotExist").classList.add("d-none");
});

document.querySelector("#findPwdForm").addEventListener("submit", (event) => {
  event.preventDefault();

  let findId = document.querySelector("#find-id").value;
  // 아이디 존재 안하면
  if (findId !== "ssafy") {
    document.querySelector("#foundPwd").classList.add("d-none");
    document.querySelector("#idNotExist").classList.remove("d-none");
  } else {
    // 아이디 존재하면
    document.querySelector("#idNotExist").classList.add("d-none");
    document.querySelector("#foundPwd").classList.remove("d-none");
  }
});
