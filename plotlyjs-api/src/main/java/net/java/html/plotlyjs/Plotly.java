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
import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JavaScriptResource("plotly.min.js")
@SuppressWarnings("unused")
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
            System.out.println(strlayout);
            jsNewPlot(id,strdata,strlayout);
            return new Plotly<>(id, data, layout);
        } catch (JsonProcessingException e) {
            throw new PlotlyException(e);
        }
    }
    /**Restyle the trace array
     * @param update a <code>Data</code> object containing the restyle parameters
     * @param indices the indices in the trace array to apply the new style
     * @throws PlotlyException
    */ 
    public void restyle(Data<?> update, int... indices)throws PlotlyException{
        try{
        jsRestyle(id,Plotly.mapper.writeValueAsString(update),indices);
        }
        catch(JsonProcessingException e){
            throw new PlotlyException(e);
        }
    }
    
    /**Update just the chart layout more nicely than redraw.
     @param layout a <code>Layout</code> object containing the layout parameters
    */
    public void relayout(Layout layout) throws JsonProcessingException{
        jsRelayout(id,Plotly.mapper.writeValueAsString(layout));
    }
    
    /**Add trace(s) to the chart.
     @param traces an Array of <code>Trace</code>s containing the trace parameters
     *@throws PlotlyException
    */
    public void addTraces(Trace... traces) throws PlotlyException{
        try{
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
    
    public void redraw(){
        jsRedraw(id);
    }
    
    @JavaScriptBody(args={"elementId","update","indices"}, body = ""
            + "if(indices){"
            + "Plotly.restyle(document.getElementById(elementId), JSON.parse(update), indices);"
            + "}"
            + "else{"
            + "(Plotly.restyle(document.getElementById(elementId), JSON.parse(update)));"
            + "}")
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
    @JavaScriptBody(args = {"elementId"}, body =
            "Plotly.redraw(document.getElementById(elementId));")
    private static native void jsRedraw(String elementId);
    
    
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
