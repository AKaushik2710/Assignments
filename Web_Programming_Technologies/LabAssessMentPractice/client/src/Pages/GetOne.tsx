import {useState, useRef} from 'react';
import type {BookProps} from '../App'
import axios from 'axios';

export default function GetOne(){
    const [book, seBook] = useState<BookProps | null>(null);
    const idRef = useRef<HTMLInputElement>(null);
    async function getOneHandler(){
        const db = axios.get(`http://localhost:3000/${idRef.current!.value}`);
        db.then(e => {
            console.log(e.data);
            seBook(e.data[0])});
    }

    return <div className="container-fluid vh-100">
        <div className="row h-100">
            <div className="col-3 h-100">
                <div className="row h-20"></div>
                <div className="row h-20">
                    <div className="col-4"></div>
                    <div className="col-4">
                        <button className="btn btn-primary">Home</button>
                    </div>
                </div>
            </div>
            <div className="col-6 h-100">
                <div className='row h-25'></div>
                <div className='row h-25 bg-danger'>
                    <label className="form-label" htmlFor="id"></label>
                    <input className='form-control' name="id" placeholder="Enter Id..." ref={idRef} type="number"></input>
                    <button className="btn btn-primary" onClick={getOneHandler}>Get</button>
                </div>
                <div className="row h-50">
                    <div className="col-2">{book?.id}</div>
                    <div className="col-2">{book?.title}</div>
                    <div className="col-2">{book?.author}</div>
                    <div className="col-2">{book?.genre}</div>
                    <div className="col-2">{book?.pub}</div>
                    {/* <div className="col-2"></div> */}
                </div>
            </div>
        </div>
    </div>
}