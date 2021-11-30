import ImgHome from "../../public/imgHome.jpg";
import "./home.css";

function Home() {
  return (
    <div className="container-home">
      <div
        style={{
          position: "absolute",
          backgroundImage: `url(${ImgHome})`,
          backgroundPositionY: "0px",
          backgroundRepeat: "no-repeat",
        }}
      ></div>
    </div>
  );
}
export default Home;
