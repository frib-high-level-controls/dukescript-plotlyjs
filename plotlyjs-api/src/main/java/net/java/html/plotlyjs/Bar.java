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
public class Bar<T extends Trace> extends Charts{

    public Bar(Builder<?,T> builder) {
        super(builder);
    }
//    /*
//        Y magnitude direction-horizontal or vertical
//    */
//    private final String orientation;
//    private final Stream stream;
//    private final String text;
//    /*
//        On hover, what info to show; if
//        Unspecified, the chart will show all data at that point.
//    */
//    private final String hoverinfo;
//    private final Object xsrc;
//    private final Object visible;
//    private final BarMarker marker;
//    private final Number y0;
//    private final Object tsrc;
//    private final Boolean showlegend;
//    private final ErrorBar error_x;
//    private final ErrorBar error_y;
//    private final Object rsrc;
//    private final Axis xaxis;
//    private final Axis yaxis;
//    private final Object ysrc;
//    private final Number opacity;
//    private final String legendgroup;
//    private final Object textsrc;
//    private final Number dx;
//    private final Number dy;
//    private final Number x0;
//    private final String name;
//
//    public static class Builder {
//
//        private final String type = "bar";
//        private List x;
//        private List y;
//        private String orientation = Chart.Orientations.VERTICAL;
//        private Stream stream;
//        private String text;
//        private String hoverinfo = Chart.HoverFlags.ALL;
//        private Object xsrc;
//        private Object visible = true;
//        private BarMarker marker;
//        private Number y0;
//        private Object tsrc;
//        private Boolean showlegend = true;
//        private ErrorBar error_x;
//        private ErrorBar error_y;
//        private Object rsrc;
//        private Axis xaxis;
//        private Axis yaxis;
//        private Object ysrc;
//        private Number opacity;
//        private String legendgroup;
//        private Object textsrc;
//        private Number dx;
//        private Number dy;
//        private Number x0;
//        private String name;
//
//        private Builder() {
//        }
//
//
//        public Builder x(final List value) {
//            this.x = value;
//            return this;
//        }
//
//        public Builder y(final List value) {
//            this.y = value;
//            return this;
//        }
//
//        public Builder orientation(final String value) {
//            this.orientation = value;
//            return this;
//        }
//
//        public Builder stream(final Stream value) {
//            this.stream = value;
//            return this;
//        }
//
//        public Builder text(final String value) {
//            this.text = value;
//            return this;
//        }
//
//        public Builder hoverinfo(final String value) {
//            this.hoverinfo = value;
//            return this;
//        }
//
//        public Builder xsrc(final Object value) {
//            this.xsrc = value;
//            return this;
//        }
//
//        public Builder visible(final Object value) {
//            this.visible = value;
//            return this;
//        }
//
//        public Builder marker(final BarMarker value) {
//            this.marker = value;
//            return this;
//        }
//
//        public Builder y0(final Number value) {
//            this.y0 = value;
//            return this;
//        }
//
//        public Builder tsrc(final Object value) {
//            this.tsrc = value;
//            return this;
//        }
//
//        public Builder showlegend(final Boolean value) {
//            this.showlegend = value;
//            return this;
//        }
//
//        public Builder error_x(final ErrorBar value) {
//            this.error_x = value;
//            return this;
//        }
//
//        public Builder error_y(final ErrorBar value) {
//            this.error_y = value;
//            return this;
//        }
//
//        public Builder rsrc(final Object value) {
//            this.rsrc = value;
//            return this;
//        }
//
//        public Builder xaxis(final Axis value) {
//            this.xaxis = value;
//            return this;
//        }
//
//        public Builder yaxis(final Axis value) {
//            this.yaxis = value;
//            return this;
//        }
//
//        public Builder ysrc(final Object value) {
//            this.ysrc = value;
//            return this;
//        }
//
//        public Builder opacity(final Number value) {
//            this.opacity = value;
//            return this;
//        }
//
//        public Builder legendgroup(final String value) {
//            this.legendgroup = value;
//            return this;
//        }
//
//        public Builder textsrc(final Object value) {
//            this.textsrc = value;
//            return this;
//        }
//
//        public Builder dx(final Number value) {
//            this.dx = value;
//            return this;
//        }
//
//        public Builder dy(final Number value) {
//            this.dy = value;
//            return this;
//        }
//
//        public Builder x0(final Number value) {
//            this.x0 = value;
//            return this;
//        }
//
//        public Builder name(final String value) {
//            this.name = value;
//            return this;
//        }
//
//        public Bar build() {
//            return new net.java.html.plotlyjs.Bar(this);
//        }
//    }
//
//    public static Bar.Builder builder() {
//        return new Bar.Builder();
//    }
//
//    private Bar(Builder builder) {
//        this.type = builder.type;
//        this.x = builder.x;
//        this.y = builder.y;
//        this.orientation = builder.orientation;
//        this.stream = builder.stream;
//        this.text = builder.text;
//        this.hoverinfo = builder.hoverinfo;
//        this.xsrc = builder.xsrc;
//        this.visible = builder.visible;
//        this.marker = builder.marker;
//        this.y0 = builder.y0;
//        this.tsrc = builder.tsrc;
//        this.showlegend = builder.showlegend;
//        this.error_x = builder.error_x;
//        this.error_y = builder.error_y;
//        this.rsrc = builder.rsrc;
//        this.xaxis = builder.xaxis;
//        this.yaxis = builder.yaxis;
//        this.ysrc = builder.ysrc;
//        this.opacity = builder.opacity;
//        this.legendgroup = builder.legendgroup;
//        this.textsrc = builder.textsrc;
//        this.dx = builder.dx;
//        this.dy = builder.dy;
//        this.x0 = builder.x0;
//        this.name = builder.name;
//    }
//    
}
