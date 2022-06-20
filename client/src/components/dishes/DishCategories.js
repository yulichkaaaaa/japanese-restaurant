import { useState } from "react";
import { useEffect } from "react";
import classes from "./DishCategories.module.css";
import DishCategory from "./DishCategory";

function DishCategories() {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    fetch("/categories")
      .then((response) => response.json())
      .then((data) => setCategories(data.filter((category) => category)));
  }, []);

  let categoriesToRender = [];
  for (const category of categories) {
    categoriesToRender.push(<DishCategory category={category} />);
  }

  return <ul className={classes.menuCategories}>{categoriesToRender}</ul>;
}

export default DishCategories;
