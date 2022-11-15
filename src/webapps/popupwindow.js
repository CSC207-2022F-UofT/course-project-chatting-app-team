var btn = document.getElementById("open_btn");
var div = document.getElementById("background");
var close = document.getElementById("close-button");

btn.onclick = function show() {
  console.log("shit");
  div.style.display = "block";
};

close.onclick = function close() {
  console.log("shit");
  div.style.display = "none";
};

window.onclick = function close(e) {
  if (e.target == div) {
    console.log("shit");
    div.style.display = "none";
  }
};
