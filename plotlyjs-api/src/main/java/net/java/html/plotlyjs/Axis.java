/*
 * The MIT License
 *
 * Copyright 2016 MSU.
 *
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
 */
package net.java.html.plotlyjs;

/*
 * #%L
 * %%
 * Copyright (C) 2015 - 2016 MSU
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


import java.util.ArrayList;

/**
 *
 * @author daykin
 */

@SuppressWarnings("unused")
public class Axis {
        
        private final String showexponent;
        private final boolean showticklabels;
        private final String showticksuffix;
        private final Font titlefont;
        private final String linecolor;
        private final String mirror;
        private final int nticks;
        private final int linewidth;
        private final String autorange;
        private final String tickprefix;
        private final int position;
        private final String tickformat;
        private final String tickmode;
        private final String title;
        private final String ticks;
        private final String overlaying;
        private final String rangemode;
        private final String showtickprefix;
        private final boolean zeroline;
        private final ArrayList<Integer> domain;
        private final String gridcolor;
        private final String type;
        private final int zerolinewidth;
        private final int ticklen;
        private final String hoverformat;
        private final String ticksuffix;
        private final boolean fixedrange;
        private final boolean showline;
        private final ArrayList<String> ticktext;
        private final boolean showgrid;
        private final int tickvals[]; 
        private final Font tickfont;
        private final int tickwidth;
        private final int tick0;
        private final int tickangle;
        private final int gridwidth;
        private final int dtick ;
        private final String side;
        private final String zerolinecolor;
        private final ArrayList<Integer>range;
        private final String anchor;
        private final String exponentformat;
    
        
    static final class ShowModes{
        public static final String ALL = "all";
        public static final String FIRST = "first";
        public static final String LAST = "last";
        public static final String NONE = "none";
    }
    
    static final class MirrorModes{
        public static final String TRUE = "true";
        public static final String TICKS = "ticks";
        public static final String FALSE = "false";
        public static final String ALL = "all";
        public static final String ALLTICKS = "allticks";
    }
    
    static final class AutoRangeModes{
        public static final String TRUE = "true";
        public static final String FALSE = "false";
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
    
    public Axis(AxisBuilder builder){
        showexponent = builder.showexponent;
        showticklabels = builder.showticklabels;
        showticksuffix = builder.showticksuffix;
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
        tickwidth =builder.tickwidth;
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
    
    public static class AxisBuilder{
        String showexponent = ShowModes.ALL;
        boolean showticklabels = true;
        String showticksuffix = ShowModes.ALL;
        Font titlefont = new Font.FontBuilder().build();
        String linecolor;
        String mirror = MirrorModes.FALSE;
        int nticks = 0;
        int linewidth = 1;
        String autorange = "true";
        String tickprefix = "";
        int position = 0;
        String tickformat = "";
        String tickmode = "auto";
        String title = "Axis Title";
        String ticks = Ticks.OUTSIDE;
        String overlaying = "free";
        String rangemode = "normal";
        String showtickprefix = "all";
        boolean zeroline = true;
        ArrayList<Integer> domain = new ArrayList<Integer>(){{
            add(0);
            add(10);
        }};
        String gridcolor = "#eee";
        String type = "-";
        int zerolinewidth = 1;
        int ticklen = 5;
        String hoverformat = "";
        String ticksuffix = "";
        boolean fixedrange = false;
        boolean showline = true;
        ArrayList<String> ticktext = new ArrayList<>();
        boolean showgrid = false;
        int tickvals[]; 
        Font tickfont = new Font.FontBuilder().build();
        int tickwidth = 1;
        int tick0 = 0;
        int tickangle = -90;
        int gridwidth = 1;
        int dtick = 1;
        String side;
        String zerolinecolor = "#444";
        ArrayList<Integer>range = new ArrayList<Integer>(){{add(0);add(10);}};
        String anchor = "free";
        String exponentformat = ExponentFormats.B;
        
        public AxisBuilder(){}

        public AxisBuilder showexponent(String showexponent) {
            this.showexponent = showexponent;
            return this;
        }

        public AxisBuilder showticklabels(boolean showticklabels) {
            this.showticklabels = showticklabels;
            return this;
        }

        public AxisBuilder showticksuffix(String showticksuffix) {
            this.showticksuffix = showticksuffix;
            return this;
        }

        public AxisBuilder titlefont(Font titlefont) {
            this.titlefont = titlefont;
            return this;
        }

        public AxisBuilder linecolor(String linecolor) {
            this.linecolor = linecolor;
            return this;
        }

        public AxisBuilder mirror(String mirror) {
            this.mirror = mirror;
            return this;
        }

        public AxisBuilder nticks(int nticks) {
            this.nticks = nticks;
            return this;
        }

        public AxisBuilder linewidth(int linewidth) {
            this.linewidth = linewidth;
            return this;
        }

        public AxisBuilder autorange(String autorange) {
            this.autorange = autorange;
            return this;
        }

        public AxisBuilder tickprefix(String tickprefix) {
            this.tickprefix = tickprefix;
            return this;
        }

        public AxisBuilder position(int position) {
            this.position = position;
            return this;
        }

        public AxisBuilder tickformat(String tickformat) {
            this.tickformat = tickformat;
            return this;
        }

        public AxisBuilder tickmode(String tickmode) {
            this.tickmode = tickmode;
            return this;
        }

        public AxisBuilder title(String title) {
            this.title = title;
            return this;
        }

        public AxisBuilder ticks(String ticks) {
            this.ticks = ticks;
            return this;
        }

        public AxisBuilder overlaying(String overlaying) {
            this.overlaying = overlaying;
            return this;
        }

        public AxisBuilder rangemode(String rangemode) {
            this.rangemode = rangemode;
            return this;
        }

        public AxisBuilder showtickprefix(String showtickprefix) {
            this.showtickprefix = showtickprefix;
            return this;
        }

        public AxisBuilder zeroline(boolean zeroline) {
            this.zeroline = zeroline;
            return this;
        }

        public AxisBuilder domain(ArrayList<Integer> domain) {
            this.domain = domain;
            return this;
        }

        public AxisBuilder gridcolor(String gridcolor) {
            this.gridcolor = gridcolor;
            return this;
        }

        public AxisBuilder type(String type) {
            this.type = type;
            return this;
        }

        public AxisBuilder zerolinewidth(int zerolinewidth) {
            this.zerolinewidth = zerolinewidth;
            return this;
        }

        public AxisBuilder ticklen(int ticklen) {
            this.ticklen = ticklen;
            return this;
        }

        public AxisBuilder hoverformat(String hoverformat) {
            this.hoverformat = hoverformat;
            return this;
        }

        public AxisBuilder ticksuffix(String ticksuffix) {
            this.ticksuffix = ticksuffix;
            return this;
        }

        public AxisBuilder fixedrange(boolean fixedrange) {
            this.fixedrange = fixedrange;
            return this;
        }

        public AxisBuilder showline(boolean showline) {
            this.showline = showline;
            return this;
        }

        public AxisBuilder ticktext(ArrayList<String> ticktext) {
            this.ticktext = ticktext;
            return this;
        }

        public AxisBuilder showgrid(boolean showgrid) {
            this.showgrid = showgrid;
            return this;
        }

        public AxisBuilder tickvals(int[] tickvals) {
            this.tickvals = tickvals;
            return this;
        }

        public AxisBuilder tickfont(Font tickfont) {
            this.tickfont = tickfont;
            return this;
        }

        public AxisBuilder tickwidth(int tickwidth) {
            this.tickwidth = tickwidth;
            return this;
        }

        public AxisBuilder tick0(int tick0) {
            this.tick0 = tick0;
            return this;
        }

        public AxisBuilder tickangle(int tickangle) {
            this.tickangle = tickangle;
            return this;
        }

        public AxisBuilder gridwidth(int gridwidth) {
            this.gridwidth = gridwidth;
            return this;
        }

        public AxisBuilder dtick(int dtick) {
            this.dtick = dtick;
            return this;
        }

        public AxisBuilder side(String side) {
            this.side = side;
            return this;
        }

        public AxisBuilder zerolinecolor(String zerolinecolor) {
            this.zerolinecolor = zerolinecolor;
            return this;
        }

        public AxisBuilder range(ArrayList<Integer> range) {
            this.range = range;
            return this;
        }

        public AxisBuilder anchor(String anchor) {
            this.anchor = anchor;
            return this;
        }

        public AxisBuilder exponentformat(String exponentformat) {
            this.exponentformat = exponentformat;
            return this;
        }
        
        public Axis build(){
            return new Axis(this); 
        }   
    } 
}
