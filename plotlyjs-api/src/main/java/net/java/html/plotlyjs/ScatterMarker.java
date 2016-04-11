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


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;

/**
 *
 * @author daykin
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScatterMarker extends Marker{
    String sizesrc;
    Number size;
    Number sizeref;
    String symbol;
    String symbolsrc;
    String sizemode;
    Number sizemin;

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
        private Number opacity;
        private String opacitySrc;
        private String sizesrc;
        private Number size;
        private Number sizeref;
        private String symbol;
        private String symbolsrc;
        private String sizemode;
        private Number sizemin;

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

        public Builder opacity(final Number value) {
            this.opacity = value;
            return this;
        }

        public Builder opacitySrc(final String value) {
            this.opacitySrc = value;
            return this;
        }

        public Builder sizesrc(final String value) {
            this.sizesrc = value;
            return this;
        }

        public Builder size(final Number value) {
            this.size = value;
            return this;
        }

        public Builder sizeref(final Number value) {
            this.sizeref = value;
            return this;
        }

        public Builder symbol(final String value) {
            this.symbol = value;
            return this;
        }

        public Builder symbolsrc(final String value) {
            this.symbolsrc = value;
            return this;
        }

        public Builder sizemode(final String value) {
            this.sizemode = value;
            return this;
        }

        public Builder sizemin(final Number value) {
            this.sizemin = value;
            return this;
        }

        public ScatterMarker build() {
            return new net.java.html.plotlyjs.ScatterMarker(autocolorscale, cmax, cmin, colorscale, color, reversescale, cauto, colorbar, line, colorsrc, showscale, opacity, opacitySrc, sizesrc, size, sizeref, symbol, symbolsrc, sizemode, sizemin);
        }
    }

    public static ScatterMarker.Builder builder() {
        return new ScatterMarker.Builder();
    }

    private ScatterMarker(final Boolean autocolorscale, final Number cmax, final Number cmin, final Map<Integer, String> colorscale, final String color, final Boolean reversescale, final Boolean cauto, final ColorBar colorbar, final Line line, final String colorsrc, final Boolean showscale, final Number opacity, final String opacitySrc, final String sizesrc, final Number size, final Number sizeref, final String symbol, final String symbolsrc, final String sizemode, final Number sizemin) {
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
        this.opacity = opacity;
        this.opacitySrc = opacitySrc;
        this.sizesrc = sizesrc;
        this.size = size;
        this.sizeref = sizeref;
        this.symbol = symbol;
        this.symbolsrc = symbolsrc;
        this.sizemode = sizemode;
        this.sizemin = sizemin;
    }
    
    
}
