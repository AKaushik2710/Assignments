import { useEffect, useRef, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

interface BookProps{
  id : number,
  title : string,
  author : string,
  pub : number,
  genre : string,
  avail : boolean
}
function App() {
  const [books, setBooks] = useState<BookProps[]>([]);
  const idRef = useRef<HTMLInputElement>(null);
  const titleRef = useRef<HTMLInputElement>(null);
  const authorRef = useRef<HTMLInputElement>(null);
  const pubRef = useRef<HTMLInputElement>(null);
  const genreRef = useRef<HTMLInputElement>(null);
  const availabilityRef = useRef<HTMLInputElement>(null);
  const url = 'http://localhost:3000/'
  const [available, setAvail] = useState<boolean>(true);
  useEffect(()=>{
    handleGetAll();
  },[])
  async function handleGetAll(){
    const data = await fetch(url);
    const res = await data.json();
    // const r = res.map((e : BookProps) =>{
    //   return {...e, avail : Boolean(e.avail)};
    // })

    setBooks(res);
  }
  async function handlePost(){
    try{
      if(available){
      const data = await fetch(url, {
        method : "POST",
        headers : {
          'Content-Type' : 'application/json'
        },
        body : JSON.stringify(
          {id : idRef.current?.value, title : titleRef.current?.value, author : authorRef.current?.value, pub : pubRef.current?.value, genre : genreRef.current?.value, avail : available}
        )
      });
      console.log(titleRef.current?.value);
      const res = data.json();
      res.then(e => {
        setBooks(prev => [...prev, e]);
        handleGetAll();
    });
  }
  else{
    alert('Book Not Available');
  }
    }
    catch(err){
      console.log("Error is ",err);
    }
  }

  async function handlePut(){
    const data = await fetch(url, {
      method : "PUT",
      headers : {
        'Content-Type' : 'application/json'
      },
      body : JSON.stringify(
        {id : idRef.current?.value, title : titleRef.current?.value, author : authorRef.current?.value, pub : pubRef.current?.value, genre : genreRef.current?.value, avail : available}
      )
    });
    const res = data.json();
    res.then(() => {
      if(available){
        handleGetAll()
      }
      else{
        handleDel().then(()=> handleGetAll);
      }
    });
  }

  async function handleDel(){
    const data = await fetch(`${url}${idRef.current?.value}`, {
      method : "DELETE"
    });
    const res = data.json();
    res.then(()=>handleGetAll());
  }

  async function handleGetOne(){
    const data = await fetch(`${url}${idRef.current?.value}`);
    const res = await data.json();
    // res.then(e => setBooks([e]));
    setBooks(res);
  }
  return (
    <>
    <div className='vh-100'>
      <div className="container-fluid h-100">
        <div className='row h-100'>
          <div className="col-6 border border-danger">
            <label className='form-label' htmlFor='id'>Id</label>
            <input className='form-control' ref={idRef} name='id' type='number' placeholder="Enter Book's Id"></input>
            <label className='form-label' htmlFor='title'>Title</label>
            <input className='form-control' ref={titleRef} name='title' type='text' placeholder="Enter Book's Title"></input>
            <label className='form-label' htmlFor='author'>Author</label>
            <input className='form-control my-2' ref={authorRef} type='text' name='author' placeholder="Enter Book's Author"></input>
            <label className='form-label' htmlFor='publication'>Publication</label>
            <input className='form-control my-2' ref={pubRef} type='number' placeholder="Enter Book's Title"></input>
            <label className='form-label' htmlFor='genre'>Genre</label>
            <input className='form-control my-2' ref={genreRef} type='text' name='genre' placeholder="Enter Book's Title"></input>
            <div className='row'>
              <div className='form-check col'>
              <input className='form-check-control my-2' checked={available} onChange={()=> setAvail(true)} name='avail' type='radio' value="true" id='avail1' placeholder="Enter Book's Title"></input>
              <label className='form-check-label text-sm' htmlFor='avail1'>Availability</label>
            </div>
            <div className='form-check col'>
              <input className='form-check-control my-2' checked={available===false} onChange={()=> setAvail(false)} name='avail' type='radio' value="false" id='avail2' placeholder="Enter Book's Title"></input>
              <label className='form-check-label' htmlFor='avail2'>Non-Availability</label>
            </div>
            </div>
            <button className='btn btn-primary' onClick={handlePost}>Post</button>
            <button className='btn btn-primary' onClick={handleGetOne}>Get</button>
            <button className='btn btn-primary' onClick={handlePut}>Put</button>
            <button className='btn btn-primary' onClick={handleDel}>Delete</button>
          </div>
          <div className="col-6">
            {books.map((book)=>{
              return <div className='row' key={book.id}>
                <div className='col-3 border-danger border text-center my-2'>{book.title}</div>
                <div className='col-2 border-danger border text-center my-2'>{book.author}</div>
                <div className='col-2 border-danger border text-center my-2'>{book.pub}</div>
                <div className='col-3 border-danger border text-center my-2'>{book.genre}</div>
                <div className='col-2 border-danger border text-center my-2'>{book.avail}</div>
              </div>
              
            })}
          </div>
        </div>
      </div>
      </div>
    </>
  )
}

export default App
