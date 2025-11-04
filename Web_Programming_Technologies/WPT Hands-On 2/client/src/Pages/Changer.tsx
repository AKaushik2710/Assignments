import axios from 'axios';
import { useRef, useState } from 'react'
import { useNavigate } from 'react-router';
export default function Changer() {
  const idRef = useRef<HTMLInputElement>(null);
  const nameRef = useRef<HTMLInputElement>(null);
  const emailRef = useRef<HTMLInputElement>(null);
  const courseRef = useRef<HTMLSelectElement>(null);
  const addressRef = useRef<HTMLInputElement>(null);
  const mobRef = useRef<HTMLInputElement>(null);
  const dobRef = useRef<HTMLInputElement>(null);
  const navigate = useNavigate();

  async function handleChange(){
    axios.put(`http://localhost:3000/${idRef.current?.value}`, {name : nameRef.current?.value,
        email : emailRef.current?.value, course : courseRef.current?.value,
        address : addressRef.current?.value, mob : mobRef.current?.value, dob : dobRef.current?.value
    }).then(()=> navigate('/'));
  }
  return (
    <>
    <div className='container-fluid vh-100'>
      <div className='h-100'>
        <div className='row h-100'>
          <div className='col-3 bg-warning'></div>
          <div className='col-6 bg-primary h-100'>
            <label htmlFor='id' className='form-label'>ID</label>
        <input name='id' type='number'ref={idRef} className='form-control'></input>
            <label htmlFor='name' className='form-label'>Name</label>
        <input name='name' type='text'ref={nameRef} className='form-control'></input>
        <label htmlFor='email' className='form-label'>Email</label>
        <input name='email' type='email' ref={emailRef} className='form-control'></input>
        <label htmlFor='course' className='form-label'>Course</label>
        <select name='course' ref={courseRef} className='form-control'>
          <option>DAC</option>
          <option>DBDA</option>
          <option>HPC</option>
        </select>
        <label htmlFor='address' className='form-label'>Address</label>
        <input name='address' type='text' ref={addressRef} className='form-control'></input>
        <label htmlFor='mobile' className='form-label'>Mobile</label>
        <input name='mobile' type='phone' ref={mobRef} className='form-control'></input>
        <label htmlFor='dob' className='form-label'>Date of Birth</label>
        <input name='dob' type='date' ref={dobRef} className='form-control'></input>
        <div className='row mt-4'>
          <div className='col-5'></div>
          <div className='col-3'>
            <button className='btn btn-warning' onClick={handleChange}>Put Data</button>
          </div>
        </div>
          </div>
          <div className='col-3 bg-warning'></div>
        </div>
        
      </div>
    </div>
      
    </>
  )
}
