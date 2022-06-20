import { useState } from "react";
import AddressForm from "../components/checkout/AddressForm";
import CheckoutFooter from "../components/checkout/CheckoutFooter";
import CheckoutItems from "../components/checkout/CheckoutItems";
import ExtraItems from "../components/checkout/ExtraItems";
import PickupInfo from "../components/checkout/PickupInfo";
import PromoCodeInput from "../components/checkout/PromoCodeInput";
import classes from "./Checkout.module.css";

function Checkout() {
  const [isDelivery, setIsDelivery] = useState(true);
  const [isCash, setIsCash] = useState(true);

  let deliveryContent = isDelivery ? <AddressForm /> : <PickupInfo />;
  return (
    <div className={classes.paymentContainer}>
      <div className={classes.paymentHeader}>
        <h2 className={classes.paymentTitle}>Checkout</h2>
      </div>
      <div className={classes.paymentBody}>
        <CheckoutItems />
        <ExtraItems />
        <div className={classes.choose}>
          <div id="delivery" className={classes.chooseItem}>
            Delivery
          </div>
          <div
            id="pickup"
            className={classes.chooseItem + " " + classes.isActive}
          >
            PickUp
          </div>
          {deliveryContent}
          <PromoCodeInput />
          <h4 className={classes.paymentSectionHeader}>Payment Method</h4>
          <div className={classes.choose}>
            <div
              className={classes.chooseItem + " " + classes.isActive}
              id="cash"
            >
              Cash
            </div>
            <div className={classes.chooseItem} id="bank-card">
              Bank Card
            </div>
          </div>
        </div>
      </div>
      <CheckoutFooter />
    </div>
  );
}

export default Checkout;
