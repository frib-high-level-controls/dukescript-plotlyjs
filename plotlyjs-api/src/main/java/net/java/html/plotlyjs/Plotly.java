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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;
import netscape.javascript.JSObject;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JavaScriptResource("plotly.min.js")
@SuppressWarnings("unused")
public final class Plotly <T extends Chart>{
    static private ObjectMapper mapper = new ObjectMapper();
    static private JavaType type;
    static private String id;
    private final Data<T> data;
    private final Layout layout;
    private final Config config;
    
    private Plotly(String id, Data<T> data, Layout layout){
        Plotly.id = id;
        this.data = data;
        this.layout = layout;
        this.config = new Config.Builder().showLink(false).displaylogo(false).modeBarButtonsToRemove(new String[]{"sendDataToCloud"}).build();
    }
    
    private Plotly(String id, Data<T> data, Layout layout, Config config){
        Plotly.id = id;
        this.data = data;
        this.layout = layout;
        this.config = config;
    }
    
    public static Plotly<?>newPlot(String id, Data<?> data, Layout layout, Config config)throws PlotlyException{
        try {
            Plotly.mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            String strdata = Plotly.mapper.writeValueAsString(data.getTraces());
            String strlayout = Plotly.mapper.writeValueAsString(layout);
            jsNewPlot(id,strdata,strlayout);
            System.out.println(strdata);
            return new Plotly<>(id, data, layout, config);
        } catch (JsonProcessingException e) {
            throw new PlotlyException(e);
        }
    }
    
    public static Plotly<?> newPlot(String id, Data<?> data, Layout layout) throws PlotlyException {
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
            jsNewPlot(id,strdata,strlayout, strconfig);
            return new Plotly<>(id, data, layout, defaultConfig);
        } catch (JsonProcessingException e) {
            throw new PlotlyException(e);
        }
    }
    /**Restyle the trace array
     * @param data a <code>Data</code> object containing the restyle parameters
     * @param indices the indices in the trace array to apply the new style
     * @throws PlotlyException
    */ 
    public void restyle(JsonNode data, int... indices)throws PlotlyException{
        try{
            String update = Plotly.mapper.writeValueAsString(data);
            jsRestyle(id,update,indices);
        }
        catch(JsonProcessingException e){
            throw new PlotlyException(e);
        }
    }
    
    public void restyle(String data, int... indices)throws PlotlyException{
        try{
            jsRestyle(id,data,indices);
        }
        catch(Exception e){
            throw new PlotlyException(e);
        }
    }
    
    public void restyle(Data<T> data, int... indices)throws PlotlyException{
        try{
            jsRestyle(id,mapper.writeValueAsString(data),indices);
        }
        catch(Exception e){
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
     @param traces an Array of {@link Chart} traces containing the trace parameters
     *@throws PlotlyException
    */
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
            "var elementId = document.getElementById(strElementId);\n" +
            "Plotly.newPlot(elementId, data, layout, {showLink: false, displaylogo: false, modeBarButtonsToRemove: ['sendDataToCloud']});\n" +
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
            + "var plot = document.getElementById(strElementId);"
            + "return plot;")
    private native static JSObject jsGetPlot(String strElementId);
    
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
