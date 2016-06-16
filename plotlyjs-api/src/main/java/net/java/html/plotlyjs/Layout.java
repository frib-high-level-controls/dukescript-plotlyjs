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
import java.util.List;


@JsonInclude(Include.NON_NULL)
public class Layout {
    
    @SuppressWarnings("unused")
    private final String title;
    private final Margin margin;
    private final Integer width;
    private final Integer height;
    private final Font font;
    private final Axis xaxis;
    private final Axis yaxis;
    private final String barmode;    
    private final String boxmode;
    private final Object hovermode;
    private final List<Shape> shapes;
    private final List<Annotation> annotations;

    
    public static class Builder {

        private String title;
        private Margin margin;
        private Integer width;
        private Integer height;
        private Font font;
        private Axis xaxis;
        private Axis yaxis;
        private String barmode;
        private String boxmode;
        private Object hovermode;
        private List<Shape> shapes;
        private List<Annotation> annotations;

        
        public Builder() {
        }

        
        public Builder title(final String value) {
            this.title = value;
            return this;
        }

        
        public Builder margin(final Margin value) {
            this.margin = value;
            return this;
        }

        
        public Builder width(final Integer value) {
            this.width = value;
            return this;
        }

        
        public Builder height(final Integer value) {
            this.height = value;
            return this;
        }

        
        public Builder font(final Font value) {
            this.font = value;
            return this;
        }

        
        public Builder xaxis(final Axis value) {
            this.xaxis = value;
            return this;
        }

        
        public Builder yaxis(final Axis value) {
            this.yaxis = value;
            return this;
        }

        
        public Builder barmode(final String value) {
            this.barmode = value;
            return this;
        }
        
        
        public Builder boxmode(final String boxmode){
            this.boxmode = boxmode;
            return this;
        }
        
        
        public Builder hovermode(final Object hovermode){
            this.hovermode = (hovermode instanceof java.lang.String || hovermode instanceof java.lang.Boolean)?hovermode:false;
            return this;
        }
        
        public Builder shapes(final List<Shape> shapes){
            this.shapes = shapes;
            return this;
        }
        
        public Builder annotations(final List<Annotation> annotations){
            this.annotations = annotations;
            return this;
        }
        
        public Layout build() {
            return new net.java.html.plotlyjs.Layout(this);
        }
    }

    
    public static Layout.Builder builder() {
        return new Layout.Builder();
    }

    private Layout(Builder builder) {
        this.title = builder.title;
        this.margin = builder.margin;
        this.width = builder.width;
        this.height = builder.height;
        this.font = builder.font;
        this.xaxis = builder.xaxis;
        this.yaxis = builder.yaxis;
        this.boxmode = builder.boxmode;
        this.barmode = builder.barmode;
        this.hovermode = builder.hovermode;
        this.shapes = builder.shapes;
        this.annotations = builder.annotations;
    }
    
    
}
