import { Search } from '@mui/icons-material';
import './App.css';
import AllPosts from './Pages/AllPosts';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Create from './Pages/Create';
import Navbar from './components/Navbar';
import Edit from './Pages/Edit';

function App() {
  return (
  <>
   <BrowserRouter>
   <Navbar/>
   <Routes>
   <Route path='/' element={<AllPosts/>}/>
   <Route path="/create" element={<Create />} />
   <Route path="/edit" element={<Edit />} />
   </Routes>
   </BrowserRouter> 
  </>
  );
}

export default App;
