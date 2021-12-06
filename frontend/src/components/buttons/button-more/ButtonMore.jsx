import "./buttonMore.css";
import { Link } from "react-router-dom";

function ButtonMore(props){
    return(
        <>
            <Link to="/produto">
                <button id={props.idBtnMore} type="button" className="btn-more"> {props.text} </button>
            </Link>
        </>
    );
}
export default ButtonMore;