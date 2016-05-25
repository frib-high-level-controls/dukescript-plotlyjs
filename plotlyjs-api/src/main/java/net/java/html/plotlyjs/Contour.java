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


/**
 *
 * @author daykin
 */
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;
@JsonInclude(Include.NON_NULL)
public class Contour<TRACE_T extends CartesianTrace> extends Charts{
    private final String type;
    private final Number zmax;
    private final String xtype;//enum this?
    private final Stream stream;
    private final Object zsrc;
    private final List<?> text;
    private final Number zmin;
    private final String hoverinfo;
    private final Object xsrc;
    private final Object visible;
    private final Number y0;
    private final Line line;
    private final ColorBar colorbar;
    private final Boolean showlegend;
    private final Integer ncontours;
    private final String ytype; //enum array/scaled
    private final Contours contours;
    private final Axis xaxis;
    private final Object ysrc;
    private final Number opacity;
    private final String legendgroup;
    private final Boolean autocontour;
    private final Boolean transpose;
    private final Boolean autocolorscale;
    private final Object textsrc;
    private final Number dx;
    private final Number dy;
    private final Boolean showscale;
    private final Object x0;
    private final Boolean zauto;
    private final String name;
    private final Map<Number,String> colorscale;
    private final Boolean connectgaps;
    private final Axis yaxis;
    private final Boolean reversescale;
    private final List<?> x;
    private final List<?> y;
    private final List<?> z;

    public static class Builder<TRACE_2 extends CartesianTrace> {
        private static final String type = "contour";
        private Number zmax;
        private String xtype;
        private Stream stream;
        private Object zsrc;
        private List<?> text;
        private Number zmin;
        private String hoverinfo;
        private Object xsrc;
        private Object visible;
        private Number y0;
        private Line line;
        private ColorBar colorbar;
        private Boolean showlegend;
        private Integer ncontours;
        private String ytype;
        private Contours contours;
        private Axis xaxis;
        private Object ysrc;
        private Number opacity;
        private String legendgroup;
        private Boolean autocontour;
        private Boolean transpose;
        private Boolean autocolorscale;
        private Object textsrc;
        private Number dx;
        private Number dy;
        private Boolean showscale;
        private Object x0;
        private Boolean zauto;
        private String name;
        private Map<Number,String> colorscale;
        private Boolean connectgaps;
        private Axis yaxis;
        private Boolean reversescale;
        private List<?> y;
        private List<?> x;
        private List<?> z;

        private Builder() {
        }

        public static <TRACE_3 extends CartesianTrace> Builder<TRACE_3> start(){
            return new Builder<>();
        }
        
        public Builder<TRACE_2> trace(final TRACE_2 trace){
            this.x = trace.x;
            this.y = trace.y;
            if(trace instanceof XYZTrace){
                this.z = ((XYZTrace)trace).z;
            }
            return this;
        }
        
        public Builder<TRACE_2> zmax(final Number value) {
            this.zmax = value;
            return this;
        }

        public Builder<TRACE_2> xtype(final String value) {
            this.xtype = value;
            return this;
        }

        public Builder<TRACE_2> stream(final Stream value) {
            this.stream = value;
            return this;
        }

        public Builder<TRACE_2> zsrc(final Object value) {
            this.zsrc = value;
            return this;
        }

        public Builder<TRACE_2> text(final List<?> value) {
            this.text = value;
            return this;
        }

        public Builder<TRACE_2> zmin(final Number value) {
            this.zmin = value;
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

        public Builder<TRACE_2> y0(final Number value) {
            this.y0 = value;
            return this;
        }

        public Builder<TRACE_2> line(final Line value) {
            this.line = value;
            return this;
        }

        public Builder<TRACE_2> colorbar(final ColorBar value) {
            this.colorbar = value;
            return this;
        }

        public Builder<TRACE_2> showlegend(final Boolean value) {
            this.showlegend = value;
            return this;
        }

        public Builder<TRACE_2> ncontours(final Integer value) {
            this.ncontours = value;
            return this;
        }

        public Builder<TRACE_2> ytype(final String value) {
            this.ytype = value;
            return this;
        }

        public Builder<TRACE_2> contours(final Contours value) {
            this.contours = value;
            return this;
        }

        public Builder<TRACE_2> xaxis(final Axis value) {
            this.xaxis = value;
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

        public Builder<TRACE_2> autocontour(final Boolean value) {
            this.autocontour = value;
            return this;
        }

        public Builder<TRACE_2> transpose(final Boolean value) {
            this.transpose = value;
            return this;
        }

        public Builder<TRACE_2> autocolorscale(final Boolean value) {
            this.autocolorscale = value;
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

        public Builder<TRACE_2> showscale(final Boolean value) {
            this.showscale = value;
            return this;
        }

        public Builder<TRACE_2> x0(final Object value) {
            this.x0 = value;
            return this;
        }

        public Builder<TRACE_2> zauto(final Boolean value) {
            this.zauto = value;
            return this;
        }

        public Builder<TRACE_2> name(final String value) {
            this.name = value;
            return this;
        }

        public Builder<TRACE_2> colorscale(final Map<Number,String> value) {
            this.colorscale = value;
            return this;
        }

        public Builder<TRACE_2> connectgaps(final Boolean value) {
            this.connectgaps = value;
            return this;
        }

        public Builder<TRACE_2> yaxis(final Axis value) {
            this.yaxis = value;
            return this;
        }

        public Builder<TRACE_2> reversescale(final Boolean value) {
            this.reversescale = value;
            return this;
        }

        private Builder<TRACE_2> y(final List<?> value) {
            this.y = value;
            return this;
        }

        private Builder<TRACE_2> x(final List<?> value) {
            this.x = value;
            return this;
        }

        private Builder<TRACE_2> z(final List<?> value) {
            this.z = value;
            return this;
        }

        public Contour<TRACE_2> build() {
            return new net.java.html.plotlyjs.Contour<>(this);
        }
    }

    public static <TRACE extends CartesianTrace>Contour.Builder<TRACE> builder() {
        return Builder.start();
    }

    private Contour(Builder<TRACE_T> builder) {
        this.type = "contour";
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
        this.line = builder.line;
        this.colorbar = builder.colorbar;
        this.showlegend = builder.showlegend;
        this.ncontours = builder.ncontours;
        this.ytype = builder.ytype;
        this.contours = builder.contours;
        this.xaxis = builder.xaxis;
        this.ysrc = builder.ysrc;
        this.opacity = builder.opacity;
        this.legendgroup = builder.legendgroup;
        this.autocontour = builder.autocontour;
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
        this.y = builder.y;
        this.x = builder.x;
        this.z = builder.z;
    }

}
