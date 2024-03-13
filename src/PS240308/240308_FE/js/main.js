var a = document.querySelectorAll(".like-btn");
var b = document.querySelectorAll(".moive__info_box");
var t = document.getElementById("text");
var count = 0;

//순회하며 버튼이 눌렸는지 확인
a.forEach((element,index) => {
    element.addEventListener("click", function() {
        handler(index);
    });
});

function handler(i) {
    const [title, genre, director, runningTime] = b[i].innerText.split("\n\n");

    let movie = {
        t: title,
        g: genre,
        d: director,
        r: runningTime,
    }

    localStorage.setItem(count, JSON.stringify(movie));
    count+=1;

    t.innerText = "";
    for(var i=0; i<count; i++) {
        let temp = JSON.parse(localStorage.getItem(i));

        t.innerText += temp.t + " | " + temp.g + " | " + temp.d + " | " + temp.r + "\n";
    }
}

