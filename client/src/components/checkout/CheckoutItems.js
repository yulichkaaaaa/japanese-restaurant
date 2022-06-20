import classes from "./CheckoutItems.module.css";
import { useCookies } from "react-cookie";
import CheckoutItem from "./CheckoutItem";
function CheckoutItems() {
  const [cookies, setCookie] = useCookies();
  const cartItems = cookies.cartItems ?? [];
  let cartItemsToRender = [];
  for (const cartItem of cartItems) {
    cartItemsToRender.push(<CheckoutItem cartItem={cartItem} />);
  }

  return (
    <div className={classes.paymentCart}>
      <h4 className={classes.paymentSectionHeader}>Your order</h4>
      <ul className={classes.paymentCartItems}>{cartItemsToRender}</ul>
    </div>
  );
}

export default CheckoutItems;
