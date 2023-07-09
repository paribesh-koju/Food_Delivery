const buttons = document.querySelectorAll(".bull");
const content = document.querySelectorAll(".dashboard-content");

buttons.forEach((btn, i) => {
    btn.addEventListener("click", (e) => {
        e.preventDefault();
        console.log(buttons[i].textContent);
        content.forEach((box, j) => {
            if (j == i) {
                content[j].classList.remove("hidden");
            } else {
                box.classList.add("hidden");
            }
        });
    });
});