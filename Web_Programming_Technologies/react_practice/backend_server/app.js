const http = require('http');
const server = http.createServer((req, res)=>{
    if(req.url === '/' && req.method === 'GET'){
        res.writeHead(200, {'Content-Type' : 'text/html'});
        res.end('<h1>Welcome to the Home Page</h1>');
    }
})

server.listen(3000, ()=> console.log("Server is listening on port on 3000"));