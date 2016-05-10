
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
 * Class representing an axis for use with {@link Layout}s. 
 * Use {@link Axis.Builder} to construct an axis,
 * or ignore to use plotly defaults.
 * @author daykin
 */
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("unused")
public class Axis {        
        private final String showexponent;
        private final Boolean showticklabels;
        private final Boolean autotick;
        private final String showticksuffix;
        private final Font titlefont;
        private final String linecolor;
        private final Object mirror;
        private final Integer nticks;
        private final Number linewidth;
        private final Object autorange;
        private final String tickprefix;
        private final Number position;
        private final String tickformat;
        private final String tickmode;
        private final String title;
        private final String ticks;
        private final String overlaying;
        private final String rangemode;
        private final String showtickprefix;
        private final Boolean zeroline;
        private final List<Number> domain;
        private final String gridcolor;
        private final String type;
        private final Number zerolinewidth;
        private final Number ticklen;
        private final String hoverformat;
        private final String ticksuffix;
        private final Boolean fixedrange;
        private final Boolean showline;
        private final List<String> ticktext;
        private final Boolean showgrid;
        private final List tickvals; 
        private final Font tickfont;
        private final Number tickwidth;
        private final Number tick0;
        private final Number tickangle;
        private final Number gridwidth;
        private final Number dtick ;
        private final String side;
        private final String zerolinecolor;
        private final List<Number>range;
        private final String anchor;
        private final String exponentformat;
    
    /*
        Number of exponents to show
    */    
    static final class ShowModes{
        public static final String ALL = "all";
        public static final String FIRST = "first";
        public static final String LAST = "last";
        public static final String NONE = "none";
    }
    
    /*
        Enumerate options for mirroring to other side of chart
    */
    static final class MirrorModes{
        public static final Boolean TRUE = true;
        public static final String TICKS = "ticks";
        public static final Boolean FALSE = false;
        public static final String ALL = "all";
        public static final String ALLTICKS = "allticks";
    }
    
    /*
        Very easy way to set the range of an axis
    */
    static final class AutoRangeModes{
        public static final Boolean TRUE = true;
        public static final Boolean FALSE = false;
        public static final String REVERSED = "reversed";
    }
    
    /*
        Enumerate whether ticks are automatic, linear, or set according to a
        Respective array(in turn)
    */
    static final class TickModes{
        public static final String AUTO = "auto";
        public static final String LINEAR = "linear";
        public static final String ARRAY = "array";
    }
    
    /*
        Get whether or not ticks are to be drawn, and if so, where relative to axis lines
    */
    static final class Ticks{
        public static final String OUTSIDE = "outside";
        public static final String INSIDE = "inside";
        public static final String NONE = "";
    }
    
    /*
        Out to extrema of input data, force extend to zero, or force
        Non-negative
    */
    static final class RangeMode{
        public static final String NORMAL = "normal";
        public static final String TOZERO = "tozero";
        public static final String NONNEGATIVE = "nonnegative";
        
    }
    
    /*
        No type specified/dash -> infer scale from data, or force linear/log/date/category scaling  
    */
    static final class Types{
        public static final String INFER = "-";
        public static final String LINEAR = "linear";
        public static final String LOG = "log";
        public static final String DATE = "date";
        public static final String CATEGORY = "category";
    }
    
    /*
        All sides as defined in js documentation; used for borders, positioning, etc.
    */
    static final class Sides {
        public static final String TOP = "top";
        public static final String BOTTOM = "bottom";
        public static final String LEFT = "left";
        public static final String RIGHT = "right";   
    }
    
    static final class ExponentFormats {
        public static final String NONE = "none";
        public static final String LOWER_E = "e";
        public static final String UPPER_E = "E";
        public static final String POWER = "power";
        public static final String SI = "SI";
        public static final String B = "B";
    }

    public static class Builder {

        private String showexponent;
        private Boolean showticklabels;
        private Boolean autotick;
        private String showticksuffix;
        private Font titlefont;
        private String linecolor;
        private Object mirror;
        private Integer nticks;
        private Number linewidth;
        private Object autorange;
        private String tickprefix;
        private Number position;
        private String tickformat;
        private String tickmode;
        private String title;
        private String ticks;
        private String overlaying;
        private String rangemode;
        private String showtickprefix;
        private Boolean zeroline;
        private List<Number> domain;
        private String gridcolor;
        private String type;
        private Number zerolinewidth;
        private Number ticklen;
        private String hoverformat;
        private String ticksuffix;
        private Boolean fixedrange;
        private Boolean showline;
        private List<String> ticktext;
        private Boolean showgrid;
        private List tickvals;
        private Font tickfont;
        private Number tickwidth;
        private Number tick0;
        private Number tickangle;
        private Number gridwidth;
        private Number dtick;
        private String side;
        private String zerolinecolor;
        private List<Number> range;
        private String anchor;
        private String exponentformat;

        public Builder() {
        }

        public Builder showexponent(final String value) {
            this.showexponent = value;
            return this;
        }

        public Builder showticklabels(final Boolean value) {
            this.showticklabels = value;
            return this;
        }

        public Builder autotick(final Boolean value) {
            this.autotick = value;
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

        public Builder linecolor(final String value) {
            this.linecolor = value;
            return this;
        }

        public Builder mirror(final Object value) {
            this.mirror = value;
            return this;
        }

        public Builder nticks(final Integer value) {
            this.nticks = value;
            return this;
        }

        public Builder linewidth(final Number value) {
            this.linewidth = value;
            return this;
        }

        public Builder autorange(final Object value) {
            this.autorange = value;
            return this;
        }

        public Builder tickprefix(final String value) {
            this.tickprefix = value;
            return this;
        }

        public Builder position(final Number value) {
            this.position = value;
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

        public Builder overlaying(final String value) {
            this.overlaying = value;
            return this;
        }

        public Builder rangemode(final String value) {
            this.rangemode = value;
            return this;
        }

        public Builder showtickprefix(final String value) {
            this.showtickprefix = value;
            return this;
        }

        public Builder zeroline(final Boolean value) {
            this.zeroline = value;
            return this;
        }

        public Builder domain(final List<Number> value) {
            this.domain = value;
            return this;
        }

        public Builder gridcolor(final String value) {
            this.gridcolor = value;
            return this;
        }

        public Builder type(final String value) {
            this.type = value;
            return this;
        }

        public Builder zerolinewidth(final Number value) {
            this.zerolinewidth = value;
            return this;
        }

        public Builder ticklen(final Number value) {
            this.ticklen = value;
            return this;
        }

        public Builder hoverformat(final String value) {
            this.hoverformat = value;
            return this;
        }

        public Builder ticksuffix(final String value) {
            this.ticksuffix = value;
            return this;
        }

        public Builder fixedrange(final Boolean value) {
            this.fixedrange = value;
            return this;
        }

        public Builder showline(final Boolean value) {
            this.showline = value;
            return this;
        }

        public Builder ticktext(final List<String> value) {
            this.ticktext = value;
            return this;
        }

        public Builder showgrid(final Boolean value) {
            this.showgrid = value;
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

        public Builder tickwidth(final Number value) {
            this.tickwidth = value;
            return this;
        }

        public Builder tick0(final Number value) {
            this.tick0 = value;
            return this;
        }

        public Builder tickangle(final Number value) {
            this.tickangle = value;
            return this;
        }

        public Builder gridwidth(final Number value) {
            this.gridwidth = value;
            return this;
        }

        public Builder dtick(final Number value) {
            this.dtick = value;
            return this;
        }

        public Builder side(final String value) {
            this.side = value;
            return this;
        }

        public Builder zerolinecolor(final String value) {
            this.zerolinecolor = value;
            return this;
        }

        public Builder range(final List<Number> value) {
            this.range = value;
            return this;
        }

        public Builder anchor(final String value) {
            this.anchor = value;
            return this;
        }

        public Builder exponentformat(final String value) {
            this.exponentformat = value;
            return this;
        }

        public Axis build() {
            return new net.java.html.plotlyjs.Axis(this);
        }
    }

    public static Axis.Builder builder() {
        return new Axis.Builder();
    }

    private Axis(Builder builder) {
        this.showexponent = builder.showexponent;
        this.showticklabels = builder.showticklabels;
        this.autotick = builder.autotick;
        this.showticksuffix = builder.showticksuffix;
        this.titlefont = builder.titlefont;
        this.linecolor = builder.linecolor;
        this.mirror = builder.mirror;
        this.nticks = builder.nticks;
        this.linewidth = builder.linewidth;
        this.autorange = builder.autorange;
        this.tickprefix = builder.tickprefix;
        this.position = builder.position;
        this.tickformat = builder.tickformat;
        this.tickmode = builder.tickmode;
        this.title = builder.title;
        this.ticks = builder.ticks;
        this.overlaying = builder.overlaying;
        this.rangemode = builder.rangemode;
        this.showtickprefix = builder.showtickprefix;
        this.zeroline = builder.zeroline;
        this.domain = builder.domain;
        this.gridcolor = builder.gridcolor;
        this.type = builder.type;
        this.zerolinewidth = builder.zerolinewidth;
        this.ticklen = builder.ticklen;
        this.hoverformat = builder.hoverformat;
        this.ticksuffix = builder.ticksuffix;
        this.fixedrange = builder.fixedrange;
        this.showline = builder.showline;
        this.ticktext = builder.ticktext;
        this.showgrid = builder.showgrid;
        this.tickvals = builder.tickvals;
        this.tickfont = builder.tickfont;
        this.tickwidth = builder.tickwidth;
        this.tick0 = builder.tick0;
        this.tickangle = builder.tickangle;
        this.gridwidth = builder.gridwidth;
        this.dtick = builder.dtick;
        this.side = builder.side;
        this.zerolinecolor = builder.zerolinecolor;
        this.range = builder.range;
        this.anchor = builder.anchor;
        this.exponentformat = builder.exponentformat;
    }
    

}