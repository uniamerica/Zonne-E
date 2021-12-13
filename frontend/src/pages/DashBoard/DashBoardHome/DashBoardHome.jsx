import "./dashBoardHome.css";
import { useState } from "react";
import { Link } from "react-router-dom";
import GaugeChart from "../../../components/gaugeChart/GaugeChart";
import ChartBar from "../../../components/chartBar/ChartBar";

function DashBoardHome(){
    
    return(
        <div>
            <h1 style={{
                position: 'relative',
                top: '150px',
                left: '250px',
            }}>DashBoard</h1>
            <GaugeChart />
            <ChartBar />
        </div>
    );
}
export default DashBoardHome;