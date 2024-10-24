import { Dropdown, DropdownToggle } from "react-bootstrap";
import menu_style from '../styles/menu_style.css';
import Login from '../pages/Login';
 

export default function Menu() {

    return <Dropdown>
        <DropdownToggle variant='success' className='dropdown'>
        <svg xmlns="http://www.w3.org/2000/svg" class="bi bi-list" viewBox="0 0 16 16">
    <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"/>
  </svg>
        </DropdownToggle>
        <Dropdown.Menu className='dropdownBox'>
            <Dropdown.Item href="\Login.js" className='dropdownText'>Account</Dropdown.Item>
            <Dropdown.Item href="\Login.js"className='dropdownText'>Settings </Dropdown.Item>
            <Dropdown.Item href="\Login.js"className='dropdownText'>Logout</Dropdown.Item>
      </Dropdown.Menu>
    </Dropdown>
    
}