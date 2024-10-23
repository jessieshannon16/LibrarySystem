import './App.css';
import Icon_button from './components/icon_button';
import Taskbar from './components/taskbar';
import Browse from './pages/Browse'
import CheckIn from './pages/CheckIn'
import CheckOut from './pages/CheckOut'
import BookCard from './components/bookCard';
import { Outlet } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Taskbar className='taskbar'/>
      <Outlet />
    </div>
    
  );
}

export default App;
