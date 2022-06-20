import classes from "./DishCategories.module.css";

function DishCategory(props) {
  const category = props.category;

  return (
    <li className={classes.menuCategoriesItem}>
      <button className={classes.menuCategoriesButton}>{category.name}</button>
    </li>
  );
}

export default DishCategory;
