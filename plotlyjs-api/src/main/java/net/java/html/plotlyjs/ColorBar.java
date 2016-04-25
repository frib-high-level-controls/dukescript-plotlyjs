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


import java.util.List;

/**
 *
 * @author daykin
 */
public class ColorBar {
    
    public static final class Positions{
        public static final String RIGHT = "right";
        public static final String TOP = "top";
        public static final String MIDDLE = "middle";
        public static final String CENTER = "center";
        public static final String BOTTOM = "bottom";
    }
    
    public static final class TickSettings{
        public static final String ALL = "all";
        public static final String FIRST = "first";
        public static final String LAST = "last";
        public static final String NONE = "none";
    }
    
    public static final class LenModes{
        public static final String FRACTION = "fraction";
        public static final String PIXELS = "pixels";
    }
    
    public static final class Ticks{
        public static final String OUTSIDE = "outside";
	public static final String INSIDE = "inside";
        public static final String NONE = "";
    }
    
    public static final class ExponentModes{
        public static final String NONE = "none";
	public static final String E_LOWER = "e";
	public static final String E_UPPER = "E";
	public static final String POWER = "power";
	public static final String SI = "SI";
	public static final String B = "B";
    }
    
    public static final class ThicknessModes{
        public static final String FRACTION = "fraction";
        public static final String PIXELS = "pixels";
    }
    
    private String yanchor;
    private String showexponent;
    private Boolean showticklabels;
    private String lenmode;
    private String showticksuffix;
    private Font titlefont;
    private Integer borderwidth;
    private String tickvalssrc;
    private Integer nticks;
    private String titleside;
    private String outlinecolor;
    private String tickprefix;
    private String tickformat;
    private String tickmode;
    private String title;
    private String ticks;
    private Integer thickness;
    private String bgcolor;
    private Integer outlinewidth;
    private String ticktextsrc;
    private String bordercolor;
    private String xanchor;
    private Integer ticklen;
    private Integer len;
    private String ticksuffix;
    private String tickcolor;
    private List ticktext;
    private Integer xpad;
    private List tickvals;
    private Font tickfont;
    private Integer tickwidth;
    private Number tick0;
    private Integer tickangle;
    private Integer dtick;
    private Integer ypad;
    private String exponentformat;
    private Double y;
    private Double x;
    private String thicknessmode;

    public static class Builder {

        private String yanchor;
        private String showexponent;
        private Boolean showticklabels;
        private String lenmode;
        private String showticksuffix;
        private Font titlefont;
        private Integer borderwidth;
        private String tickvalssrc;
        private Integer nticks;
        private String titleside;
        private String outlinecolor;
        private String tickprefix;
        private String tickformat;
        private String tickmode;
        private String title;
        private String ticks;
        private Integer thickness = 30;
        private String bgcolor;
        private Integer outlinewidth = 1;
        private String ticktextsrc;
        private String bordercolor;
        private String xanchor;
        private Integer ticklen;
        private Integer len = 1;
        private String ticksuffix;
        private String tickcolor;
        private List ticktext;
        private Integer xpad = 10;
        private List tickvals;
        private Font tickfont;
        private Integer tickwidth = 1;
        private Number tick0;
        private Integer tickangle;
        private Integer dtick = 1;
        private Integer ypad = 10;
        private String exponentformat;
        private Double y = 0.5;
        private Double x = 1.;
        private String thicknessmode;

        private Builder() {
        }

        public Builder yanchor(final String value) {
            this.yanchor = value;
            return this;
        }

        public Builder showexponent(final String value) {
            this.showexponent = value;
            return this;
        }

        public Builder showticklabels(final Boolean value) {
            this.showticklabels = value;
            return this;
        }

        public Builder lenmode(final String value) {
            this.lenmode = value;
            return this;
        }

        public Builder showticksuffix(final String value) {
            this.showticksuffix = value;
            return this;
        }

        public Builder titlefont(final Font value) {
            this.titlefont = value;
            return this;
        }

        public Builder borderwidth(final Integer value) {
            this.borderwidth = value;
            return this;
        }

        public Builder tickvalssrc(final String value) {
            this.tickvalssrc = value;
            return this;
        }

        public Builder nticks(final Integer value) {
            this.nticks = value;
            return this;
        }

        public Builder titleside(final String value) {
            this.titleside = value;
            return this;
        }

        public Builder outlinecolor(final String value) {
            this.outlinecolor = value;
            return this;
        }

        public Builder tickprefix(final String value) {
            this.tickprefix = value;
            return this;
        }

        public Builder tickformat(final String value) {
            this.tickformat = value;
            return this;
        }

        public Builder tickmode(final String value) {
            this.tickmode = value;
            return this;
        }

        public Builder title(final String value) {
            this.title = value;
            return this;
        }

        public Builder ticks(final String value) {
            this.ticks = value;
            return this;
        }

        public Builder thickness(final Integer value) {
            this.thickness = value;
            return this;
        }

        public Builder bgcolor(final String value) {
            this.bgcolor = value;
            return this;
        }

        public Builder outlinewidth(final Integer value) {
            this.outlinewidth = value;
            return this;
        }

        public Builder ticktextsrc(final String value) {
            this.ticktextsrc = value;
            return this;
        }

        public Builder bordercolor(final String value) {
            this.bordercolor = value;
            return this;
        }

        public Builder xanchor(final String value) {
            this.xanchor = value;
            return this;
        }

        public Builder ticklen(final Integer value) {
            this.ticklen = value;
            return this;
        }

        public Builder len(final Integer value) {
            this.len = value;
            return this;
        }

        public Builder ticksuffix(final String value) {
            this.ticksuffix = value;
            return this;
        }

        public Builder tickcolor(final String value) {
            this.tickcolor = value;
            return this;
        }

        public Builder ticktext(final List value) {
            this.ticktext = value;
            return this;
        }

        public Builder xpad(final Integer value) {
            this.xpad = value;
            return this;
        }

        public Builder tickvals(final List value) {
            this.tickvals = value;
            return this;
        }

        public Builder tickfont(final Font value) {
            this.tickfont = value;
            return this;
        }

        public Builder tickwidth(final Integer value) {
            this.tickwidth = value;
            return this;
        }

        public Builder tick0(final Number value) {
            this.tick0 = value;
            return this;
        }

        public Builder tickangle(final Integer value) {
            this.tickangle = value;
            return this;
        }

        public Builder dtick(final Integer value) {
            this.dtick = value;
            return this;
        }

        public Builder ypad(final Integer value) {
            this.ypad = value;
            return this;
        }

        public Builder exponentformat(final String value) {
            this.exponentformat = value;
            return this;
        }

        public Builder y(final Double value) {
            this.y = value;
            return this;
        }

        public Builder x(final Double value) {
            this.x = value;
            return this;
        }

        public Builder thicknessmode(final String value) {
            this.thicknessmode = value;
            return this;
        }

        public ColorBar build() {
            return new net.java.html.plotlyjs.ColorBar(this);
        }
    }

    public static ColorBar.Builder builder() {
        return new ColorBar.Builder();
    }

    private ColorBar(Builder builder) {
        this.yanchor = builder.yanchor;
        this.showexponent = builder.showexponent;
        this.showticklabels = builder.showticklabels;
        this.lenmode = builder.lenmode;
        this.showticksuffix = builder.showticksuffix;
        this.titlefont = builder.titlefont;
        this.borderwidth = builder.borderwidth;
        this.tickvalssrc = builder.tickvalssrc;
        this.nticks = builder.nticks;
        this.titleside = builder.titleside;
        this.outlinecolor = builder.outlinecolor;
        this.tickprefix = builder.tickprefix;
        this.tickformat = builder.tickformat;
        this.tickmode = builder.tickmode;
        this.title = builder.title;
        this.ticks = builder.ticks;
        this.thickness = builder.thickness;
        this.bgcolor = builder.bgcolor;
        this.outlinewidth = builder.outlinewidth;
        this.ticktextsrc = builder.ticktextsrc;
        this.bordercolor = builder.bordercolor;
        this.xanchor = builder.xanchor;
        this.ticklen = builder.ticklen;
        this.len = builder.len;
        this.ticksuffix = builder.ticksuffix;
        this.tickcolor = builder.tickcolor;
        this.ticktext = builder.ticktext;
        this.xpad = builder.xpad;
        this.tickvals = builder.tickvals;
        this.tickfont = builder.tickfont;
        this.tickwidth = builder.tickwidth;
        this.tick0 = builder.tick0;
        this.tickangle = builder.tickangle;
        this.dtick = builder.dtick;
        this.ypad = builder.ypad;
        this.exponentformat = builder.exponentformat;
        this.y = builder.y;
        this.x = builder.x;
        this.thicknessmode = builder.thicknessmode;
    }
    
    
    
    
}
