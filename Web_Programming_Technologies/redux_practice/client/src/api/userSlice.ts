import { createSlice, type PayloadAction } from "@reduxjs/toolkit";
import { fetchOneUser, fetchUsers, deleteUser, changeUser, addUser }  from "./userCalls";
import { act } from "react";
export interface UserState{
    id : number,
    name : string,
    address : string,
    salary : number
}
const initialState : UserState[] = [];

const usersSlice = createSlice({
    name : "users",
    initialState,
    reducers : {
    },
    extraReducers : (builder)=>{
        builder
        .addCase(fetchUsers.fulfilled, (state, action : PayloadAction<UserState[]>)=>{
            state = action.payload.map(e => e);
            return state;
        })

        .addCase(fetchOneUser.fulfilled, (state, action : PayloadAction<UserState>)=>{
            state = [action.payload];
            return state;
        })

        .addCase(addUser.fulfilled, (state, action : PayloadAction<UserState>)=>{
            state.push(action.payload);
            console.log(state);
            // return state;
        })

        .addCase(changeUser.fulfilled, (state, action : PayloadAction<UserState>)=>{
            state.map((user)=>{
                if(user.id === action.payload.id){
                    return action.payload;
                }
                return user;
            })
            return state;
        })

        .addCase(deleteUser.fulfilled, (state, action:PayloadAction<number>)=>{
            return state.filter(user => user.id !== action.payload);
        })
    }
})

export default usersSlice.reducer;