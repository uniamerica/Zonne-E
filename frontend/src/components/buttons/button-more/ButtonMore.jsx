import "./buttonMore.css";
import { Link } from "react-router-dom";

function ButtonMore(props){
    return(
        <>
            <Link to={"/" + props.rota}>
                <button id={props.idBtnMore} type={props.tipo} className="btn-more" onClick={props.click}> {props.text} </button>
            </Link>
        </>
    );
}
export default ButtonMore;