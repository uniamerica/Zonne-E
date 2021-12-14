import "./gaugeChart.css";
import React, { useState, useEffect } from "react";
import { IoSpeedometer as Velocimeter } from "react-icons/io5";
import { AiFillThunderbolt as Thunder } from "react-icons/ai";
import { HiSun as Sun } from "react-icons/hi";
import OrbZ from "../../public/orbZonne.png";
import Ponteiro from "../../public/ponteiro.png";
import api from "../../api";



function GaugeChart(props) {
  const [gaugeValue, setGaugeValue] = useState(0.5);
  const [user, setUser] = useState();
  const [valueSolarPanel, setValueSolarPanel] = useState();
  const [valueKw, setValueKw] = useState();
  const [valuePorcent, setValuePorcent] = useState();
  
  // const {email} = useParams();
  
  useEffect(() => {
     findByEmail();
    
  }, []);
  
  async function findByEmail() {
    const response = await api.get("/user/email/" + props.email);
    console.log(props.email)
    if (response.status == 200) {
      setUser(response.data);
      setValueSolarPanel(Number.parseInt(response.data.devices[0].deviceValueSolarPanel, 10))
      setValueKw(Number.parseInt(response.data.devices[0].deviceValueKw, 10))
    }
    
    valueSolarToPorcent();
    console.log(valuePorcent)
    
  }
  const valueSolarToPorcent = () => {
    let result = (valueKw * 100) / valueSolarPanel;
    setValuePorcent(result);
    return result;
  };
  const valuePorcentToDeg = () => {
    return (valuePorcent * 180) / 100;
  };

  return (
    <div>
      <div className="container-gauge-data">
        <div>
          <div className="container-gauge">
            <div
              style={{
                position: "absolute",
                width: "320px",
                height: "165px",
                top: "100px",
                left: "100px",
                overflow: "hidden",
              }}
            >
              <div
                className="rotate"
                style={{
                  position: "relative",
                  width: "320px",
                  height: "320px",
                  background: `url(${OrbZ})`,
                  backgroundRepeat: "no-repeat",
                  transform: `rotate(${valuePorcentToDeg()}deg)`,
                }}
              ></div>
            </div>
          </div>
          <div
            className="rotate"
            style={{
              position: "relative",
              top: "400px",
              left: "380px",
              width: "60px",
              height: "49px",
              background: `url(${Ponteiro})`,
              backgroundRepeat: "no-repeat",
              transform: `rotate(${valuePorcentToDeg()}deg)`,
            }}
          ></div>
        </div>
        <div className="data-gauge">
          <div className="data-gauge-top">
            <h3 className="title-data-gauge">produzindo atualmente</h3>
            <h3 className="porcent-data-gauge">{valuePorcent + "%"}</h3>
            <h3 className="data-gauge-kw">{valueKw + " kWh"}</h3>
            <span className="row-data-gauge"></span>
          </div>
          <div className="data-gauge-bottom">
            <span className="data-gauge-info">
              <span className="data-gauge-info-text">valor</span>  
              <span className="data-gauge-info-text">estimado</span>
            </span>
            <h3 className="data-gauge-kw">{valueSolarPanel + " kWh"}</h3>
          </div>
        </div>
      </div>
      <div className="hotbar">
        <div className="hotbar-box">
          <Velocimeter className="hotbar-icons" />
          <div className="hotbar-text">
            <span className="hotbar-titles">energia gasta</span>
            <span className="hotbar-content">1.000kW</span>
          </div>
        </div>
        <div className="hotbar-box">
          <Thunder id="thunder-hotbar" className="hotbar-icons" />
          <div className="hotbar-text">
            <span className="hotbar-titles">total gerada</span>
            <span className="hotbar-content">5.130kW</span>
          </div>
        </div>
        <div className="hotbar-box">
          <Sun id="sun-hotbar" className="hotbar-icons" />
          <div className="hotbar-text">
            <span className="hotbar-titles">clima</span>
            <span className="hotbar-content">Ensolarado</span>
          </div>
        </div>
      </div>
    </div>
  );
}
export default GaugeChart;
