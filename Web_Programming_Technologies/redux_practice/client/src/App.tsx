import { useEffect, useRef } from 'react'
import { useAppDispatch, useAppSelector } from './store/hook'
import './App.css'
import {type UserState } from './api/userSlice'
import { addUser, changeUser, deleteUser, fetchOneUser, fetchUsers } from './api/userCalls'
import {Div, Input, Label, Button} from './Components/Assembler'
function App() {
  const dispatch = useAppDispatch();
  const user = useAppSelector(state => state.users);
  useEffect(()=>{
    dispatch(fetchUsers());
  },[])

  const idRef = useRef<HTMLInputElement>(null);
  const nameRef = useRef<HTMLInputElement>(null);
  const addressRef = useRef<HTMLInputElement>(null);
  const salaryRef = useRef<HTMLInputElement>(null);
      console.log(user);
  return (
    <>
    <Div cn='flex w-full h-lvh'>
      <Div cn="flex w-1/2 flex-col h-lvh justify-center items-center border border-white">
        <Label cn="text-white w-1/2" inpFor='id'>Enter Id:</Label>
        <Input cn="w-1/2 text-white accent-red-300 bg-teal-300 mb-4 p-2 mt-2 rounded-md focus:border focus:border-white focus:text-teal-300 focus:bg-black outline-none" type='number' placeholder='Enter ID...' name='id' ref={idRef}></Input>
        <Label cn="text-white w-1/2" inpFor='name'>Enter Name:</Label>
        <Input cn="w-1/2 text-white accent-red-300 bg-teal-300 mb-4 p-2 mt-2 rounded-md focus:border focus:border-white focus:text-teal-300 focus:bg-black outline-none" type='text' placeholder='Enter Name...' name='name' ref={nameRef}></Input>
        <Label cn="text-white w-1/2" inpFor='address'>Enter Address:</Label>
        <Input cn="w-1/2 text-white accent-red-300 bg-teal-300 mb-4 p-2 mt-2 rounded-md focus:border focus:border-white focus:text-teal-300 focus:bg-black outline-none" type='text' placeholder='Enter Address...' name='address' ref={addressRef}></Input>
        <Label cn="text-white w-1/2" inpFor='salary'>Enter Salary:</Label>
        <Input cn="w-1/2 text-white accent-red-300 bg-teal-300 mb-4 p-2 mt-2 rounded-md focus:border focus:border-white focus:text-teal-300 focus:bg-black outline-none" type='number' placeholder='Enter Salary...' name='salary' ref={salaryRef}></Input>
        <Div cn='flex flex-col justify-around w-2/3 mt-4'>
          <Div cn='flex justify-around w-full'>
            <Button onClick={()=>{
              dispatch(fetchOneUser(parseInt(idRef.current!.value)));
            }} cn='text-green-300 border border-white p-2 rounded-xl hover:bg-green-700 hover:text-white'>Get One!!</Button>
            <Button onClick={()=>{
              dispatch(changeUser({"id" : parseInt(idRef.current!.value), "name" : nameRef.current!.value, "address" : addressRef.current!.value, "salary" : parseInt(salaryRef.current!.value)}));
              dispatch(fetchUsers());
            }} cn='text-yellow-300 border border-white p-2 rounded-xl hover:bg-yellow-300 hover:text-white'>Change One!!</Button>
          </Div>
          <Div cn='flex justify-around w-full mt-4'>
            <Button onClick={()=>{
              dispatch(addUser({"id" : parseInt(idRef.current!.value), "name" : nameRef.current!.value, "address" : addressRef.current!.value, "salary" : parseInt(salaryRef.current!.value)}));
              // dispatch(fetchUsers());
            }} cn='text-blue-500 border border-white p-2 rounded-xl hover:bg-blue-700 hover:text-white'>Add One!!</Button>
            <Button onClick={()=>{
              dispatch(deleteUser(parseInt(idRef.current!.value)));
              dispatch(fetchUsers());
            }} cn='text-red-500 border border-white p-2 rounded-xl hover:bg-red-700 hover:text-white'>Delete One!!</Button>
          </Div>
        </Div>
      </Div>
      <Div cn="flex w-1/2 h-lvh border border-red-500">
      <table className='text-white w-full h-full overflow-auto'>
        <thead>
          <tr>
          <th>Name</th>
          <th>Address</th>
          <th>Salary</th>
        </tr>
        </thead>
        <tbody>
        {user.map((e:UserState)=>{
          return <tr key={e.id} className='border border-white h-[8dvh]'>
            <td className='border border-white text-center'>{e.name}</td>
            <td className='border border-white text-center'>{e.address}</td>
            <td className='border border-white text-center'>{e.salary}</td>
          </tr>
        })}
        </tbody>
      </table>
      </Div>
    </Div>
      {/* {user.map((e : UserState)=>{
        return <div key={e.id}>
          <p className='text-red-700'>{e.name}</p>
          <p>{e.address}</p>
          <p>{e.salary}</p>
        </div>
      })} */}
    </>
  )
}

export default App
