import style from '../styles/checkinform_style.css'

export default function CheckInForm() {
    return(
        <div className="checkInBox">
        <form className='checkInForm'>
            <div className='title'>
            <h2>Check-In a Book</h2>
            </div>
    <div class="mb-3">
        <label for="UserID" class="form-label">UserID</label>
        <input type="UserID" class="form-control" id="inputUserID" aria-describedby="emailHelp"/>
       
    </div>
    <div class="mb-3">
        <label for="ISBNID" class="form-label">ISBN Number</label>
        <input type="ISBNID" class="form-control" id="ISBNID"/>
    </div>

    
    <button type="submit" className="btn btn-primary checkoutbutton">Check In</button>
        </form>
        </div>
    );
}