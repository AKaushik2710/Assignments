import { createAsyncThunk } from "@reduxjs/toolkit";
import type { UserState } from "./userSlice";
// import { UserState } from "./userSlice";

export const fetchUsers = createAsyncThunk(
    'users/employees',
    async (_, thunkAPI)=>{
        try{
            const response = await fetch(`${import.meta.env.VITE_API_URL}/employees`);
            const data = await response.json();
            return data;
        }
        catch(err){
            thunkAPI.rejectWithValue("Error occured while fetching");
        }
    }
)

export const fetchOneUser = createAsyncThunk(
    'users/fetchOneUser',
    async(id : number, thunkAPI)=>{
        try{
            const data = await fetch(`${import.meta.env.VITE_API_URL}/employees/${id}`);
            const res = await data.json();
            return res;
        }
        catch(err){
            return thunkAPI.rejectWithValue("Error occured while fetching one user");
        }
    }
)
export const addUser = createAsyncThunk(
    'users/addUser',
    async(user : UserState, thunkAPI)=>{
        try{
            const response = await fetch(`${import.meta.env.VITE_API_URL}/employees`,{
                method : "POST",
                headers : {
                    'Content-Type' : 'application/json'
                },
                body : JSON.stringify(user)
            });
            const data = await response.json();
            return data;
        }
        catch(err){
            return thunkAPI.rejectWithValue("Error occurred while adding user");
        }
    }
)

export const changeUser = createAsyncThunk(
    'users/changeUser',
    async(user : UserState, thunkAPI)=>{
        try{
            const response = await fetch(`${import.meta.env.VITE_API_URL}/employees/${user.id}`,{
                method : "PUT",
                headers : {
                    'Content-Type' : 'application/json'
                },
                body : JSON.stringify(user)
            });
            const data = await response.json();
            return data;
        }
        catch(err){
            return thunkAPI.rejectWithValue('Error occurred while changing user');
        }
    }
)

export const deleteUser = createAsyncThunk(
    'users/deleteUser',
    async(id : number, thunkAPI)=>{
        try{
            const data = await fetch(`${import.meta.env.VITE_API_URL}/employees/${id}`,{
                method : "DELETE"
            });
            const res = await data.json();
            return res;
        }
        catch(err){
            return thunkAPI.rejectWithValue("Error occurred while deleting user");
        }
    }
)