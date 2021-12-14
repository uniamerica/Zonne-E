import "./cardbox.css";
import ImgProdutoShop from "../../public/imgProdutoShop.jpg"
import {BsFillTrashFill as Trash} from "react-icons/bs"

function CardboxShop(props){
    return(
        <div className="container-cardbox"> 
            <div
                style={{
                    width: "115px",
                    height: "142px",


                    background: `url(${ImgProdutoShop})`,
                }}
            ></div>
            <div className="container-cardbox-texto-data">
                <div className="containerCardbox-texto"> 
                    <span className="cardbox-texto">{props.texto}</span>
                    <Trash/>
                </div>
                <div className="containerCardbox-data"> 
                    <span className="cardbox-quantidade">x{props.quantidade}</span>
                    <span className="cardbox-preco">R${props.preco}</span>
                </div>
            </div>
        </div> 
    );
}
export default CardboxShop;