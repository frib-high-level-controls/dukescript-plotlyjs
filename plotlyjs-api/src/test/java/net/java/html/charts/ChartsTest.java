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

import com.sun.glass.ui.Window;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import net.java.html.boot.BrowserBuilder;
import net.java.html.plotlyjs.CartesianTrace;
import net.java.html.plotlyjs.Data;
import net.java.html.plotlyjs.Layout;
import net.java.html.plotlyjs.Plotly;
import net.java.html.plotlyjs.Scatter;
import net.java.html.plotlyjs.Trace;

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

    @Test
    public void lineChart() throws Exception {
        run(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                
                List<Number> x = new ArrayList<Number>();
                for (int i=0; i<10; i++){
                    x.add(i);
                }
                List<Number> y = new ArrayList<Number>();
                for (int i=0; i<10; i++){
                    y.add(i);
                }
                CartesianTrace trace = new CartesianTrace(x,y);
                Data data = new Data(new Scatter<>(trace));
                Plotly.newPlot("lineChart", data, new Layout("title"));

                return null;
            }
        });

//        waitForAnimation();
//
//        class CheckRenderAndRemove1st implements Callable<Void> {
//            @Override
//            public Void call() throws Exception {
//                assertInt(chart.eval("datasets.length"), 2, "Two datasets");
//                assertEquals(chart.eval("datasets[0].label"), "My First dataset");
//                assertInt(chart.eval("datasets[0].points.length"), 7, "Seven values set 0");
//                assertInt(chart.eval("datasets[1].points.length"), 7, "Seven values set 1");
//                assertInt(chart.eval("datasets[1].points[0].value"), 28, "1st value in 2nd set");
//                assertEquals(chart.eval("datasets[1].points[0].label"), "January", "1st label");
//                assertEquals(chart.eval("datasets[1].points[0].datasetLabel"), "My Second dataset", "2nd data set label");
//
//                chart.getData().remove(0);
//                return null;
//            }
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
