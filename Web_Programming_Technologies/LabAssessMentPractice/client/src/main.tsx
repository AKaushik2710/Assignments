import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import Put from './Pages/Put.tsx';
import Post from './Pages/Post.tsx';
import Delete from './Pages/Delete.tsx';
import GetOne from './Pages/GetOne.tsx';
import 'bootstrap/dist/css/bootstrap.min.css';
import {createBrowserRouter, RouterProvider} from 'react-router';

const router = createBrowserRouter([
  {
    path : '/',
    element : <App />
  },
  {
    path : '/put',
    element : <Put />
  },
  {
    path : '/post',
    element : <Post />
  },
  {
    path : '/del',
    element : <Delete />
  },
  {
    path : 'getOne',
    element : <GetOne />
  }
])
createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={router}>

    </RouterProvider>
  </StrictMode>,
)
