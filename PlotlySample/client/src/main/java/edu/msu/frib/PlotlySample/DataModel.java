package edu.msu.frib.PlotlySample;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.java.html.json.Model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import net.java.html.plotlyjs.Axis;
import net.java.html.plotlyjs.Bar;
import net.java.html.plotlyjs.Box;
import net.java.html.plotlyjs.BoxMarker;
import net.java.html.plotlyjs.CartesianTrace;
import net.java.html.plotlyjs.Chart;
import net.java.html.plotlyjs.Heatmap;
import net.java.html.plotlyjs.Histogram;
import net.java.html.plotlyjs.Histogram2d;
import net.java.html.plotlyjs.HistogramMarker;
import net.java.html.plotlyjs.Layout;
import net.java.html.plotlyjs.Plotly;
import net.java.html.plotlyjs.Scatter;
import net.java.html.plotlyjs.TimeTrace;

@Model(className = "Data", targetId="", properties = {
})
final class DataModel {
    private static Data ui;
    /**
     * Called when the page is ready.
     */
    static void onPageLoad() throws Exception {
        ui = new Data();
        ui.applyBindings();

        List<Number> scatter0x = new ArrayList<>();
        List<Number> scatter1x = new ArrayList<>();
        List<Number> scatter0y = new ArrayList<>();
        List<Number> scatter1y = new ArrayList<>();
        for(double i = 0;i<4*Math.PI;i+=.05){
            scatter0x.add(i);
            scatter1x.add(i);
            scatter0y.add(Math.sin(i));
            scatter1y.add(-1*Math.sin(i));
        }
        CartesianTrace scatterTrace0 = new CartesianTrace(scatter0x,scatter0y);
        CartesianTrace scatterTrace1 = new CartesianTrace(scatter1x,scatter1y);
        net.java.html.plotlyjs.Data scatterData = 
                new net.java.html.plotlyjs.Data<>(Scatter.builder()
                        .data(scatterTrace0).build(),
                        Scatter.builder()
                                .data(scatterTrace1)
                                .build());
        Plotly scatter = Plotly.newPlot("scatter", scatterData, new Layout.Builder().title("Scatter").width(480).height(400).build());
        scatter.moveTraces(0);
        scatter.redraw();
        
        
        List<Number> h0 = new ArrayList<>();
        List<Number> h1 = new ArrayList<>();
        Random randGen = new Random();
        for (int i=0; i<10000; i++){
            h0.add(randGen.nextGaussian()*2);
            h1.add(randGen.nextGaussian()*2+2);
        }        
        HistogramMarker hist0Marker = HistogramMarker.builder().color("blue").build();
        HistogramMarker hist1Marker = HistogramMarker.builder().color("red").build();
        Histogram hist0 = new Histogram.Builder().trace(new CartesianTrace().x(h0)).nbinsx(100).opacity(0.7).marker(hist0Marker).build();
        Histogram hist1 = new Histogram.Builder().trace(new CartesianTrace().x(h1)).nbinsx(100).opacity(0.7).marker(hist1Marker).build();
        net.java.html.plotlyjs.Data data = new net.java.html.plotlyjs.Data(hist0,hist1);
        Layout layout = new Layout.Builder().title("Histogram")
                .barmode("overlay")
                .width(480).height(400)
                .xaxis(new Axis.Builder().dtick(10).nticks(10).build())
                .build();
        Plotly lineChart = Plotly.newPlot("histogram", data, layout);
        data.updateTrace(1, hist1);
        lineChart.redraw();
        
        List<Number> ty = new ArrayList<>();
        List<Date> tt = new ArrayList<>();
        Long now = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            tt.add(new Date(now + (1000*i)));
            ty.add(i);
        }
        TimeTrace timetrace0 = new TimeTrace(tt,ty);
        Scatter timescatter = Scatter.builder().data(timetrace0).build();
        net.java.html.plotlyjs.Data timedata = new net.java.html.plotlyjs.Data(timescatter);
        Layout timelayout = new Layout.Builder().title("Scatter with time axis")
                .width(480).height(400)
                .xaxis(new Axis.Builder().type("date").build())
                .build();
        Plotly timeChart = Plotly.newPlot("timeScatter", timedata, timelayout);
        
        //2d histogram
        List<Number> x2d = new ArrayList<>();
        List<Number> y2d = new ArrayList<>();
        
        for(int i = 0; i<5000; i++){
            x2d.add(randGen.nextGaussian());
            y2d.add(randGen.nextGaussian());
        }
        
        CartesianTrace hist2dTrace = new CartesianTrace(x2d,y2d);
        Histogram2d hist = new Histogram2d.Builder().data(hist2dTrace).nbinsx(50).nbinsy(50).build();
        net.java.html.plotlyjs.Data hist2dData = new net.java.html.plotlyjs.Data(hist);
        Layout h2dLayout = new Layout.Builder().title("2D Histogram").width(480).height(400).build();
        Plotly hist2d = Plotly.newPlot("histogram2d", hist2dData, h2dLayout);
        
        
        List<ArrayList<Double>> zheat = new ArrayList<>();
        List<Number> xheat = new ArrayList<>();
        List<Number> yheat = new ArrayList<>();
        for(int x = 0; x<5; x++){
            zheat.add(new ArrayList<Double>());
            yheat.add(x);
            xheat.add(x);
            for(int i = 0; i<10; i++){
                zheat.get(x).add(randGen.nextGaussian());
            }
        }
        Heatmap heat = new Heatmap.Builder().x(xheat).y(yheat).z(zheat).build();
        
        Layout heatmapLayout = new Layout.Builder().width(480).title("heatmap").height(400).build();
        Plotly heatmap = Plotly.newPlot("heatmap",new net.java.html.plotlyjs.Data(heat), heatmapLayout);
        
        ArrayList<String> barX = new ArrayList<String>() {{
            add("giraffes");
            add("orangutans");
            add("monkeys");
        }};
        ArrayList<Number> bar0y = new ArrayList<Number>(){{
            add(20);
            add(14);
            add(23);
        }};
        
        ArrayList<Number> bar1y = new ArrayList<Number>(){{
            add(12);
            add(18);
            add(29);
        }};
        
        Bar bar0 = Bar.builder().x(barX).y(bar0y).name("SF Zoo").build();
        Bar bar1 = Bar.builder().x(barX).y(bar1y).name("LA Zoo").build();
        
        net.java.html.plotlyjs.Data barData = new net.java.html.plotlyjs.Data(bar0,bar1);
        Layout barLayout = Layout.builder().title("Bar").barmode("group").build();
        Plotly barSample = Plotly.newPlot("barSample", barData, barLayout);
        
        // Box plot
        String[] yArray = {"day 1", "day 1", "day 1", "day 1", "day 1", "day 1", "day 2", "day 2", "day 2", "day 2", "day 2", "day 2"};
        Double[] kaleX = {0.2, 0.2, 0.6, 1.0, 0.5, 0.4, 0.2, 0.7, 0.9, 0.1, 0.5, 0.3};
        Double[] radishX = {0.6, 0.7, 0.3, 0.6, 0.0, 0.5, 0.7, 0.9, 0.5, 0.8, 0.7, 0.2};
        Double[] carrotX = {0.1, 0.3, 0.1, 0.9, 0.6, 0.6, 0.9, 1.0, 0.3, 0.6, 0.8, 0.5};
        List<String> y = Arrays.asList(yArray);
        List<Double> kalex = Arrays.asList(kaleX);
        List<Double> radishx = Arrays.asList(radishX);
        List<Double> carrotx = Arrays.asList(carrotX);
        
        
        Box trace1 = Box.builder().x(kalex)
                .y(y)
                .name("kale")
                .marker(BoxMarker.builder().color("3D9970").build())
                .boxmean(false)
                .orientation(Chart.Orientations.HORIZONTAL)
                .build();
        
        Box trace2 = Box.builder()
                .x(radishx)
                .y(y)
                .name("radishes")
                .marker(BoxMarker.builder().color("#FF4136").build())
                .boxmean(false)
                .orientation(Chart.Orientations.HORIZONTAL)
                .build();
        
        Box trace3 = Box.builder()
                .x(carrotx)
                .y(y)
                .name("carrots")
                .marker(BoxMarker.builder().color("#FF851B").build())
                .boxmean(false)
                .orientation(Chart.Orientations.HORIZONTAL)
                .build();
        
        net.java.html.plotlyjs.Data<Box> boxdata = new net.java.html.plotlyjs.Data<>(trace1,trace2,trace3);
        
        Layout boxlayout = Layout.builder()
                .title("Grouped Horizontal Box Plot")
                .xaxis(Axis.builder().title("normalized moisture")
                .zeroline(false)
                .build())
                .boxmode("group")
                .build();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
        System.out.println(mapper.writeValueAsString(boxdata));
        Plotly boxPlot = Plotly.newPlot("box", boxdata, boxlayout);
        
        
    }
}
