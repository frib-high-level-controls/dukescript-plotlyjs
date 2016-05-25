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
import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;
import netscape.javascript.JSObject;
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
    
    public void addClickListener(ChartListener l){
        this.clickListeners.add(l);
        if(!(this.hasClickListenersEnabled())){
           this.clickListenersEnabled = true;
            jsEnableClickEvents(id, this);
        }
    }
    
    public void keyEvent(boolean shift, boolean ctrl){
        this.shift = shift;
        this.ctrl = ctrl;
    }
    
    public void addHoverListener(ChartListener l){
        this.hoverListeners.add(l);
        if(!(hasHoverListenersEnabled())){
            this.hoverListenersEnabled = true;
            jsEnableHoverEvents(id,this);
        }
    }
    
    public void addUnhoverListener(ChartListener l){
        this.unhoverListeners.add(l);
        if(!(this.hasHoverListenersEnabled())){
            this.hoverListenersEnabled = true;
            jsEnableUnHoverEvents(id,this);
        }
    }
    
    public void addZoomListener(ChartListener l){
        this.zoomListeners.add(l);
        if(!(this.hasZoomListenersEnabled())){
            this.zoomListenersEnabled = true;
            jsEnableZoomEvents(id, this);
        }
    }

    public void removeClickListener(ChartListener l){
        this.clickListeners.remove(l);
    }
    
    public void removeHoverListener(ChartListener l){
        this.hoverListeners.remove(l);
    }
    
    public void removeZoomListener(ChartListener l){
        this.zoomListeners.remove(l);
    }
    
    public void removeUnhoverListener(ChartListener l){
        this.unhoverListeners.remove(l);
    }
    
    public void removeClickListener(int index) throws PlotlyException{
        try{
            this.clickListeners.remove(index);
        }
        catch(NullPointerException e){
            throw new PlotlyException("click listener index out of range.",e);
        }
    }
    
    public void removeHoverListener(int index) throws PlotlyException{
        try{
            this.hoverListeners.remove(index);
        }
        catch(NullPointerException e){
            throw new PlotlyException("hover listener index out of range.",e);
        }
    }
    
    public void removeZoomListener(int index) throws PlotlyException{
        try{
            this.zoomListeners.remove(index);
        }
        catch(NullPointerException e){
            throw new PlotlyException("zoom listener index out of range.",e);
        }
    }
    
    public void removeUnhoverListener(int index){
        this.unhoverListeners.remove(index);
    }
    
    
    public void notifyClickListeners(JSObject obj){
        ClickEvent event = new ClickEvent(this,this.shift,this.ctrl,obj);
        for (ChartListener l: clickListeners){
            l.plotly_click(event);
        }
    }
    
    public void notifyHoverListeners(JSObject obj){
        HoverEvent event = new HoverEvent(this,this.shift,this.ctrl,obj);
        for (ChartListener l: hoverListeners){
            l.plotly_hover(event);
        }
    }
    
    public void notifyUnhoverListeners(JSObject obj){
        UnhoverEvent event = new UnhoverEvent (this, this.shift,this.ctrl, obj);
        for (ChartListener l: unhoverListeners){
            l.plotly_unhover(event);
        }
    }
    
    public void notifyZoomListeners(JSObject obj){
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
    
    /**Update just the chart layout more nicely than redraw.
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
    
    public void redraw() throws PlotlyException{
        try{
        jsRedraw(id,Plotly.mapper.writeValueAsString(data.getTraces()));
        }
        catch(JsonProcessingException e){
            throw new PlotlyException(e);
        }
     }
    
    public Object getPlot(){
        return jsGetPlot(id);
    }
    
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
    
    /**Redraw the chart element.
    @param elementId the associated DOM element
    */
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