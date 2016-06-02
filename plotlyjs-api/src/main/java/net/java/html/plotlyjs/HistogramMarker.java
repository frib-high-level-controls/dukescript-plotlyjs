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
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistogramMarker extends Marker{

    
    public static class Builder {

        private Boolean autocolorscale;
        private Number cmax;
        private Number cmin;
        private Map<Number,String> colorscale;
        private String color;
        private Boolean reversescale;
        private Boolean cauto;
        private ColorBar colorbar;
        private Line line;
        private String colorsrc;
        private Boolean showscale;
        private Number opacity;
        private String opacitySrc;

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

        
        public Builder colorscale(final Map<Number,String> value) {
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

        
        public HistogramMarker build() {
            return new net.java.html.plotlyjs.HistogramMarker(this);
        }
    }

    
    public static HistogramMarker.Builder builder() {
        return new HistogramMarker.Builder();
    }

    private HistogramMarker(Builder builder) {
        this.autocolorscale = builder.autocolorscale;
        this.cmax = builder.cmax;
        this.cmin = builder.cmin;
        this.colorscale = builder.colorscale;
        this.color = builder.color;
        this.reversescale = builder.reversescale;
        this.cauto = builder.cauto;
        this.colorbar = builder.colorbar;
        this.line = builder.line;
        this.colorsrc = builder.colorsrc;
        this.showscale = builder.showscale;
    }
    
}
