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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import net.java.html.boot.BrowserBuilder;
import net.java.html.plotlyjs.Axis;
import net.java.html.plotlyjs.Bar;
import net.java.html.plotlyjs.Box;
import net.java.html.plotlyjs.BoxMarker;
import net.java.html.plotlyjs.CartesianTrace;
import net.java.html.plotlyjs.Chart;
import net.java.html.plotlyjs.Data;
import net.java.html.plotlyjs.Heatmap;
import net.java.html.plotlyjs.Histogram;
import net.java.html.plotlyjs.Histogram2d;
import net.java.html.plotlyjs.HistogramMarker;
import net.java.html.plotlyjs.Layout;
import net.java.html.plotlyjs.Plotly;
import net.java.html.plotlyjs.Scatter;
import net.java.html.plotlyjs.ScatterMarker;
import net.java.html.plotlyjs.TimeTrace;
import netscape.javascript.JSObject;

import org.netbeans.html.boot.spi.Fn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("restriction")
public class ChartsTest implements Runnable {
    private Plotly chart;
    private Fn.Presenter presenter;
    private boolean animationComplete;
    ObjectMapper mapper = new ObjectMapper();
    Random randGen = new Random();

    @BeforeMethod
    public void initializePresenter() throws InterruptedException {
        animationComplete = false;
        final CountDownLatch initialized = new CountDownLatch(1);
        final BrowserBuilder builder = BrowserBuilder.newBrowser().
            loadPage("charts.html").
            loadFinished(new Runnable() {
                @Override
                public void run() {
                    presenter = Fn.activePresenter();
                    initialized.countDown();
                }
            });
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                builder.showAndWait();
            }
        });
        initialized.await();
        assertNotNull(presenter, "We have the presenter");
    }
    
    @BeforeMethod
    public void configureMapper(){
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    @Test
    public void basicLineChart() throws Exception {
        run(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                
                List<Number> x = new ArrayList<>();
                for (int i=0; i<10; i++){
                    x.add(i);
                }
                List<Number> y = new ArrayList<>();
                for (int i=0; i<10; i++){
                    y.add(i);
                }
                CartesianTrace trace = new CartesianTrace(x,y);
                Scatter sctr = Scatter.builder().data(trace).build();
                Data data = new Data(sctr);
                chart = Plotly.newPlot("scatter", data, new Layout.Builder().title("chart").build());
                return null;
            }
        });

    }

    @Test
    public void basicHistogram2d() throws Exception {
        run(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
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
            chart = Plotly.newPlot("histogram2d", hist2dData, h2dLayout);
            return null;
            }
        });
    }
    
    
    //Basic heatmap using random numbers
    @Test
    public void basicHeatmap() throws Exception {
        run(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
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
                chart = Plotly.newPlot("heatmap",new net.java.html.plotlyjs.Data(heat), heatmapLayout);
                return null;
            }
        });
    }
    
    @Test
    public void barTest() throws Exception {
        run(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
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
                
                Plotly barSample = Plotly.newPlot("bar", barData, barLayout);
                //System.out.println("built bar chart with " + mapper.writeValueAsString(bar0));
                return null;
            }
        });
    }
    
    @Test
    public void boxTest() throws Exception {
        run(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
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

                Plotly boxPlot = Plotly.newPlot("boxTest", boxdata, boxlayout);
                return null;
            }
        });
    }
    
    @Test
    public void basicTimechart() throws Exception {
        run(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
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
                Layout timelayout = Layout.builder().title("Histogram")
                        .width(480).height(400)
                        .xaxis(Axis.builder().type("date").build())
                        .build();
                chart = Plotly.newPlot("timeScatter", timedata, timelayout);
                
            return null;
            }
        });
    }

    
    @Test
    public void redrawTest()throws Exception{
        run(new Callable<Void>(){
            @Override
            public Void call() throws Exception{
                List<Number> x = new ArrayList<>();
                for (int i=0; i<10; i++){
                    x.add(i);
                }
                List<Number> y = new ArrayList<>();
                for (int i=0; i<10; i++){
                    y.add(i);
                }
                CartesianTrace trace = new CartesianTrace(x,y);
                Scatter sctr = Scatter.builder().data(trace).build();
                Data data = new Data(sctr);
                Plotly testChart = Plotly.newPlot("redrawTest", data, new Layout.Builder().title("chart").build());
                Scatter replacement = Scatter.builder().data(trace)
                        .marker(new ScatterMarker.Builder().opacity(0.7).build())
                        .build();
                data.updateTrace(0, replacement);
                testChart.redraw();
                JSObject plotdata = (JSObject)testChart.getPlot();
                double newOpacity = (Double)plotdata.eval("this.data[0].marker.opacity");
                assertEquals(newOpacity, 0.7); //make sure we have the right redraw data
                return null;
            }
        });
    }
    
    @Test
    public void restyleTest()throws Exception{
        run(new Callable<Void>(){
            @Override
            public Void call() throws Exception{
                List<Number> x = new ArrayList<>();
                for (int i=0; i<10; i++){
                    x.add(i);
                }
                List<Number> y = new ArrayList<>();
                for (int i=0; i<10; i++){
                    y.add(i);
                }
                CartesianTrace trace = new CartesianTrace(x,y);
                Scatter sctr = Scatter.builder().data(trace).build();
                Data data = new Data(sctr);
                Plotly testChart = Plotly.newPlot("restyleTest", data, new Layout.Builder().title("chart").build());
                ScatterMarker restyle = ScatterMarker.builder().opacity(0.5).build();    
                Scatter replacement = Scatter.builder().data(trace)
                            .marker(restyle)
                            .build();
                data.updateTrace(0, replacement);
                String strUpdate = mapper.writeValueAsString(restyle);
                testChart.restyle(strUpdate,0);
                JSObject plotdata = (JSObject)testChart.getPlot();
                double newOpacity = (Double)plotdata.eval("this.data[0].opacity");
                assertEquals(newOpacity, 0.5); //make sure we have the right restyle data
                return null;
            }
        });
    }
    
    @Test
    public void relayoutTest()throws Exception{
        run(new Callable<Void>(){
            @Override
            public Void call() throws Exception{
                List<Number> x = new ArrayList<>();
                for (int i=0; i<10; i++){
                    x.add(i);
                }
                List<Number> y = new ArrayList<>();
                for (int i=0; i<10; i++){
                    y.add(i);
                }
                CartesianTrace trace = new CartesianTrace(x,y);
                Scatter sctr = Scatter.builder().data(trace).build();
                Data data = new Data(sctr);
                Plotly testChart = Plotly.newPlot("relayoutTest", data, Layout.builder().title("chart").build());
                Layout newLayout = Layout.builder().title("newTitle").build();
                testChart.relayout(newLayout);
                JSObject rawData = (JSObject)testChart.getPlot();
                String newTitle = (String)rawData.eval("this.layout.title");
                assertEquals(newTitle,"newTitle","title change worked");
                return null;
            }
        });
    }
   
    @Test
    public void addTracesTest()throws Exception{
        run(new Callable<Void>(){
            @Override
            public Void call() throws Exception{
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
                net.java.html.plotlyjs.Data scatterData = 
                        new net.java.html.plotlyjs.Data<>(Scatter.builder()
                                .data(scatterTrace0)
                                .build());
                Plotly scatter = Plotly.newPlot("addTracesTest", scatterData, Layout.builder().title("Scatter").width(480).height(400).build());
                scatter.addTraces(Scatter.builder().data(scatterTrace1).build());
                JSObject rawData = (JSObject)scatter.getPlot();
                int numTraces = (Integer)rawData.eval("this.data.length");
                assertEquals(numTraces, 2);
                return null;
            }
        });
    }
    
    @Test
    public void moveTracesTest()throws Exception{
        run(new Callable<Void>(){
            @Override
            public Void call() throws Exception{
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
                net.java.html.plotlyjs.Data scatterData = 
                        new net.java.html.plotlyjs.Data<>(Scatter.builder()
                                .data(scatterTrace0)
                                .build(),
                        Scatter.builder().data(scatterTrace1).build());
                Plotly scatter = Plotly.newPlot("moveTracesTest", scatterData, Layout.builder().title("Scatter").width(480).height(400).build());
                scatter.moveTraces(0);
                JSObject rawData = (JSObject)scatter.getPlot();
                int zeroth = (Integer)rawData.eval("this.data[0].y[0]");
                assertEquals(zeroth,10);
                return null;
            }
        });
    }
    
    @Test
    public void deleteTracesTest()throws Exception{
        run(new Callable<Void>(){
            @Override
            public Void call() throws Exception{
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
                net.java.html.plotlyjs.Data scatterData = 
                        new net.java.html.plotlyjs.Data<>(Scatter.builder()
                                .data(scatterTrace0)
                                .build(),
                        Scatter.builder().data(scatterTrace1).build());
                Plotly scatter = Plotly.newPlot("deleteTracesTest", scatterData, Layout.builder().title("Scatter").width(480).height(400).build());
                scatter.deleteTraces(0);
                JSObject rawData = (JSObject)scatter.getPlot();
                int length = (Integer)rawData.eval("this.data.length");
                assertEquals(length,1);
                assertEquals(scatterData.getTraces().size(),1);
                return null;
            }
        });
    }
    
    
    @AfterMethod
    public void cleanUpTheGraph() throws Exception {
        if (chart != null) {
            run(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    chart = null;
                    return null;
                }
            });
        }
    }

    private void run(final Callable<?> r) throws Exception {
        final CountDownLatch await = new CountDownLatch(1);
        final Throwable[] arr = { null };
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try (Closeable c = Fn.activate(presenter)) {
                    r.call();
                } catch (Throwable t) {
                    arr[0] = t;
                } finally {
                    await.countDown();
                }
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
            run(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    for (Window w : Window.getWindows()) {
                        w.setSize(w.getWidth(), w.getHeight() - 1);
                    }
                    return null;
                }
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
