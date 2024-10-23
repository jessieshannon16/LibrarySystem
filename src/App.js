import './App.css';
import Icon_button from './components/icon_button';
import Taskbar from './components/taskbar';
import Browse from './pages/Browse'
import CheckIn from './pages/CheckIn'
import CheckOut from './pages/CheckOut'

function App() {
  return (
    <div className="App">
      <Taskbar className='taskbar'/>
      <header className="App-header">
        
        <h1>Library Booking System</h1>
      </header>
    </div>
  );
}

export default App;
