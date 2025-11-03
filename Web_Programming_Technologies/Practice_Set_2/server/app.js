const express = require('express');
const app = express();
require('dotenv').config();
const db = require('./db');
const cors = require('cors');

app.use(express.json());
app.use(express.urlencoded({extended : true}));
app.use(cors());

app.get('/', async(req, res)=>{
    const q = 'select * from exp';
    db.query(q, (err, data)=>{
        if(err) res.status(500).json({error : "Data Not found"});
        res.status(200).json(data);
    })
});

app.post('/', async(req, res)=>{
    const {id, exp, cat, descrip, expDate} = req.body;
    const q = 'insert into exp values(?,?,?,?,?)'
    db.query(q, [id, exp, cat, descrip, expDate], (err, data)=>{
        if(err) res.status(500).json({error : "Unable To Post"});
        res.status(201).json(data);
    })
})

app.put('/', async(req, res)=>{
    const {id, exp, cat, descrip, expDate} = req.body;
    console.log(exp, cat, descrip, expDate, id);
    const q = 'update exp set exp=?, cat=?, descrip=?, expDate=? where id=?';
    db.query(q, [exp, cat, descrip, expDate, id], (err, data)=>{
        if(err){
            res.status(500).json({error : "Error Occured while changing data"});
        }
        res.status(200).json(data);
    })
})
app.delete('/:id', async(req,res)=>{
    const {id} = req.params;
    const q = 'delete from exp where id = ?';
    db.query(q, id, (err, data)=>{
        if(err) res.status(500).json({error : "Data Not found for deletion"});
        res.status(200).json(data);
    })
})
app.listen(3000, console.log("Running"));