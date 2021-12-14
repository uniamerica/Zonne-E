import React, {useState} from "react";
import api from "../../api";

import "./cadastro.css";


    function Cadastro(){

       const [nome, setNome] = useState("");
       const [sobrenome, setSobrenome] = useState("");
       const [cpf, setCpf] = useState("");
       const [email, setEmail] = useState("");
       const [senha, setSenha] = useState("");

            const handleSubmit = (e) =>{
                e.preventDefault();
                const postCadastro = {
                   userName: nome,
                   userLastName: sobrenome,
                   cpf:cpf,
                   userEmail: email,
                   userPassword: senha
            }

            api.post('/user', postCadastro).then((resp) =>{
                console.log(resp);

            } );
            setNome("");
            setSobrenome("");
            setCpf("");
            setEmail("");
            setSenha("");
            
            }
        return(
            <div className="form-cadastro">
                <form onSubmit={handleSubmit}>
                    <ul className="ul-cadastro">  
                        <li>
                            <input name="InputNome" onChange={value=> setNome(value.target.value)} value={nome}  ClassName="input-cadastro" type="text" placeholder="Name"></input>
                        </li>

                        <li>
                        <input name="InputSobrenome" onChange={value=>setSobrenome(value.target.value)} value={sobrenome}  ClassName="input-cadastro" type="text" placeholder="Sobrenome"></input>
                        </li>
                    
                        <li>
                        <input name="InputCpf" onChange={value=> setCpf(value.target.value)} value={cpf}  ClassName="input-cadastro" type="text" placeholder="Cpf"></input>
                        </li>

                        <li>
                        <input name="InputEmail" onChange={value=>setEmail(value.target.value)} value={email}  ClassName="input-cadastro" type="text" placeholder="Email"></input>
                        </li>

                        <li>
                        <input name="InputSenha" onChange={value=>setSenha(value.target.value)} value={senha}  ClassName="input-cadastro" type="text" placeholder="Senha"></input>
                        </li>
                    
                        

                        <li>
                            <button name="botao-form-confirmar" type="submit" className="input-cadastro">Confirmar</button>
                        </li>
                    </ul>
                </form>
            </div>            
        );
    }export default Cadastro;