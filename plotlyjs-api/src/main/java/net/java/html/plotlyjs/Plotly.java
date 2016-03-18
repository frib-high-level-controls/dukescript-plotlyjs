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
    
    public void restyle() {
        
    }
    
    public void relayout() {
        
    }
    
    public void addTraces() {
        
    }
    
    public void deleteTraces() {
        
    }
    
    public void moveTraces() {
        
    }
    
    public void redraw() {
        
    }
    
    @JavaScriptBody(args = { "strElementId", "strdata", "strlayout" }, body =
            "var data = JSON.parse(strdata);\n" +
            "var layout = JSON.parse(strlayout);\n" +
            "var elementId = document.getElementById(strElementId);\n" +
            "Plotly.newPlot(elementId, data, layout);\n" +
            "return document.getElementById(strElementId);"
    )
    native static Object jsNewPlot(String strElementId, String strdata, String strlayout);

}
