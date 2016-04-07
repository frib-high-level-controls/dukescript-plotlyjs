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
public class Line {
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
            return new net.java.html.plotlyjs.Line(colorsrc, autocolorscale, cmin, colorscale, color, reversescale, width, cauto, widthsrc, cmax);
        }
    }

    public static Line.Builder builder() {
        return new Line.Builder();
    }

    private Line(final String colorsrc, final Boolean autocolorscale, final Number cmin, final Map<Integer, String> colorscale, final String color, final Boolean reversescale, final Integer width, final Boolean cauto, final String widthsrc, final Number cmax) {
        this.colorsrc = colorsrc;
        this.autocolorscale = autocolorscale;
        this.cmin = cmin;
        this.colorscale = colorscale;
        this.color = color;
        this.reversescale = reversescale;
        this.width = width;
        this.cauto = cauto;
        this.widthsrc = widthsrc;
        this.cmax = cmax;
    }
}
