import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import Home from "./pages/Home/Home";
import Produto from "./pages/Produto/Produto";
import NotFound from "./pages/NotFound/NotFound";
import Header from "./components/header/Header";

function App() {
  return (
    <Router>
      <Header/>
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/produto" component={Produto} />
        <Route path="*" component={NotFound} />        
      </Switch>
    </Router>
  );
}

export default App;
