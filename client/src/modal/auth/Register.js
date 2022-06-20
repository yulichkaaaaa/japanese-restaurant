import { useState } from "react";
import classes from "./Login.module.css";

function Register(props) {
  const [user, setUser] = useState({ name: "", email: "", password: "" });
  const [errorMessage, setErrorMessage] = useState("");
  const [buttonEnabled, setButtonEnabled] = useState(false)

  function close(e) {
    props.onClose(e);
  }

  function switchModal(e) {
    props.onSwitch(e);
  }

  if (!props.visibleRegister) {
    return null;
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    saveUser();
  };

  const handleChange = (event) => {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let usr = user ?? {};
    usr[name] = value;
    setUser(usr);
  };

  const handleRepeatPasswordChange = (event) => {
    console.log('Im here')
    const target = event.target;
    const value = target.value;
    if (value !== user.password) {
      setErrorMessage("Password missmatch");
      setButtonEnabled(false)
    } else {
      setErrorMessage("");
      setButtonEnabled(true)
    }
  }

  const saveUser = (e) => {
    fetch("/users", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    })
      .then((res) => res.json())
      .then((result) => {
        console.log(result)
          ? setErrorMessage(result.errorMessage ?? "")
          : props.onClose(e);
      });
  };

  return (
    <div className={classes.login}>
      <div className={classes.loginBody}>
        <div className={classes.loginContent}>
          <div className={classes.loginHeader}>
            <h3 className={classes.loginTitle}>Register</h3>
            <p className={classes.loginClose} onClick={close}>
              x
            </p>
          </div>
          <div className={classes.loginFormContainer}>
            <form className={classes.loginForm} onSubmit={handleSubmit}>
              <div className={classes.loginFormField}>
                <input
                  className={classes.loginFieldInput}
                  type="text"
                  placeholder="Username"
                  onChange={handleChange}
                  name="name"
                />
              </div>
              <div className={classes.loginFormField}>
                <input
                  className={classes.loginFieldInput}
                  type="email"
                  placeholder="Email"
                  onChange={handleChange}
                  name="email"
                />
              </div>
              <div className={classes.loginFormField}>
                <input
                  className={classes.loginFieldInput}
                  type="password"
                  placeholder="Password"
                  onChange={handleChange}
                  name="password"
                />
              </div>
              <div className={classes.loginFormField}>
                <input
                  className={classes.loginFieldInput}
                  type="password"
                  placeholder="Repeat password"
                  name="repeatPassword"
                  onChange={handleRepeatPasswordChange}
                />
                <p className={classes.loginErrorMessage}>{errorMessage}</p>
              </div>
              <input className={classes.loginFormSubmit} disabled={!buttonEnabled} type="submit" />
            </form>
          </div>
          <footer className={classes.loginFooter}>
            <p className={classes.loginFooterText}>
              You already have an account?
              <span className={classes.switchLink} onClick={switchModal}>
                {" "}
                Login
              </span>
            </p>
          </footer>
        </div>
      </div>
    </div>
  );
}

export default Register;
