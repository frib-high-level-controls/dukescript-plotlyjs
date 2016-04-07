/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.html.plotlyjs;

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
            return new net.java.html.plotlyjs.ColorBar(yanchor, showexponent, showticklabels, lenmode, showticksuffix, titlefont, borderwidth, tickvalssrc, nticks, titleside, outlinecolor, tickprefix, tickformat, tickmode, title, ticks, thickness, bgcolor, outlinewidth, ticktextsrc, bordercolor, xanchor, ticklen, len, ticksuffix, tickcolor, ticktext, xpad, tickvals, tickfont, tickwidth, tick0, tickangle, dtick, ypad, exponentformat, y, x, thicknessmode);
        }
    }

    public static ColorBar.Builder builder() {
        return new ColorBar.Builder();
    }

    private ColorBar(final String yanchor, final String showexponent, final Boolean showticklabels, final String lenmode, final String showticksuffix, final Font titlefont, final Integer borderwidth, final String tickvalssrc, final Integer nticks, final String titleside, final String outlinecolor, final String tickprefix, final String tickformat, final String tickmode, final String title, final String ticks, final Integer thickness, final String bgcolor, final Integer outlinewidth, final String ticktextsrc, final String bordercolor, final String xanchor, final Integer ticklen, final Integer len, final String ticksuffix, final String tickcolor, final List ticktext, final Integer xpad, final List tickvals, final Font tickfont, final Integer tickwidth, final Number tick0, final Integer tickangle, final Integer dtick, final Integer ypad, final String exponentformat, final Double y, final Double x, final String thicknessmode) {
        this.yanchor = yanchor;
        this.showexponent = showexponent;
        this.showticklabels = showticklabels;
        this.lenmode = lenmode;
        this.showticksuffix = showticksuffix;
        this.titlefont = titlefont;
        this.borderwidth = borderwidth;
        this.tickvalssrc = tickvalssrc;
        this.nticks = nticks;
        this.titleside = titleside;
        this.outlinecolor = outlinecolor;
        this.tickprefix = tickprefix;
        this.tickformat = tickformat;
        this.tickmode = tickmode;
        this.title = title;
        this.ticks = ticks;
        this.thickness = thickness;
        this.bgcolor = bgcolor;
        this.outlinewidth = outlinewidth;
        this.ticktextsrc = ticktextsrc;
        this.bordercolor = bordercolor;
        this.xanchor = xanchor;
        this.ticklen = ticklen;
        this.len = len;
        this.ticksuffix = ticksuffix;
        this.tickcolor = tickcolor;
        this.ticktext = ticktext;
        this.xpad = xpad;
        this.tickvals = tickvals;
        this.tickfont = tickfont;
        this.tickwidth = tickwidth;
        this.tick0 = tick0;
        this.tickangle = tickangle;
        this.dtick = dtick;
        this.ypad = ypad;
        this.exponentformat = exponentformat;
        this.y = y;
        this.x = x;
        this.thicknessmode = thicknessmode;
    }
    
    
    
    
}
