package net.java.html.plotlyjs;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

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


/**
 *
 * @author daykin
 * @param <T> an implementation of {@link Trace}
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Histogram<T extends Trace> extends Charts{

    public Histogram(Builder<?,T> builder) {
        super(builder);
    }
    
//    private final String orientation;
//    private final Stream stream;
//    private final String text;
//    private final String hoverinfo;
//    private final Object visible;
//    private final Boolean showlegend;
//    private final Axis xaxis;
//    private final Axis yaxis;
//    private final Number opacity;
//    private final String legendgroup;
//    private final Integer nbinsx;
//    private final Integer nbinsy;
//    private final String histfunc;
//    private final Boolean autobiny;
//    private final Boolean autobinx;
//    private final String name;
//    private final String histnorm;
//    private final HistogramMarker marker;
//    private final ErrorBar error_x;
//    private final ErrorBar error_y;
//    private final AxisBin xbins;
//    private final AxisBin ybins;
//
//    public static class Builder {
//
//        private String type = "histogram";
//        private List x;
//        private List y;
//        private String orientation;
//        private Stream stream;
//        private String text;
//        private String hoverinfo;
//        private Object visible;
//        private Boolean showlegend;
//        private Axis xaxis;
//        private Axis yaxis;
//        private Number opacity;
//        private String legendgroup;
//        private Integer nbinsx;
//        private Integer nbinsy;
//        private String histfunc;
//        private Boolean autobiny;
//        private Boolean autobinx;
//        private String name;
//        private String histnorm;
//        private HistogramMarker marker;
//        private ErrorBar error_x;
//        private ErrorBar error_y;
//        private AxisBin xbins;
//        private AxisBin ybins;
//
//        public Builder() {
//        }
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
//        public Builder trace(final Value value){
//            this.x = value.x;
//            this.y = value.y;
//            return this;
//        }
//        
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
//        public Builder visible(final Object value) {
//            this.visible = value;
//            return this;
//        }
//
//        public Builder showlegend(final Boolean value) {
//            this.showlegend = value;
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
//        public Builder nbinsx(final Integer value) {
//            this.nbinsx = value;
//            return this;
//        }
//
//        public Builder nbinsy(final Integer value) {
//            this.nbinsy = value;
//            return this;
//        }
//        public Builder histfunc(final String value) {
//            this.histfunc = value;
//            return this;
//        }
//
//        public Builder autobiny(final Boolean value) {
//            this.autobiny = value;
//            return this;
//        }
//
//        public Builder autobinx(final Boolean value) {
//            this.autobinx = value;
//            return this;
//        }
//
//        public Builder name(final String value) {
//            this.name = value;
//            return this;
//        }
//
//        public Builder histnorm(final String value) {
//            this.histnorm = value;
//            return this;
//        }
//
//        public Builder marker(final HistogramMarker value) {
//            this.marker = value;
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
//        public Builder xbins(final AxisBin value) {
//            this.xbins = value;
//            return this;
//        }
//
//        public Builder ybins(final AxisBin value) {
//            this.ybins = value;
//            return this;
//        }
//
//        public Histogram build() {
//            return new net.java.html.plotlyjs.Histogram(this);
//        }
//    }
//
//    public static Histogram.Builder builder() {
//        return new Histogram.Builder();
//    }
//
//    private Histogram(Builder builder) {
//        this.type = builder.type;
//        this.x = builder.x;
//        this.y = builder.y;
//        this.orientation = builder.orientation;
//        this.stream = builder.stream;
//        this.text = builder.text;
//        this.hoverinfo = builder.hoverinfo;
//        this.visible = builder.visible;
//        this.showlegend = builder.showlegend;
//        this.xaxis = builder.xaxis;
//        this.yaxis = builder.yaxis;
//        this.opacity = builder.opacity;
//        this.legendgroup = builder.legendgroup;
//        this.nbinsx = builder.nbinsx;
//        this.nbinsy = builder.nbinsy;
//        this.histfunc = builder.histfunc;
//        this.autobiny = builder.autobiny;
//        this.autobinx = builder.autobinx;
//        this.name = builder.name;
//        this.histnorm = builder.histnorm;
//        this.marker = builder.marker;
//        this.error_x = builder.error_x;
//        this.error_y = builder.error_y;
//        this.xbins = builder.xbins;
//        this.ybins = builder.ybins;
//    }

}
