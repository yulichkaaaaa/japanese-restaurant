import Header from "./header/Header";
import Footer from "./footer/Footer";
import classes from "./Layout.module.css";

function Layout(props) {
  return (
    <div>
      <Header />
      <div>{props.children}</div>
      <Footer />
    </div>
  );
}

export default Layout;
