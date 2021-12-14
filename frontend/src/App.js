import {BrowserRouter as Router, Switch, Route, useParams} from "react-router-dom";
import Home from "./pages/Home/Home";
import Produto from "./pages/Produto/Produto";
import Shop from "./pages/Shop/Shop";
import Login from "./pages/Login/Login";
import Cadastro from "./pages/Cadastro/Cadastro"
import NotFound from "./pages/NotFound/NotFound";
import Header from "./components/header/Header";
import ScrollToTop from "./components/ScrollToTop";
import "./App.css";
import DashBoardHome from "./pages/DashBoard/DashBoardHome/DashBoardHome";
import NavBarLatDashBoard from "./components/navBarDashBoard/navBarLatDashBoard/NavBarLatDashBoard";
import NavBarSupDashBoard from "./components/navBarDashBoard/navBarSupDashBoard/NavBarSupDashBoard";


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