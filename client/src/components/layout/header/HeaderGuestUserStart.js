import { Link } from "react-router-dom"

function HeaderGuestUserStart() {
    return (
        <nav>
            <ul class>
                <li>
                    <Link to="/home">Home</Link>
                </li>
                <li>
                    <Link to="/menu">Menu</Link>
                </li>
                <li>
                    <Link to="/reviews">Reviews</Link>
                </li>
                <li>
                    <Link to="">Lang</Link>
                </li>
            </ul>
        </nav>
    );
}

export default HeaderGuestUserStart;