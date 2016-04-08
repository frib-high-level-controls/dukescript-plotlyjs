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
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Histogram<T extends Value> extends Chart{
    public static final class HistFunc{
        public static final String COUNT = "count";
        public static final String SUM = "sum";
        public static final String AVG = "avg";
        public static final String MIN = "min";
        public static final String MAX = "max";
    }
    
    public static final class HistNorm{
        public static final String PERCENT = "percent";
        public static final String PROBABILITY = "probability";
        public static final String DENSITY = "density";
        public static final String PROBABILITY_DENSITY = "probability density";
    }  
    
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

    public static class Builder {

        private final String type = "histogram";
        private List x;
        private List y;
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

        public Builder() {
        }

        public Builder x(final List value) {
            this.x = value;
            return this;
        }

        public Builder y(final List value) {
            this.y = value;
            return this;
        }
        
        public Builder trace(final Value value){
            this.x = value.x;
            this.y = value.y;
            return this;
        }
        
        
        public Builder orientation(final String value) {
            this.orientation = value;
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

        public Builder visible(final Object value) {
            this.visible = value;
            return this;
        }

        public Builder showlegend(final Boolean value) {
            this.showlegend = value;
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

        public Builder opacity(final Number value) {
            this.opacity = value;
            return this;
        }

        public Builder legendgroup(final String value) {
            this.legendgroup = value;
            return this;
        }

        public Builder nbinsx(final Integer value) {
            this.nbinsx = value;
            return this;
        }

        public Builder nbinsy(final Integer value) {
            this.nbinsy = value;
            return this;
        }
        public Builder histfunc(final String value) {
            this.histfunc = value;
            return this;
        }

        public Builder autobiny(final Boolean value) {
            this.autobiny = value;
            return this;
        }

        public Builder autobinx(final Boolean value) {
            this.autobinx = value;
            return this;
        }

        public Builder name(final String value) {
            this.name = value;
            return this;
        }

        public Builder histnorm(final String value) {
            this.histnorm = value;
            return this;
        }

        public Builder marker(final HistogramMarker value) {
            this.marker = value;
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

        public Builder xbins(final AxisBin value) {
            this.xbins = value;
            return this;
        }

        public Builder ybins(final AxisBin value) {
            this.ybins = value;
            return this;
        }

        public Histogram build() {
            return new net.java.html.plotlyjs.Histogram(type, x, y, orientation,
                    stream, text, hoverinfo, visible, showlegend, xaxis, yaxis, 
                    opacity, legendgroup, nbinsx, nbinsy, histfunc, autobiny, 
                    autobinx, name, histnorm, marker, error_x, error_y, xbins, 
                    ybins);
        }
    }

    public static Histogram.Builder builder() {
        return new Histogram.Builder();
    }

    private Histogram(final String type, final List x, final List y, 
            final String orientation, final Stream stream, final String text, 
            final String hoverinfo, final Object visible, 
            final Boolean showlegend, final Axis xaxis, final Axis yaxis, 
            final Number opacity, final String legendgroup, final Integer nbinsx, 
            final Integer nbinsy, final String histfunc, final Boolean autobiny, 
            final Boolean autobinx, final String name, final String histnorm, 
            final HistogramMarker marker, final ErrorBar error_x, 
            final ErrorBar error_y, final AxisBin xbins, final AxisBin ybins) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.stream = stream;
        this.text = text;
        this.hoverinfo = hoverinfo;
        this.visible = visible;
        this.showlegend = showlegend;
        this.xaxis = xaxis;
        this.yaxis = yaxis;
        this.opacity = opacity;
        this.legendgroup = legendgroup;
        this.nbinsx = nbinsx;
        this.nbinsy = nbinsy;
        this.histfunc = histfunc;
        this.autobiny = autobiny;
        this.autobinx = autobinx;
        this.name = name;
        this.histnorm = histnorm;
        this.marker = marker;
        this.error_x = error_x;
        this.error_y = error_y;
        this.xbins = xbins;
        this.ybins = ybins;
    }
    
    public Histogram(T data){
        this.type = "histogram";
        this.x = data.x;
        this.y = data.y;
    }
    
}
