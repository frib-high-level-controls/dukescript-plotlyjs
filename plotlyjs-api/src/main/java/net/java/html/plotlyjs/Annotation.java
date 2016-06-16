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

/**
 *
 * @author berryman
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Annotation {
    public enum ANCHOR { auto, top, middle, bottom };
    public enum ALIGN { left, center, right };
    private final String bordercolor;
    private final ANCHOR yanchor;
    private final String text;
    private final Number arrowsize;
    private final Number textangle;
    private final Number borderwidth;
    private final Number ay;
    private final Number ax;
    private final Font font;
    private final String arrowcolor;
    private final String xref;
    private final Number arrowhead;
    private final String bgcolor;
    private final Number borderpad;
    private final boolean showarrow;
    private final Number opacity;
    private final ANCHOR xanchor;
    private final Number arrowwidth;
    private final String yref;
    private final ALIGN align;
    private final Number y;
    private final Number x;
    
    
    public static class Builder {
        private String bordercolor;
        private ANCHOR yanchor;
        private String text;
        private Number arrowsize;
        private Number textangle;
        private Number borderwidth;
        private Number ay;
        private Number ax;
        private Font font;
        private String arrowcolor;
        private String xref;
        private Number arrowhead;
        private String bgcolor;
        private Number borderpad;
        private boolean showarrow;
        private Number opacity;
        private ANCHOR xanchor;
        private Number arrowwidth;
        private String yref;
        private ALIGN align;
        private Number y;
        private Number x;
        
        public Builder bordercolor(String bordercolor) {
            this.bordercolor = bordercolor;
            return this;
        }
        
        public Builder yanchor(ANCHOR yanchor) {
            this.yanchor = yanchor;
            return this;
        }
        
        public Builder text(String text) {
            this.text = text;
            return this;
        }
        
        public Builder arrowsize (Number arrowsize) {
            this.arrowsize = arrowsize;
            return this;
        }
        
        public Builder textangle (Number textangle) {
            this.textangle = textangle;
            return this;
        }
        
        public Builder borderwidth (Number borderwidth) {
            this.borderwidth = borderwidth;
            return this;            
        }
        
        public Builder ay (Number ay) {
            this.ay = ay;
            return this;
        }
        
        public Builder ax (Number ax) {
            this.ax = ax;
            return this;   
        }
        
        public Builder font (Font font) {
            this.font = font;
            return this;
        }
        
        public Builder arrowcolor (String arrowcolor) {
            this.arrowcolor = arrowcolor;
            return this;
        }
        
        public Builder xref (String xref) {
            this.xref = xref;
            return this;
        }
        
        public Builder arrowhead (Number arrowhead) {
            this.arrowhead = arrowhead;
            return this;
        }
        
        public Builder bgcolor(String bgcolor) {
            this.bgcolor = bgcolor;
            return this;
        }
        
        public Builder borderpad (Number borderpad) {
            this.borderpad = borderpad;
            return this;
        }
        
        public Builder showarrow (boolean showarrow) {
            this.showarrow = showarrow;
            return this;
        }
        
        public Builder opacity (Number opacity) {
            this.opacity = opacity;
            return this;
        }
        
        public Builder xanchor (ANCHOR xanchor) {
            this.xanchor = xanchor;
            return this;
        }
        
        public Builder arrowwidth (Number arrowwidth) {
            this.arrowwidth = arrowwidth;
            return this;
        }
        
        public Builder yref (String yref) {
            this.yref = yref;
            return this;
        } 
        
        public Builder align (ALIGN align) {
            this.align = align;
            return this;
        }
        
        public Builder y (Number y) {
            this.y = y;
            return this;
        }
        
        public Builder x (Number x) {
            this.x = x;
            return this;
        }
        
        public Annotation build() {
            return new Annotation (this);
        }
    }
    
    private Annotation(Builder builder) {
        this.bordercolor = builder.bordercolor;
        this.yanchor = builder.yanchor;
        this.text = builder.text;
        this.arrowsize = builder.arrowsize;
        this.textangle = builder.textangle;
        this.borderwidth = builder.borderwidth;
        this.ay = builder.ay;
        this.ax = builder.ax;
        this.font = builder.font;
        this.arrowcolor = builder.arrowcolor;
        this.xref = builder.xref;
        this.arrowhead = builder.arrowhead;
        this.bgcolor = builder.bgcolor;
        this.borderpad = builder.borderpad;
        this.showarrow = builder.showarrow;
        this.opacity = builder.opacity;
        this.xanchor = builder.xanchor;
        this.arrowwidth = builder.arrowwidth;
        this.yref = builder.yref;
        this.align = builder.align;
        this.y = builder.y;
        this.x = builder.x;
    }    
}
