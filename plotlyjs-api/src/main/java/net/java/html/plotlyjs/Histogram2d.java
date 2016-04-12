/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.html.plotlyjs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Histogram2d <T extends Value> extends Chart {
    
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
    private List colorscale;
    private Axis yaxis;
    private String histnorm;
    private Boolean reversescale;
    private List z;

    public static class Builder {

        private final String type = "histogram2d";
        private List x;
        private List y;
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
        private List colorscale;
        private Axis yaxis;
        private String histnorm;
        private Boolean reversescale;
        private List z;

        public Builder() {
        }
        
        public Builder data(final XYZTrace value){
            this.x = value.x;
            this.y = value.y;
            this.z = value.z;
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

        public Builder zmax(final Number value) {
            this.zmax = value;
            return this;
        }

        public Builder stream(final Stream value) {
            this.stream = value;
            return this;
        }

        public Builder zsrc(final String value) {
            this.zsrc = value;
            return this;
        }

        public Builder ysrc(final String value) {
            this.ysrc = value;
            return this;
        }

        public Builder zmin(final Number value) {
            this.zmin = value;
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

        public Builder Marker(final Histogram2dMarker value) {
            this.Marker = value;
            return this;
        }

        public Builder colorbar(final ColorBar value) {
            this.colorbar = value;
            return this;
        }

        public Builder showlegend(final Boolean value) {
            this.showlegend = value;
            return this;
        }

        public Builder ybins(final AxisBin value) {
            this.ybins = value;
            return this;
        }

        public Builder xaxis(final Axis value) {
            this.xaxis = value;
            return this;
        }

        public Builder zsmooth(final Object value) {
            this.zsmooth = value;
            return this;
        }

        public Builder legendgroup(final String value) {
            this.legendgroup = value;
            return this;
        }

        public Builder autocolorscale(final Boolean value) {
            this.autocolorscale = value;
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

        public Builder xbins(final AxisBin value) {
            this.xbins = value;
            return this;
        }

        public Builder showscale(final Boolean value) {
            this.showscale = value;
            return this;
        }

        public Builder zauto(final Boolean value) {
            this.zauto = value;
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

        public Builder colorscale(final List value) {
            this.colorscale = value;
            return this;
        }

        public Builder yaxis(final Axis value) {
            this.yaxis = value;
            return this;
        }

        public Builder histnorm(final String value) {
            this.histnorm = value;
            return this;
        }

        public Builder reversescale(final Boolean value) {
            this.reversescale = value;
            return this;
        }

        public Builder z(final List value) {
            this.z = value;
            return this;
        }

        public Histogram2d build() {
            return new net.java.html.plotlyjs.Histogram2d(this);
        }
    }

    public static Histogram2d.Builder builder() {
        return new Histogram2d.Builder();
    }

    private Histogram2d(Builder builder) {
        this.type = builder.type;
        this.x = builder.x;
        this.y = builder.y;
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
