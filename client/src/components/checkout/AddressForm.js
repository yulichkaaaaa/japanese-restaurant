import classes from "./AddressForm.module.css"

function AddressForm() {
  return (
    <div className={classes.deliveryAddress}>
      <div className={classes.deliveryAddressHouse}>
        <div className={classes.deliveryAddressField}>
          <label className={classes.deliveryAddressLabel} for="city">
            City
          </label>
          <input
            className={classes.deliveryAddressInputLong}
            id="city"
            type="text"
            name="city"
            placeholder="City"
          />
        </div>
        <div className={classes.deliveryAddressField}>
          <label className={classes.deliveryAddressLabel} for="street">
            Street
          </label>
          <input
            className={classes.deliveryAddressInputLong}
            id="street"
            type="text"
            name="street"
            placeholder="Street"
          />
        </div>
      </div>
      <div className={classes.deliveryAddressHouse}>
        <div className={classes.deliveryAddressField}>
          <label className={classes.deliveryAddressLabel} for="house">
            House
          </label>
          <input
            className={classes.deliveryAddressInputShort}
            id="house"
            type="text"
            name="house"
            placeholder="House"
          />
        </div>
        <div className={classes.deliveryAddressField}>
          <label className={classes.deliveryAddressLabel} for="entrance">
            Entrance
          </label>
          <input
            className={classes.deliveryAddressInputShort}
            id="entrance"
            type="text"
            name="entrance"
            placeholder="Entrance"
          />
        </div>
        <div className={classes.deliveryAddressField}>
          <label className={classes.deliveryAddressLabel} for="floor">
            Floor
          </label>
          <input
            className={classes.deliveryAddressInputShort}
            id="floor"
            type="text"
            name="floor"
            placeholder="Floor"
          />
        </div>
        <div className={classes.deliveryAddressField}>
          <label className={classes.deliveryAddressLabel} for="flat">
            Flat
          </label>
          <input
            className={classes.deliveryAddressInputShort}
            id="flat"
            type="text"
            name="flat"
            placeholder="Flat"
          />
        </div>
      </div>
    </div>
  );
}

export default AddressForm;
