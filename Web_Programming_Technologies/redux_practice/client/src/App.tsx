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
  }, [dispatch])

  const idRef = useRef<HTMLInputElement>(null);
  const nameRef = useRef<HTMLInputElement>(null);
  const ageRef = useRef<HTMLInputElement>(null);
  const cityRef = useRef<HTMLInputElement>(null);
      console.log(user);
  return (
    <>
    <Div cn='flex w-full h-lvh'>
      <Div cn="flex w-1/2 flex-col h-lvh justify-center items-center border border-white">
        <Label cn="text-white w-1/2" inpFor='id'>Enter Id:</Label>
        <Input cn="w-1/2 text-white accent-red-300 bg-teal-300 mb-4 p-2 mt-2 rounded-md focus:border focus:border-white focus:text-teal-300 focus:bg-black outline-none" type='number' placeholder='Enter ID...' name='id' ref={idRef}></Input>
        <Label cn="text-white w-1/2" inpFor='name'>Enter Name:</Label>
        <Input cn="w-1/2 text-white accent-red-300 bg-teal-300 mb-4 p-2 mt-2 rounded-md focus:border focus:border-white focus:text-teal-300 focus:bg-black outline-none" type='text' placeholder='Enter Name...' name='name' ref={nameRef}></Input>
        <Label cn="text-white w-1/2" inpFor='age'>Enter Age:</Label>
        <Input cn="w-1/2 text-white accent-red-300 bg-teal-300 mb-4 p-2 mt-2 rounded-md focus:border focus:border-white focus:text-teal-300 focus:bg-black outline-none" type='number' placeholder='Enter Age...' name='age' ref={ageRef}></Input>
        <Label cn="text-white w-1/2" inpFor='city'>Enter City:</Label>
        <Input cn="w-1/2 text-white accent-red-300 bg-teal-300 mb-4 p-2 mt-2 rounded-md focus:border focus:border-white focus:text-teal-300 focus:bg-black outline-none" type='text' placeholder='Enter City...' name='city' ref={cityRef}></Input>
        <Div cn='flex flex-col justify-around w-2/3 mt-4'>
          <Div cn='flex justify-around w-full'>
            <Button onClick={()=>{
              dispatch(fetchOneUser(parseInt(idRef.current!.value)));
            }} cn='text-green-300 border border-white p-2 rounded-xl hover:bg-green-700 hover:text-white'>Get One!!</Button>
            <Button onClick={ async()=>{
              await dispatch(changeUser({"id" : parseInt(idRef.current!.value), "name" : nameRef.current!.value, "age" : parseInt(ageRef.current!.value), "city" : cityRef.current!.value})).unwrap();
              dispatch(fetchUsers());
            }} cn='text-yellow-300 border border-white p-2 rounded-xl hover:bg-yellow-300 hover:text-white'>Change One!!</Button>
          </Div>
          <Div cn='flex justify-around w-full mt-4'>
            <Button onClick={ async()=>{
              await dispatch(addUser({"id" : parseInt(idRef.current!.value), "name" : nameRef.current!.value, "age" : parseInt(ageRef.current!.value), "city" : cityRef.current!.value})).unwrap().then(()=>{
              dispatch(fetchUsers())});
            }} cn='text-blue-500 border border-white p-2 rounded-xl hover:bg-blue-700 hover:text-white'>Add One!!</Button>
            <Button onClick={ async()=>{
              await dispatch(deleteUser(parseInt(idRef.current!.value))).unwrap();
              dispatch(fetchUsers());
            }} cn='text-red-500 border border-white p-2 rounded-xl hover:bg-red-700 hover:text-white'>Delete One!!</Button>
          </Div>
        </Div>
      </Div>
      <Div cn="flex w-1/2 h-lvh border border-red-500 flex-col">
        <table className="text-white w-full">
          <thead className="sticky top-0 bg-black">
            <tr>
              <th className="border border-white w-1/3 py-2">Name</th>
              <th className="border border-white w-1/3 py-2">Age</th>
              <th className="border border-white w-1/3 py-2">City</th>
            </tr>
          </thead>
        </table>
        <Div cn="flex-1 overflow-y-auto">
          <table className="text-white w-full">
            <tbody>
              {user.map((e: UserState) => (
                <tr key={e.id} className="border border-white hover:bg-gray-800">
                  <td className="border border-white text-center py-2 w-1/3 text-red-800">{e.name}</td>
                  <td className="border border-white text-center py-2 w-1/3 text-red-800">{e.age}</td>
                  <td className="border border-white text-center py-2 w-1/3 text-red-800">{e.city}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </Div>
      </Div>
    </Div>
  </>
  )
}

export default App
