import classes from './Home.module.css'
import background from "./img/preview.jpg";
import { useState, useEffect } from "react";


function Home(){
    function onButtonCklick(event) {

    }

    return(
        <section className={classes.preview} style={{ backgroundImage: `url(${background})`}}>
            <div className={classes.previewContainer}>
                <div className={classes.previewInfo}>The most delicious sushi!</div>
                <h1 className={classes.previewTitle}>Japanese restaurant</h1>
                <div className={classes.previewBtnContainer}>
                    <button className={classes.previewBtn} onClick={onButtonCklick}>Menu</button>
                </div>
            </div>
        </section>
    );
}

export default Home;