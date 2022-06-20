import classes from "./CheckoutConfirm.module.css";
import cats from "./img/cats.png";

function CheckoutConfirm() {
  const orderConfirmation =
    "Your order has been issued. Usually delivery takes about hour and a half. \r\n You can go to the pickup point in half an hour. Thank you for choosing us!";

  return (
    <div class="order-confirm-container">
      <div class="order-confirm">
        <img
          src={`${cats}`}
          className={classes.menuItemPicture}
          alt={"Picture of cute cats"}
        />
        <p className={classes.confirmInfo}>{orderConfirmation}</p>
        <button class={classes.paymentConfirmButton}>To home</button>
      </div>
    </div>
  );
}

export default CheckoutConfirm;
