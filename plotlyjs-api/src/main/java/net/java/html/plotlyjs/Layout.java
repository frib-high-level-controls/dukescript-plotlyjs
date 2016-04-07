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



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonInclude(Include.NON_NULL)
public class Layout {
    
    @SuppressWarnings("unused")
    private String title;
    private Margin margin;
    private int width;
    private int height;
    private Font font;
    private Axis xaxis;
    private Axis yaxis;
    
    
    public Layout(String title){
        this.title = title;
        this.margin = new Margin.Builder().build();
        this.width = 700;
        this.height = 450;
        this.font = new Font.FontBuilder().build();
        this.xaxis = new Axis.Builder().build();
        this.yaxis = new Axis.Builder().build();
    }
    public Layout(String title, int width, int height){
        this.title = title;
        this.margin = new Margin.Builder().build();
        this.width = width;
        this.height = height;
        this.font = new Font.FontBuilder().build();
        this.xaxis = new Axis.Builder().build();
        this.yaxis = new Axis.Builder().build();
    }
    public void setTitle(String title){
        this.title = title;
    }

    public void setMargin(Margin margin) {
        this.margin = margin;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setXaxis(Axis xaxis) {
        this.xaxis = xaxis;
    }

    public void setYaxis(Axis yaxis) {
        this.yaxis = yaxis;
    }

}
