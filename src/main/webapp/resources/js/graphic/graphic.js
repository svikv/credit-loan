$(function(){

    var ctx = document.getElementById("canvas");
    var data = {
        labels: $('#data .x').map(function() { return $(this).text(); }).get(),
        datasets: [
            {
                fill: false,
                lineTension: 0.1,
                backgroundColor: "rgba(75,192,192,0.4)",
                borderColor: "rgba(75,192,192,1)",
                borderCapStyle: 'butt',
                borderDash: [],
                borderDashOffset: 0.0,
                borderJoinStyle: 'miter',
                pointBorderColor: "rgba(75,192,192,1)",
                pointBackgroundColor: "#fff",
                pointBorderWidth: 1,
                pointHoverRadius: 5,
                pointHoverBackgroundColor: "rgba(75,192,192,1)",
                pointHoverBorderColor: "rgba(220,220,220,1)",
                pointHoverBorderWidth: 2,
                pointRadius: 2,
                pointHitRadius: 10,
                pointStyle: "circle",
                data: $('#data .y').map(function() { return $(this).text(); }).get()
            }
        ]
    };

    var myLineChart = new Chart(ctx, {
        type: 'line',
        data: data,
        options: {
            responsive: true,
            title: {
                display: true,
                fontSize: 14,
                text: 'Monthly payment plan'
            },
            legend: {
                display: false
            },
            scales: {
                xAxes: [{
                    scaleLabel:{
                        display: true,
                        fontSize: 14,
                        labelString: 'Month period'
                    },
                    ticks:{
                        stepSize: 2
                    }
                }],
                yAxes: [{
                    scaleLabel:{
                        display: true,
                        fontSize: 14,
                        labelString: 'Payment amount, grn'
                    }
                }]
            }
        }
    });
});