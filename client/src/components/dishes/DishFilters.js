import classes from "./DishFilters.module.css";

function DishFilters(props) {
  function onChoose(e) {
    props.onChoose(e);
  }
  return (
    <div className={classes.menuItemsSort}>
      <p className={classes.menuSortLabel}>Sort</p>
      <div className={classes.menuSortingForm}>
        <button
          className={classes.menuSortCriteria}
          name="price"
          onClick={onChoose}
          type="button"
        >
          By price
        </button>
      </div>
      <div className={classes.menuSortingForm}>
        <button
          className={classes.menuSortCriteria}
          name="discountPercents"
          onClick={onChoose}
          type="button"
        >
          By discount
        </button>
      </div>
      <div className={classes.menuSortingForm}>
        <button
          className={classes.menuSortCriteria}
          name="popularity"
          onClick={onChoose}
          type="button"
        >
          By popularity
        </button>
      </div>

      <p className={classes.menuNotFoundLabel}>
        {props.noDishesFound ? "No results were found for your search" : ""}
      </p>
    </div>
  );
}

export default DishFilters;
