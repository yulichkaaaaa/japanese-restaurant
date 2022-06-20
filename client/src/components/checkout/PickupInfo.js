import classes from "./PickupInfo.module.css";
import { useEffect, useState } from "react";

function PickupInfo() {
  const [cafes, setCafes] = useState([]);

  useEffect(() => {
    fetch("/cafes")
      .then((response) => response.json())
      .then((data) => setCafes(data.filter((cafe) => cafe)));
  }, []);

  let cafesToRender = [];

  for (const cafe of cafes) {
    cafesToRender.push(
      <option value={cafe.address.addressId}>
        {cafe.address.city}, {cafe.address.street}, {cafe.address.house}
      </option>
    );
  }

  return (
    <div className={classes.pickupInfo}>
      <p className={classes.pickupLabel}>Choose cafe</p>
      <select className={classes.pickupSelect} name="address_id">
        {cafesToRender}
      </select>
    </div>
  );
}

export default PickupInfo;
