package net.java.html.plotlyjs;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;


/*
 * #%L
 * %%
 * Copyright (C) 2015 - 2016 MSU
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


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;

@JavaScriptResource("plotly.min.js")
public final class Plotly <T extends Trace>{
    static private ObjectMapper mapper = new ObjectMapper();
    static private JavaType type;
    static private String id;
    private Data<T> data;
    private Layout layout;
    
    private Plotly(String id, Data<T> data, Layout layout){
        Plotly.id = id;
        this.data = data;
        this.layout = layout;   
    }
    public static Plotly<?> newPlot(String id, Data<?> data, Layout layout) throws PlotlyException {
        try {
            Plotly.mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            String strdata = Plotly.mapper.writeValueAsString(data.getTraces());
            String strlayout = Plotly.mapper.writeValueAsString(layout);
            jsNewPlot(id,strdata,strlayout);
            return new Plotly<>(id, data, layout);
        } catch (JsonProcessingException e) {
            throw new PlotlyException(e);
        }
    }
    
    public void restyle(){}
    
    public void relayout(){}
    
    public void addTraces(){}
    
    public void deleteTraces(){}
    
    public void moveTraces(){}
    
    public void redraw(){}
    
    /**Restyle the trace array
     @param update a raw JSON string containing the restyle parameters
     @param indices the indices in the trace array to apply the new style
    */
    @JavaScriptBody(args={"elementId","update","indices"}, body = ""
            + "if(indices){"
            + "Plotly.restyle(document.getElementById(elementId), JSON.parse(update), indices);"
            + "}"
            + "else{"
            + "(Plotly.restyle(document.getElementById(elementId), JSON.parse(update))"
            + "}")
    private static native void restyle(String elementId, String update, int... indices);
    
   /**Update just the chart layout more nicely than redraw.
     @param elementId the associated DOM element id
     @param update a raw JSON string containing the layout parameters
    */
    @JavaScriptBody(args={"elementId","update"}, body = ""
            + "Plotly.relayout(document.getElementById(elementId), JSON.parse(update));")
    private static native void relayout(String elementId, String update);
    
   /**Add trace(s) to the chart.
     @param elementId the associated DOM element id
     @param rawTracesJson a raw JSON string containing the trace parameters
    */
    @JavaScriptBody(args={"elementId","rawTracesJson"}, body = ""
            + "Plotly.addTraces(document.getElementById(elementId),JSON.parse(rawTracesJson));")
    private static native void addTraces(String elementId, String rawTracesJson);
   

    /**Delete n traces.
    @param elementId the associated DOM element id
    @param traces an array containing the traces to delete.
    */
    @JavaScriptBody(args={"elementId","traces"}, body = ""
            + "Plotly.deleteTraces(document.getElementById(elementId), traces);")
    private static native void deleteTraces(String elementId, int... traces);
    

    /**Move indices to the end of the trace array. Affects the layering and legend of the plot.
    @param elementId the associated DOM element id
    @param indices the index to bump to the end.
    */
    @JavaScriptBody(args = {"elementId", "indices"}, body = ""
            + "Plotly.moveTraces(document.getElementById(elementId), indices);")
    private static native void moveTraces(String elementId, int... indices);
    
    
    /**move traces in an array to different specified indices, respective to the
    <code>from</code> and <code>to</code> array positions.
    @param elementId The associated DOM element ID
    @param from Array to pull from
    @param to Array of the respective positions
    */
    @JavaScriptBody(args = {"elementId", "from", "to"}, body = ""
            + "Plotly.moveTraces(document.getElementById(elementId),from, to);")
    private static native void moveTraces(String elementId, int[] from, int[] to);
    
    /**Redraw the chart element.
    @param elementId the associated DOM element
    */
    @JavaScriptBody(args = {"elementId"}, body =
            "Plotly.redraw(document.getElementById(elementId));")
    private static native void redraw(String elementId);
    
    
    /**Create a new plot.
    *@param strElementId the associated DOM element to contain the plot
    *@param strdata A JSON-formatted string containing the trace parameters.
    *@param strlayout A JSON-formatted string containing the layout parameters.
    *@return an Object representing the plot's DOM.
    */
    @JavaScriptBody(args = { "strElementId", "strdata", "strlayout" }, body =
            "var data = JSON.parse(strdata);\n" +
            "var layout = JSON.parse(strlayout);\n" +
            "var elementId = document.getElementById(strElementId);\n" +
            "Plotly.newPlot(elementId, data, layout);\n" +
            "return document.getElementById(strElementId);"
    )
    native static Object jsNewPlot(String strElementId, String strdata, String strlayout);

}
