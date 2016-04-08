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

import java.util.List;

@SuppressWarnings("unused")
public class Scatter<T extends Value> extends Chart{
    
    String mode;
    String textposition;
    Stream stream;
    String text;
    String hoverinfo;
    String xsrc;
    Object visible;
    ScatterMarker marker;
    Number y0;
    String tsrc;
    Line line;
    String fill;
    Boolean showlegend;
    ErrorBar error_x;
    ErrorBar error_y;
    String textsrc;
    String rsrc;
    Axis xaxis;
    Axis yaxis;
    String ysrc;
    List<Number> t;
    Number opacity;
    Font textfont;
    String legendgroup;
    String textpositionsrc;
    String fillcolor;
    Number dx;
    Number dy;
    Number x0;
    String name;
    Boolean connectgaps;
    List<Number> r;

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

        private Builder() {
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
            return new net.java.html.plotlyjs.Scatter(type, x, y, mode, textposition, stream, text, hoverinfo, xsrc, visible, marker, y0, tsrc, line, fill, showlegend, error_x, error_y, textsrc, rsrc, xaxis, yaxis, ysrc, t, opacity, textfont, legendgroup, textpositionsrc, fillcolor, dx, dy, x0, name, connectgaps, r);
        }
    }

    public static Scatter.Builder builder() {
        return new Scatter.Builder();
    }

    private Scatter(final String type, final List x, final List y, final String mode, final String textposition, final Stream stream, final String text, final String hoverinfo, final String xsrc, final Object visible, final ScatterMarker marker, final Number y0, final String tsrc, final Line line, final String fill, final Boolean showlegend, final ErrorBar error_x, final ErrorBar error_y, final String textsrc, final String rsrc, final Axis xaxis, final Axis yaxis, final String ysrc, final List<Number> t, final Number opacity, final Font textfont, final String legendgroup, final String textpositionsrc, final String fillcolor, final Number dx, final Number dy, final Number x0, final String name, final Boolean connectgaps, final List<Number> r) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.mode = mode;
        this.textposition = textposition;
        this.stream = stream;
        this.text = text;
        this.hoverinfo = hoverinfo;
        this.xsrc = xsrc;
        this.visible = visible;
        this.marker = marker;
        this.y0 = y0;
        this.tsrc = tsrc;
        this.line = line;
        this.fill = fill;
        this.showlegend = showlegend;
        this.error_x = error_x;
        this.error_y = error_y;
        this.textsrc = textsrc;
        this.rsrc = rsrc;
        this.xaxis = xaxis;
        this.yaxis = yaxis;
        this.ysrc = ysrc;
        this.t = t;
        this.opacity = opacity;
        this.textfont = textfont;
        this.legendgroup = legendgroup;
        this.textpositionsrc = textpositionsrc;
        this.fillcolor = fillcolor;
        this.dx = dx;
        this.dy = dy;
        this.x0 = x0;
        this.name = name;
        this.connectgaps = connectgaps;
        this.r = r;
    }
    
    public Scatter(T data) {
        this.type = "scatter";
        this.x = data.x;
        this.y = data.y;
    }
    
    public Scatter(List x, List y){
        this.type = "scatter";
        this.x = x;
        this.y = y;
    }
}
