import BookCard from "./bookCard";
import { Row } from "react-bootstrap";
import Col from "react-bootstrap/Col";


export default function CardGrid(){
    return(
     <div className='p-4'>
        <Row xs={1} md={6} className="g-2">
            {Array.from({ length: 200 }).map((_, idx) => (
                <Col key={idx}>
                <BookCard />
            </Col>
            ))}
        </Row>
    </div>
    );
}