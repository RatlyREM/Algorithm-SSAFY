var a = document.querySelectorAll(".like-btn");
var b = document.querySelectorAll(".moive__info_box");

a.forEach((element,index) => {
    element.addEventListener("click", function() {
        handler(index);
    });
});


function handler(i) {
    const [title, genre, director, runningTime] = b[i].innerText.split("\n\n");

    console.log(title + "\n"+  genre + "\n" + director + "\n" + runningTime + "\n찜");
}

