import classes from "./ExtraItems.module.css"

function ExtraItems() {
    return (
        <div className={classes.paymentExtraItems}>
        <h4 className={classes.paymentSectionHeader}>Extra</h4>
        <ul className={classes.extraItems}>
            <li className={classes.extraItem}>
                <input type="checkbox"/><label for="sticks" className={classes.extraItemTitle}>Sticks</label>
            </li>
            <li className={classes.extraItem}>
                <input type="checkbox"/><label for="fork" className={classes.extraItemTitle}>Fork</label>
            </li>
            <li className={classes.extraItem}>
                <input type="checkbox"/><label for="ginger" className={classes.extraItemTitle}>Ginger</label>
            </li>
            <li className={classes.extraItem}>
                <input type="checkbox"/><label for="wasabi" className={classes.extraItemTitle}>Wasabi</label>
            </li>
            <li className={classes.extraItem}>
                <input type="checkbox"/><label for="soy_sauce" className={classes.extraItemTitle}>Soy sause</label>
            </li>
        </ul>
    </div>  
    );
}

export default ExtraItems;