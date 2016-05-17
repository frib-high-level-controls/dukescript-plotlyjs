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

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.java.html.js.JavaScriptBody;
import net.java.html.plotlyjs.CartesianTrace;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import net.java.html.plotlyjs.ChartListener;
import net.java.html.plotlyjs.ClickEvent;
import net.java.html.plotlyjs.HoverEvent;
import net.java.html.plotlyjs.Layout;
import net.java.html.plotlyjs.Plotly;
import net.java.html.plotlyjs.PlotlyException;
import net.java.html.plotlyjs.Scatter;
import net.java.html.plotlyjs.UnhoverEvent;
import net.java.html.plotlyjs.ZoomEvent;
import netscape.javascript.JSObject;

public class ListenersTest {
    
    public static class L implements ChartListener{
        
        @Override
        public void plotly_click(ClickEvent ev) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void plotly_hover(HoverEvent ev) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void plotly_zoom(ZoomEvent ev) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void plotly_unhover(UnhoverEvent ev) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    

    private L click;
    private L hover;
    private L zoom;
    private L unhover;
    private Plotly plot;

    public ListenersTest() throws PlotlyException {
        List<Number> x = new CopyOnWriteArrayList<>();
//                for (int i=0; i<10; i++){
//                    x.add(i);
//                }
//                List<Number> y = new CopyOnWriteArrayList<>();
//                for (int i=0; i<10; i++){
//                    y.add(i);
//                }
//                CartesianTrace trace = new CartesianTrace(x,y);
//                Scatter sctr = Scatter.builder().data(trace).build();
//                net.java.html.plotlyjs.PlotlyData data = new net.java.html.plotlyjs.PlotlyData(sctr);
//                plot = Plotly.newPlot("chart", data, new Layout.Builder().title("chart").build()); 
    }

    @BeforeMethod
    public void addFewItems() {
//        plot.addClickListener(click);
//        plot.addHoverListener(hover);
//        plot.addZoomListener(zoom);
//        plot.addUnhoverListener(unhover);
    }

    @Test
    public void testRemoveLast() {
//        current = Listeners.remove(current, l3);
//        List<ChartListener> arr = Listeners.all(current);
//        assertEquals(arr.size(), 2, "just two");
//        assertEquals(arr.get(0), l1);
//        assertEquals(arr.get(1), l2);
    }

    @Test
    public void testRemoveSecond() {
//        current = Listeners.remove(current, l2);
//        List<ChartListener> arr = Listeners.all(current);
//        assertEquals(arr.size(), 2, "just two");
//        assertEquals(arr.get(0), l1);
//        assertEquals(arr.get(1), l3);
    }

    @Test
    public void testRemoveFirst() {
//        current = Listeners.remove(current, l1);
//        List<ChartListener> arr = Listeners.all(current);
//        assertEquals(arr.size(), 2, "just two");
//        assertEquals(arr.get(0), l2, "l2: " + arr);
//        assertEquals(arr.get(1), l3, "l3: " + arr);
    }

    @Test
    public void testRemoveTwo() {
//        current = Listeners.remove(current, l1);
//        current = Listeners.remove(current, l2);
//        List<ChartListener> arr = Listeners.all(current);
//        assertEquals(arr.size(), 1, "just one");
//        assertEquals(arr.get(0), l3);
    }

    @Test
    public void testRemoveSecondTwo() {
//        current = Listeners.remove(current, l2);
//        current = Listeners.remove(current, l3);
//        List<ChartListener> arr = Listeners.all(current);
//        assertEquals(arr.size(), 1, "just one");
//        assertEquals(arr.get(0), l1);
    }

    @Test
    public void testRemoveFirstLast() {
//        current = Listeners.remove(current, l1);
//        current = Listeners.remove(current, l3);
//        List<ChartListener> arr = Listeners.all(current);
//        assertEquals(arr.size(), 1, "just one");
//        assertEquals(arr.get(0), l2);
    }
//
//    @Test(expectedExceptions = PlotlyException.class)
//    public void testRemoveOutOfRange() throws PlotlyException{
//        plot.removeClickListener(12345);
//    }
    
    @Test
    public void testRemoveAll() {
//        current = Listeners.remove(current, l1);
//        current = Listeners.remove(current, l3);
//        current = Listeners.remove(current, l2);
//        List<ChartListener> arr = Listeners.all(current);
//        assertEquals(arr.size(), 0, "empty");
//
//        current = Listeners.add(current, new L("l4"));
//        arr = Listeners.all(current);
//        assertEquals(arr.size(), 1, "one");
    }

//    private static final class L implements ChartListener {
//        private final String id;
//
//        public L(String id) {
//            this.id = id;
//        }
//
//
//        @Override
//        public void chartClick(ChartEvent ev) {
//        }
//
//        @Override
//        public String toString() {
//            return "L[" + id + "]";
//        }
//
//
//    }
    
//    @JavaScriptBody(args = {"context"},body = ""
//            + "")
//    public static native void generateClickEvent(JSObject context);
}
