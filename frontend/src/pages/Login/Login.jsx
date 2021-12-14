import loginFundo from "../../public/loginFundo.jpg";
import loginMarca from "../../public/loginMarca.png";
import { useState, useEffect } from "react";
import "./login.css";
import ButtonMore from "../../components/buttons/button-more/ButtonMore";
import { Link } from "react-router-dom";
import api from "../../api";
import GaugeChart from "../../components/gaugeChart/GaugeChart";

function Login() {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [user, setUser] = useState();
 

  
  async function findByEmail(userEmail) {
    const response = await api.get("/user/email/" + userEmail);
    
    
    if (response.status == 200) {
      setUser(response.data);
      
      window.setTimeout(() =>{
        verifyUser(response.data.userPassword);
      }, 1000);
     
    } else {
      setEmail("");
      setSenha("");
    }
    const verifyUser = (password) => {
      if (password == senha) {
        console.log(password);
        
        window.location.href = "/dashboard";
      }
    };
  }
  
  const handleClick = (e) => {
    e.preventDefault();
    findByEmail(email);
    
  };

  return (
    <div className="container-login">
      <div
        className="login-marca"
        style={{
          position: "absolute",
          backgroundImage: `url(${loginMarca})`,
          backgroundRepeat: "no-repeat",
          width: "100%",
          height: "100%",
          left: "880px",
          top: "560px",
        }}
      ></div>

      <div
        className="login-fundo"
        style={{
          position: "absolute",
          backgroundImage: `url(${loginFundo})`,
          backgroundRepeat: "no-repeat",

          width: "100%",
          height: "100%",
          left: "0px",
          top: "-1px",
        }}
      ></div>

      <form className="login">
        <div className="box-login">
          <span className="title-login"> login</span>
          <input
            onChange={(value) => setEmail(value.target.value)}
            value={email}
            type="text"
            placeholder="Email"
            className="inputs-login"
          />
          <input
            onChange={(value) => setSenha(value.target.value)}
            value={senha}
            type="password"
            placeholder="Senha"
            className="inputs-login"
          />
          <div className="btns-login">
            <div className="links-login">
              <Link to="/" className="links">
                <span className="text-links-login">Esqueceu a senha?</span>
              </Link>
              <Link to="/" className="links">
                <span className="text-links-login">
                  Não possui uma conta? Registre-se
                </span>
              </Link>
            </div>
            <ButtonMore
              idBtnMore="btn-entrar-login"
              text="entrar"
              tipo="submit"
              click={handleClick}
            />
          </div>
        </div>
      </form>
    </div>
  );
}
export default Login;
