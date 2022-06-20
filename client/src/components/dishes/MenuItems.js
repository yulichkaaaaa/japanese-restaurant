import { useState, useEffect } from "react";
import classes from "./MenuItems.module.css";
import MenuItem from "./MenuItem";

function MenuItems(props) {
  const [dishes, setDishes] = useState([]);
  const params = props.params
  let query = ""

  if(params) {
  query = Object.keys(params)
             .map(k => encodeURIComponent(k) + '=' + encodeURIComponent(params[k]))
             .join('&');
  }           

  console.log(query)
  useEffect(() => {
    fetch('/dishes?' + query, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((data) => setDishes(data.filter((dish) => dish)));
  }, [props.params]);

  let dishesToRender = [];
  for (const dish of dishes) {
    dishesToRender.push(<MenuItem dish={dish} />);
  }

  if (dishes.length > 0) {
    return <div className={classes.menuItems}>{dishesToRender}</div>;
  }

  return (
    <div className={classes.menuItems}>
      <div className={classes.emptyDishesList}>
        <p className={classes.emptyDishesListLabel}>No dishes were found</p>
      </div>
    </div>
  );
}

export default MenuItems;
