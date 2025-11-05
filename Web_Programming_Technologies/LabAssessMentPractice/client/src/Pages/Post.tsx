import {useRef} from 'react';
import {useNavigate} from 'react-router';
import axios from 'axios';

export default function Post(){
    const idRef = useRef<HTMLInputElement>(null);
    const titleRef = useRef<HTMLInputElement>(null);
    const pubRef = useRef<HTMLInputElement>(null);
    const genreRef = useRef<HTMLInputElement>(null);
    const availRef = useRef<HTMLSelectElement>(null);
    const authorRef = useRef<HTMLInputElement>(null);

    const navigate = useNavigate();
    async function handlePost(){
        await axios.post('http://localhost:3000/', {
            id : idRef.current!.value,
            title : titleRef.current!.value,
            author : authorRef.current!.value,
            pub : pubRef.current!.value,
            genre : genreRef.current!.value,
            avail : availRef.current!.value === "true"
        });
    }

    return <div className="container-fluid vh-100">
        <div className="row w-100 h-100">
            <div className="h-100 col-3">

            </div>
            <div className="col-6 h-100">
                <label htmlFor="id" className="form-label">ID</label>
                <input name="id" type="number" className="form-control" ref={idRef}></input>
                <label htmlFor="title" className="form-label">ID</label>
                <input name="title" type="text" maxLength={40} className="form-control" ref={titleRef}></input>
                <label htmlFor="author" className="form-label">ID</label>
                <input name="author" type="text" className="form-control" ref={authorRef}></input>
                <label htmlFor="pub" className="form-label">ID</label>
                <input name="pub" type="number" maxLength={4} className="form-control" ref={pubRef}></input>
                <label htmlFor="genre" className="form-label">ID</label>
                <input name="genre" type="text" className="form-control" ref={genreRef}></input>
                <select ref={availRef} className="form-select">
                    <option value='true'>Available</option>
                    <option value='false'>Not Available</option>
                </select>

                <button className="btn btn-primary" onClick={()=>handlePost().then(()=> navigate('/'))}>Post</button>
            </div>
        </div>
    </div>
}