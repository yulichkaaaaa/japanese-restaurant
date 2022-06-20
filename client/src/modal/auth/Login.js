import { useState } from "react";
import classes from "./Login.module.css";
import { useCookies } from "react-cookie";

function Login(props) {
  function submitForm(event) {}

  function registerClick(e) {
    props.onSwitch(e);
  }

  function closeClick(e) {
    props.onClose(e);
  }

  const [user, setUser] = useState({ email: "", password: "" });
  const [errorMessage, setErrorMessage] = useState("");
  const [cookie, setCookie] = useCookies();

  if (!props.visibleLogin) {
    return null;
  }

  const loginUser = (e) => {
    fetch("/users/login", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    })
      .then((res) => res.json())
      .then((result) => {
        if (result) {
          setCookie("user", user, { path: "/" });
          props.onClose(e);
        } else {
          setErrorMessage(result.errorMessage ?? "");
        }
      });
  };

  return (
    <div className={classes.login}>
      <div className={classes.loginBody}>
        <div className={classes.loginContent}>
          <div className={classes.loginHeader}>
            <h3 className={classes.loginTitle}>Login</h3>
            <p className={classes.loginClose} onClick={closeClick}>
              x
            </p>
          </div>
          <div className={classes.loginFormContainer}>
            <form className={classes.loginForm} onSubmit={submitForm}>
              <div className={classes.loginFormField}>
                <input
                  className={classes.loginFieldInput}
                  type="text"
                  placeholder="Email"
                />
              </div>
              <div className={classes.loginFormField}>
                <input
                  className={classes.loginFieldInput}
                  type="password"
                  placeholder="Password"
                />
              </div>
              <p className={classes.loginErrorLabel}>{errorMessage}</p>
              <input className={classes.loginFormSubmit} type="submit" />
            </form>
          </div>
          <footer className={classes.loginFooter}>
            <p className={classes.loginFooterText}>
              Don't have an account yet?
              <span className={classes.switchLink} onClick={registerClick}>
                {" "}
                Register
              </span>
            </p>
          </footer>
        </div>
      </div>
    </div>
  );
}

export default Login;
