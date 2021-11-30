import { useState } from "react";
import { Link } from "react-router-dom";
import Logo from "../../public/zonne.png";
import shopCartOff from "../../public/shopCart.png";
import shopCart from "../../public/shopCartWhite.png";
import "./header.css";

function Header() {
  const [home, setHome] = useState(true);
  const [produto, setProduto] = useState(false);
  const [suporte, setSuporte] = useState(false);
  const [faq, setFaq] = useState(false);
  const [login, setLogin] = useState(false);
  const [cadastro, setCadastro] = useState(false);
  const [shop, setShop] = useState(false);
  const [navBar, setNavBar] = useState(false);

  const handleChangeHome = (e) => {
    e.preventDefault();
    setHome(true);
    setProduto(false);
    setSuporte(false);
    setFaq(false);
    setLogin(false);
    setCadastro(false);
    setShop(false);
  };
  const handleChangeProduto = (e) => {
    e.preventDefault();
    setHome(false);
    setProduto(true);
    setSuporte(false);
    setFaq(false);
    setLogin(false);
    setCadastro(false);
    setShop(false);
  };
  const handleChangeSuporte = (e) => {
    e.preventDefault();
    setHome(false);
    setProduto(false);
    setSuporte(true);
    setFaq(false);
    setLogin(false);
    setCadastro(false);
    setShop(false);
  };
  const handleChangeFaq = (e) => {
    e.preventDefault();
    setHome(false);
    setProduto(false);
    setSuporte(false);
    setFaq(true);
    setLogin(false);
    setCadastro(false);
    setShop(false);
  };
  const handleChangeLogin = (e) => {
    e.preventDefault();
    setHome(false);
    setProduto(false);
    setSuporte(false);
    setFaq(false);
    setLogin(true);
    setCadastro(false);
    setShop(false);
  };
  const handleChangeCadastro = (e) => {
    e.preventDefault();
    setHome(false);
    setProduto(false);
    setSuporte(false);
    setFaq(false);
    setLogin(false);
    setCadastro(true);
    setShop(false);
  };
  const handleChangeShop = (e) => {
    e.preventDefault();
    setHome(false);
    setProduto(false);
    setSuporte(false);
    setFaq(false);
    setLogin(false);
    setCadastro(false);
    setShop(true);
  };
  const changeBackGround = () => {

    if(window.scrollY >= 80){
      setNavBar(true);
    }else{
      setNavBar(false);
    }
  }

  window.addEventListener('scroll', changeBackGround);

  return (
    <header className="container-header">
      <nav className={navBar ? "container-header-navBar active" : "container-header-navBar"}>
        <ul className="container-header-ul">
          <li className="header-li" onClick={handleChangeHome}>
            <Link className="nav-bar" to="/">
              <div className={home ? "text-header-off" : "text-header"}>
                Home
              </div>
            </Link>
          </li>
          <li className="header-li" onClick={handleChangeProduto}>
            <Link className="nav-bar" to="/produto">
              <div className={produto ? "text-header-off" : "text-header"}>
                Produto
              </div>
            </Link>
          </li>
          <li className="header-li" onClick={handleChangeSuporte}>
            <Link className="nav-bar" to="/suporte">
              <div className={suporte ? "text-header-off" : "text-header"}>
                Suporte
              </div>
            </Link>
          </li>
          <li className="header-li" onClick={handleChangeFaq}>
            <Link className="nav-bar" to="/faq">
              <div className={faq ? "text-header-off" : "text-header"}>Faq</div>
            </Link>
          </li>
          <li className="header-li" onClick={handleChangeHome}>
            <Link to="/">
              <div className="nav-bar-logo">
                <img src={Logo} width="242" height="63"></img>
              </div>
            </Link>
          </li>
          <li className="header-li" onClick={handleChangeShop}>
            <Link to="/shop">
              <div>
                <img
                  src={shop ? shopCart : shopCartOff}
                  width="50"
                  height="45"
                ></img>
              </div>
            </Link>
          </li>
          <li className="header-li" onClick={handleChangeLogin}>
            <Link className="nav-bar" to="/login">
              <div className={login ? "text-header-off" : "text-header"}>
                Login
              </div>
            </Link>
          </li>
          <li className="header-li" onClick={handleChangeCadastro}>
            <Link className="nav-bar" to="/cadastro">
              <div className={cadastro ? "text-header-off" : "text-header"}>
                Cadastro
              </div>
            </Link>
          </li>
        </ul>
      </nav>
    </header>
  );
}
export default Header;
