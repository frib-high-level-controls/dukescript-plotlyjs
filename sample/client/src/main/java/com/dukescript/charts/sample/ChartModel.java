package com.dukescript.charts.sample;

import java.util.Arrays;

/*
 * #%L
 * Charts Sample General Code - a library from the "DukeScript" project.
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
import java.util.Random;
import net.java.html.json.Model;
import net.java.html.charts.Chart;
import net.java.html.charts.ChartEvent;
import net.java.html.charts.ChartListener;
import net.java.html.charts.Color;
import net.java.html.charts.Config;
import net.java.html.charts.Segment;
import net.java.html.charts.Values;
import net.java.html.json.Function;
import net.java.html.json.ModelOperation;
import net.java.html.json.Property;

import org.csstudio.scan.display.DataNotifier;
import org.csstudio.scan.display.DataProviderException;
import org.csstudio.scan.display.DataProviderWrapper;
import org.csstudio.scan.display.ScanDisplayService;
import org.csstudio.scan.display.data.Scan;
import org.diirt.util.array.ArrayDouble;
import org.diirt.util.array.IteratorDouble;
import org.diirt.vtype.VLong;
import org.diirt.vtype.VTable;

@Model(className = "Data", targetId="", properties = {
    @Property(name = "code", type = String.class),
    @Property(name = "numProviders", type = int.class),
    @Property(name = "providerName", type = String.class),
    @Property(name = "arrayTest", type = double.class, array = true),
    @Property(name = "scan", type = ScanModel.class, array = true),
    @Property(name = "currentScan", type = long.class),
    @Property(name = "maxScans", type = long.class)
})
public final class ChartModel {
    private static Data ui;
    private static final Color[] PALETTE = {
        Color.valueOf("#4D4D4D"),
        Color.valueOf("#5DA5DA"),
        Color.valueOf("#FAA43A"),
        Color.valueOf("#60BD68"),
        Color.valueOf("#F17CB0"),
        Color.valueOf("#B2912F"),
        Color.valueOf("#B276B2"),
        Color.valueOf("#DECF3F"),
        Color.valueOf("#F15854")
    };
    private static int paletteIndex;
    private static Chart<?,?> chart;
    private static final double[] VALUES = new double[12];
    private static final String[] NAMES = {
        "January", "February", "March",
        "April", "May", "June", "July",
        "August", "September", "October", "November", "December"
    };
    
    private static ScanDisplayService scanDisplayService = ScanDisplayService.getInstance();
    private static List<DataProviderWrapper> dataProviders = scanDisplayService.getDataProviders();

    
    public static void onPageLoad() throws Exception {
        ScanDisplayService scanDisplayService = ScanDisplayService.getInstance();
        List<DataProviderWrapper> dataProviders = scanDisplayService.getDataProviders();

//        dataProviders.get(0).getProvider().addDataNotifier(new ChartModel());;
        Random r = new Random();
        for (int i = 0; i < VALUES.length; i++) {
            VALUES[i] = (int)(r.nextDouble() * 100.0);
        }
        List<Scan> scans = dataProviders.get(0).getProvider().getScans(4);
        ui = new Data();
//        ArrayDouble sampledata =(ArrayDouble)table.getColumnData(0);
//        IteratorDouble inter = sampledata.iterator();
//        while(inter.hasNext()){
//            ui.getArrayTest().add(inter.nextDouble());
//        }
//         for(Scan scan : scans){
//             ScanData scanData = new ScanData();
//             scanData.setId(scan.getId());
//             scanData.setName(scan.getName());
//             ui.getScan().add(scanData);
//         }
        ui.applyBindings();
        plotLine(ui,scans);
    }
       
//    @Override
//    public void scanDataUpdated(Scan scan) {
////        scan.getScanData().getColumnName(column);
//    }
    
    static void plotLine(Data model , List<Scan> scans) {
        final Color c1 = PALETTE[nextPaletteIndex()];
        final Color c2 = PALETTE[nextPaletteIndex()];
        final Values.Set values = new Values.Set("m/q", c1, c2);
        
        Chart<Values, Config> valueChart = Chart.createLine(values);
        List<Values> data = valueChart.getData();
        for(Scan scan : scans){
            ArrayDouble sampledata = (ArrayDouble)scan.getScanData().getColumnData(0);
            IteratorDouble inter = sampledata.iterator();
            double[] Y = new double[sampledata.size()];
            int i = 0;
            while (inter.hasNext()) {
                Y[i]=inter.nextDouble();
                ui.getArrayTest().add(Y[i]);
                i++;
            }
            model.setProviderName(scan.getScanData().getColumnName(0));
            data.add(new Values(scan.getScanData().getColumnName(0), Y));
            
        }
        valueChart.applyTo("chart");
        if (chart != null) {
            chart.destroy();
        }
        chart = valueChart;
    }

//    @Override
//    public void scanSubmitted(Scan scan) {
//        ui.setCurrentScan(scan.getId());
//    }
//
//
//
    @Function
    static void submitScan(Data model) throws DataProviderException {
        VLong scanId = dataProviders.get(0).getProvider().submitScan("xml_commands");
        
    }
    
    @Function
    static void pauseScan(Data model) throws DataProviderException {
        dataProviders.get(0).getProvider().pauseScan(model.getCurrentScan());
    }
    
    @Function
    static void resumeScan(Data model) throws DataProviderException {
        dataProviders.get(0).getProvider().resumeScan(model.getCurrentScan());
    }
    
    @Function
    static void abortScan(Data model) throws DataProviderException {
        dataProviders.get(0).getProvider().abortScan(model.getCurrentScan());
    }


    
    static void lineLike(Data model, int type) {
        StringBuilder sb = new StringBuilder();
        final Color c1 = PALETTE[nextPaletteIndex()];
        final Color c2 = PALETTE[nextPaletteIndex()];
        final Values.Set values = new Values.Set("Months", c1, c2);

        sb.append("// import net.java.html.charts.*;\n");
        sb.append("Chart<Values, Config> chart = Chart.");

        Chart<Values, Config> valueChart;
        switch (type) {
            case 0:
                valueChart = Chart.createBar(values);
                sb.append("createBar(");
                break;
            case 1:
                valueChart = Chart.createLine(values);
                sb.append("createLine(");
                break;
            default:
                valueChart = Chart.createRadar(values);
                sb.append("createRadar(");
                break;
        }
        sb.append("new Values.Set(\"Months\", Color.valueOf(\"");
        sb.append(c1).append("\"), Color.valueOf(\"").append(c2).append("\")));\n");

        List<Values> data = valueChart.getData();
        for (int i = 0; i < 12; i++) {
            data.add(new Values(NAMES[i], VALUES[i]));
            sb.append("chart.getData().add(new Values(\"").append(NAMES[i]).append("\", ").append(VALUES[i]).append("));\n");
        }
        valueChart.addChartListener(new AddOne(valueChart));
        valueChart.applyTo("chart");
        sb.append("chart.applyTo(\"chart\");\n");
        if (chart != null) {
            chart.destroy();
        }
        chart = valueChart;
        model.setCode(sb.toString());
    }


    @Function
    static void line(Data model) {
        lineLike(model, 1);
    }
    @Function
    static void bar(Data model) {
        lineLike(model, 0);
    }
    @Function
    static void radar(Data model) {
        lineLike(model, 2);
    }


    private static int nextPaletteIndex() {
        return paletteIndex++ % PALETTE.length;
    }

    private static double delta(ChartEvent ev) {
        int delta = ev.isCtrlKey() ? 10 : 1;
        return ev.isShiftKey() ? -delta : delta;
    }

    private static class AddOne implements ChartListener {
        private final Chart<Values,?> chart;

        public AddOne(Chart<Values, ?> chart) {
            this.chart = chart;
        }

        @Override
        public void chartClick(ChartEvent ev) {
            final double d = delta(ev);
            int index = 0;
            for (Values v : chart.getData()) {
                if (ev.getLabel().equals(v.getLabel())) {
                    chart.getData().set(index, new Values(ev.getLabel(), ev.getValues()[0] + d));
                    VALUES[index] += d;
                }
                index++;
            }
        }
    }

    private static class AddSegment implements ChartListener {
        private final Chart<Segment,?> chart;

        public AddSegment(Chart<Segment, ?> chart) {
            this.chart = chart;
        }

        @Override
        public void chartClick(ChartEvent ev) {
            final double d = delta(ev);
            int index = 0;
            for (Segment v : chart.getData()) {
                if (ev.getLabel().equals(v.getLabel())) {
                    Color c = PALETTE[index % PALETTE.length];
                    chart.getData().set(index, new Segment("Index" + index, ev.getValues()[0] + d, c, c));
                    VALUES[index] += d;
                }
                index++;
            }
        }
    }
}
