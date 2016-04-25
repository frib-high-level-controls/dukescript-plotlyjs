/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.Map;

/**
 *
 * @author daykin
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Heatmap extends Chart{
    private final Number zmax;
    private final String xtype;
    private final Stream stream;
    private final String zsrc;
    private final List text;
    private final Number zmin;
    private final String hoverinfo;
    private final String xsrc;
    private final Object visible;
    private final Number y0;
    private final ColorBar colorbar;
    private final Boolean showlegend;
    private final String ytype;
    private final Axis xaxis;
    private final String ysrc;
    private final Object zsmooth;
    private final Number opacity;
    private final String legendgroup;
    private final Boolean transpose;
    private final Boolean autocolorscale;
    private final String textsrc;
    private final Number dx;
    private final Number dy;
    private final Boolean showscale;
    private final Number x0;
    private final Boolean zauto;
    private final String name;
    private final Map colorscale;
    private final Boolean connectgaps;
    private final Axis yaxis;
    private final Boolean reversescale;
    private final List z;

    public static class Builder {

        private final String type = "heatmap";
        private List x;
        private List y;
        private Number zmax;
        private String xtype;
        private Stream stream;
        private String zsrc;
        private List text;
        private Number zmin;
        private String hoverinfo;
        private String xsrc;
        private Object visible;
        private Number y0;
        private ColorBar colorbar;
        private Boolean showlegend;
        private String ytype;
        private Axis xaxis;
        private String ysrc;
        private Object zsmooth;
        private Number opacity;
        private String legendgroup;
        private Boolean transpose;
        private Boolean autocolorscale;
        private String textsrc;
        private Number dx;
        private Number dy;
        private Boolean showscale;
        private Number x0;
        private Boolean zauto;
        private String name;
        private Map colorscale;
        private Boolean connectgaps;
        private Axis yaxis;
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

        public Builder xtype(final String value) {
            this.xtype = value;
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

        public Builder text(final List value) {
            this.text = value;
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

        public Builder y0(final Number value) {
            this.y0 = value;
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

        public Builder ytype(final String value) {
            this.ytype = value;
            return this;
        }

        public Builder xaxis(final Axis value) {
            this.xaxis = value;
            return this;
        }

        public Builder ysrc(final String value) {
            this.ysrc = value;
            return this;
        }

        public Builder zsmooth(final Object value) {
            this.zsmooth = value;
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

        public Builder transpose(final Boolean value) {
            this.transpose = value;
            return this;
        }

        public Builder autocolorscale(final Boolean value) {
            this.autocolorscale = value;
            return this;
        }

        public Builder textsrc(final String value) {
            this.textsrc = value;
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

        public Builder showscale(final Boolean value) {
            this.showscale = value;
            return this;
        }

        public Builder x0(final Number value) {
            this.x0 = value;
            return this;
        }

        public Builder zauto(final Boolean value) {
            this.zauto = value;
            return this;
        }

        public Builder name(final String value) {
            this.name = value;
            return this;
        }

        public Builder colorscale(final Map value) {
            this.colorscale = value;
            return this;
        }

        public Builder connectgaps(final Boolean value) {
            this.connectgaps = value;
            return this;
        }

        public Builder yaxis(final Axis value) {
            this.yaxis = value;
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

        public Heatmap build() {
            return new net.java.html.plotlyjs.Heatmap(this);
        }
    }

    public static Heatmap.Builder builder() {
        return new Heatmap.Builder();
    }

    private Heatmap(Builder builder) {
        this.type = builder.type;
        this.x = builder.x;
        this.y = builder.y;
        this.zmax = builder.zmax;
        this.xtype = builder.xtype;
        this.stream = builder.stream;
        this.zsrc = builder.zsrc;
        this.text = builder.text;
        this.zmin = builder.zmin;
        this.hoverinfo = builder.hoverinfo;
        this.xsrc = builder.xsrc;
        this.visible = builder.visible;
        this.y0 = builder.y0;
        this.colorbar = builder.colorbar;
        this.showlegend = builder.showlegend;
        this.ytype = builder.ytype;
        this.xaxis = builder.xaxis;
        this.ysrc = builder.ysrc;
        this.zsmooth = builder.zsmooth;
        this.opacity = builder.opacity;
        this.legendgroup = builder.legendgroup;
        this.transpose = builder.transpose;
        this.autocolorscale = builder.autocolorscale;
        this.textsrc = builder.textsrc;
        this.dx = builder.dx;
        this.dy = builder.dy;
        this.showscale = builder.showscale;
        this.x0 = builder.x0;
        this.zauto = builder.zauto;
        this.name = builder.name;
        this.colorscale = builder.colorscale;
        this.connectgaps = builder.connectgaps;
        this.yaxis = builder.yaxis;
        this.reversescale = builder.reversescale;
        this.z = builder.z;
    }
    
    
}
