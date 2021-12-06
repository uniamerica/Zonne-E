import ImgHome from "../../public/imgHome.jpg";
import ImgHand from "../../public/imgHand.png";
import ImgSolarPanel from "../../public/imgSolarPanel.jpg";
import ImgProduct from "../../public/imgProduct.png";
import "./home.css";
import ButtonMore from "../../components/buttons/button-more/ButtonMore";
import Footer from "../../components/footer/Footer";

function Home() {
  return (
    <div className="container-home">
      <div
        style={{
          position: "absolute",
          backgroundImage: `url(${ImgHome})`,
          backgroundPositionY: "0px",
          backgroundRepeat: "no-repeat",
          width: "100%",
          height: "939px",
        }}
      >
        <div className="card-1">
          <h2 className="title-card-home">Marty, this may seem a</h2>
          <p className="p-card-home">
            Let's get you into a radiation suit, we must prepare to reload. Ah,
            where're my pants? You know, Doc, you left your equipment on all
            week. Right, gimme a Pepsi free. Mom, Dad
          </p>
        </div>
        <div className="cards-home">
          <h2 className="title-cards">Our first television set, Dad</h2>
          <p className="p-cards">
            Well, bring her along. This concerns her too. But I can't go to the
            dance, I'll miss my favorite television program, Science Fiction
            Theater. Alright, c'mon, I think we're safe. C'mon. Will you take
            care of that?
          </p>
        </div>
      </div>
      <div
        style={{
          position: "absolute",
          width: "768px",
          height: "620px",
          left: "-107px",
          top: "950px",

          background: `url(${ImgHand})`,
          transform: "rotate(-13.43deg)",
        }}
      ></div>
      <div className="card-2">
        <h2 className="title-section_hand-home">
          Our first television set, Dad
        </h2>
        <p className="p-section_hand-home">
          Well, bring her along. This concerns her too. But I can't go to the
          dance, I'll miss my favorite television program, Science Fiction
          Theater. Alright, c'mon, I think we're safe. C'mon. Will you take care
          of that?
        </p>
        <ButtonMore idBtnMore="btn-section_hand-home" text="saiba mais"/>
      </div>
      <div style={{
        position: "absolute",
        width: "1448px",
        height: "480px",
        left: "-8px",
        top: "2062px",
        
        background: `url(${ImgProduct})`,
        
        backgroundRepeat: "no-repeat",
        boxShadow: "0px 4px 40px 10px #000000",
      }}>
        <ButtonMore idBtnMore="btn-section_product-home" text="encomendar agora"/>
      </div>
      <div style={{
        position: "absolute",
        width: "1440px",
        height: "900px",
        left: "0px",
        top: "1626px",
      
        background: `url(${ImgSolarPanel})`,
        
        backgroundRepeat: "no-repeat",
        boxShadow: "4px 4px 40px 20px rgba(255, 255, 255, 0.57), inset 4px 4px 50px 10px #FFFFFF",
      }}>
        <div className="cards-home" id="card-2-section-solarPaenl">
          <h2 className="title-cards">Our first television set, Dad</h2>
          <p className="p-cards">
            Well, bring her along. This concerns her too. But I can't go to the
            dance, I'll miss my favorite television program, Science Fiction
            Theater. Alright, c'mon, I think we're safe. C'mon. Will you take
            care of that?
          </p>
          <ButtonMore idBtnMore="btn-section_card-2-home" text="saiba mais"/>
        </div>
      </div>
      <Footer idFooter="footerHome"/>
    </div>
  );
}
export default Home;
