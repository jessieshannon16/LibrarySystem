

import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import book from '../assets/book.png'
import Col from 'react-bootstrap/Col';
import detailbutton_style from '../styles/detailbutton_styles.css'
import { useNavigate } from 'react-router-dom';

export default function DetailButton(){
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

let navigate = useNavigate()
  const checkIn = () => {
    let path = "/CheckIn";
    navigate(path);
  } 


  const checkOut = () => {
    let path = "/CheckOut";
    navigate(path);
  } 


  return (
    <>
      <Button className="detailButton mb-2" onClick={handleShow} >
        See More Details
      </Button>

      <Modal show={show} size="lg" onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Book Title</Modal.Title>
        </Modal.Header>
        <Modal.Body className="BookInfo" >
        <Col xs={6} md={4}>
              <img src={book} />
        </Col>
        <Col xs={12} md={8} >
              Author: Stephen King <br />
              Genre: Thriller <br />
              Description: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
        </Col>
            
        </Modal.Body>
        <Modal.Footer>
         <Button className="checkoutButton" onClick={checkOut}>
            Check Out Book
          </Button>
          <Button className="checkinButton" onClick={checkIn}>
            Check In Book
          </Button>
          <Button className="detailButton" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

