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
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

/**
 *
 * @author daykin
 */
@JsonInclude(Include.NON_NULL)
public class Scatter3d extends Chart{
    public final String textposition;
    public final Projection projection;
    public final Stream stream;
    public final Object zsrc;
    public final String text;
    public final Object scene;
    public final Object xsrc;
    public final Object visible;
    public final Scatter3dMarker marker;
    public final Boolean showlegend;
    public final ErrorBar error_x;
    public final ErrorBar error_y;
    public final ErrorBar error_z;
    public final String surfacecolor;
    public final Object ysrc;    
    public final Number opacity;
    public final Font textfont;
    public final String legendgroup;
    public final Object textpositionsrc;
    public final Object textsrc;
    public final String hoverinfo;
    public final Line line;
    public final String name;
    public final Boolean connectgaps;
    public final String mode;
    public final String surfaceaxis;
    public final List z;

    public static class Builder {

        private List x;
        private List y;
        private String textposition;
        private Projection projection;
        private Stream stream;
        private Object zsrc;
        private String text;
        private Object scene;
        private Object xsrc;
        private Object visible;
        private Scatter3dMarker marker;
        private Boolean showlegend;
        private ErrorBar error_x;
        private ErrorBar error_y;
        private ErrorBar error_z;
        private String surfacecolor;
        private Object ysrc;
        private Number opacity;
        private Font textfont;
        private String legendgroup;
        private Object textpositionsrc;
        private Object textsrc;
        private String hoverinfo;
        private Line line;
        private String name;
        private Boolean connectgaps;
        private String mode;
        private String surfaceaxis;
        private List z;

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

        public Builder textposition(final String value) {
            this.textposition = value;
            return this;
        }

        public Builder projection(final Projection value) {
            this.projection = value;
            return this;
        }

        public Builder stream(final Stream value) {
            this.stream = value;
            return this;
        }

        public Builder zsrc(final Object value) {
            this.zsrc = value;
            return this;
        }

        public Builder text(final String value) {
            this.text = value;
            return this;
        }

        public Builder scene(final Object value) {
            this.scene = value;
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

        public Builder marker(final Scatter3dMarker value) {
            this.marker = value;
            return this;
        }

        public Builder showlegend(final Boolean value) {
            this.showlegend = value;
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

        public Builder error_z(final ErrorBar value) {
            this.error_z = value;
            return this;
        }

        public Builder surfacecolor(final String value) {
            this.surfacecolor = value;
            return this;
        }

        public Builder ysrc(final Object value) {
            this.ysrc = value;
            return this;
        }

        public Builder opacity(final Number value) {
            this.opacity = value;
            return this;
        }

        public Builder textfont(final Font value) {
            this.textfont = value;
            return this;
        }

        public Builder legendgroup(final String value) {
            this.legendgroup = value;
            return this;
        }

        public Builder textpositionsrc(final Object value) {
            this.textpositionsrc = value;
            return this;
        }

        public Builder textsrc(final Object value) {
            this.textsrc = value;
            return this;
        }

        public Builder hoverinfo(final String value) {
            this.hoverinfo = value;
            return this;
        }

        public Builder line(final Line value) {
            this.line = value;
            return this;
        }

        public Builder name(final String value) {
            this.name = value;
            return this;
        }

        public Builder connectgaps(final Boolean value) {
            this.connectgaps = value;
            return this;
        }

        public Builder mode(final String value) {
            this.mode = value;
            return this;
        }

        public Builder surfaceaxis(final String value) {
            this.surfaceaxis = value;
            return this;
        }

        public Builder z(final List value) {
            this.z = value;
            return this;
        }

        public Scatter3d build() {
            return new net.java.html.plotlyjs.Scatter3d(this);
        }
    }

    public static Scatter3d.Builder builder() {
        return new Scatter3d.Builder();
    }

    private Scatter3d(Builder builder) {
        this.type = "scatter3d";
        this.x = builder.x;
        this.y = builder.y;
        this.textposition = builder.textposition;
        this.projection = builder.projection;
        this.stream = builder.stream;
        this.zsrc = builder.zsrc;
        this.text = builder.text;
        this.scene = builder.scene;
        this.xsrc = builder.xsrc;
        this.visible = builder.visible;
        this.marker = builder.marker;
        this.showlegend = builder.showlegend;
        this.error_x = builder.error_x;
        this.error_y = builder.error_y;
        this.error_z = builder.error_z;
        this.surfacecolor = builder.surfacecolor;
        this.ysrc = builder.ysrc;
        this.opacity = builder.opacity;
        this.textfont = builder.textfont;
        this.legendgroup = builder.legendgroup;
        this.textpositionsrc = builder.textpositionsrc;
        this.textsrc = builder.textsrc;
        this.hoverinfo = builder.hoverinfo;
        this.line = builder.line;
        this.name = builder.name;
        this.connectgaps = builder.connectgaps;
        this.mode = builder.mode;
        this.surfaceaxis = builder.surfaceaxis;
        this.z = builder.z;
    }

}
