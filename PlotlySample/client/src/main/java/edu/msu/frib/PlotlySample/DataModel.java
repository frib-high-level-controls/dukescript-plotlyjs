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
import net.java.html.json.Property;
import net.java.html.plotlyjs.*;
import netscape.javascript.JSObject;



@Model(className = "Point", targetId="", properties = {
    @Property(name = "x", type = double.class),
    @Property(name = "y", type = double.class),
    @Property(name = "z", type = double.class)
})
final class DataModel {
    private static Point ui;
    /**
     * Called when the page is ready.
     */
    
    static void onPageLoad() throws Exception {
        ui = new Point(0,0,0);
        ui.applyBindings();
        initializeCharts();

    }
    private static class ExampleListener implements ChartListener{
        private final Plotly <? extends Chart> chart;
        public ExampleListener(Plotly <? extends Chart> chart){
            this.chart = chart;
        }

        @Override
        public void plotly_click(ClickEvent ev) {
              JSObject plotObj = (JSObject)ev.info;
              Object plotdata = ((JSObject)plotObj).eval("this.points");
              Object pt = ((JSObject)plotdata).getSlot(0);
              StringBuilder sb = new StringBuilder();
              sb.append("Nearest point to cursor: (")
              .append(((JSObject)pt).eval("this.x.toPrecision(2)"))
                      .append(", ")
                      .append(((JSObject)pt).eval("this.y.toPrecision(2)"))
                      .append(")");
              sb = (ev.shift)?sb.append(", Shift pressed"):sb.append(", Shift not pressed");
              sb = (ev.ctrl)?sb.append(", Ctrl pressed"):sb.append(", Ctrl not pressed");
              System.out.println(sb.toString());
        }

        @Override
        public void plotly_hover(HoverEvent ev) {
            JSObject plotObj = (JSObject)ev.info;
                Object plotdata = ((JSObject)plotObj).eval("this.points");
                Object pt = ((JSObject)plotdata).getSlot(0);
                double x = new Double((String)((JSObject)pt).eval("this.x.toPrecision(3)"));
                double y = new Double((String)((JSObject)pt).eval("this.y.toPrecision(3)"));
                ui.setX(x);
                ui.setY(y);
                System.out.println(ui.toString());
                      
        }

        @Override
        public void plotly_zoom(ZoomEvent ev) {
            
            JSObject plotdata = (JSObject)ev.info;
            if(plotdata.eval("this['xaxis.autorange']") instanceof Boolean){
            System.out.println("Range returned to default scale.");
            }
            else{
            Date begin = new Date();
            Date end = new Date();
            begin.setTime(((Double)plotdata.eval("this['xaxis.range[0]']")).longValue());
            end.setTime(((Double)plotdata.eval("this['xaxis.range[1]']")).longValue());
            StringBuilder sb = new StringBuilder();
            sb.append("Showing data from ")
                    .append(begin.toString())
                    .append(" to ")
                    .append(end.toString())
                    .append(".");
            System.out.println(sb.toString());
            }
        }

        @Override
        public void plotly_unhover(UnhoverEvent ev){
            System.out.println("Something got unhovered!");
        }
        
        
    }
    
    static void initializeCharts() throws Exception{
        List<Number> scatter0x = new ArrayList<>();
        List<Number> scatter0y = new ArrayList<>();

        for(double i = 0;i<4*Math.PI;i+=.05){
            scatter0x.add(i);
            scatter0y.add(Math.sin(i));
        }
        
        CartesianTrace scatterTrace0 = new CartesianTrace(scatter0x,scatter0y);
        PolarTrace scatterTrace1 = new PolarTrace(scatter0x, scatter0y);
        net.java.html.plotlyjs.PlotlyData<Scatter<CartesianTrace>> scatterData = 
                new net.java.html.plotlyjs.PlotlyData<Scatter<CartesianTrace>>(Scatter.builder()
                        .data(scatterTrace0).build());
        Scatter<PolarTrace> polar = Scatter.builder().data(scatterTrace1).build();
        Plotly scatter = Plotly.newPlot("scatter", scatterData, new Layout.Builder().title("Scatter with Click Event").width(480).height(400).build());
        //scatterData.addTraces(polar);
        ExampleListener exList = new ExampleListener(scatter);
        scatter.addClickListener(exList);
        //scatter.moveTraces(0);
        //scatter.redraw();
        
//        
//        List<Number> h0 = new ArrayList<>();
//        List<Number> h1 = new ArrayList<>();
//        Random randGen = new Random();
//        for (int i=0; i<10000; i++){
//            h0.add(randGen.nextGaussian()*2);
//            h1.add(randGen.nextGaussian()*2+2);
//        }        
//        HistogramMarker hist0Marker = HistogramMarker.builder().color("blue").build();
//        HistogramMarker hist1Marker = HistogramMarker.builder().color("red").build();
//        Histogram hist0 = new Histogram.Builder().trace(new CartesianTrace().x(h0)).nbinsx(100).opacity(0.7).marker(hist0Marker).build();
//        Histogram hist1 = new Histogram.Builder().trace(new CartesianTrace().x(h1)).nbinsx(100).opacity(0.7).marker(hist1Marker).build();
//        net.java.html.plotlyjs.PlotlyData data = new net.java.html.plotlyjs.PlotlyData(hist0,hist1);
//        Layout layout = new Layout.Builder().title("Histogram with hover events")
//                .barmode("overlay")
//                .width(480).height(400)
//                .hovermode("closest")
//                .xaxis(new Axis.Builder().dtick(10).nticks(10).build())
//                .build();
//        Plotly hst = Plotly.newPlot("histogram", data, layout);
//        ExampleListener hoverListener = new ExampleListener(hst);
//        hst.addHoverListener(hoverListener);
//        hst.addUnhoverListener(hoverListener);
//        data.updateTrace(1, hist1);
//        hst.redraw();
//        
//        
//        List<Number> ty = new ArrayList<>();
//        List<Date> tt = new ArrayList<>();
//        Long now = System.currentTimeMillis();
//        for(int i=0;i<10;i++){
//            tt.add(new Date(now + (1000*i)));
//            ty.add(i);
//        }
//        TimeTrace timetrace0 = new TimeTrace(tt,ty);
//        Scatter timescatter = Scatter.builder().data(timetrace0).build();
//        net.java.html.plotlyjs.PlotlyData timedata = new net.java.html.plotlyjs.PlotlyData(timescatter);
//        Layout timelayout = new Layout.Builder().title("Time series")
//                .width(480).height(400)
//                .xaxis(new Axis.Builder().type("date").build())
//                .build();
//        Plotly timeChart = Plotly.newPlot("timeScatter", timedata, timelayout);
//        ExampleListener zoomlist = new ExampleListener(timeChart);
//        timeChart.addZoomListener(zoomlist);
//        
//        //2d histogram
//        List<Number> x2d = new ArrayList<>();
//        List<Number> y2d = new ArrayList<>();
//        
//        for(int i = 0; i<5000; i++){
//            x2d.add(randGen.nextGaussian());
//            y2d.add(randGen.nextGaussian());
//        }
//        
//        CartesianTrace hist2dTrace = new CartesianTrace(x2d,y2d);
//        Histogram2d hist = new Histogram2d.Builder().data(hist2dTrace).nbinsx(50).nbinsy(50).build();
//        net.java.html.plotlyjs.PlotlyData hist2dData = new net.java.html.plotlyjs.PlotlyData(hist);
//        Layout h2dLayout = new Layout.Builder().title("2D Histogram").width(480).height(400).build();
//        Plotly hist2d = Plotly.newPlot("histogram2d", hist2dData, h2dLayout);
//        
//        
//        List<ArrayList<Double>> zheat = new ArrayList<>();
//        List<Number> xheat = new ArrayList<>();
//        List<Number> yheat = new ArrayList<>();
//        for(int x = 0; x<5; x++){
//            zheat.add(new ArrayList<Double>());
//            yheat.add(x);
//            xheat.add(x);
//            for(int i = 0; i<10; i++){
//                zheat.get(x).add(randGen.nextGaussian());
//            }
//        }
//        Heatmap heat = new Heatmap.Builder().x(xheat).y(yheat).z(zheat).build();
//        
//        Layout heatmapLayout = new Layout.Builder().width(480).title("heatmap").height(400).build();
//        Plotly heatmap = Plotly.newPlot("heatmap",new net.java.html.plotlyjs.PlotlyData(heat), heatmapLayout);
//        
//        ArrayList<String> barX = new ArrayList<String>() {{
//            add("giraffes");
//            add("orangutans");
//            add("monkeys");
//        }};
//        ArrayList<Number> bar0y = new ArrayList<Number>(){{
//            add(20);
//            add(14);
//            add(23);
//        }};
//        
//        ArrayList<Number> bar1y = new ArrayList<Number>(){{
//            add(12);
//            add(18);
//            add(29);
//        }};
//        
//        Bar bar0 = Bar.builder().x(barX).y(bar0y).name("SF Zoo").build();
//        Bar bar1 = Bar.builder().x(barX).y(bar1y).name("LA Zoo").build();
//        
//       net.java.html.plotlyjs.PlotlyData barData = new net.java.html.plotlyjs.PlotlyData(bar0,bar1);
//        Layout barLayout = Layout.builder().title("Bar").barmode("group").build();
//        Plotly barSample = Plotly.newPlot("barSample", barData, barLayout);
//        
//        // Box plot
//        String[] yArray = {"day 1", "day 1", "day 1", "day 1", "day 1", "day 1", "day 2", "day 2", "day 2", "day 2", "day 2", "day 2"};
//        Double[] kaleX = {0.2, 0.2, 0.6, 1.0, 0.5, 0.4, 0.2, 0.7, 0.9, 0.1, 0.5, 0.3};
//        Double[] radishX = {0.6, 0.7, 0.3, 0.6, 0.0, 0.5, 0.7, 0.9, 0.5, 0.8, 0.7, 0.2};
//        Double[] carrotX = {0.1, 0.3, 0.1, 0.9, 0.6, 0.6, 0.9, 1.0, 0.3, 0.6, 0.8, 0.5};
//        List<String> y = Arrays.asList(yArray);
//        List<Double> kalex = Arrays.asList(kaleX);
//        List<Double> radishx = Arrays.asList(radishX);
//        List<Double> carrotx = Arrays.asList(carrotX);
//        
//        
//        Box trace1 = Box.builder().x(kalex)
//                .y(y)
//                .name("kale")
//                .marker(BoxMarker.builder().color("3D9970").build())
//                .boxmean(false)
//                .orientation(Chart.Orientations.HORIZONTAL)
//                .build();
//        
//        Box trace2 = Box.builder()
//                .x(radishx)
//                .y(y)
//                .name("radishes")
//                .marker(BoxMarker.builder().color("#FF4136").build())
//                .boxmean(false)
//                .orientation(Chart.Orientations.HORIZONTAL)
//                .build();
//        
//        Box trace3 = Box.builder()
//                .x(carrotx)
//                .y(y)
//                .name("carrots")
//                .marker(BoxMarker.builder().color("#FF851B").build())
//                .boxmean(false)
//                .orientation(Chart.Orientations.HORIZONTAL)
//                .build();
//       
//        net.java.html.plotlyjs.PlotlyData<Box> boxdata = new net.java.html.plotlyjs.PlotlyData<>(trace1,trace2,trace3);
//        
//        Layout boxlayout = Layout.builder()
//                .title("Grouped Horizontal Box Plot")
//                .xaxis(Axis.builder().title("normalized moisture")
//                .zeroline(false)
//                .build())
//                .boxmode("group")
//                .build();
//        Plotly boxPlot = Plotly.newPlot("box", boxdata, boxlayout);
//        
//        
//        ArrayList<Integer> values = new ArrayList<Integer>(){{
//            add(19);
//            add(26);
//            add(55);
//        }};
//        ArrayList<String> labels = new ArrayList<String>(){{
//                add("Residential");
//                add("Commercial");
//                add("Utility");
//        }};
//        Pie pie = Pie.builder().values(values).labels(labels).build();
//        net.java.html.plotlyjs.PlotlyData<Pie> pieData = new net.java.html.plotlyjs.PlotlyData<>(pie);
//        Layout pieLayout = Layout.builder().title("Pie Chart").height(400).width(500).build();
//        Plotly pieChart = Plotly.newPlot("pie", pieData, pieLayout);
//        
//        //contour
//        List <List> contourZ = new ArrayList<>();
//        ArrayList<Double> cz1 = new ArrayList(){{
//            add(10);
//            add(10.625);
//            add(12.5);
//            add(15.625);
//            add(20);
//        }};
//        ArrayList<Double> cz2 = new ArrayList(){{
//            add(5.625);
//            add(6.25);
//            add(8.125);
//            add(11.25);
//            add(15.625);
//        }};
//        ArrayList<Double> cz3 = new ArrayList(){{
//            add(2.5);
//            add(3.125);
//            add(5);
//            add(8.125);
//            add(12.5);
//        }};
//        ArrayList<Double> cz4 = new ArrayList(){{
//            add(0.625);
//            add(1.25);
//            add(3.125);
//            add(6.25);
//            add(10.625);
//        }};
//        ArrayList<Double> cz5 = new ArrayList(){{
//            add(0);
//            add(0.625);
//            add(2.5);
//            add(5.625);
//            add(10);
//        }};
//        
//        contourZ.add(cz1);
//        contourZ.add(cz2);
//        contourZ.add(cz3);
//        contourZ.add(cz4);
//        contourZ.add(cz5);
//        Contour contour = Contour.builder().z(contourZ).build();
//        net.java.html.plotlyjs.PlotlyData<Contour> contourData = new net.java.html.plotlyjs.PlotlyData(contour);
//        Plotly cplot = Plotly.newPlot("contour", contourData, Layout.builder().title("Contour plot").build());
//        
//        ArrayList<Double> s3dx = new ArrayList<>();
//        ArrayList<Double> s3dy = new ArrayList<>();
//        ArrayList<Double> s3dz = new ArrayList<>();
//        for(int i=0; i<10;i++){
//            s3dx.add(randGen.nextGaussian());
//            s3dy.add(randGen.nextGaussian());
//            s3dz.add(randGen.nextGaussian());
//        }
//        Scatter3d s3d = Scatter3d.builder()
//                .x(s3dx)
//                .y(s3dy)
//                .z(s3dz)
//                .build();
//        PlotlyData s3dData = new PlotlyData(s3d);
//        Layout s3dLayout = Layout.builder().build();
//        Plotly s3dPlot = Plotly.newPlot("scatter3d", s3dData, s3dLayout);

    }
}