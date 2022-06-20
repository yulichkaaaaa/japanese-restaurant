import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useState } from "react";
import { Link } from "react-router-dom";
import classes from "./Header.module.css";
import Login from "../../../modal/auth/Login";
import Register from "../../../modal/auth/Register";
import Cart from "../../../modal/Cart";

function HeaderGuestUserEnd(props) {
  function handleSubmit(event) {
    event.preventDefault();
  }

  function showLogin(e) {
    setVisibleLogin(!visibleLogin);
  }

  function showRegister(e) {
    setVisibleRegister(!visibleRegister);
  }

  function switchLogin(e) {
    showLogin(e);
    showRegister(e);
  }
  
  function showCart(e) {
    setVisibleCart(!visibleCart);
  }

  const [cartItemsCount, setCartItemsCount] = useState(props.cartItemsCount);
  const [visibleLogin, setVisibleLogin] = useState(false);
  const [visibleRegister, setVisibleRegister] = useState(false);
  const [visibleCart, setVisibleCart] = useState(false);


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
        <li>
          <p className={classes.link} onClick={showLogin}>
            Login
          </p>
        </li>
      </ul>
      <Login
        onSwitch={switchLogin}
        onClose={showLogin}
        visibleLogin={visibleLogin}
      />
      <Register
        onSwitch={switchLogin}
        onClose={showRegister}
        visibleRegister={visibleRegister}
      />
      <Cart
        onClose={showCart}
        visibleCart={visibleCart}
      />
    </div>
  );
}

export default HeaderGuestUserEnd;
