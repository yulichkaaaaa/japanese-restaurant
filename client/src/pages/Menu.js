import { useState } from "react";
import DishCategories from "../components/dishes/DishCategories";
import DishFilters from "../components/dishes/DishFilters";
import MenuItems from "../components/dishes/MenuItems";
import classes from "./Menu.module.css";

function Menu() {
  const [filter, setFilter] = useState("");
  const [categoryId, setCategoryId] = useState({});

  function setFilterValue(e) {
    const target = e.target;
    const name = target.name;
    setFilter(name);
  }

  function setCategoryIdValue(e) {
    const target = e.target;
    const name = target.name;
    setFilter(Number(name));
  }

  const params = {};

  if (filter) {
    params["sortCriteria"] = filter;
    if (filter === "discountPercents") {
      params["sortDirection"] = "desc";
    }
  }

  return (
    <div className={classes.menuContainer}>
      <div className={classes.menuHeader}>
        <h2 className={classes.menuTitle}>Menu</h2>
      </div>
      <div className={classes.menuContent}>
        <DishCategories onChoose={setCategoryIdValue} />
        <div className={classes.menuPanel}>
          <DishFilters onChoose={setFilterValue} />
          <MenuItems params={params} />
        </div>
      </div>
    </div>
  );
}

export default Menu;
