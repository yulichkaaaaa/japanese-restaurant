import classes from "./CheckoutItem.module.css";

function CheckoutItem(props) {
  const item = props.cartItem;

  return (
    <li className={classes.paymentCartItem}>
      <div class={classes.cartItemInformation}>
        <img
          src={`${process.env.PUBLIC_URL}${item.dish.pictureName}`}
          alt={item.dish.name}
          className={classes.cartItemImage}
        />
        <div className={classes.cartItemTitle}>
          <h4 className={classes.cartItemName}>{item.dish.name}</h4>
          <p className={classes.cartItemDescription}>{item.dish.description}</p>
        </div>
      </div>
      <div className={classes.cartItemManage}>
        <div className={classes.cartItemPrice}>
          <p className={classes.cartItemPriceValue}>{item.dish.price}</p>
          <span className={classes.cartItemPriceCurrency}></span>
        </div>
        <div className={classes.cartItemCount}>
          <p className={classes.cartItemCountLabel}>x {item.value}</p>
        </div>
      </div>
    </li>
  );
}

export default CheckoutItem;
