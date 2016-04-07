/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.html.plotlyjs;

import java.util.Map;

/**
 *
 * @author daykin
 */
public class HistogramMarker extends Marker{

    public static class Builder {

        private Boolean autocolorscale;
        private Number cmax;
        private Number cmin;
        private Map<Integer,String> colorscale;
        private String color;
        private Boolean reversescale;
        private Boolean cauto;
        private ColorBar colorbar;
        private Line line;
        private String colorsrc;
        private Boolean showscale;

        private Builder() {
        }

        public Builder autocolorscale(final Boolean value) {
            this.autocolorscale = value;
            return this;
        }

        public Builder cmax(final Number value) {
            this.cmax = value;
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

        public Builder cauto(final Boolean value) {
            this.cauto = value;
            return this;
        }

        public Builder colorbar(final ColorBar value) {
            this.colorbar = value;
            return this;
        }

        public Builder line(final Line value) {
            this.line = value;
            return this;
        }

        public Builder colorsrc(final String value) {
            this.colorsrc = value;
            return this;
        }

        public Builder showscale(final Boolean value) {
            this.showscale = value;
            return this;
        }

        public HistogramMarker build() {
            return new net.java.html.plotlyjs.HistogramMarker(autocolorscale, cmax, cmin, colorscale, color, reversescale, cauto, colorbar, line, colorsrc, showscale);
        }
    }

    public static HistogramMarker.Builder builder() {
        return new HistogramMarker.Builder();
    }

    private HistogramMarker(final Boolean autocolorscale, final Number cmax, final Number cmin, final Map<Integer, String> colorscale, final String color, final Boolean reversescale, final Boolean cauto, final ColorBar colorbar, final Line line, final String colorsrc, final Boolean showscale) {
        this.autocolorscale = autocolorscale;
        this.cmax = cmax;
        this.cmin = cmin;
        this.colorscale = colorscale;
        this.color = color;
        this.reversescale = reversescale;
        this.cauto = cauto;
        this.colorbar = colorbar;
        this.line = line;
        this.colorsrc = colorsrc;
        this.showscale = showscale;
    }
    
}
