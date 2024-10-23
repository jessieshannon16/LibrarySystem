import React from "react";
import Icon_button from "./icon_button";
import Menu from "./menu";
import taskbar_styles from '../styles/taskbar_style.css';



export default function Taskbar() {
    return(
        <ul className='taskbar'>
         
            <li><Icon_button /></li>
            <li><a href="\Browse.js">Browse Library</a></li>
            

            <li><a href='\CheckIn.js'>Check-In Book</a></li>
       
            <li><a href='\CheckOut.js'>Check-Out Book</a></li>
            <li><Menu /></li>
            </ul>
     
    );
};  