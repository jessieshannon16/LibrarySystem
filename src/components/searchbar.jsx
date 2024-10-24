import searchbar_styles from '../styles/searchbar_styles.css';


export default function Searchbar(){
    return (
        <nav class="searchbar p-2">
            <div class="container-fluid">
                <form class="d-flex justify-content-center " role="search">
                    <input class="form-control me-2 w-25" type="search" placeholder="Search for books" aria-label="Search"/>
                    <button class="btn btn-outline-success searchButton" type="submit">Search</button>
                </form>
            </div>
        </nav>
    );
}