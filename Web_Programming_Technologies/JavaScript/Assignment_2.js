
let startBtn = document.getElementById("startBtn");
let stopBtn = document.getElementById("stopBtn");
const container = document.getElementById("time");
let timer=null;
let t = 0;
function startTimer(){
    let timeVal = document.getElementById("timer").value != '' ? parseInt(document.getElementById("timer").value) : container.innerHTML.split(':')[1];
    document.getElementById("timer").value = '';
    timer = setInterval(()=>{
        if(timeVal > 0){
            timeVal--;
            container.innerHTML = `Time Left : ${timeVal} seconds`;
            console.log(`Time Left: ${timeVal} seconds`);
        }
        else{
            clearInterval(timer);
            container.innerHTML = "Time's up!";
            console.log("Time's up!");
        }
    },1000);
}
startBtn.addEventListener("click", startTimer);
stopBtn.addEventListener("click", ()=>{
    clearInterval(timer);
    t = container.innerHTML.split(':')[1];
    container.innerHTML = `Timer Stopped at : ${container.innerHTML.split(':')[1]}`;
    console.log("Timer Stopped");
})