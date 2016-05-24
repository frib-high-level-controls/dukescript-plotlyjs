/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @param <TRACE_T> a type of Trace
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Histogram2d <TRACE_T extends CartesianTrace> extends Charts {
    private final String type;
    private final TRACE_T trace;
    private final List <?> x;
    private final List <?> y;
    private final Number zmax;
    private final Stream stream;
    private final String zsrc;
    private final String ysrc;
    private final Number zmin;
    private final String hoverinfo;
    private final String xsrc;
    private final Object visible;
    private final Histogram2dMarker Marker;
    private final ColorBar colorbar;
    private final Boolean showlegend;
    private final AxisBin ybins;
    private final Axis xaxis;
    private final Object zsmooth;
    private final String legendgroup;
    private final Boolean autocolorscale;
    private final Integer nbinsx;
    private final Integer nbinsy;
    private final String histfunc;
    private final AxisBin xbins;
    private final Boolean showscale;
    private final Boolean zauto;
    private final Boolean autobiny;
    private final Boolean autobinx;
    private final String name;
    private final String[] colorscale;
    private final Axis yaxis;
    private final String histnorm;
    private final Boolean reversescale;
    private final List<?> z;

    public static class Builder<TRACE2 extends CartesianTrace> {
        private TRACE2 trace;
        private List<?> x;
        private List<?> y;
        private Number zmax;
        private Stream stream;
        private String zsrc;
        private String ysrc;
        private Number zmin;
        private String hoverinfo;
        private String xsrc;
        private Object visible;
        private Histogram2dMarker Marker;
        private ColorBar colorbar;
        private Boolean showlegend;
        private AxisBin ybins;
        private Axis xaxis;
        private Object zsmooth;
        private String legendgroup;
        private Boolean autocolorscale;
        private Integer nbinsx;
        private Integer nbinsy;
        private String histfunc;
        private AxisBin xbins;
        private Boolean showscale;
        private Boolean zauto;
        private Boolean autobiny;
        private Boolean autobinx;
        private String name;
        private String[] colorscale;
        private Axis yaxis;
        private String histnorm;
        private Boolean reversescale;
        private List<?> z;

        private Builder() {
        }
        
        private static<TRACE_3 extends CartesianTrace> Builder<TRACE_3> start(){
            return new Builder<>();
        }
        
        public Builder<TRACE2> trace(final TRACE2 value){
            this.x = value.x;
            this.y = value.y;
            if(value instanceof XYZTrace){
            this.z = ((XYZTrace)value).z;
            }
            return this;
        }
        
        public Builder<TRACE2> x(final List<?> value) {
            this.x = value;
            return this;
        }

        public Builder<TRACE2> y(final List<?> value) {
            this.y = value;
            return this;
        }

        public Builder<TRACE2> zmax(final Number value) {
            this.zmax = value;
            return this;
        }

        public Builder<TRACE2> stream(final Stream value) {
            this.stream = value;
            return this;
        }

        public Builder<TRACE2> zsrc(final String value) {
            this.zsrc = value;
            return this;
        }

        public Builder<TRACE2> ysrc(final String value) {
            this.ysrc = value;
            return this;
        }

        public Builder<TRACE2> zmin(final Number value) {
            this.zmin = value;
            return this;
        }

        public Builder<TRACE2> hoverinfo(final String value) {
            this.hoverinfo = value;
            return this;
        }

        public Builder<TRACE2> xsrc(final String value) {
            this.xsrc = value;
            return this;
        }

        public Builder<TRACE2> visible(final Object value) {
            this.visible = value;
            return this;
        }

        public Builder<TRACE2> Marker(final Histogram2dMarker value) {
            this.Marker = value;
            return this;
        }

        public Builder<TRACE2> colorbar(final ColorBar value) {
            this.colorbar = value;
            return this;
        }

        public Builder<TRACE2> showlegend(final Boolean value) {
            this.showlegend = value;
            return this;
        }

        public Builder<TRACE2> ybins(final AxisBin value) {
            this.ybins = value;
            return this;
        }

        public Builder<TRACE2> xaxis(final Axis value) {
            this.xaxis = value;
            return this;
        }

        public Builder<TRACE2> zsmooth(final Object value) {
            this.zsmooth = value;
            return this;
        }

        public Builder<TRACE2> legendgroup(final String value) {
            this.legendgroup = value;
            return this;
        }

        public Builder<TRACE2> autocolorscale(final Boolean value) {
            this.autocolorscale = value;
            return this;
        }

        public Builder<TRACE2> nbinsx(final Integer value) {
            this.nbinsx = value;
            return this;
        }

        public Builder<TRACE2> nbinsy(final Integer value) {
            this.nbinsy = value;
            return this;
        }

        public Builder<TRACE2> histfunc(final String value) {
            this.histfunc = value;
            return this;
        }

        public Builder<TRACE2> xbins(final AxisBin value) {
            this.xbins = value;
            return this;
        }

        public Builder<TRACE2> showscale(final Boolean value) {
            this.showscale = value;
            return this;
        }

        public Builder<TRACE2> zauto(final Boolean value) {
            this.zauto = value;
            return this;
        }

        public Builder<TRACE2> autobiny(final Boolean value) {
            this.autobiny = value;
            return this;
        }

        public Builder<TRACE2> autobinx(final Boolean value) {
            this.autobinx = value;
            return this;
        }

        public Builder<TRACE2> name(final String value) {
            this.name = value;
            return this;
        }

        public Builder<TRACE2> colorscale(final String[] value) {
            this.colorscale = value;
            return this;
        }

        public Builder<TRACE2> yaxis(final Axis value) {
            this.yaxis = value;
            return this;
        }

        public Builder<TRACE2> histnorm(final String value) {
            this.histnorm = value;
            return this;
        }

        public Builder<TRACE2> reversescale(final Boolean value) {
            this.reversescale = value;
            return this;
        }

        public Builder<TRACE2> z(final List<?> value) {
            this.z = value;
            return this;
        }

        public Histogram2d<TRACE2> build() {
            return new net.java.html.plotlyjs.Histogram2d<>(this);
        }
    }

    public static <TRACE extends CartesianTrace> Histogram2d.Builder<TRACE> builder() {
        return Histogram2d.Builder.start();
    }

    private Histogram2d(Builder<TRACE_T> builder) {
        this.type = "histogram2d";
        this.x = builder.x;
        this.y = builder.y;
        this.trace = builder.trace;
        this.zmax = builder.zmax;
        this.stream = builder.stream;
        this.zsrc = builder.zsrc;
        this.ysrc = builder.ysrc;
        this.zmin = builder.zmin;
        this.hoverinfo = builder.hoverinfo;
        this.xsrc = builder.xsrc;
        this.visible = builder.visible;
        this.Marker = builder.Marker;
        this.colorbar = builder.colorbar;
        this.showlegend = builder.showlegend;
        this.ybins = builder.ybins;
        this.xaxis = builder.xaxis;
        this.zsmooth = builder.zsmooth;
        this.legendgroup = builder.legendgroup;
        this.autocolorscale = builder.autocolorscale;
        this.nbinsx = builder.nbinsx;
        this.nbinsy = builder.nbinsy;
        this.histfunc = builder.histfunc;
        this.xbins = builder.xbins;
        this.showscale = builder.showscale;
        this.zauto = builder.zauto;
        this.autobiny = builder.autobiny;
        this.autobinx = builder.autobinx;
        this.name = builder.name;
        this.colorscale = builder.colorscale;
        this.yaxis = builder.yaxis;
        this.histnorm = builder.histnorm;
        this.reversescale = builder.reversescale;
        this.z = builder.z;
    }
    
    
}
