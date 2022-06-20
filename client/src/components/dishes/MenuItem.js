import classes from "./MenuItem.module.css";
import { useCookies } from "react-cookie";

function MenuItem(props) {
  const dish = props.dish;
  const [cookies, setCookie] = useCookies();

  function addToCart() {
    let cartItems = cookies.cartItems ?? [];
    for (const cartItem of cartItems) {
      if (cartItem.dish.dishId === dish.dishId) {
        cartItem.count = cartItem.count + 1;
      } else if (
        cartItems[cartItems.length - 1].dish.dishId === cartItem.dish.dishId
      ) {
        cartItems.push({ dish: dish, count: 1 });
      }
    }
    if (cartItems.length === 0) {
      cartItems.push({ dish: dish, count: 1 });
    }
    setCookie("cartItems", cartItems, { path: "/" });
  }

  return (
    <div className={classes.menuItem}>
      <img
        src={`${process.env.PUBLIC_URL}${dish.pictureName}`}
        className={classes.menuItemPicture}
        alt={dish.name}
      />
      <div className={classes.menuItemContent}>
        <h3 className={classes.menuItemTitle}>{dish.name}</h3>
        <p className={classes.menuItemDescription}>{dish.deccription}</p>
      </div>
      <div className={classes.menuItemBottom}>
        <div className={classes.menuItemPrice}>
          <p className={classes.menuPriceValue}>{dish.price}</p>
          <span className={classes.menuItemPriceCurrency}>$</span>
        </div>
        <div>
          <button
            className={classes.menuItemButton}
            onClick={addToCart}
            type="button"
          >
            Add to cart
          </button>
        </div>
      </div>
    </div>
  );
}

export default MenuItem;
