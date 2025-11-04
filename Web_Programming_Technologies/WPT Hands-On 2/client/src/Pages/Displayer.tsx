import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router";

interface StudentProps{
    id : number,
    name : string, 
    email : string,
    course : string,
    address : string,
    mob :  number,
    dob : string
}
export default function Displayer(){
    const [students, setStudents] = useState<StudentProps[]>([]);
    const navigate = useNavigate();
    useEffect(()=>{
        (async function(){
            const data = await axios.get('http://localhost:3000/');
            if(data.status){
                console.log(data.data);
                setStudents(data.data);
            };
        })();
    },[]);
    return<>
    <div className="container-fluid vh-100 bg-warning">
        <div className="row h-100">
            <div className="col-2 ">
                <button className="btn btn-primary" onClick={()=> navigate('/post')}>Post</button>
                <button className="btn btn-primary" onClick={()=> navigate('/put')}>Put</button>
            </div>
            <div className="col-8 bg-primary p-0">
                <table className="col-8 border border-2 border-dark w-100">
        <thead>
            <tr>
                <th className="col-2 text-center">Name</th>
                <th className="col-2 text-center">Email</th>
                <th className="col-1 text-center">Course</th>
                <th className="col-3 text-center">Address</th>
                <th className="col-2 text-center">Mobile</th>
                <th className="col-2 text-center">DOB</th>
            </tr>
        </thead>
    </table>
    <table className="border w-100">
        <tbody>
            {students.map(e => {
                return <tr key={e.id} className="mt-6 p-2 border border-2 border-danger ">
                    <td className="col-2 text-center border border-2 border-danger">{e.name}</td>
                    <td className="col-2 text-center border border-2 border-danger">{e.email}</td>
                    <td className="col-1 text-center border border-2 border-danger">{e.course}</td>
                    <td className="col-3 text-center border border-2 border-danger">{e.address}</td>
                    <td className="col-2 text-center border border-2 border-danger">{e.mob}</td>
                    <td className="col-2 text-center border border-2 border-danger">{e.dob.split('T')[0]}</td>
                </tr>
            })}
        </tbody>
    </table>
            </div>
            <div className="col-2">
                <button className="btn btn-primary" onClick={()=> navigate('/getOne')}>Get One</button>
                <button className="btn btn-primary" onClick={()=> navigate('/del')}>Delete</button>
            </div>
        </div>
    </div>
    </>
}