import { Button } from "react-bootstrap";
import { Card } from "react-bootstrap";
import book from '../assets/book.png'
import bookCard_style from '../styles/bookCard_style.css'
import DetailButton from "./BookDetails";

export default function BookCard(){
    return (
      <div className="card mb-3" >
        <div className="row ">
        <div className="col-md-4 ">
          <img src={book} class="img-fluid rounded-start" alt="Book image"/>
        </div>
        <div className="col-md-8">
          <div className="card-body">
            <h5 className="card-title">Book title</h5>
            <p className="card-text">Author: Stephen King</p>
            <p className="bookGenre">Genre: Thriller</p>
            <DetailButton />
          </div>
        </div>
      </div>
    </div>
      );
}


