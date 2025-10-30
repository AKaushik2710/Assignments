import axios from "axios";
import { useState, useRef, useEffect } from "react";
import callMaker from "./callMaker";
export default function EmpApp() {
    const [data, setData] = useState([]);
    const inRef = useRef(null);
    const idRef = useRef(null);
    const nameRef = useRef(null);
    const addRef = useRef(null);
    const salRef = useRef(null);
    
    async function fetchData(){
        try{
            const response = callMaker.getAll();
            response.then(e => setData(e));
        }
        catch(err){
            console.error("Error occured : ", err);
        }
    }

    async function fetchOne(){
        try{
            console.log("Calling");
            const response = callMaker.getById(inRef.current.value);
            
            response.then(e => setData([e]));
        }
        catch(err){
            console.error("Error occured : ", err);
        }
    }

    async function postOne(){
        try{
            const response = callMaker.postOne({id : idRef.current.value, name : nameRef.current.value, address : addRef.current.value, salary : salRef.current.value});
            response.then(e => {
                setData(e);
            });
        }
        catch(err){
            console.error("Error occured : ", err);
        }
    }

    async function putOne(){
        try{
            const response = callMaker.putOne(inRef.current.value,{id : idRef.current.value, name : nameRef.current.value, address : addRef.current.value, salary : salRef.current.value});
            response.then(e => {
                setData(e);
            });
        }
        catch(err){
            console.log(err);
        }
    }
    async function deleteOne(){
        try{
            const response = callMaker.deleteOne(inRef.current.value);
            response.then(e => {
                setData(e);
            });
        }
        catch(err){
            console.log(err);
        }
    }
    return (
        <div>
            <h2>Welcome again</h2>
            <div>
                <div><input ref={inRef} type="number" id="ipone" placeholder="enter finder Id" /></div>
                <div>
                    <input ref={idRef} type="number" id="ipone" placeholder="enter Id" />
                    <input ref={nameRef} type="text" id="ipone" placeholder="enter name" />
                    <input ref={addRef} type="text" id="ipone" placeholder="enter address" />
                    <input ref={salRef} type="number" id="ipone" placeholder="enter salary" />
                </div>
            </div>
            <div style={{display : "flex"}}>
                <button onClick={fetchData}>Fetch!!</button>
                <button onClick={fetchOne}>Get One!!</button>
                <button onClick={postOne}>Post One</button>
                <button onClick={putOne}>Put One</button>
                <button onClick={deleteOne}>Delete One</button>
                </div>
            
            {data && data.map((emp)=>{
                return <div key={emp.id}> {emp.name} </div>;
            })}
        </div>
    )
}