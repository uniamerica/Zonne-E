import "./shop.css";
import ImgDetail from "../../public/imgDetail.png"
import {MdArrowForwardIos as Arrow } from "react-icons/md";
import CardboxShop from "../../components/cardboxShop/CardboxShop";

function Shop(){
    return(
        <div className="container-shop">
            <div className="container-box1-shop">
                <div className="container-formaPagamento">
                    <h2 className="texto-shop">SHOP</h2>
                    <Arrow className="icons-arrow" />
                    <h2 className="texto-formaPagamento">Forma De Pagamento</h2>
                </div>
                <div className="metodos-pagamento">
                    <h2 className="texto-metodoPagamento">Escolha sua forma de pagamento preferida</h2>
                </div>
                <div className="containerCheckboxPagamento">
                    <label class="checkboxButton">Crédito
                    <input type="checkbox"/>
                    <span class="checkmark"></span>
                    </label>

                    <label class="checkboxButton">Débito
                    <input type="checkbox"/>
                    <span class="checkmark"></span>
                    </label>

                    <label class="checkboxButton">Boleto
                    <input type="checkbox"/>
                    <span class="checkmark"></span>
                    </label>
                </div>
                <div className="containerInformacoesPagamento">
                    <input 
                        type="text"
                        placeholder=" Nome Completo do titular do cartão "/>
                    <input
                        type="text"
                        placeholder="Número do Cartão"/>
                    <input
                        type="text"
                        placeholder="Data de validade (MM/AA)"/>
                    <input
                        type="text"
                        placeholder="Código de segurança (CVV)"/>
                </div>
                <div className="shopBotaoFinalizar">
                    <button type="submit">
                        Finalizar
                    </button>
                </div>
                <div
                    style={{
                        position: "absolute",
                        width: "676.45px",
                        height: "738.89px",
                        top: "500px",
                        
                        background: `url(${ImgDetail})`,
                        backgroundRepeat: "no-repeat",
                    }}
                ></div>
            </div> 
            <div className="container-box2-shop">
                <span className="resumoTextoShop">Resumo</span>
                <CardboxShop texto="Clock Device" quantidade={3} preco={100.01}/>
                <CardboxShop texto="Inversor Device" quantidade={1} preco={120.99}/>
            </div>  
        </div>
    );
}
export default Shop;