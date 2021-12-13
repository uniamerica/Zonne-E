import { Chart as ChartJS } from 'chart.js/auto'
import { Chart, Bar }            from 'react-chartjs-2'

function ChartBar() {
  return (
    <div style={{
        width: '400px',
        height: '400px'
    }}>
      <Bar style={{
          position: "absolute",
          left: '870px',
      }}
        data={{
          labels: ["6:00", "9:00", "12:00", "15:00", "18:00"],
          datasets: [
            {
              label: 'Energia Gerada',
              data: [1050, 1250, 2500, 1400, 1200],
              backgroundColor: '#f6ae2d',
            },
          ],
        }}
        height={200}
        width={200}
        />
    </div>
  );
}
export default ChartBar;
