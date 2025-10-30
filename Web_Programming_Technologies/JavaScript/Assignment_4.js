const arr = [
    {
        src :  "https://media.istockphoto.com/id/517188688/photo/mountain-landscape.jpg?s=612x612&w=0&k=20&c=A63koPKaCyIwQWOTFBRWXj_PwCrR4cEoOw2S9Q7yVl8=",
        cap : "C"
    },
    {
        src : "https://media.istockphoto.com/id/1550071750/photo/green-tea-tree-leaves-camellia-sinensis-in-organic-farm-sunlight-fresh-young-tender-bud.jpg?s=612x612&w=0&k=20&c=RC_xD5DY5qPH_hpqeOY1g1pM6bJgGJSssWYjVIvvoLw=",
        cap : "Breath of Leaves"
    },
    {
        src : "https://static.vecteezy.com/system/resources/previews/054/571/540/non_2x/sunset-nature-free-photo.jpg",
        cap : "The Settling Sun"
    }
]

let count =0;

document.getElementById("prevBtn").addEventListener("click",()=>{
    let pointer = count==3 ? 0 : ++count;
    document.getElementById("imgDisplay").setAttribute("src", arr[pointer].src);
    document.getElementById("caption").innerHTML = arr[pointer].cap;
})

document.getElementById("nextBtn").addEventListener("click", ()=>{
    let pointer = count==0 ? 3 : --count;
    document.getElementById("imgDisplay").setAttribute("src", arr[pointer].src);
    document.getElementById("caption").innerHTML = arr[pointer].cap;
})