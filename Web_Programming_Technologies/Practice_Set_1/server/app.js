const express = require('express');
const app = express();
require('dotenv').config();
const db = require('./db');
const cors = require('cors');
app.use(express.json());
app.use(express.urlencoded({extended : true}));
app.use(cors());
app.get('/', async(req, res)=>{
    const q = 'SELECT * FROM books';
    try{
        db.query(q, (err, result)=>{
            if(err) res.status(500).json({error : "Error occured"});
            const fres = result.map(e => {
                return {...e, avail : !!e.avail};
            })
            res.status(200).json(result);
        })
    }
    catch(err){
        console.log(err);
    }
})

app.get('/:id', (req, res)=>{
    const {id} = req.params;
    db.query('SELECT * FROM books where id = ?', id, (err, result)=>{
        if(err) res.status(500);
        res.status(200).json(result);
    })
})
app.post('/', async(req, res)=>{
    const {id,title, author, pub, genre, avail} = req.body;
    console.log(id,title, author, pub, genre, avail);
    const q =  'INSERT INTO books VALUES(?,?,?,?,?,?)';
    db.query(q, [id,title, author, pub, genre, avail], (err, result)=>{
        if(err){
            console.log(err);
            res.status(500).json({error : "Error occured"});
        }
        res.status(201).json(result);
    })
})

app.put('/', (req, res)=>{
    const {id, title, author, pub, genre, avail} = req.body;
    db.query('UPDATE BOOKS SET title=?, author=?, pub=?, genre=?, avail=? WHERE id=?', [title, author, pub, genre, avail, id], (err, result)=>{
        if(err){
            res.status(500).json({error : "Server error"});
        }
        res.status(200).json(result);
    })
})
app.delete('/:id', (req, res)=>{
    const {id} = req.params;
    console.log("Running");
    db.query('DELETE FROM books where id=?', id, (err, result)=>{
        if(err){
            console.log(id);
            res.status(500);
        }
        console.log(id);
        res.status(200).json(result);
    })
})
app.listen(3000, ()=> console.log("Running"));