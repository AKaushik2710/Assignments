const mysql = require('mysql2');

const db = mysql.createConnection({
    host : process.env.DB_HOSTT,
    user : process.env.DB_USER,
    password : process.env.DB_PASS,
    database : process.env.DB_NAME
});

db.connect((err)=>{
    if(err){
        console.log('Database connection error due to', err.cause);
    }
    else{
        console.log('Database connected on ', process.env.DB_NAME);
    }

});

const dbQuery =  {
    getter : 'SELECT * FROM EMPLOYEES;',
    setter : 'INSERT INTO EMPLOYEES VALUES (?, ?, ?, ?)',
    updater : 'UPDATE EMPLOYEES SET NAME=?, AGE=?, CITY=? WHERE ID=?',
    deleter : 'DELETE FROM EMPLOYEES WHERE ID=?',
    selector : 'SELECT * FROM EMPLOYEES WHERE ID=?'
}
module.exports = { db, dbQuery };