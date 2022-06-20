import { Route, Switch } from "react-router-dom";

import Home from "./pages/Home";
import Menu from "./pages/Menu";
import Reviews from "./pages/Reviews";
import Layout from "./components/layout/Layout";
import Provider from "./i18n/Provider";

function App() {
  return (
    <Provider>
      <Layout>
        <Switch>
          <Route path="/" exact>
            <Home />
          </Route>
          <Route path="/dishes">
            <Menu />
          </Route>
          <Route path="/reviews">
            <Reviews />
          </Route>
        </Switch>
      </Layout>
    </Provider>
  );
}

export default App;
