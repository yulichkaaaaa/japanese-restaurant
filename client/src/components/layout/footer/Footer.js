import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTwitter } from "@fortawesome/free-brands-svg-icons";
import classes from "./Footer.module.css";

function Footer() {
  return (
    <footer className={classes.footer}>
      <div className={classes.container}>
        <div className={classes.row}>
          <div className={classes.col}>
            <h4 className={classes.title}>Menu</h4>
            <ul>
              <li className={classes.item}>
                <Link className={classes.link} to="/dishes">
                  All
                </Link>
              </li>
              <li className={classes.item}>
                <Link className={classes.link} to="/dishes/discounts">
                  Discounts
                </Link>
              </li>
              <li className={classes.item}>
                <Link className={classes.link} to="/dishes/popular">
                  Popular
                </Link>
              </li>
              <li className={classes.item}>
                <Link className={classes.link} to="/dishes?categoryId=2">
                  Sushi sets
                </Link>
              </li>
            </ul>
          </div>
          <div className={classes.col}>
            <h4 className={classes.title}>About</h4>
            <ul>
              <li className={classes.item}>
                <Link className={classes.link} to="/">
                  Home
                </Link>
              </li>
              <li className={classes.item}>
                <Link className={classes.link} to="/reviews">
                  Reviews
                </Link>
              </li>
            </ul>
          </div>
          <div>
            <h4 className={classes.title}>Follow us</h4>
            <a className={classes.socialLink} href="#">
              <i className="fab fa-facebook-f"></i>
            </a>
            <a className={classes.socialLink} href="#">
              <i className="fab fa-instagram"></i>
            </a>
            <a className={classes.socialLink} href="#">
              <FontAwesomeIcon icon={faTwitter} />
            </a>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
