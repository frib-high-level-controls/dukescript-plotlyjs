package net.java.html.charts;

/*
 * #%L
 * charts-api - a library from the "DukeScript" project.
 * %%
 * Copyright (C) 2015 Dukehoff GmbH
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.glass.ui.Window;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import net.java.html.boot.BrowserBuilder;
import net.java.html.plotlyjs.*;
import netscape.javascript.JSObject;

import org.netbeans.html.boot.spi.Fn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author daykin
 */
public class ChartsTest implements Runnable {
    @SuppressWarnings("unchecked")
    private Plotly chart;
    private Fn.Presenter presenter;
    private boolean animationComplete;
    ObjectMapper mapper = new ObjectMapper();
    Random randGen = new Random();

    /**
     *
     * @throws InterruptedException
     */
    @BeforeMethod
    public void initializePresenter() throws InterruptedException {
        animationComplete = false;
        final CountDownLatch initialized = new CountDownLatch(1);
        final BrowserBuilder builder = BrowserBuilder.newBrowser().
            loadPage("charts.html").
            loadFinished(() -> {
                presenter = Fn.activePresenter();
                initialized.countDown();
        });
        Executors.newSingleThreadExecutor().execute(builder::showAndWait);
        initialized.await();
        assertNotNull(presenter, "We have the presenter");
    }
    
    /**
     *
     */
    @BeforeMethod
    public void configureMapper(){
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void basicLineChart() throws Exception {
        run(() -> {
            List<Number> x = new ArrayList<>();
            for (int i=0; i<10; i++){
                x.add(i);
            }
            List<Number> y = new ArrayList<>();
            for (int i=0; i<10; i++){
                y.add(i);
            }
            CartesianTrace trace = new CartesianTrace(x,y);
            Scatter<CartesianTrace> sctr = Scatter.<CartesianTrace>builder().trace(trace).build();
            PlotlyData<Scatter<CartesianTrace>> data = new PlotlyData<>(sctr);
            chart = Plotly.newPlot("chart", data, new Layout.Builder().title("chart").build());
            
            return null;
        });

    }
    
    /**
     *
     * @throws Exception
     */
    @Test
    public void flippedAxes() throws Exception {
        run(() -> {
            List<Number> x = new ArrayList<>();
            for (int i=0; i<10; i++){
                x.add(i);
            }
            List<Number> y = new ArrayList<>();
            for (int i=0; i<10; i++){
                y.add(i);
            }
            Scatter<CartesianTrace> sctr = Scatter.<CartesianTrace>builder().trace(new CartesianTrace(x,y)).build();
            PlotlyData<Scatter<CartesianTrace>> data = new PlotlyData<>(sctr);
            chart = Plotly.newPlot("chart", data, new Layout.Builder().title("chart").build());
            
            return null;
        });

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void basicHistogram2d() throws Exception {
        run(() -> {
            List<Number> x2d = new ArrayList<>();
            List<Number> y2d = new ArrayList<>();
            
            for(int i = 0; i<5000; i++){
                x2d.add(randGen.nextGaussian());
                y2d.add(randGen.nextGaussian());
            }

            CartesianTrace hist2dTrace = new CartesianTrace(x2d,y2d);
            Histogram2d<CartesianTrace> hist = Histogram2d.<CartesianTrace>builder().trace(hist2dTrace).nbinsx(50).nbinsy(50).build();
            PlotlyData<Histogram2d<CartesianTrace>>hist2dData = new PlotlyData<>(hist);
            Layout h2dLayout = new Layout.Builder().title("2D Histogram").width(480).height(400).build();
            chart = Plotly.newPlot("chart", hist2dData, h2dLayout);            
            return null;
        });
    }
    
    
    //Basic heatmap using random numbers

    /**
     *
     * @throws Exception
     */
        @Test
    public void basicHeatmap() throws Exception {
        run(() -> {
            List<ArrayList<Double>> zheat = new ArrayList<>();
            List<Number> xheat = new ArrayList<>();
            List<Number> yheat = new ArrayList<>();
            for(int x = 0; x<5; x++){
                zheat.add(new ArrayList<>());
                yheat.add(x);
                xheat.add(x);
                for(int i = 0; i<10; i++){
                    zheat.get(x).add(randGen.nextGaussian());
                }
            }
            Heatmap<XYZTrace> heat = Heatmap.<XYZTrace>builder().trace(new XYZTrace(xheat,yheat,zheat)).build();
            PlotlyData<Heatmap<XYZTrace>> heatData = new PlotlyData<>(heat);
            Layout heatmapLayout = new Layout.Builder().width(480).title("heatmap").height(400).build();
            chart = Plotly.newPlot("chart",heatData, heatmapLayout);            
            return null;
        });
    }
    
    /**
     *
     * @throws Exception
     */
    @Test
    public void barTest() throws Exception {
        run(() -> {
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
            
            Bar<CartesianTrace> bar0 = Bar.builder().trace(new CartesianTrace(barX,bar0y)).name("SF Zoo").build();
            Bar<CartesianTrace> bar1 = Bar.builder().trace(new CartesianTrace(barX,bar1y)).name("LA Zoo").build();
            
            PlotlyData<Bar<CartesianTrace>> barData = new PlotlyData<>(bar0,bar1);
            Layout barLayout = Layout.builder().title("Bar").barmode("group").build();            
            chart = Plotly.newPlot("chart", barData, barLayout);            
            return null;
        });
    }
    
    /**
     *
     * @throws Exception
     */
    @Test
    public void boxTest() throws Exception {
        run(() -> {
            String[] yArray = {"day 1", "day 1", "day 1", "day 1", "day 1", "day 1", "day 2", "day 2", "day 2", "day 2", "day 2", "day 2"};
            Double[] kaleX = {0.2, 0.2, 0.6, 1.0, 0.5, 0.4, 0.2, 0.7, 0.9, 0.1, 0.5, 0.3};
            Double[] radishX = {0.6, 0.7, 0.3, 0.6, 0.0, 0.5, 0.7, 0.9, 0.5, 0.8, 0.7, 0.2};
            Double[] carrotX = {0.1, 0.3, 0.1, 0.9, 0.6, 0.6, 0.9, 1.0, 0.3, 0.6, 0.8, 0.5};
            List<String> y = Arrays.asList(yArray);
            List<Double> kalex = Arrays.asList(kaleX);
            List<Double> radishx = Arrays.asList(radishX);
            List<Double> carrotx = Arrays.asList(carrotX);
            
            
            Box<CartesianTrace> trace1 = Box.builder().trace(new CartesianTrace(kalex,y))
                    .name("kale")
                    .marker(BoxMarker.builder().color("3D9970").build())
                    .boxmean(false)
                    .orientation(Charts.Orientations.HORIZONTAL)
                    .build();
            
            Box<CartesianTrace> trace2 = Box.builder()
                    .trace(new CartesianTrace(radishx,y))
                    .name("radishes")
                    .marker(BoxMarker.builder().color("#FF4136").build())
                    .boxmean(false)
                    .orientation(Charts.Orientations.HORIZONTAL)
                    .build();
            
            Box<CartesianTrace> trace3 = Box.builder()
                    .trace(new CartesianTrace(carrotx,y))
                    .name("carrots")
                    .marker(BoxMarker.builder().color("#FF851B").build())
                    .boxmean(false)
                    .orientation(Charts.Orientations.HORIZONTAL)
                    .build();
            
            net.java.html.plotlyjs.PlotlyData<Box<CartesianTrace>> boxdata = new net.java.html.plotlyjs.PlotlyData<>(trace1,trace2,trace3);
            
            Layout boxlayout = Layout.builder()
                    .title("Grouped Horizontal Box Plot")
                    .xaxis(Axis.builder().title("normalized moisture")
                            .zeroline(false)
                            .build())
                    .boxmode("group")
                    .build();
            
            chart = Plotly.newPlot("chart", boxdata, boxlayout);
            
            return null;
        });
    }
    
    /**
     *
     * @throws Exception
     */
    @Test
    public void basicTimeSeries() throws Exception {
        run(() -> {
            List<Number> ty = new ArrayList<>();
            List<Date> tt = new ArrayList<>();
            Long now = System.currentTimeMillis();
            for(int i=0;i<10;i++){
                tt.add(new Date(now + (1000*i)));
                ty.add(i);
            }
            TimeTrace timetrace0 = new TimeTrace(tt,ty);
            Scatter<CartesianTrace> timescatter = Scatter.<CartesianTrace>builder().trace(timetrace0).build();
            PlotlyData<Scatter<CartesianTrace>> timedata = new PlotlyData<>(timescatter);
            Layout timelayout = Layout.builder().title("Time series")
                    .width(480).height(400)
                    .xaxis(Axis.builder().type("date").build())
                    .build();
            chart = Plotly.newPlot("chart", timedata, timelayout);
            
            return null;
        });
    }
    
    /**
     *
     * @throws Exception
     */
    @Test
    public void contourTest()throws Exception{
        run(() -> {
            List <List<?>> contourZ = new ArrayList<>();
            ArrayList<Double> cz1 = new ArrayList<Double>(){{
                add(10.0);
                add(10.625);
                add(12.5);
                add(15.625);
                add(20.0);
            }};
            ArrayList<Double> cz2 = new ArrayList<Double>(){{
                add(5.625);
                add(6.25);
                add(8.125);
                add(11.25);
                add(15.625);
            }};
            ArrayList<Double> cz3 = new ArrayList<Double>(){{
                add(2.5);
                add(3.125);
                add(5.0);
                add(8.125);
                add(12.5);
            }};
            ArrayList<Double> cz4 = new ArrayList<Double>(){{
                add(0.625);
                add(1.25);
                add(3.125);
                add(6.25);
                add(10.625);
            }};
            ArrayList<Double> cz5 = new ArrayList<Double>(){{
                add(0.0);
                add(0.625);
                add(2.5);
                add(5.625);
                add(10.0);
            }};
            
            contourZ.add(cz1);
            contourZ.add(cz2);
            contourZ.add(cz3);
            contourZ.add(cz4);
            contourZ.add(cz5);
            Contour<XYZTrace> contour = Contour.<XYZTrace>builder().trace(new XYZTrace(null,null,contourZ)).build();
            net.java.html.plotlyjs.PlotlyData<Contour<?>> contourData = new PlotlyData<>(contour);
            chart = Plotly.newPlot("chart", contourData, Layout.builder().title("Contour plot").build());
            return null;
        });
    }
    
    //Make sure nonsense data types are ignored and don't cause runtime errors

    /**
     *
     * @throws Exception
     */
        @Test
    public void wrongTypeTest()throws Exception{
        run(() -> {
            List <List<?>> contourZ = new ArrayList<>();
            ArrayList<String> cz1 = new ArrayList<String>(){{
                add("never");
                add("gonna");
                add("give");
                add("you");
                add("up");
            }};
            ArrayList<Double> cz2 = new ArrayList<Double>(){{
                add(5.625);
                add(6.25);
                add(8.125);
                add(11.25);
                add(15.625);
            }};
            ArrayList<Double> cz3 = new ArrayList<Double>(){{
                add(2.5);
                add(3.125);
                add(5.0);
                add(8.125);
                add(12.5);
            }};
            ArrayList<Double> cz4 = new ArrayList<Double>(){{
                add(0.625);
                add(1.25);
                add(3.125);
                add(6.25);
                add(10.625);
            }};
            ArrayList<Double> cz5 = new ArrayList<Double>(){{
                add(0.0);
                add(0.625);
                add(2.5);
                add(5.625);
                add(10.0);
            }};
            contourZ.add(cz1);
            contourZ.add(cz2);
            contourZ.add(cz3);
            contourZ.add(cz4);
            contourZ.add(cz5);
            Contour<XYZTrace> contour = Contour.<XYZTrace>builder().trace(new XYZTrace(null,null,contourZ)).build();
            net.java.html.plotlyjs.PlotlyData<Contour<XYZTrace>> contourData = new PlotlyData<>(contour);
            chart = Plotly.newPlot("chart", contourData, Layout.builder().title("Contour plot").build());
            return null;
        });
    }    
    
    /**
     *
     * @throws Exception
     */
    @Test
    public void redrawTest()throws Exception{
        run(() -> {
            List<Number> x = new ArrayList<>();
            for (int i=0; i<10; i++){
                x.add(i);
            }
            List<Number> y = new ArrayList<>();
            for (int i=0; i<10; i++){
                y.add(i);
            }
            CartesianTrace trace = new CartesianTrace(x,y);
            Scatter<CartesianTrace> sctr = Scatter.<CartesianTrace>builder().trace(trace).build();
            PlotlyData<Scatter<CartesianTrace>> data = new PlotlyData<>(sctr);
            chart = Plotly.<Scatter<CartesianTrace>>newPlot("chart", data, new Layout.Builder().title("chart").build());
            Scatter<CartesianTrace> replacement = Scatter.<CartesianTrace>builder().trace(trace)
                    .marker(ScatterMarker.builder().opacity(0.7).build())
                    .build();
            chart.restyle(replacement,0);
            chart.redraw();
            JSObject plotdata = (JSObject)chart.getPlot();
            double newOpacity = (Double)plotdata.eval("this.data[0].marker.opacity");
            assertEquals(newOpacity, 0.7); //make sure we have the right redraw data            
            return null;
        });
    }
    
    /**
     *
     * @throws Exception
     */
    @Test
    public void restyleTest()throws Exception{
        run(() -> {
            List<Number> x = new CopyOnWriteArrayList<>();
            for (int i=0; i<10; i++){
                x.add(i);
            }
            List<Number> y = new CopyOnWriteArrayList<>();
            for (int i=0; i<10; i++){
                y.add(i);
            }
            CartesianTrace trace = new CartesianTrace(x,y);
            Scatter<CartesianTrace> sctr = Scatter.<CartesianTrace>builder().trace(trace).build();
            net.java.html.plotlyjs.PlotlyData<Scatter<CartesianTrace>> data = new PlotlyData<>(sctr);
            chart = Plotly.newPlot("chart", data, new Layout.Builder().title("chart").build());
            ScatterMarker restyle = ScatterMarker.builder().opacity(0.5).build();
            Scatter<CartesianTrace> replacement = Scatter.<CartesianTrace>builder().trace(trace)
                    .marker(restyle)
                    .build();            
            chart.restyle(replacement, 0);
            JSObject plotdata = (JSObject)chart.getPlot();
            double newOpacity = (Double)plotdata.eval("this.data[0].marker.opacity");
            assertEquals(newOpacity, 0.5); //make sure we have the right restyle data
            
            return null;
        });
    }
    
    /**
     *
     * @throws Exception
     */
    @Test
    public void relayoutTest()throws Exception{
        run(() -> {
            List<Number> x = new ArrayList<>();
            for (int i=0; i<10; i++){
                x.add(i);
            }
            List<Number> y = new ArrayList<>();
            for (int i=0; i<10; i++){
                y.add(i);
            }
            CartesianTrace trace = new CartesianTrace(x,y);
            Scatter<CartesianTrace> sctr = Scatter.<CartesianTrace>builder().trace(trace).build();
            PlotlyData<Scatter<CartesianTrace>> data = new PlotlyData<>(sctr);
            chart = Plotly.newPlot("chart", data, Layout.builder().title("chart").build());
            Layout newLayout = Layout.builder().title("newTitle").build();
            chart.relayout(newLayout);
            JSObject rawData = (JSObject)chart.getPlot();
            String newTitle = (String)rawData.eval("this.layout.title");
            assertEquals(newTitle,"newTitle","title change");            
            return null;
        });
    }
   
    /**
     *
     * @throws Exception
     */
    @Test
    public void addTracesTest()throws Exception{
        run(() -> {
            List<Number> scatter0x = new ArrayList<>();
            List<Number> scatter1x = new ArrayList<>();
            List<Number> scatter0y = new ArrayList<>();
            List<Number> scatter1y = new ArrayList<>();
            for(double i = 0;i<4*Math.PI;i+=.1){
                scatter0x.add(i);
                scatter1x.add(i);
                scatter0y.add(Math.sin(i));
                scatter1y.add(-1*Math.sin(i));
            }
            CartesianTrace scatterTrace0 = new CartesianTrace(scatter0x,scatter0y);
            CartesianTrace scatterTrace1 = new CartesianTrace(scatter1x,scatter1y);
            PlotlyData<Scatter<CartesianTrace>> scatterData =
                    new net.java.html.plotlyjs.PlotlyData<>(Scatter.<CartesianTrace>builder()
                            .trace(scatterTrace0)
                            .build());
            chart = Plotly.newPlot("chart", scatterData, Layout.builder().title("Scatter").width(480).height(400).build());
            chart.addTraces(Scatter.<CartesianTrace>builder().trace(scatterTrace1).build());
            JSObject rawData = (JSObject)chart.getPlot();
            int numTraces = (Integer)rawData.eval("this.data.length");
            assertEquals(numTraces, 2);
            
            return null;
        });
    }
    
    /**
     *
     * @throws Exception
     */
    @Test
    public void moveTracesTest()throws Exception{
        run(() -> {
            List<Number> scatter0x = new ArrayList<>();
            List<Number> scatter1x = new ArrayList<>();
            List<Number> scatter0y = new ArrayList<>();
            List<Number> scatter1y = new ArrayList<>();
            for(int i = 0;i<10;i+=1){
                scatter0x.add(i);
                scatter1x.add(i);
                scatter0y.add(i);
                scatter1y.add(10-i);
            }
            CartesianTrace scatterTrace0 = new CartesianTrace(scatter0x,scatter0y);
            CartesianTrace scatterTrace1 = new CartesianTrace(scatter1x,scatter1y);
            PlotlyData<Scatter<CartesianTrace>> scatterData =
                    new net.java.html.plotlyjs.PlotlyData<>(Scatter.<CartesianTrace>builder()
                            .trace(scatterTrace0)
                            .build(),
                            Scatter.<CartesianTrace>builder().trace(scatterTrace1).build());
            chart = Plotly.newPlot("chart", scatterData, Layout.builder().title("Scatter").width(480).height(400).build());
            chart.moveTraces(0);
            JSObject rawData = (JSObject)chart.getPlot();
            int zeroth = (Integer)rawData.eval("this.data[0].y[0]");
            assertEquals(zeroth,10);
            
            return null;
        });
    }
    
    /**
     *
     * @throws Exception
     */
    @Test
    public void deleteTracesTest()throws Exception{
        run(() -> {
            List<Number> scatter0x = new ArrayList<>();
            List<Number> scatter1x = new ArrayList<>();
            List<Number> scatter0y = new ArrayList<>();
            List<Number> scatter1y = new ArrayList<>();
            for(int i = 0;i<10;i+=1){
                scatter0x.add(i);
                scatter1x.add(i);
                scatter0y.add(i);
                scatter1y.add(10-i);
            }
            CartesianTrace scatterTrace0 = new CartesianTrace(scatter0x,scatter0y);
            CartesianTrace scatterTrace1 = new CartesianTrace(scatter1x,scatter1y);
            PlotlyData<Scatter<CartesianTrace>> scatterData =
                    new net.java.html.plotlyjs.PlotlyData<>(Scatter.<CartesianTrace>builder()
                            .trace(scatterTrace0)
                            .build(),
                            Scatter.<CartesianTrace>builder().trace(scatterTrace1).build());
            chart = Plotly.newPlot("chart", scatterData, Layout.builder().title("Scatter").width(480).height(400).build());
            chart.deleteTraces(0);
            JSObject rawData = (JSObject)chart.getPlot();
            int length = (Integer)rawData.eval("this.data.length");
            assertEquals(length,1);           
            return null;
        });
    }
    
    /**
     *
     * @throws Exception
     */
    @AfterMethod
    public void cleanUpTheGraph() throws Exception {
        if (chart != null) {
            run(() -> {
                chart = null;
                
                return null;
            });
        }
    }

    private void run(final Callable<?> r) throws Exception {
        final CountDownLatch await = new CountDownLatch(1);
        final Throwable[] arr = { null };
        Platform.runLater(() -> {
            try (Closeable c = Fn.activate(presenter)) {
                r.call();
            } catch (Throwable t) {
                arr[0] = t;
            } finally {
                await.countDown();
            }
        });
        await.await();
        if (arr[0] instanceof Exception) {
            throw (Exception)arr[0];
        }
        if (arr[0] instanceof Error) {
            throw (Error)arr[0];
        }
    }

    @Override
    public synchronized void run() {
        animationComplete = true;
        notifyAll();
    }

    private void waitForAnimation() throws Exception {
        waitForAnimationImpl();
    }
    private synchronized void waitForAnimationImpl() throws Exception {
        while (!animationComplete) {
            wait(1000);
            run(() -> {
                Window.getWindows().stream().forEach((w) -> {
                    w.setSize(w.getWidth(), w.getHeight() - 1);
                });
                return null;
            });
        }
    }

    static void assertInt(Object real, int exp, String msg) {
        if (real instanceof Number) {
            assertEquals(((Number)real).intValue(), exp, msg);
        } else {
            fail("Expecting number: " + real);
        }
    }
}
