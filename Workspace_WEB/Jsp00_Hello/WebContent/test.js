
setTimeout(" ... ", 1000) // 코드를 문자열로 넘김
setTimeout(function() { ... }, 1000); // 함수로 작성해서 넘김

elt.setAttribute("onclick", "...") // 코드를 문자열로 넘김
elt.addEventListener("click", function() { ... }, false); // 함수로 작성해서 넘김
