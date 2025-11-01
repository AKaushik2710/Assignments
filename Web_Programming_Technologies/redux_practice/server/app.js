const express = require('express');
const app = express();
const cors  = require('cors');
require('dotenv').config();
const {db, dbQuery} = require('./db');
const port  = process.env.PORT || 3000;

app.use(express.json());
app.use(cors());
app.use(express.urlencoded({ extended : true}));

app.get('/employees', async(req, res)=>{
    db.query(dbQuery.getter, (err, results)=>{
        console.log(dbQuery.getter

        );
        if(err){
            return res.status(500).json({ error : `Database did not send data due to ${err.cause}`});
        }
        return res.status(200).json(results);
    })
});

app.post('/employees', async(req, res)=>{
    const {id, name, age, city} = req.body;
    db.query(dbQuery.setter, [id, name, age, city], (err, results)=>{
        if(err){
            return res.status(500).json({error : `Could not  insert data due to ${err.cause}`});
        }
        return res.status(201);
    })
});

app.listen(port, ()=>{
    console.log('Server is running on port', port);
})