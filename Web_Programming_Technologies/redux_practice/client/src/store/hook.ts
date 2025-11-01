import { useSelector, useDispatch } from "react-redux";
import { type AppDispatch, type AppStore, type RootState } from "./store";

export const useAppDispatch = useDispatch.withTypes<AppDispatch>();
export const useAppSelector = useSelector.withTypes<RootState>();