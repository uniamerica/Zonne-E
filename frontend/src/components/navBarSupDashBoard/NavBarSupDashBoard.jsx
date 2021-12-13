import "./navBarSupDashBoard.css"
import {BsPersonCircle as Perfil} from "react-icons/bs";
import {TiArrowSortedDown as ArrowDown} from "react-icons/ti";
import Logo from "../../public/zonne.png";

function NavBarSupDashBoard(){
    return(
    <>
        <nav className="container-navSup">
            <img src={Logo} width="238" height="66" style={{
                paddingLeft: "60px",
            }}/>
            <div className="personDashboard">
                <Perfil className="perfil-dashBoard" />
                <h3 className="name-person-dashBoard">João da Silva</h3>
                <ArrowDown className="arrown-down-dashBoard" />
            </div>
        </nav>
    </>
    );
}
export default NavBarSupDashBoard;