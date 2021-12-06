import { BsFacebook as Facebook, BsInstagram as Instagram } from "react-icons/bs";
import {
  FaPhoneAlt as Phone,
  FaGooglePlay as GooglePlay,
  FaApple as AppleStore,
} from "react-icons/fa";
import "./footer.css";

function Footer(props) {
  return (
    <footer id={props.idFooter} className="container-footer">
      <div className="container-nav-footer">
        <h3 className="nav-footer"> home </h3>
        <h3 className="nav-footer"> produto </h3>
        <h3 className="nav-footer"> suporte </h3>
        <h3 className="nav-footer"> faq </h3>
        <h3 className="nav-footer"> login </h3>
        <h3 className="nav-footer"> cadastro </h3>
        <h3 className="nav-footer"> compras </h3>
      </div>
      <div className="container-contacts-social">
        <div className="container-contacts">
          <h1 className="titles-footer"> contatos </h1>
          <div className="box-contacts-footer">
            <div className="contacts-footer">
              <Phone className="icons-footer"/>
              <h3 className="align-text-footer">(45) 4002-8922</h3>
            </div>
            <div className="contacts-footer">
              <Phone className="icons-footer"/>
              <h3 className="align-text-footer">(45) 4002-8922</h3>
            </div>
          </div>
        </div>
        <div className="container-social">
          <h1 className="titles-footer"> redes socias </h1>
          <div className="box-social-footer">
            <div className="footer-social">
              <Instagram className="icons-footer"/>
              <h3 className="align-text-footer">@Zonne-E</h3>
            </div>
            <div className="footer-social">
              <Facebook className="icons-footer"/>
              <h3 className="align-text-footer">@Zonne-E</h3>
            </div>
          </div>
        </div>
      </div>
      <div className="container-apps">
        <h1 className="titles-footer">baixe o app</h1>
        <div className="box-apps-footer">
          <div className="footer-apps">
            <GooglePlay className="icons-footer"/>
            <h3 className="align-text-footer">google play</h3>
          </div>
          <div className="footer-apps">
            <AppleStore className="icons-footer"/>
            <h3 className="align-text-footer">app store</h3>
          </div>
        </div>
      </div>
    </footer>
  );
}
export default Footer;
