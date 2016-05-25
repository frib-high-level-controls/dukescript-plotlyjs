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

/**
 *
 * @author daykin
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bar<TRACE_T extends CartesianTrace> extends Charts{
    private final String type;
    private final List<?> x;
    private final List<?> y;
    private final String orientation;
    private final Stream stream;
    private final String text;
    private final String hoverinfo;
    private final Object xsrc;
    private final Object visible;
    private final BarMarker marker;
    private final Number y0;
    private final Object tsrc;
    private final Boolean showlegend;
    private final ErrorBar error_x;
    private final ErrorBar error_y;
    private final Object rsrc;
    private final Axis xaxis;
    private final Axis yaxis;
    private final Object ysrc;
    private final Number opacity;
    private final String legendgroup;
    private final Object textsrc;
    private final Number dx;
    private final Number dy;
    private final Number x0;
    private final String name;

    public static class Builder<TRACE_2 extends CartesianTrace> {

        private final String type = "bar";
        private List<?> x;
        private List<?> y;
        private String orientation = Chart.Orientations.VERTICAL;
        private Stream stream;
        private String text;
        private String hoverinfo = Chart.HoverFlags.ALL;
        private Object xsrc;
        private Object visible = true;
        private BarMarker marker;
        private Number y0;
        private Object tsrc;
        private Boolean showlegend = true;
        private ErrorBar error_x;
        private ErrorBar error_y;
        private Object rsrc;
        private Axis xaxis;
        private Axis yaxis;
        private Object ysrc;
        private Number opacity;
        private String legendgroup;
        private Object textsrc;
        private Number dx;
        private Number dy;
        private Number x0;
        private String name;

        private Builder() {
        }
        
        public static<TRACE_3 extends CartesianTrace> Builder<TRACE_3> start(){
            return new Builder<>();
        }
        
        public Builder<TRACE_2> trace(final TRACE_2 trace){
            this.x = trace.x;
            this.y = trace.y;
            return this;
        }
        
        private Builder<TRACE_2> x(final List<?> value) {
            this.x = value;
            return this;
        }

        private Builder<TRACE_2> y(final List<?> value) {
            this.y = value;
            return this;
        }

        public Builder<TRACE_2> orientation(final String value) {
            this.orientation = value;
            return this;
        }

        public Builder<TRACE_2> stream(final Stream value) {
            this.stream = value;
            return this;
        }

        public Builder<TRACE_2> text(final String value) {
            this.text = value;
            return this;
        }

        public Builder<TRACE_2> hoverinfo(final String value) {
            this.hoverinfo = value;
            return this;
        }

        public Builder<TRACE_2> xsrc(final Object value) {
            this.xsrc = value;
            return this;
        }

        public Builder<TRACE_2> visible(final Object value) {
            this.visible = value;
            return this;
        }

        public Builder<TRACE_2> marker(final BarMarker value) {
            this.marker = value;
            return this;
        }

        public Builder<TRACE_2> y0(final Number value) {
            this.y0 = value;
            return this;
        }

        public Builder<TRACE_2> tsrc(final Object value) {
            this.tsrc = value;
            return this;
        }

        public Builder<TRACE_2> showlegend(final Boolean value) {
            this.showlegend = value;
            return this;
        }

        public Builder<TRACE_2> error_x(final ErrorBar value) {
            this.error_x = value;
            return this;
        }

        public Builder<TRACE_2> error_y(final ErrorBar value) {
            this.error_y = value;
            return this;
        }

        public Builder<TRACE_2> rsrc(final Object value) {
            this.rsrc = value;
            return this;
        }

        public Builder<TRACE_2> xaxis(final Axis value) {
            this.xaxis = value;
            return this;
        }

        public Builder<TRACE_2> yaxis(final Axis value) {
            this.yaxis = value;
            return this;
        }

        public Builder<TRACE_2> ysrc(final Object value) {
            this.ysrc = value;
            return this;
        }

        public Builder<TRACE_2> opacity(final Number value) {
            this.opacity = value;
            return this;
        }

        public Builder<TRACE_2> legendgroup(final String value) {
            this.legendgroup = value;
            return this;
        }

        public Builder<TRACE_2> textsrc(final Object value) {
            this.textsrc = value;
            return this;
        }

        public Builder<TRACE_2> dx(final Number value) {
            this.dx = value;
            return this;
        }

        public Builder<TRACE_2> dy(final Number value) {
            this.dy = value;
            return this;
        }

        public Builder<TRACE_2> x0(final Number value) {
            this.x0 = value;
            return this;
        }

        public Builder<TRACE_2> name(final String value) {
            this.name = value;
            return this;
        }

        public Bar<TRACE_2> build() {
            return new net.java.html.plotlyjs.Bar<>(this);
        }
    }

    public static <TRACE extends CartesianTrace> Bar.Builder<TRACE> builder() {
        return Builder.start();
    }

    private Bar(Builder<TRACE_T> builder) {
        this.type = "bar";
        this.x = builder.x;
        this.y = builder.y;
        this.orientation = builder.orientation;
        this.stream = builder.stream;
        this.text = builder.text;
        this.hoverinfo = builder.hoverinfo;
        this.xsrc = builder.xsrc;
        this.visible = builder.visible;
        this.marker = builder.marker;
        this.y0 = builder.y0;
        this.tsrc = builder.tsrc;
        this.showlegend = builder.showlegend;
        this.error_x = builder.error_x;
        this.error_y = builder.error_y;
        this.rsrc = builder.rsrc;
        this.xaxis = builder.xaxis;
        this.yaxis = builder.yaxis;
        this.ysrc = builder.ysrc;
        this.opacity = builder.opacity;
        this.legendgroup = builder.legendgroup;
        this.textsrc = builder.textsrc;
        this.dx = builder.dx;
        this.dy = builder.dy;
        this.x0 = builder.x0;
        this.name = builder.name;
    }
    
}
