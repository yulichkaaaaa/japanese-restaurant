import CartItem from "../components/cart/CartItem";
import classes from "./Cart.module.css";
import { useCookies } from "react-cookie";

function Cart(props) {
  function close(e) {
    props.onClose(e);
  }

  const [cookies, setCookie] = useCookies();
  const cartItems = cookies.cartItems ?? [];
  let cartItemsToRender = [];
  for (const cartItem of cartItems) {
    cartItemsToRender.push(<CartItem cartItem={cartItem} />);
  }

  if (!props.visibleCart) {
    return null;
  }

  const emptyCart = (
    <div className={classes.cartEmpty}>
      <p className={classes.cartEmptyLabel}>
        Your cart is empty. Please, add something
      </p>
      <p className={classes.cartEmptyLink}> from menu</p>
    </div>
  );

  const cartWithItems = (
    <div className={classes.cartItemsContainer}>
      <div className={classes.cartItems}>
        <ul className={classes.cartItemsList}>{cartItemsToRender}</ul>
      </div>
      <hr className={classes.cartItemsDelimiter} />
      <div className={classes.cartFooter}>
        <div className={classes.cartItemsTotalPrice}>
          <p className={classes.totalLabel}>Total</p>
          <p className={classes.cartItemsTotal}>23.32</p>
          <span className={classes.totalCurrency}>$</span>
        </div>
        <div className={classes.cartItemsManage}>
          <button className={classes.checkout} type="button">
            Checkout
          </button>
        </div>
      </div>
    </div>
  );

  return (
    <div className={classes.cart}>
      <div className={classes.cartBody}>
        <div className={classes.cartContent}>
          <div className={classes.cartHeader}>
            <h3 className={classes.cartTitle}>Cart</h3>
            <p className={classes.cartClose} onClick={close}>
              x
            </p>
          </div>
          {cartItemsToRender.length > 0 ? cartWithItems : emptyCart}
        </div>
      </div>
    </div>
  );
}

export default Cart;
