const express = require('express');
const app = express();
require('dotenv').config();
const db = require('./db');
const cors = require('cors');

app.use(express.json());
app.use(express.urlencoded({extended : true}));
app.use(cors());

app.get('/', async(req, res)=>{
    const q = 'select * from stud';
    db.query(q, (err, results)=>{
        if(err){
            console.log('Eror over here')
            res.status(500).json({error: `Following error occured ${err}`});
        }
        res.status(200).json(results);
    })
})

app.get('/getId', async(req, res)=>{
    const q = 'select  id from stud order by  id  desc limit 1';
    db.query(q, (err, data)=>{
        if(err){
            res.status(500).json({error : `Following error occured ${err}`})
        }
        res.status(200).json(data);
    })
})
app.post('/', async(req, res)=>{
    console.log("Call Getting through");
    const {id, name, email, course, address, mob, dob} = req.body;
    console.log(id, name, email, course, address, mob, dob);
    const q = 'insert into stud values(?, ?, ?, ?, ?, ?, ?)';
    db.query(q, [parseInt(id), name, email, course, address, parseInt(mob), dob], (err,data)=>{
        if(err){
            console.log(err);
            res.status(500).json({error: `Following error occured ${err}`});
        }
        res.status(200).json(data);
    })
})

app.put('/:id', async(req, res)=>{
    const {id} = req.params;
    const {name, email, course, address, mob, dob} =  req.body;
    const q = 'update stud set name=?, email=?, course=?, address=?, mob=?, dob=? where id=?';
    db.query(q, [name, email, course, address, mob, dob, id], (err, data)=>{
        if(err){
            res.status(500).json({error: `Following error occured ${err}`});
        }
        console.log(data,"This is ID--->", id);
        res.status(200).json(data);
    })
})

app.delete('/:id', async(req, res)=>{
    const {id} = req.params;
    const q = 'delete from stud where id=?';
    db.query(q, id, (err, data)=>{
        if(err){
            res.status(500).json({error: `Following error occured ${err}`});
        }
        res.status(200).json(data);
    })
});

app.listen(3000, console.log('Running'));