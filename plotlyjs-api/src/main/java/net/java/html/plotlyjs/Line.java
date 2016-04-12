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


import java.util.Map;

/**
 *
 * @author daykin
 */
public class Line {
    
    public static final class Shapes{
        public static final String LINEAR = "linear";
	public static final String SPLINE = "spline";
	public static final String HV = "hv";
	public static final String VH = "vh";
	public static final String HVH = "hvh";
	public static final String VHV = "vhv";
    }
    
    private String colorsrc;
    private Boolean autocolorscale;
    private Number cmin;
    private Map<Integer,String> colorscale;
    private String color;
    private Number smoothing;
    private String dash;
    private String shape;
    private Boolean reversescale;
    private Integer width;
    private Boolean cauto;
    private String widthsrc;
    private Number cmax;

    public static class Builder {

        private String colorsrc;
        private Boolean autocolorscale;
        private Number cmin;
        private Map<Integer,String> colorscale;
        private String color;
        private Boolean reversescale;
        private Integer width;
        private Boolean cauto;
        private String widthsrc;
        private Number cmax;

        private Builder() {
        }

        public Builder colorsrc(final String value) {
            this.colorsrc = value;
            return this;
        }

        public Builder autocolorscale(final Boolean value) {
            this.autocolorscale = value;
            return this;
        }

        public Builder cmin(final Number value) {
            this.cmin = value;
            return this;
        }

        public Builder colorscale(final Map<Integer,String> value) {
            this.colorscale = value;
            return this;
        }

        public Builder color(final String value) {
            this.color = value;
            return this;
        }

        public Builder reversescale(final Boolean value) {
            this.reversescale = value;
            return this;
        }

        public Builder width(final Integer value) {
            this.width = value;
            return this;
        }

        public Builder cauto(final Boolean value) {
            this.cauto = value;
            return this;
        }

        public Builder widthsrc(final String value) {
            this.widthsrc = value;
            return this;
        }

        public Builder cmax(final Number value) {
            this.cmax = value;
            return this;
        }

        public Line build() {
            return new net.java.html.plotlyjs.Line(this);
        }
    }

    public static Line.Builder builder() {
        return new Line.Builder();
    }

    private Line(Builder builder) {
        this.colorsrc = builder.colorsrc;
        this.autocolorscale = builder.autocolorscale;
        this.cmin = builder.cmin;
        this.colorscale = builder.colorscale;
        this.color = builder.color;
        this.reversescale = builder.reversescale;
        this.width = builder.width;
        this.cauto = builder.cauto;
        this.widthsrc = builder.widthsrc;
        this.cmax = builder.cmax;
    }
}
