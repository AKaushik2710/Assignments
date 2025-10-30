const btn = document.getElementById("add");

btn.addEventListener("click", ()=>{
    let task = document.querySelector("input").value;
    if(task===""){
        alert("Please enter a task");
    }
    else{
        let li = document.createElement("li");
        li.innerHTML = task;
        let workBtns = document.createElement("span");
        let check = document.createElement("input");
        check.setAttribute("type", "checkbox");
        console.log(check);
        check.addEventListener("change", ()=>{
            if(check.checked){
                li.style.textDecoration = "line-through";
            }
            else{
                li.style.textDecoration = "none";
            }
        })
        let delBtn = document.createElement("button");
        delBtn.innerHTML = "Delete";
        workBtns.append(check);
        delBtn.addEventListener("click",()=>{
            li.remove();
        })
        workBtns.append(delBtn);
        li.append(workBtns);
        document.getElementById("tasklist").append(li);
        document.querySelector("input").value = "";
    }
})