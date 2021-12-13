import "./navBarLatDashBoard.css";
import {
  MdArrowForwardIos as ArrowFoward,
  MdArrowBackIos as ArrowBack,
  MdOutlineLogout as LogOutIcon,
} from "react-icons/md";
import {
  AiFillDashboard as DashBoardIcon,
  AiFillWarning as WarningIcon,
} from "react-icons/ai";
import { FaCalendarAlt as ReportIcon } from "react-icons/fa";
import { Link } from "react-router-dom";

function NavBarLatDashBoard() {
  return (
    <nav className="container-navLat">
      <div className="close-icon">
        <h3 className="titles-nav-dashBoard"> fechar </h3>
        <ArrowBack className="arrow-back-dashBoard arrows-dashBoard" />
      </div>
      <Link to="/dashboard" className="link-dashBoard">
        <div className="dashBoard-icon box-icons-dashBoard">
          <DashBoardIcon className="dashIcon-dashBoard icons-dashBoard" />
          <h3 className="titles-nav-dashBoard "> dashboard </h3>
        </div>
      </Link>
      <Link to="/relatorios"  className="link-dashBoard">
        <div className="report-icon box-icons-dashBoard">
          <ReportIcon className="reportIcon-dashBoard icons-dashBoard" />
          <h3 className="titles-nav-dashBoard"> relátorio </h3>
        </div>
      </Link>
      <Link to="/avisos"  className="link-dashBoard">
        <div className="warning-icon box-icons-dashBoard">
          <WarningIcon className="warningIcon-dashBoard icons-dashBoard" />
          <h3 className="titles-nav-dashBoard"> avisos </h3>
        </div>
      </Link>
      <Link to="/"  className="link-dashBoard">
        <div className="logout-icon box-icons-dashBoard">
          <LogOutIcon className="logOutIcon-dashBoard icons-dashBoard" />
          <h3 className="titles-nav-dashBoard"> logout </h3>
        </div>
      </Link>
    </nav>
  );
}
export default NavBarLatDashBoard;
