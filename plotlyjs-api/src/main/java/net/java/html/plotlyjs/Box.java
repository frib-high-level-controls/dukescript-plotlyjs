package net.java.html.plotlyjs;

/*
 * #%L
 * This software is Copyright by the Board of Trustees of Michigan
 * State University (c) Copyright 2016.
 * Contact Information:
 * Facility for Rare Isotope Beam
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
public class Box extends Chart{
    public static final class Mean{
        public static final Boolean TRUE = true;
        public static final Boolean FALSE = false;
        public static final String SD = "sd";
    }
    public static final class Boxpoints{
        public static final String ALL = "all";
	public static final String OUTLIERS = "outliers";
	public static final String SUSPECTEDOUTLIERS = "suspectedoutliers";
	public static final Boolean FALSE = false;
    }
    
    private final Number jitter;
    private final String orientation;
    private final Stream stream;
    private final Object ysrc;
    private final Object xsrc;
    private final Object visible;
    private final BoxMarker marker;
    private final Number y0;
    private final Number pointpos;
    private final Line line;
    private final Boolean showlegend;
    private final Object boxmean;
    private final Axis xaxis;
    private final Number opacity;
    private final String legendgroup;
    private final String fillcolor;
    private final String hoverinfo;
    private final Number x0;
    private final Number whiskerwidth;
    private final String name;
    private final Axis yaxis;
    private final Object boxpoints;

    public static class Builder {

        private final String type = "box";
        private List x;
        private List y;
        private Number jitter;
        private String orientation;
        private Stream stream;
        private Object ysrc;
        private Object xsrc;
        private Object visible;
        private BoxMarker marker;
        private Number y0;
        private Number pointpos;
        private Line line;
        private Boolean showlegend;
        private Object boxmean;
        private Axis xaxis;
        private Number opacity;
        private String legendgroup;
        private String fillcolor;
        private String hoverinfo;
        private Number x0;
        private Number whiskerwidth;
        private String name;
        private Axis yaxis;
        private Object boxpoints;

        private Builder() {
        }

        public Builder x(final List value) {
            this.x = value;
            return this;
        }

        public Builder y(final List value) {
            this.y = value;
            return this;
        }
        
        public Builder data(final Value value){
            this.x = value.x;
            this.y = value.y;
            return this;
        }

        public Builder jitter(final Number value) {
            this.jitter = value;
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

        public Builder ysrc(final Object value) {
            this.ysrc = value;
            return this;
        }

        public Builder xsrc(final Object value) {
            this.xsrc = value;
            return this;
        }

        public Builder visible(final Object value) {
            this.visible = value;
            return this;
        }

        public Builder marker(final BoxMarker value) {
            this.marker = value;
            return this;
        }

        public Builder y0(final Number value) {
            this.y0 = value;
            return this;
        }

        public Builder pointpos(final Number value) {
            this.pointpos = value;
            return this;
        }

        public Builder line(final Line value) {
            this.line = value;
            return this;
        }

        public Builder showlegend(final Boolean value) {
            this.showlegend = value;
            return this;
        }

        public Builder boxmean(final Object value) {
            this.boxmean = value;
            return this;
        }

        public Builder xaxis(final Axis value) {
            this.xaxis = value;
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

        public Builder fillcolor(final String value) {
            this.fillcolor = value;
            return this;
        }

        public Builder hoverinfo(final String value) {
            this.hoverinfo = value;
            return this;
        }

        public Builder x0(final Number value) {
            this.x0 = value;
            return this;
        }

        public Builder whiskerwidth(final Number value) {
            this.whiskerwidth = value;
            return this;
        }

        public Builder name(final String value) {
            this.name = value;
            return this;
        }

        public Builder yaxis(final Axis value) {
            this.yaxis = value;
            return this;
        }

        public Builder boxpoints(final Object value) {
            this.boxpoints = value;
            return this;
        }

        public Box build() {
            return new net.java.html.plotlyjs.Box(this);
        }
    }

    public static Box.Builder builder() {
        return new Box.Builder();
    }

    private Box(Builder builder) {
        this.type = builder.type;
        this.x = builder.x;
        this.y = builder.y;
        this.jitter = builder.jitter;
        this.orientation = builder.orientation;
        this.stream = builder.stream;
        this.ysrc = builder.ysrc;
        this.xsrc = builder.xsrc;
        this.visible = builder.visible;
        this.marker = builder.marker;
        this.y0 = builder.y0;
        this.pointpos = builder.pointpos;
        this.line = builder.line;
        this.showlegend = builder.showlegend;
        this.boxmean = builder.boxmean;
        this.xaxis = builder.xaxis;
        this.opacity = builder.opacity;
        this.legendgroup = builder.legendgroup;
        this.fillcolor = builder.fillcolor;
        this.hoverinfo = builder.hoverinfo;
        this.x0 = builder.x0;
        this.whiskerwidth = builder.whiskerwidth;
        this.name = builder.name;
        this.yaxis = builder.yaxis;
        this.boxpoints = builder.boxpoints;
    }
    
    
}
