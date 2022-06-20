import { useState } from "react";
import classes from "./CheckoutFooter.module.css";

function CheckoutFooter(props) {
  const [errorMessage, setErrorMessage] = useState("");

  if (props.errorMessage) {
    setErrorMessage(props.errorMessage);
  }

  return (
    <div className={classes.paymentFooter}>
      <div className={classes.promoCodeField}>
        <label className={classes.promoCodeLabel} for="promo-code">
          Your email
        </label>
        <input
          class={classes.promoCodeInput}
          id="guest-email"
          type="email"
          placeholder="Your email"
          name="guest_email"
        />
      </div>
      <div className={classes.commentOrder}>
        <h4 className={classes.paymentSectionHeader}>Your comment</h4>
        <textarea
          className={classes.commentOrderInput}
          placeholder="Your comment..."
          name="order_comment"
        ></textarea>
      </div>

      <div className={classes.paymentConfirm}>
        <p className={classes.paymentErrorLabel}>{errorMessage}</p>
        <button class={classes.paymentConfirmButton} type="submit">
          Checkout
        </button>
      </div>
    </div>
  );
}

export default CheckoutFooter;
