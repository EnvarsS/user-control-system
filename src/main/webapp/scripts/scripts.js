document.addEventListener("DOMContentLoaded", () => {
    // Smooth fade-in effect for containers
    const containers = document.querySelectorAll(".container");
    containers.forEach(c => {
        c.style.opacity = 0;
        setTimeout(() => {
            c.style.transition = "opacity 1s ease";
            c.style.opacity = 1;
        }, 200);
    });

    // Button click animation
    const buttons = document.querySelectorAll("button, .btn");
    buttons.forEach(btn => {
        btn.addEventListener("click", e => {
            btn.classList.add("clicked");
            setTimeout(() => btn.classList.remove("clicked"), 200);
        });
    });
});
