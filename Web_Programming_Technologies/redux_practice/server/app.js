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
        if(err){
            return res.status(500).json({ error : `Database did not send data due to ${err.cause}`});
        }
        return res.status(200).json(results);
    })
});

app.post('/employees', async(req, res)=>{
    const {id, name, age, city} = req.body;
    console.log(id, name, age, city);
    db.query(dbQuery.setter, [id, name, age, city], (err, results)=>{
        if(err){
            return res.status(500).json({error : `Could not  insert data due to ${err.cause}`});
        }
        return res.status(201).json(results);
    })
});

app.get('/employees/:id', async(req, res)=>{
    const {id} = req.params;
    db.query(dbQuery.selector, id, (err, result)=>{
        if(err){
            return res.status(500).json({ error : `Databse did not send data due to ${err.cause}`});
        }
        return res.status(200).json(result);
    })
});

app.put('/employees', async(req, res)=>{
    const {id, name, age, city} = req.body;
    db.query(dbQuery.updater, [name, age, city, id], (err, result)=>{
        if(err){
            return res.status(500).json({error : `Could not update data due to ${err.cause}`});
        }
        return res.status(200).json({message : `User with id ${id} updated successfully`});
    })
})

app.delete('/employees/:id', async(req, res)=>{
    const {id} = req.params;
    db.query(dbQuery.deleter, id, (err, result)=>{
        if(err){
            return res.status(500).json({ error : `Could not delete data due to ${err.cause}`});
        }
        return res.status(200).json({ message : `User with id ${id} deleted successfully`});
    })
})
app.listen(port, ()=>{
    console.log('Server is running on port', port);
})