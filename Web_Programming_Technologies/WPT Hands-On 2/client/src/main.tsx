import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import Displayer from './Pages/Displayer.tsx'
import { createBrowserRouter, RouterProvider } from 'react-router'
import 'bootstrap/dist/css/bootstrap.min.css';
import Delete from './Pages/Delete.tsx'
import Changer from './Pages/Changer.tsx'
const router = createBrowserRouter([
  {
    path : '/',
    element : <Displayer />
  },
  {
    path : '/post',
    element : <App />
  },
  {
    path : '/del',
    element : <Delete />
  },
  {
    path : '/put',
    element : <Changer />
  }
])

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={router}>
    </RouterProvider>
  </StrictMode>,
)
