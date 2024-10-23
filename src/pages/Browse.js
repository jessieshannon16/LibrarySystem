import Icon_button from '../components/icon_button';
import Taskbar from '../components/taskbar';

function Browse() {
  return (
    <div className="App">
      <Taskbar className='taskbar'/>
      <header className="App-header">
        
        <h1>Browse Library</h1>
        <Icon_button />
      </header>
    </div>
  );
}

export default Browse;
