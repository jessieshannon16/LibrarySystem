import Icon_button from '../components/icon_button';
import Taskbar from '../components/taskbar';

function CheckOut() {
  return (
    <div className="App">
      <Taskbar className='taskbar'/>
      <header className="App-header">
        
        <h1>Check-Out Book</h1>
        <Icon_button />
      </header>
    </div>
  );
}

export default CheckOut;
