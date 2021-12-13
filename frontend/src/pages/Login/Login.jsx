import loginFundo from "../../public/loginFundo.jpg";
import loginMarca from "../../public/loginMarca.png";
import React from 'react';
import "./login.css";

function Login(){
    return(
        <div className="container-login">
            <div className="login-marca"
            style={{
               position: "absolute",
               backgroundImage: `url(${loginMarca})`,
               backgroundRepeat: "no-repeat",
               width: "750px",
               height: "950px",
               left: "840px",
               top: "360px",
            }}>
            </div>
            
            <div className="login-fundo"
                style={{
                   position: "absolute",
                   backgroundImage: `url(${loginFundo})`,
                   backgroundRepeat: "no-repeat",
                   maxWidth:"auto",
                   maxHeight:"auto",
                   width: "874px",
                   height: "750px",
                   left: "0px",
                   top: "-1px", 
                }}>
            </div>

            <div className="login">
                <div className="login-titulo">
                    <h1>Login</h1>

                    <div className="loginInputEmail">
                        <input 
                        type="text"
                        placeholder=" Email "/>
                    </div>

                    <div className="loginInputSenha">
                        <input 
                        type="text"
                        placeholder="Senha"/>
                    </div>

                    <div className="loginBotaoCadastro">
                        <button type="submit">Não possui uma conta? Registre-se</button>
                    </div>

                    <div className="loginBotaoEsqueceuSenha"
                     style={{
                        display: "flex",
                        position: "absolute",
                        width: "362px",
                        height: "26px",
                        left: "986px",
                        top: "240px",
                        background:"transparent",
                     }}>
                        <button type="submit">Esqueceu a senha?</button>
                   </div>

                    <div className="loginBotaoEntrar">
                    <button type="submit">
                        Entrar
                    </button>
                    </div>
                    
                </div>   
            </div>
            

        </div>
    )
}export default Login;