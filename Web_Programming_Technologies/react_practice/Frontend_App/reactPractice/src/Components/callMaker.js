import axios from "axios";

const callMaker = {
    getAll : async()=>{
        const data =  await axios.get('http://localhost:3000/employees');
        return data.data;
    },
    getById : async(id)=>{
        const data = await axios.get(`http://localhost:3000/employees/${id}`);
        return data.data;
    },
    postOne : async(myObj)=>{
        const data = await axios.post('http://localhost:3000/employees', myObj);
        return callMaker.getAll();
    },
    putOne : async(id, myObj)=>{
        const data = await axios.put(`http://localhost:3000/employees/${id}`,myObj);
        return callMaker.getAll();
    },
    deleteOne : async(id)=>{
        const data = await axios.delete(`http://localhost:3000/employees/${id}`);
        return callMaker.getAll();
    }
}

export default callMaker;