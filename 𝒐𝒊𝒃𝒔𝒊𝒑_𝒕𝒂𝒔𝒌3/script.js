let input = document.getElementById("input");
let text = document.querySelector(".text");

function Save(){
    if (input.value == "") {
        alert("Please Enter the Task")
    } else {
        let newEle = document.createElement("li");
        newEle.innerHTML = `${input.value} <i class="fa-sharp fa-solid fa-square-xmark"></i>`;
        text.appendChild(newEle);
        input.value="";
        newEle.querySelector("i").addEventListener("click" , remove);

        function remove(){
            newEle.remove();
        }

    }
   
   

}