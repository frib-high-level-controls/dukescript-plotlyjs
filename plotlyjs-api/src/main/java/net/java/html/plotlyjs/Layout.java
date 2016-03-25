package net.java.html.plotlyjs;

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


public class Layout {
    
    @SuppressWarnings("unused")
    private String title = "";
    private Margin margin;
    private int width;
    private int height;
    private Font font;
    private Axis x;
    private Axis y;
    
    
    public Layout(String title){
        this.title = title;
        this.margin = new Margin.MarginBuilder().build();
        this.width = 700;
        this.height = 450;
        this.font = new Font.FontBuilder().build();
        this.x = new Axis.AxisBuilder().build();
        this.y = new Axis.AxisBuilder().build();
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    

}
