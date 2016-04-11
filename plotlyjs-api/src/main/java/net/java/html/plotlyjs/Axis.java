
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
        private String showexponent;
        private boolean showticklabels;
        private boolean autotick;
        private String showticksuffix;
        private Font titlefont;
        private String linecolor;
        private Object mirror;
        private int nticks;
        private int linewidth;
        private Object autorange;
        private String tickprefix;
        private int position;
        private String tickformat;
        private String tickmode;
        private String title;
        private String ticks;
        private String overlaying;
        private String rangemode;
        private String showtickprefix;
        private boolean zeroline;
        private List<Number> domain;
        private String gridcolor;
        private String type;
        private int zerolinewidth;
        private int ticklen;
        private String hoverformat;
        private String ticksuffix;
        private boolean fixedrange;
        private boolean showline;
        private List<String> ticktext;
        private boolean showgrid;
        private int tickvals[]; 
        private Font tickfont;
        private int tickwidth;
        private int tick0;
        private int tickangle;
        private int gridwidth;
        private int dtick ;
        private String side;
        private String zerolinecolor;
        private List<Number>range;
        private String anchor;
        private String exponentformat;
    
        
    static final class ShowModes{
        public static final String ALL = "all";
        public static final String FIRST = "first";
        public static final String LAST = "last";
        public static final String NONE = "none";
    }
    
    static final class MirrorModes{
        public static final Boolean TRUE = true;
        public static final String TICKS = "ticks";
        public static final Boolean FALSE = false;
        public static final String ALL = "all";
        public static final String ALLTICKS = "allticks";
    }
    
    static final class AutoRangeModes{
        public static final Boolean TRUE = true;
        public static final Boolean FALSE = false;
        public static final String REVERSED = "reversed";
    }
    
    static final class TickModes{
        public static final String AUTO = "auto";
        public static final String LINEAR = "linear";
        public static final String ARRAY = "array";
    }
    
    static final class Ticks{
        public static final String OUTSIDE = "outside";
        public static final String INSIDE = "inside";
        public static final String NONE = "";
    }
    
    static final class RangeMode{
        public static final String NORMAL = "normal";
        public static final String TOZERO = "tozero";
        public static final String NONNEGATIVE = "nonnegative";
        
    }
    
    static final class Types{
        public static final String INFER = "-";
        public static final String LINEAR = "linear";
        public static final String LOG = "log";
        public static final String DATE = "date";
        public static final String CATEGORY = "category";
    }
    
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
    
    public Axis(Builder builder){
        showexponent = builder.showexponent;
        showticklabels = builder.showticklabels;
        showticksuffix = builder.showticksuffix;
        autotick = builder.autotick;
        titlefont = builder.titlefont;
        linecolor = builder.linecolor;
        mirror = builder.mirror;
        nticks = builder.nticks;
        linewidth = builder.linewidth;
        autorange = builder.autorange;
        tickprefix = builder.tickprefix;
        position = builder.position;
        tickformat = builder.tickformat;
        tickmode = builder.tickmode;
        title = builder.title;
        ticks = builder.ticks;
        overlaying = builder.overlaying;
        rangemode = builder.rangemode;
        showtickprefix = builder.showtickprefix;
        zeroline = builder.zeroline;
        domain = builder.domain;
        gridcolor = builder.gridcolor;
        type = builder.type;
        zerolinewidth = builder.zerolinewidth;
        ticklen = builder.ticklen;
        hoverformat = builder.hoverformat;
        ticksuffix = builder.ticksuffix;
        fixedrange = builder.fixedrange;
        showline = builder.showline;
        ticktext = builder.ticktext;
        showgrid = builder.showgrid;
        tickvals = builder.tickvals;
        tickfont = builder.tickfont;
        tickwidth = builder.tickwidth;
        tick0 = builder.tick0;
        tickangle = builder.tickangle;
        gridwidth = builder.gridwidth;
        dtick = builder.dtick;
        side = builder.side;
        zerolinecolor = builder.zerolinecolor;
        range = builder.range;
        anchor = builder.anchor;
        exponentformat = builder.exponentformat;
    }
    
    public static class Builder{
        String showexponent;
        Boolean showticklabels = true;
        String showticksuffix;
        Font titlefont;
        String linecolor;
        Boolean autotick = true;
        Object mirror;
        int nticks = 0;
        int linewidth = 1;
        Object autorange = true;
        String tickprefix;
        int position = 0;
        String tickformat;
        String tickmode;
        String title;
        String ticks;
        String overlaying;
        String rangemode;
        String showtickprefix;
        boolean zeroline = true;
        List<java.lang.Number> domain;
        String gridcolor;
        String type = "-";
        int zerolinewidth = 1;
        int ticklen = 5;
        String hoverformat;
        String ticksuffix;
        boolean fixedrange = true;
        boolean showline = true;
        List<String> ticktext;
        boolean showgrid = false;
        int tickvals[]; 
        Font tickfont;
        int tickwidth = 1;
        int tick0;
        int tickangle;
        int gridwidth = 1;
        int dtick = 1;
        String side;
        String zerolinecolor;
        List<java.lang.Number>range;
        String anchor;
        String exponentformat;
        
        public Builder(){}

        public Builder showexponent(String showexponent) {
            this.showexponent = showexponent;
            return this;
        }

        public Builder showticklabels(boolean showticklabels) {
            this.showticklabels = showticklabels;
            return this;
        }

        public Builder showticksuffix(String showticksuffix) {
            this.showticksuffix = showticksuffix;
            return this;
        }

        public Builder titlefont(Font titlefont) {
            this.titlefont = titlefont;
            return this;
        }

        public Builder linecolor(String linecolor) {
            this.linecolor = linecolor;
            return this;
        }
        
        public Builder autotick(Boolean autotick){
            this.autotick = autotick;
            return this;
        }
        
        public Builder mirror(Object mirror) {
            if(mirror instanceof java.lang.String || mirror instanceof java.lang.Boolean){
            this.mirror = mirror;
            return this;
            }
            else{
                throw new IllegalArgumentException("mirror expects a String or boolean (enumerated: true | \"ticks\" | false | \"all\" | \"allticks\" )");
            }
        }

        public Builder nticks(int nticks) {
            this.nticks = nticks;
            return this;
        }

        public Builder linewidth(int linewidth) {
            this.linewidth = linewidth;
            return this;
        }

        public Builder autorange(boolean autorange) {
            this.autorange = autorange;
            return this;
        }

        public Builder tickprefix(String tickprefix) {
            this.tickprefix = tickprefix;
            return this;
        }

        public Builder position(int position) {
            this.position = position;
            return this;
        }

        public Builder tickformat(String tickformat) {
            this.tickformat = tickformat;
            return this;
        }

        public Builder tickmode(String tickmode) {
            this.tickmode = tickmode;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder ticks(String ticks) {
            this.ticks = ticks;
            return this;
        }

        public Builder overlaying(String overlaying) {
            this.overlaying = overlaying;
            return this;
        }

        public Builder rangemode(String rangemode) {
            this.rangemode = rangemode;
            return this;
        }

        public Builder showtickprefix(String showtickprefix) {
            this.showtickprefix = showtickprefix;
            return this;
        }

        public Builder zeroline(boolean zeroline) {
            this.zeroline = zeroline;
            return this;
        }

        public Builder domain(List<Number> domain) {
            this.domain = domain;
            return this;
        }

        public Builder gridcolor(String gridcolor) {
            this.gridcolor = gridcolor;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder zerolinewidth(int zerolinewidth) {
            this.zerolinewidth = zerolinewidth;
            return this;
        }

        public Builder ticklen(int ticklen) {
            this.ticklen = ticklen;
            return this;
        }

        public Builder hoverformat(String hoverformat) {
            this.hoverformat = hoverformat;
            return this;
        }

        public Builder ticksuffix(String ticksuffix) {
            this.ticksuffix = ticksuffix;
            return this;
        }

        public Builder fixedrange(boolean fixedrange) {
            this.fixedrange = fixedrange;
            return this;
        }

        public Builder showline(boolean showline) {
            this.showline = showline;
            return this;
        }

        public Builder ticktext(List<String> ticktext) {
            this.ticktext = ticktext;
            return this;
        }

        public Builder showgrid(boolean showgrid) {
            this.showgrid = showgrid;
            return this;
        }

        public Builder tickvals(int[] tickvals) {
            this.tickvals = tickvals;
            return this;
        }

        public Builder tickfont(Font tickfont) {
            this.tickfont = tickfont;
            return this;
        }

        public Builder tickwidth(int tickwidth) {
            this.tickwidth = tickwidth;
            return this;
        }

        public Builder tick0(int tick0) {
            this.tick0 = tick0;
            return this;
        }

        public Builder tickangle(int tickangle) {
            this.tickangle = tickangle;
            return this;
        }

        public Builder gridwidth(int gridwidth) {
            this.gridwidth = gridwidth;
            return this;
        }

        public Builder dtick(int dtick) {
            this.dtick = dtick;
            return this;
        }

        public Builder side(String side) {
            this.side = side;
            return this;
        }

        public Builder zerolinecolor(String zerolinecolor) {
            this.zerolinecolor = zerolinecolor;
            return this;
        }

        public Builder range(List<Number> range) {
            this.range = range;
            return this;
        }

        public Builder anchor(String anchor) {
            this.anchor = anchor;
            return this;
        }

        public Builder exponentformat(String exponentformat) {
            this.exponentformat = exponentformat;
            return this;
        }
        
        public Axis build(){
            return new Axis(this); 
        }   
    } 
}