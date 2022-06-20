import classes from "./PromoCodeInput.module.css";

function PromoCodeInput() {
  return (
    <div className={classes.promoCode}>
      <h4 className={classes.paymentSectionHeader}>Promocode</h4>
      <div className={classes.promoCodeField}>
        <label className={classes.promoCodeLabel} for="promo-code">
          Enter promocode
        </label>
        <input
          className ={classes.promoCodeInput}
          id="promo-code"
          type="text"
          placeholder="Promo code"
          name="promo_code_name"
        />
      </div>
    </div>
  );
}

export default PromoCodeInput;
