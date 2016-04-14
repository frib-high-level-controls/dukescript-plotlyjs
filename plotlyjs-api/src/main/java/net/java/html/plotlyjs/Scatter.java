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
import java.util.List;

@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Scatter<T extends Value> extends Chart{
    
    private final String mode;
    private final String textposition;
    private final Stream stream;
    private final String text;
    private final String hoverinfo;
    private final String xsrc;
    private final Object visible;
    private final ScatterMarker marker;
    private final Number y0;
    private final String tsrc;
    private final Line line;
    private final String fill;
    private final Boolean showlegend;
    private final ErrorBar error_x;
    private final ErrorBar error_y;
    private final String textsrc;
    private final String rsrc;
    private final Axis xaxis;
    private final Axis yaxis;
    private final String ysrc;
    private final List<Number> t;
    private final Number opacity;
    private final Font textfont;
    private final String legendgroup;
    private final String textpositionsrc;
    private final String fillcolor;
    private final Number dx;
    private final Number dy;
    private final Number x0;
    private final String name;
    private final Boolean connectgaps;
    private final List<Number> r;

    public static class Builder {

        private String type;
        private List x;
        private List y;
        private String mode;
        private String textposition;
        private Stream stream;
        private String text;
        private String hoverinfo;
        private String xsrc;
        private Object visible;
        private ScatterMarker marker;
        private Number y0;
        private String tsrc;
        private Line line;
        private String fill;
        private Boolean showlegend;
        private ErrorBar error_x;
        private ErrorBar error_y;
        private String textsrc;
        private String rsrc;
        private Axis xaxis;
        private Axis yaxis;
        private String ysrc;
        private List<Number> t;
        private Number opacity;
        private Font textfont;
        private String legendgroup;
        private String textpositionsrc;
        private String fillcolor;
        private Number dx;
        private Number dy;
        private Number x0;
        private String name;
        private Boolean connectgaps;
        private List<Number> r;

        public Builder() {
        }

        public Builder type(final String value) {
            this.type = value;
            return this;
        }
        
        public Builder data(final Value value){
            this.x = value.x;
            this.y = value.y;
            return this;
        }
        
        public Builder x(final List value) {
            this.x = value;
            return this;
        }

        public Builder y(final List value) {
            this.y = value;
            return this;
        }

        public Builder mode(final String value) {
            this.mode = value;
            return this;
        }

        public Builder textposition(final String value) {
            this.textposition = value;
            return this;
        }

        public Builder stream(final Stream value) {
            this.stream = value;
            return this;
        }

        public Builder text(final String value) {
            this.text = value;
            return this;
        }

        public Builder hoverinfo(final String value) {
            this.hoverinfo = value;
            return this;
        }

        public Builder xsrc(final String value) {
            this.xsrc = value;
            return this;
        }

        public Builder visible(final Object value) {
            this.visible = value;
            return this;
        }

        public Builder marker(final ScatterMarker value) {
            this.marker = value;
            return this;
        }

        public Builder y0(final Number value) {
            this.y0 = value;
            return this;
        }

        public Builder tsrc(final String value) {
            this.tsrc = value;
            return this;
        }

        public Builder line(final Line value) {
            this.line = value;
            return this;
        }

        public Builder fill(final String value) {
            this.fill = value;
            return this;
        }

        public Builder showlegend(final Boolean value) {
            this.showlegend = value;
            return this;
        }

        public Builder error_x(final ErrorBar value) {
            this.error_x = value;
            return this;
        }

        public Builder error_y(final ErrorBar value) {
            this.error_y = value;
            return this;
        }

        public Builder textsrc(final String value) {
            this.textsrc = value;
            return this;
        }

        public Builder rsrc(final String value) {
            this.rsrc = value;
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

        public Builder ysrc(final String value) {
            this.ysrc = value;
            return this;
        }

        public Builder t(final List<Number> value) {
            this.t = value;
            return this;
        }

        public Builder opacity(final Number value) {
            this.opacity = value;
            return this;
        }

        public Builder textfont(final Font value) {
            this.textfont = value;
            return this;
        }

        public Builder legendgroup(final String value) {
            this.legendgroup = value;
            return this;
        }

        public Builder textpositionsrc(final String value) {
            this.textpositionsrc = value;
            return this;
        }

        public Builder fillcolor(final String value) {
            this.fillcolor = value;
            return this;
        }

        public Builder dx(final Number value) {
            this.dx = value;
            return this;
        }

        public Builder dy(final Number value) {
            this.dy = value;
            return this;
        }

        public Builder x0(final Number value) {
            this.x0 = value;
            return this;
        }

        public Builder name(final String value) {
            this.name = value;
            return this;
        }

        public Builder connectgaps(final Boolean value) {
            this.connectgaps = value;
            return this;
        }

        public Builder r(final List<Number> value) {
            this.r = value;
            return this;
        }

        public Scatter build() {
            return new net.java.html.plotlyjs.Scatter(this);
        }
    }

    public static Scatter.Builder builder() {
        return new Scatter.Builder();
    }

    private Scatter(Builder builder) {
        this.type = builder.type;
        this.x = builder.x;
        this.y = builder.y;
        this.mode = builder.mode;
        this.textposition = builder.textposition;
        this.stream = builder.stream;
        this.text = builder.text;
        this.hoverinfo = builder.hoverinfo;
        this.xsrc = builder.xsrc;
        this.visible = builder.visible;
        this.marker = builder.marker;
        this.y0 = builder.y0;
        this.tsrc = builder.tsrc;
        this.line = builder.line;
        this.fill = builder.fill;
        this.showlegend = builder.showlegend;
        this.error_x = builder.error_x;
        this.error_y = builder.error_y;
        this.textsrc = builder.textsrc;
        this.rsrc = builder.rsrc;
        this.xaxis = builder.xaxis;
        this.yaxis = builder.yaxis;
        this.ysrc = builder.ysrc;
        this.t = builder.t;
        this.opacity = builder.opacity;
        this.textfont = builder.textfont;
        this.legendgroup = builder.legendgroup;
        this.textpositionsrc = builder.textpositionsrc;
        this.fillcolor = builder.fillcolor;
        this.dx = builder.dx;
        this.dy = builder.dy;
        this.x0 = builder.x0;
        this.name = builder.name;
        this.connectgaps = builder.connectgaps;
        this.r = builder.r;
    }
   
}
