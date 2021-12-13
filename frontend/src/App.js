import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import Home from "./pages/Home/Home";
import Produto from "./pages/Produto/Produto";
import Login from "./pages/Login/Login";
import NotFound from "./pages/NotFound/NotFound";
import Header from "./components/header/Header";
import ScrollToTop from "./components/ScrollToTop";
import "./App.css";

function App() {
  return (
    <Router>
      <ScrollToTop />
      <Header className="header-app"/>
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/produto" component={Produto} />
        <Route path="/login" component={Login} />
        <Route path="*" component={NotFound} />    
      </Switch>
    </Router>
  );
}

export default App;
