package net.java.html.plotlyjs;

/* 
 * #%L
 * This software is Copyright by the Board of Trustees of Michigan State University.
 * Contact Information:
 * Facility for Rare Isotope Beams
 * Michigan State University
 * East Lansing, MI 48824-1321
 * http://frib.msu.edu
 * %%
 * Copyright (C) 2016 Board of Trustees of Michigan State University
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

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;
import netscape.javascript.JSObject;

/**
 * 
 * <h3>Plotly for Dukescript</h3> A
 * <a href="https://dukescript.com/">Dukescript</a>-based Java wrapper for <a href="https://plot.ly/javascript/">Plotly.js</a>.
 * <h4>Typical Usage</h4> In order to construct a basic chart, the prototype is generally as follows: <br>
 * <ol>
 * <li> in your view, include Plotly.js and create a container for your plot as outlined <a href="https://plot.ly/javascript/getting-started/">here.</a>
 * <li>Put the data to be plotted in a {@link java.util.List}.</li>
 * <li>Construct one or more {@link Trace}s  with the specified data.</li>
 * <li>Build one or more {@link Chart}s with the trace type as the parameter.</li>
 * <li>Construct a {@link PlotlyData} object with the <code>Chart< &lt;some Trace&gt; ></code> as the type parameter. </li>
 * <li>Call {@link Plotly#newPlot(String,PlotlyData,Layout)}, or {@link Plotly#newPlot(String,PlotlyData,Layout,Config)} for advanced options</li>
 * <li>Enjoy the magic of Plotly.</li>
 * </ol>
 * <h3>Example</h3>
 * <code>
 * 	&#47;&#47;constructing a simple sine graph in a div called "myScatter" with 480x400px dimensions...<br>
 *  &#09; List<Number> scatter0x = new ArrayList<>();<br>
 *   &#09;List<Number> scatter0y = new ArrayList<>();<br>
 *   &#09;for(double t = 0;t<4*Math.PI;t+=0.1){<br>
 *    &#09;&#09;    scatter0x.add(t);<br>
 *   &#09;&#09;    scatter0y.add(Math.sin(t));<br>
 *   &#09;}<br>
 *   &#09;CartesianTrace scatterTrace0 = new CartesianTrace(scatter0x,scatter0y);<br>
 *   &#09;Scatter<CartesianTrace> scatter0 = Scatter.<CartesianTrace>builder().trace(scatterTrace0).build();<br>
 *   &#09;PlotlyData<Scatter<CartesianTrace>> scatterData = new PlotlyData<>(scatter0);<br>
 *   &#09;Plotly<Scatter<CartesianTrace>> scatter = Plotly.
 *   &#09;&#09;       newPlot("myScatter", scatterData, new Layout.Builder()<br>
 *   &#09;&#09;               .title("Scatter with Click Event")<br>
 *   &#09;&#09;               .width(480)<br>
 *   &#09;&#09;               .height(400)<br>
 *   &#09;&#09;               .build());<br>
 * </code>
 * 
 * @author daykin &lt;daykin at frib msu edu&gt; </span>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JavaScriptResource("plotly.min.js")
@SuppressWarnings("unused")
public final class Plotly <T extends Charts>{

    static private ObjectMapper mapper = new ObjectMapper();
    static private JavaType type;
    static private String id;
    private final PlotlyData<T> data;
    private final Layout layout;
    private final Config config;
    private final ArrayList<ChartListener> clickListeners = new ArrayList<>();
    private final ArrayList<ChartListener> hoverListeners = new ArrayList<>();
    private final ArrayList<ChartListener> zoomListeners = new ArrayList<>();
    private final ArrayList<ChartListener> unhoverListeners = new ArrayList<>();
    private Boolean clickListenersEnabled = false;
    private Boolean hoverListenersEnabled = false;
    private Boolean zoomListenersEnabled = false;
    private Boolean keyListenersEnabled = false;
    private Boolean shift = false;
    private Boolean ctrl = false;
    
    private Plotly(String id, PlotlyData<T> data, Layout layout){
        this(id,data,layout,new Config.Builder().showLink(false)
                .displaylogo(false)
                .modeBarButtonsToRemove(new String[]{"sendDataToCloud"})
                .build());
    }
    
    private Plotly(String id, PlotlyData<T> data, Layout layout, Config config){
        JQuery.init();
        Plotly.id = id;
        this.data = data;
        this.layout = layout;
        this.config = config;
    }
    
    /**
     *
     * @param <CHART> a type of Chart, i.e. any type which extends {@link Charts}.
     * @param id the the DOM element id in your view which will contain your plot.
     * @param data a {@link PlotlyData} object representing
     * @param layout A {@link Layout} object. 
     * @param config Advanced Plotly configuration options in a {@link Config} object. the average Joe will probably not need this.  
     * @return a {@link Plotly} object representing this plot.
     * @throws PlotlyException
     */
    public static<CHART extends Charts> Plotly<CHART>newPlot(String id, PlotlyData<CHART> data, Layout layout, Config config)throws PlotlyException{
        try {
            Plotly.mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            String strdata = Plotly.mapper.writeValueAsString(data.getTraces());
            String strlayout = Plotly.mapper.writeValueAsString(layout);
            JQuery.init();
            if(Plotly.jsElementExists(id)){
                jsNewPlot(id,strdata,strlayout);
                return new Plotly<>(id, data, layout, config);
            }
            else{
                throw new PlotlyException("the specified DOM element does not exist.");
            }
        } catch (JsonProcessingException e) {
            throw new PlotlyException(e);
        }
    }
    
    /**
    *
    * @param <CHART> a type of Chart, i.e. any type which extends {@link Charts}.
    * @param id the the DOM element id in your view which will contain your plot.
    * @param data a {@link PlotlyData} object representing
    * @param layout A {@link Layout} object. 
    * @return
    * @throws PlotlyException
    */
    public static <CHART extends Charts> Plotly<CHART> newPlot(String id, PlotlyData<CHART> data, Layout layout) throws PlotlyException {
        try {
            Plotly.mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            String strdata = Plotly.mapper.writeValueAsString(data.getTraces());
            String strlayout = Plotly.mapper.writeValueAsString(layout);
            Config defaultConfig = new Config.Builder()
                    .showLink(false)
                    .displaylogo(false)
                    .modeBarButtonsToRemove(new String[]{"sendDataToCloud"})
                    .build();
            String strconfig = Plotly.mapper.writeValueAsString(defaultConfig);
            jsNewPlot(id,strdata,strlayout,strconfig);
            
            Plotly<CHART> plt =  new Plotly<>(id, data, layout, defaultConfig);
            
            plt.addKeyListeners();
            return plt;
        } 
        catch (JsonProcessingException e) {
            throw new PlotlyException(e);
        }
    }
    
    private void addKeyListeners(){
        jsAddKeyListeners(this);
    }
    
    /**
     * Add a click listener implementing {@link ChartListener}. 
     * @param l The listener to add.
     */
    public void addClickListener(ChartListener l){
        this.clickListeners.add(l);
        if(!(this.hasClickListenersEnabled())){
           this.clickListenersEnabled = true;
            jsEnableClickEvents(id, this);
        }
    }
    

    protected void keyEvent(boolean shift, boolean ctrl){
        this.shift = shift;
        this.ctrl = ctrl;
    }
    
    /**
     * Add a hover listener implementing {@link ChartListener}. 
     * @param l The listener to add.
     */
    public void addHoverListener(ChartListener l){
        this.hoverListeners.add(l);
        if(!(hasHoverListenersEnabled())){
            this.hoverListenersEnabled = true;
            jsEnableHoverEvents(id,this);
        }
    }
    
    /**
     * Add an unhover listener implementing {@link ChartListener}. 
     * @param l The listener to add.
     */
    public void addUnhoverListener(ChartListener l){
        this.unhoverListeners.add(l);
        if(!(this.hasHoverListenersEnabled())){
            this.hoverListenersEnabled = true;
            jsEnableUnHoverEvents(id,this);
        }
    }
    
    /**
     * Add a zoom listener implementing {@link ChartListener}. 
     * @param l The listener to add.
     */
    public void addZoomListener(ChartListener l){
        this.zoomListeners.add(l);
        if(!(this.hasZoomListenersEnabled())){
            this.zoomListenersEnabled = true;
            jsEnableZoomEvents(id, this);
        }
    }

    /**
     * Remove a click listener. 
     * @param l The listener to remove.
     */
    public void removeClickListener(ChartListener l){
        this.clickListeners.remove(l);
    }
    
    /**
     * Remove a hover listener. 
     * @param l The listener to remove.
     */
    public void removeHoverListener(ChartListener l){
        this.hoverListeners.remove(l);
    }
    
    /**
     * Remove a zoom listener. 
     * @param l The listener to remove.
     */
    public void removeZoomListener(ChartListener l){
        this.zoomListeners.remove(l);
    }
    
    /**
     * Remove an unhover listener. 
     * @param l The listener to remove.
     */
    public void removeUnhoverListener(ChartListener l){
        this.unhoverListeners.remove(l);
    }
    

    private void notifyClickListeners(JSObject obj){
        ClickEvent event = new ClickEvent(this,this.shift,this.ctrl,obj);
        for (ChartListener l: clickListeners){
            l.plotly_click(event);
        }
    }
    
    private void notifyHoverListeners(JSObject obj){
        HoverEvent event = new HoverEvent(this,this.shift,this.ctrl,obj);
        for (ChartListener l: hoverListeners){
            l.plotly_hover(event);
        }
    }
    
    private void notifyUnhoverListeners(JSObject obj){
        UnhoverEvent event = new UnhoverEvent (this, this.shift,this.ctrl, obj);
        for (ChartListener l: unhoverListeners){
            l.plotly_unhover(event);
        }
    }
    

    private void notifyZoomListeners(JSObject obj){
        ZoomEvent event = new ZoomEvent (this, this.shift, this.ctrl, obj);
        for(ChartListener l: zoomListeners){
            l.plotly_zoom(event);
        }
    }
    
    private Boolean hasClickListenersEnabled(){
        return this.clickListenersEnabled;
    }
    
    private Boolean hasHoverListenersEnabled(){
        return this.hoverListenersEnabled;
    }
    
    private Boolean hasZoomListenersEnabled(){
        return this.hoverListenersEnabled;
    }
    
    /**
     * Restyle a trace in the plot.
     * @param A chart of the type defined in this object.
     * @param index the index to update.
     * @throws PlotlyException
     */
    @SuppressWarnings("static-access")
    public void restyle(T chart, int index)throws PlotlyException{
        try{
            this.data.<T>updateTrace(index, chart);
            jsRestyle(id,mapper.writeValueAsString(data),index);
            this.redraw();
        }
        catch(JsonProcessingException | PlotlyException e){
            throw new PlotlyException(e);
        }
    }
    
    /**Update the layout of the plot.
     @param layout a <code>Layout</code> object containing the layout parameters
     * @throws net.java.html.plotlyjs.PlotlyException
    */
    public void relayout(Layout layout) throws PlotlyException{
        try{jsRelayout(id,Plotly.mapper.writeValueAsString(layout));}
        catch(Exception e){
            throw new PlotlyException(e);
        }
    }
    
    /**Add trace(s) to the chart.
     @param traces an Array of {@link Charts} traces containing the trace parameters
     *@throws PlotlyException
    */
    @SuppressWarnings("unchecked")
    public void addTraces(T... traces) throws PlotlyException{
        try{
            this.data.addTraces(traces);
            jsAddTraces(id,Plotly.mapper.writeValueAsString(traces));
        }
        catch(JsonProcessingException e){
            throw new PlotlyException(e);
        }
    }
    
    /**Delete n traces.
    @param traces integer indices traces to delete.
    */
    public void deleteTraces(int... traces){
        this.data.deleteTraces(traces);
        jsDeleteTraces(id, traces);
    }
    
    /**Move indices to the end of the trace array. Affects the layering and legend of the plot.
    @param traces the indices to bump to the end.
    */
    public void moveTraces(int... traces){
        jsMoveTraces(id,traces);
        
    }
    
    /**Move traces in an array to different specified indices, respectively.
    @param from Array to pull from
    @param to Array of the respective positions
    */
    public void moveTraces(int[] from, int[] to){
        jsMoveTraces(id, from, to);
    }
    
    /**
     *
     * @throws PlotlyException
     */
    public void redraw() throws PlotlyException{
        try{
        jsRedraw(id,Plotly.mapper.writeValueAsString(data.getTraces()));
        }
        catch(JsonProcessingException e){
            throw new PlotlyException(e);
        }
     }
    
    /**
     *
     * @return a {@link netscape.javascript.JSObject} representing the plot's entire DOM element.
     */
    public Object getPlot(){
        return jsGetPlot(id);
    }
    
    /**
     *
     * @return
     */
    public String getId(){
        return id;
    }
    
    @JavaScriptBody(args={"elementId","update","indices"}, body = ""
            + "Plotly.restyle(document.getElementById(elementId), JSON.parse(update), indices);")
    private static native void jsRestyle(String elementId, String update, int... indices);
    

    @JavaScriptBody(args={"elementId","update"}, body = ""
            + "Plotly.relayout(document.getElementById(elementId), JSON.parse(update));")
    private static native void jsRelayout(String elementId, String update);
    

    @JavaScriptBody(args={"elementId","rawTracesJson"}, body = ""
            + "Plotly.addTraces(document.getElementById(elementId),JSON.parse(rawTracesJson));")
    private static native void jsAddTraces(String elementId, String rawTracesJson);
   


    @JavaScriptBody(args={"elementId","traces"}, body = ""
            + "Plotly.deleteTraces(document.getElementById(elementId), traces);")
    private static native void jsDeleteTraces(String elementId, int... traces);
    


    @JavaScriptBody(args = {"elementId", "indices"}, body = ""
            + "Plotly.moveTraces(document.getElementById(elementId), indices);")
    private static native void jsMoveTraces(String elementId, int... indices);
   
    @JavaScriptBody(args = {"elementId"}, body = ""
            + "return(document.getElementById(elementId)!=undefined);"
            )
    public static native Boolean jsElementExists(String elementId);
    

    @JavaScriptBody(args = {"elementId", "from", "to"}, body = ""
            + "Plotly.moveTraces(document.getElementById(elementId),from, to);")
    private static native void jsMoveTraces(String elementId, int[] from, int[] to);
    
    @JavaScriptBody(args = {"elementId", "strdata"}, body = ""
            +"var graphDiv = document.getElementById(elementId);"
            +"graphDiv.data = JSON.parse(strdata);"
            +"Plotly.redraw(graphDiv);")
    private static native void jsRedraw(String elementId, String strdata);
    
    @JavaScriptBody(args = { "strElementId", "strdata", "strlayout" }, body =
            "var data = JSON.parse(strdata);\n" +
            "var layout = JSON.parse(strlayout);\n" +
            "var elementId = document.getElementById(strElementId);\n"+
            "Plotly.newPlot(elementId, data, layout, {showLink: false, displaylogo: false, modeBarButtonsToRemove: ['sendDataToCloud']});\n"+
            "return document.getElementById(strElementId);"
    )
    native static Object jsNewPlot(String strElementId, String strdata, String strlayout);

    
    @JavaScriptBody(args = { "strElementId", "strdata", "strlayout", "strconfig" }, body =
            "var data = JSON.parse(strdata);\n" +
            "var layout = JSON.parse(strlayout);\n" +
            "var elementId = document.getElementById(strElementId);\n"+
            "var config = JSON.parse(strconfig);" +
            "Plotly.newPlot(elementId, data, layout, config);\n" +
            "return document.getElementById(strElementId);"
    )
    native static Object jsNewPlot(String strElementId, String strdata, String strlayout, String strconfig);
   
    @JavaScriptBody(args = {"strElementId"}, body = ""
            + "var plotdiv = document.getElementById(strElementId);"
            + "return plotdiv;")
    private native static Object jsGetPlot(String strElementId);
 
    @JavaScriptBody(args = {}, body = ""
            + "$return($._data($(document).get(0), 'events').length>0)")
    private native static boolean docKeyListenersEnabled();
    
    @JavaScriptBody(args = {"instance"}, javacall = true, body = ""
            + "var ctrl = false;"
            + "var shift = false;"
            + "$(document).keydown(function(e){"
            + "ctrl = (e.ctrlKey)?true:false;"
            + "shift = (e.shiftKey)?true:false;"
            + "instance.@net.java.html.plotlyjs.Plotly::keyEvent(ZZ)(shift,ctrl);"
            + "});"
            + "$(document).keyup(function(e){"
            + "ctrl = (e.ctrlKey)?true:false;"
            + "shift = (e.shiftKey)?true:false;"
            + "instance.@net.java.html.plotlyjs.Plotly::keyEvent(ZZ)(shift,ctrl);"
            + " }"
            + ");")
    private native static void jsAddKeyListeners(Plotly<?> instance);
    
    @JavaScriptBody(args = {}, javacall = true, body = ""
            + "var ctrl = false;"
            + "var shift = false;"
            + "$(document).off('keydown');"
            + "$(document).off('keyup');")
    private native static void jsRemoveKeyListeners();
    
    @JavaScriptBody(args = {"strElementId", "instance"},javacall=true, body = ""+
            "var plot = document.getElementById(strElementId);"
            + "plot.on('plotly_click', function(plot){"
            + "instance.@net.java.html.plotlyjs.Plotly::notifyClickListeners(Lnetscape/javascript/JSObject;)(plot);"
            + "});")
    private native static void jsEnableClickEvents(String strElementId, Plotly<?> instance);
    
    @JavaScriptBody(args = {"strElementId", "instance"}, javacall = true, body = ""+
            "var plot = document.getElementById(strElementId);"
            + "plot.on('plotly_hover', function(plot){"
            + "instance.@net.java.html.plotlyjs.Plotly::notifyHoverListeners(Lnetscape/javascript/JSObject;)(plot);"
            + "});")
    private native static void jsEnableHoverEvents(String strElementId, Plotly<?> instance);
    
    @JavaScriptBody(args = {"strElementId", "instance"}, javacall = true, body = ""+
            "var plot = document.getElementById(strElementId);"
            +"plot.on('plotly_unhover', function(plot){"
            + "instance.@net.java.html.plotlyjs.Plotly::notifyUnhoverListeners(Lnetscape/javascript/JSObject;)(plot);"
            + "});")
    public static native void jsEnableUnHoverEvents(String strElementId, Plotly<?> instance);
            
    @JavaScriptBody(args = {"strElementId", "instance"}, javacall = true, body = ""+
            "var plot = document.getElementById(strElementId);"
            + "plot.on('plotly_relayout', function(eventdata){"
            + "instance.@net.java.html.plotlyjs.Plotly::notifyZoomListeners(Lnetscape/javascript/JSObject;)(eventdata);"
            + "});")
    private native static void jsEnableZoomEvents(String strElementId, Plotly<?> instance);
    
    /**
     * Output a human-readable model of the plot, with each component(data, layout,config) represented as a JSON string. 
     */
    @Override
    public String toString(){
        try {
            return "data: " + mapper.writeValueAsString(this.data) + "\nlayout: "+
                    mapper.writeValueAsString(this.layout) + "\nconfig: "+
                    mapper.writeValueAsString(this.config);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Plotly.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}