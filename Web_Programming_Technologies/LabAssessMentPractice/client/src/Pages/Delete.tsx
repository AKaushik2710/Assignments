import { useRef} from 'react';
import {useNavigate} from 'react-router';
// import type {BookProps} from '../App'
import axios from 'axios';

export default function Delete(){
    // const [book, seBook] = useState<BookProps | null>(null);
    const idRef = useRef<HTMLInputElement>(null);
    const navigate = useNavigate();
    async function delOneHandler(){
        await axios.delete(`http://localhost:3000/${idRef.current!.value}`);
    }

    return <div className="container-fluid vh-100">
        <div className="row h-100">
            <div className="col-3 h-100"></div>
            <div className="col-6 h-100">
                <div className='row h-25'></div>
                <div className='row h-25 bg-danger'>
                    <label className="form-label" htmlFor="id"></label>
                    <input className='form-control' name="id" placeholder="Enter Id..." ref={idRef} type="number"></input>
                    <button className="btn btn-primary" onClick={()=>delOneHandler().then(()=> navigate('/'))}>Delete</button>
                </div>
                {/* <div className="row h-50">
                    <div className="col-2">{book?.id}</div>
                    <div className="col-2">{book?.title}</div>
                    <div className="col-2">{book?.author}</div>
                    <div className="col-2">{book?.genre}</div>
                    <div className="col-2">{book?.pub}</div>
                    {/* <div className="col-2"></div> 
                 </div>  */}
            </div>
        </div>
    </div>
}