import checkinform_style from '../styles/checkinform_style.css'

export default function CheckOutForm() {
    return(
        <div className="checkInBox">
        <form className='checkInForm'>
            <div className='title'>
                <h2>Check-Out a Book</h2>
            </div>
    <div class="mb-3">
        <label for="UserID" class="form-label">UserID</label>
        <input type="UserID" class="form-control" id="inputUserID" aria-describedby="emailHelp"/>
       
    </div>
    <div class="mb-3">
        <label for="ISBNID" class="form-label">ISBN Number</label>
        <input type="ISBNID" class="form-control" id="ISBNID"/>
    </div>

    <div class="mb-3">
        <label for="ISBNID" class="form-label">Return Date</label>
        <input type="ISBNID" class="form-control" id="ISBNID"/>
    </div>
    
    <button type='submit' className="btn btn-primary checkoutbutton">Check Out</button>
        </form>
        </div>
    );
}