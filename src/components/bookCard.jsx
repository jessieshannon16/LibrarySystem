import { Button } from "react-bootstrap";
import { Card } from "react-bootstrap";
import book from '../assets/book.png'
import bookCard_style from '../styles/bookCard_style.css'

export default function BookCard(){
    return (
        <Card style={{ width: '0.25fr' }}>
          <Card.Img variant="top" src={book } height='20px' width='20px'  />
          <Card.Body>
            <Card.Title>Book Title</Card.Title>
            <Card.Text>
              Author: Stephen
              Genre: Thriller
            </Card.Text>
            <Button variant="primary">See more details</Button>
          </Card.Body>
        </Card>
      );
}