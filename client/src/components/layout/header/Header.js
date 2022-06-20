import { Link } from "react-router-dom";
import classes from "./Header.module.css";
import { useCookies } from "react-cookie";
import HeaderGuestUserEnd from "./HeaderGuestUserEnd";
import HeaderAuthorizedUserEnd from "./HeaderAuthorizedUserEnd";

function Header() {
  const [cookies, setCookie] = useCookies();
  
  let cartItems = cookies.cartItems ?? [];
  let counter = 0;
  for (const cartItem of cartItems) {
    counter += cartItem.count;
  }

  const cartItemsCount = cartItems.length > 0 ? counter : 0;
  const headerEnd = cookies.user ? (
    <HeaderAuthorizedUserEnd cartItemsCount={cartItemsCount} />
  ) : (
    <HeaderGuestUserEnd cartItemsCount={cartItemsCount} />
  );

  return (
    <header>
      <div className={classes.container}>
        <div className={classes.start}>
          <ul className={classes.ul}>
            <li>
              <Link className={classes.link} to="">
                Home
              </Link>
            </li>
            <li>
              <Link className={classes.link} to="dishes">
                Menu
              </Link>
            </li>
            <li className="header-li">
              <Link className={classes.link} to="reviews">
                Reviews
              </Link>
            </li>
          </ul>
        </div>
        <div className={classes.end}>{headerEnd}</div>
      </div>
    </header>
  );
}

export default Header;
