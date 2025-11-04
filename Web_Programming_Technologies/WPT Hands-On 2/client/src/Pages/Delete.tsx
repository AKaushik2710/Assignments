import axios from "axios";
import { useRef } from "react";
import { useNavigate } from "react-router";

export default function Delete(){
    const idRef = useRef<HTMLInputElement>(null);
    const navigate =  useNavigate();
    async function deleter(){
        axios.delete(`http://localhost:3000/${idRef.current?.value}`).then(()=> navigate('/'));
    }

    return <div className="container-fluid vh-100 bg-warning">
        <div className="row h-100">
            <div className="col-3">
                <div className="row h-50"></div>
                <div className="row h-50">
                    <div className="col-6 h-25">
                        <button className="btn btn-primary" onClick={()=> navigate('/')}>Check Out Data</button>
                    </div>
                </div>
            </div>
            <div className="col-6 h-100">
                <div className="row h-25"></div>
                <div className="row h-50">
                    <div className="col-2"></div>
                    <div className="col-8">
                        <label htmlFor="id" className="form-label mt-4">Id</label>
                <input ref={idRef} className="form-control mt-4" placeholder="Enter Id to be deleted..."></input>
                <button className=" btn btn-primary mt-4" onClick={deleter}>Delete</button>
                    </div>
                </div>
            </div>
            <div className="col-3"></div>
        </div>
    </div>
}