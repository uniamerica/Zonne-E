import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import Home from "./pages/Home/Home";
import Produto from "./pages/Produto/Produto";
import Shop from "./pages/Shop/Shop";
import Login from "./pages/Login/Login";
import NotFound from "./pages/NotFound/NotFound";
import Header from "./components/header/Header";
import NavBarSupDashBoard from "./components/navBarSupDashBoard/NavBarSupDashBoard";
import NavBarLatDashBoard from "./components/navBarLatDashBoard/NavBarLatDashBoard";
import ScrollToTop from "./components/ScrollToTop";
import "./App.css";
import DashBoardHome from "./pages/DashBoard/DashBoardHome/DashBoardHome";


function App() {
  return (
    <Router>
      <ScrollToTop />
      {window.location.pathname !=='/dashboard' ? <Header/>: null}
      {window.location.pathname =='/dashboard' ? <NavBarLatDashBoard/>: null}
      {window.location.pathname =='/dashboard' ? <NavBarSupDashBoard />: null}
          
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/produto" component={Produto} />
        <Route path="/shop" component={Shop} />
        <Route path="/login" component={Login} />
        <Route path="/dashboard" component={DashBoardHome} />
        <Route path="*" component={NotFound} />
      </Switch>
    </Router>
  );
}

export default App;