import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import axios from 'axios'
import './App.css'

export interface BookProps{
  id : number, 
  title : string,
  author : string,
  pub : number,
  genre : string,
  avail : boolean | number
}
function App() {
  const [books, setBooks] = useState<BookProps[]>([]);

  useEffect(()=>{
    (async function GetData(){
      const data = await axios.get('http://localhost:3000');
      if(data.status){
        setBooks(data.data);
      }
    })()
  })

  return (
    <>
      <div className='container-fluid vh-100'>
        <div className='row h-100'>
          <div className="col-3 h-100"></div>
          <div className="col-6 h-100">
            {books.map((book)=>{
              if(book.avail === 1){
              return <div className="row" key={book.id}>
                <div className=" col-2">{book.title}</div>
                <div className=" col-2">{book.author}</div>
                <div className=" col-2">{book.pub}</div>
                <div className=" col-2">{book.genre}</div>
                {/* <div className=" col-2"></div> */}
              </div>}
            })}
          </div>
        </div>
      </div>
    </>
  )
}

export default App
