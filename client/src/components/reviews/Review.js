import classes from "./Review.module.css";

function Review(props) {
  const review = props.review;
  const user = props.review.user;
  const img = user.avatar ?? "guest.png";

  return (
    <li className={classes.reviewsListItem}>
      <div className={classes.reviewAuthor}>
        <p className={classes.reviewAuthorName}>${user.name}</p>
        <img
          className={classes.reviewAuthorPhoto}
          src={`${process.env.PUBLIC_URL}/images/${img}`}
          alt=""
        />
      </div>
      <div className={classes.reviewContentContainer}>
        <div className={classes.reviewHeader}>
          <h4 className={classes.reviewHeaderTitle}>${review.header}</h4>
          <div className={classes.reviewRating}>
            <span className={classes.reviewStarsCount}>
              ${review.rating}
            </span>
            <span className="fa fa-star"></span>
            <span className="fa fa-star"></span>
            <span className="fa fa-star"></span>
            <span className="fa fa-star"></span>
            <span className="fa fa-star"></span>
          </div>
        </div>
        <div className={classes.reviewContent}>
          <p>${review.text}</p>
        </div>
      </div>
    </li>
  );
}

export default Review;
