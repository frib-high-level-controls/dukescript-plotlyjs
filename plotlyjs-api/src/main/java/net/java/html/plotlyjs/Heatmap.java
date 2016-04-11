/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.html.plotlyjs;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

/**
 *
 * @author daykin
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Heatmap extends Chart{
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
            return new net.java.html.plotlyjs.Heatmap(type, x, y, zmax, xtype, stream, zsrc, text, zmin, hoverinfo, xsrc, visible, y0, colorbar, showlegend, ytype, xaxis, ysrc, zsmooth, opacity, legendgroup, transpose, autocolorscale, textsrc, dx, dy, showscale, x0, zauto, name, colorscale, connectgaps, yaxis, reversescale, z);
        }
    }

    public static Heatmap.Builder builder() {
        return new Heatmap.Builder();
    }

    private Heatmap(final String type, final List x, final List y, final Number zmax, final String xtype, final Stream stream, final String zsrc, final List text, final Number zmin, final String hoverinfo, final String xsrc, final Object visible, final Number y0, final ColorBar colorbar, final Boolean showlegend, final String ytype, final Axis xaxis, final String ysrc, final Object zsmooth, final Number opacity, final String legendgroup, final Boolean transpose, final Boolean autocolorscale, final String textsrc, final Number dx, final Number dy, final Boolean showscale, final Number x0, final Boolean zauto, final String name, final Map colorscale, final Boolean connectgaps, final Axis yaxis, final Boolean reversescale, final List z) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.zmax = zmax;
        this.xtype = xtype;
        this.stream = stream;
        this.zsrc = zsrc;
        this.text = text;
        this.zmin = zmin;
        this.hoverinfo = hoverinfo;
        this.xsrc = xsrc;
        this.visible = visible;
        this.y0 = y0;
        this.colorbar = colorbar;
        this.showlegend = showlegend;
        this.ytype = ytype;
        this.xaxis = xaxis;
        this.ysrc = ysrc;
        this.zsmooth = zsmooth;
        this.opacity = opacity;
        this.legendgroup = legendgroup;
        this.transpose = transpose;
        this.autocolorscale = autocolorscale;
        this.textsrc = textsrc;
        this.dx = dx;
        this.dy = dy;
        this.showscale = showscale;
        this.x0 = x0;
        this.zauto = zauto;
        this.name = name;
        this.colorscale = colorscale;
        this.connectgaps = connectgaps;
        this.yaxis = yaxis;
        this.reversescale = reversescale;
        this.z = z;
    }
    
    
}
