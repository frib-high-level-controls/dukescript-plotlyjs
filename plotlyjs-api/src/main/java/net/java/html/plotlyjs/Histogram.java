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
 * Bean-type wrapper builder for Plotly's Contour plot.
 * For more information see https://plot.ly/javascript/reference/#histogram
 * @author daykin
 * @param <TRACE_T> Extends CartesianTrace. The average user is probably looking
 * for DistributionTrace.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Histogram<TRACE_T extends CartesianTrace> extends Charts{
    private final String type;
    private final List<?> x;
    private final List<?> y;
    private final String orientation;
    private final Stream stream;
    private final String text;
    private final String hoverinfo;
    private final Object visible;
    private final Boolean showlegend;
    private final Axis xaxis;
    private final Axis yaxis;
    private final Number opacity;
    private final String legendgroup;
    private final Integer nbinsx;
    private final Integer nbinsy;
    private final String histfunc;
    private final Boolean autobiny;
    private final Boolean autobinx;
    private final String name;
    private final String histnorm;
    private final HistogramMarker marker;
    private final ErrorBar error_x;
    private final ErrorBar error_y;
    private final AxisBin xbins;
    private final AxisBin ybins;

    /**
     *
     * @param <TRACE_2>
     */
    public static class Builder<TRACE_2 extends CartesianTrace> {

        private String type = "histogram";
        private List<?> x;
        private List<?> y;
        private String orientation;
        private Stream stream;
        private String text;
        private String hoverinfo;
        private Object visible;
        private Boolean showlegend;
        private Axis xaxis;
        private Axis yaxis;
        private Number opacity;
        private String legendgroup;
        private Integer nbinsx;
        private Integer nbinsy;
        private String histfunc;
        private Boolean autobiny;
        private Boolean autobinx;
        private String name;
        private String histnorm;
        private HistogramMarker marker;
        private ErrorBar error_x;
        private ErrorBar error_y;
        private AxisBin xbins;
        private AxisBin ybins;

        private Builder() {
        }
        
        private static <TRACE_3 extends CartesianTrace> Builder<TRACE_3> start(){
            return new Builder<>();
        }
        
        
        public Builder<TRACE_2> orientation(final String value) {
            this.orientation = value;
            return this;
        }
        
        
        public Builder<TRACE_2> trace(final TRACE_2 value){
            this.x = value.x;
            this.y = value.y;
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

        
        public Builder<TRACE_2> visible(final Object value) {
            this.visible = value;
            return this;
        }

        
        public Builder<TRACE_2> showlegend(final Boolean value) {
            this.showlegend = value;
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

        
        public Builder<TRACE_2> opacity(final Number value) {
            this.opacity = value;
            return this;
        }

        
        public Builder<TRACE_2> legendgroup(final String value) {
            this.legendgroup = value;
            return this;
        }

        
        public Builder<TRACE_2> nbinsx(final Integer value) {
            this.nbinsx = value;
            return this;
        }

        
        public Builder<TRACE_2> nbinsy(final Integer value) {
            this.nbinsy = value;
            return this;
        }

        
        public Builder<TRACE_2> histfunc(final String value) {
            this.histfunc = value;
            return this;
        }

        
        public Builder<TRACE_2> autobiny(final Boolean value) {
            this.autobiny = value;
            return this;
        }

        
        public Builder<TRACE_2> autobinx(final Boolean value) {
            this.autobinx = value;
            return this;
        }

        
        public Builder<TRACE_2> name(final String value) {
            this.name = value;
            return this;
        }

        
        public Builder<TRACE_2> histnorm(final String value) {
            this.histnorm = value;
            return this;
        }

        
        public Builder<TRACE_2> marker(final HistogramMarker value) {
            this.marker = value;
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

        
        public Builder<TRACE_2> xbins(final AxisBin value) {
            this.xbins = value;
            return this;
        }

        
        public Builder<TRACE_2> ybins(final AxisBin value) {
            this.ybins = value;
            return this;
        }

        
        public Histogram<TRACE_2> build() {
            return new net.java.html.plotlyjs.Histogram<>(this);
        }
    }

    /**
     *
     * @param <TRACE>
     * @return
     */
    public static <TRACE extends CartesianTrace> Histogram.Builder<TRACE> builder() {
        return Histogram.Builder.start();
    }

    private Histogram(Builder<TRACE_T> builder) {
        this.type = builder.type;
        this.x = builder.x;
        this.y = builder.y;
        this.orientation = builder.orientation;
        this.stream = builder.stream;
        this.text = builder.text;
        this.hoverinfo = builder.hoverinfo;
        this.visible = builder.visible;
        this.showlegend = builder.showlegend;
        this.xaxis = builder.xaxis;
        this.yaxis = builder.yaxis;
        this.opacity = builder.opacity;
        this.legendgroup = builder.legendgroup;
        this.nbinsx = builder.nbinsx;
        this.nbinsy = builder.nbinsy;
        this.histfunc = builder.histfunc;
        this.autobiny = builder.autobiny;
        this.autobinx = builder.autobinx;
        this.name = builder.name;
        this.histnorm = builder.histnorm;
        this.marker = builder.marker;
        this.error_x = builder.error_x;
        this.error_y = builder.error_y;
        this.xbins = builder.xbins;
        this.ybins = builder.ybins;
    }

}
