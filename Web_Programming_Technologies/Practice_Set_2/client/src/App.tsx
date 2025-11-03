import { useEffect, useRef, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

interface expenseProps{
  id : number,
  exp : number,
  cat : string,
  descrip : string,
  expDate : string
}
function App() {
  const [expenses, setExpenses] = useState<expenseProps[]>([]);
  const [count, setCount] = useState<{count : number, putId : number}>({count:1, putId : 0});
  const expRef = useRef<HTMLInputElement>(null);
  const catRef = useRef<HTMLInputElement>(null);
  const desRef = useRef<HTMLTextAreaElement>(null);
  const dateRef = useRef<HTMLInputElement>(null);
  const url = 'http://localhost:3000/'
  useEffect(()=>{
    handleGetAll();
  },[]);
  async function handleGetAll(){
    const data = await fetch(url);
    const res = data.json();
    res.then(e => {
      setExpenses(e)
    });
  }

  async function handlePost(){
    const data = await fetch(url, {
      method : 'POST',
      headers : {'Content-Type' : 'application/json'},
      body : JSON.stringify({
        id : count.count, exp : expRef.current?.value, cat : catRef.current?.value, descrip : desRef.current?.value, expDate : dateRef.current?.value
      })
    });
    const res = data.json();
    res.then(() =>{
      handleGetAll();
      setCount(prev => {return {...prev, count : prev.count+1}})
      makeInpEmpty(parseInt(""),"","","");
    })
  }

  async function handleDel(id : number){
    const data = await fetch(`${url}${id}`, {
      method : "DELETE"
    });
    const res = data.json();
    res.then(()=> handleGetAll());
  }

  async function handlePut(){
    console.log("Put is going");
    const data = await fetch(url, {
      method : 'PUT',
      headers : {'Content-Type':'application/json'},
      body : JSON.stringify({
        id : count.putId, exp : expRef.current?.value, cat : catRef.current?.value, descrip : desRef.current?.value, expDate : dateRef.current?.value 
      })
    });
    const res = data.json();
    res.then(()=>{
      setCount(prev => {
        return {...prev, putId : 0};
      })
      makeInpEmpty(parseInt(""),"","","");
      handleGetAll();
    })
  }
  function makeInpEmpty(exp : number, cat : string, descrip : string, expDate : string){
    expRef.current!.value = `${exp}`;
    catRef.current!.value = `${cat}`;
    desRef.current!.value = `${descrip}`;
    dateRef.current!.value = `${expDate}`;
  }
  return (
    <>
      <div className="container-fluid">
        <div className="row">
          <div className="col-2">
            <label htmlFor='amount' className='form-label'>Expense</label>
            <input name='amount' className='form-control' type='number' ref={expRef} placeholder='Enter the amount'></input>
          </div>
          <div className='col-2'>
            <label htmlFor='category' className='form-label'>Expense</label>
            <input name='category' className='form-control' type='text' ref={catRef} placeholder='Enter the category'></input>
          </div>
          <div className='col-3'>
            <label htmlFor='desc' className='form-label'>Description</label>
            <textarea name='desc' className='form-control' ref={desRef} placeholder='Tell me...'></textarea>
          </div>
          <div className='col-3'>
            <label htmlFor='date' className='form-label'>Expense</label>
            <input name='date' className='form-control' type='date' ref={dateRef} placeholder='Enter the date'></input>
          </div>
          <button className='btn btn-primary col-1 p-1' onClick={()=>{
            count.putId===0 ?  handlePost() : handlePut();
          }}>Send</button>
        </div>
          {expenses.map((e : expenseProps) =>{
            return <div className='row' key={e.id} onClick={(f)=>{
              f.stopPropagation();
              setCount({...count, putId : e.id});
              // expRef.current!.value = `${e.exp}`;
              // catRef.current!.value = `${e.cat}`;
              // desRef.current!.value = `${e.descrip}`;
              // dateRef.current!.value = `${e.expDate}`;
              makeInpEmpty(e.exp, e.cat, e.descrip,  new Date(e.expDate).toISOString().split('T')[0]);
            }}>
              <div className='col-4'>{e.descrip}</div>
              <div className='col-2'>{e.cat}</div>
              <div className='col-2'>{e.exp}</div>
              <div className='col-2'>{e.expDate}</div>
              <button className='btn btn-danger col-2' onClick={(f)=> {
                f.stopPropagation();
                handleDel(e.id)}}>Del</button>
            </div>
          })}
      </div>
    </>
  )
}

export default App
