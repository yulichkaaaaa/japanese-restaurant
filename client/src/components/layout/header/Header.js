import classes from './layout/Header.module.css'

function Header(){
    return(
        <header>
            <div className={classes.container}>
                <div className={classes.start}>
                </div>
                <div className={classes.end}>
                </div>
            </div>
        </header>
    );
}

export default Header;