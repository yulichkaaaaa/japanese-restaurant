import classes from "./CartItem.module.css";

function CartItem(props) {
  const cartItem = props.cartItem;

  return (
    <li className={classes.cartItem}>
      <div className={classes.cartItemInformation}>
        <img
          src={`${process.env.PUBLIC_URL}${cartItem.dish.pictureName}`}
          alt={cartItem.dish.name}
          className={classes.cartItemImage}
        />
        <div className={classes.cartItemTitle}>
          <h4 className={classes.cartItemName}>{cartItem.dish.name}</h4>
          <p className={classes.cartItemDescription}>
            ${cartItem.dish.description}
          </p>
        </div>
      </div>
      <div className={classes.cartItemManage}>
        <div className={classes.cartItemPrice}>
          <p className={classes.cartItemPriceValue}>
            {cartItem.dish.price}
          </p>
          <span className={classes.cartItemPriceCurrency}>$</span>
        </div>
        <div className={classes.cartItemCount}>
          <div className={classes.cartItemCountUpdate}>
            <span className={classes.plusMinusButton}>+</span>
          </div>
          <p className={classes.cartItemCountLabel}>{cartItem.count}</p>
          <div className={classes.cartItemCountUpdate}>
            <span className={classes.plusMinusButton}>-</span>
          </div>
        </div>
        <div className={classes.cartItemDelete}>
          <div className={classes.cartItemDeleteButton}>
            <i className="fa fa-trash" id="delete-item"></i>
          </div>
        </div>
      </div>
    </li>
  );
}

export default CartItem;
