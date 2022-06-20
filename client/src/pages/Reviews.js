import classes from "./Reviews.module.css";
import { useEffect } from "react";
import Review from "../components/reviews/Review";

function Reviews() {
  const [reviews, setReviews] = [];
  let reviewsToRender = [];

  useEffect(() => {
    fetch("/reviews")
      .then((response) => response.json())
      .then((data) => setReviews(data.filter((review) => review)));
  });

  for (const review of reviews) {
    reviewsToRender.push(<Review review={review} />);
  }
  const reviewsContent =
    reviewsToRender.length > 0 ? (
      <ul className={classes.reviewsList}>{reviewsToRender}</ul>
    ) : (
      <div className={classes.reviewsEmpty}>
        <p className={classes.reviewsEmptyLabel}>There are no reviews yet</p>
      </div>
    );
  return (
    <div className={classes.reviewsContainer}>
      <div className={classes.reviewsHeader}>
        <h2 className={classes.reviewsTitle}>Reviews</h2>
        <button className={classes.giveFeedbackButton}>Give feedback</button>
      </div>
      {reviewsContent}
    </div>
  );
}

export default Reviews;
