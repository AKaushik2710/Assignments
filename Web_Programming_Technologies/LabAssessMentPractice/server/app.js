const express = require('express');
const app = express();
require('dotenv').config();
const cors = require('cors');
const db = require('./db');

app.use(express.json());
app.use(express.urlencoded({extended : true}));;
app.use(cors());

app.get('/', async(req, res)=>{
    const q = 'select * from books';
    db.query(q, (err, data)=>{
        if(err){
            res.status(500).json({error : 'Error Found in Get'});
        }
        res.status(200).json(data);
    })
})

app.get('/:id', async(req, res)=>{
    const {id} = req.params;
    const q = 'select * from books where id=?'
    db.query(q, parseInt(id), (err, data)=>{
        if(err){
            console.log(err);
            res.status(500).json({error : 'Error occurred in single get'});
        }
        res.status(200).json(data);
    })
})

app.post('/', async(req, res)=>{
    const {id, title, author, pub, genre, avail} = req.body;
    const q = 'insert into books values(?,?,?,?,?, ?)';
    db.query(q, [parseInt(id), title, author, parseInt(pub), genre, Boolean(avail)], (err, data)=>{
        if(err){
            console.log(err);
            res.status(500).json({error : 'Error occurred in Post'});
        }
        res.status(201).json(data);
    })
})

app.put('/:id', async(req, res)=>{
    const {id} = req.params;
    const {title, author, pub, genre, avail} = req.body;
    const q = 'update books set title=?, author=?, pub=?, genre=?, avail=? where id=?';
    db.query(q, [title, author, parseInt(pub), genre, Boolean(avail), parseInt(id)], (err, data)=>{
        if(err){
            console.log(err);
            res.status(500).json({error : "Error occurred in put"});
        }
        res.status(200).json(data);
    })
})

app.delete('/:id', async(req, res)=>{
    const {id} = req.params;
    const q = 'delete from books where id=?';
    db.query(q, parseInt(id), (err, data)=>{
        if(err){
            res.status(500).json({error : "Error Ocurred in Delete"});
        }
        res.status(200).json(data);
    })
})

app.listen(3000, console.log("Running"));