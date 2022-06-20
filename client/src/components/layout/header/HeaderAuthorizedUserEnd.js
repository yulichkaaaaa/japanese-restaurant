import classes from "./Header.module.css";
import { useState } from "react";
import Cart from "../../../modal/Cart";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Link } from "react-router-dom";

function HeaderAuthorizedUserEnd(props) {
  const [visibleCart, setVisibleCart] = useState(false);
  const [cartItemsCount, setCartItemsCount] = useState(props.cartItemsCount);

  function handleSubmit(event) {
    event.preventDefault();
  }

  function showCart(e) {
    setVisibleCart(!visibleCart);
  }

  return (
    <div>
      <ul className={classes.ul}>
        <li>
          <form className={classes.headerForm} onSubmit={handleSubmit}>
            <input className={classes.search} type="search" />
          </form>
        </li>
        <li>
          <FontAwesomeIcon icon={["far", "shopping-cart"]} />
          <Link className={classes.link} onClick={showCart}>
            Cart(<span>{cartItemsCount}</span>)
          </Link>
        </li>
        <li className={classes.link}>
          <i class="fas fa-user"> </i>
          <p className={classes.link}>Account</p>
        </li>
      </ul>
      <Cart
        onClose={showCart}
        visibleCart={visibleCart}
      />
    </div>
    
  );
}

export default HeaderAuthorizedUserEnd;
