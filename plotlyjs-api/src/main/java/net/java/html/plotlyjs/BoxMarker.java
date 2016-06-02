package net.java.html.plotlyjs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/*
 * #%L
 * This software is Copyright by the Board of Trustees of Michigan
 * State University (c) Copyright 2016.
 * Contact Information:
 * Facility for Rare Isotope Beam
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

/**
 * Bean-type wrapper builder for Plotly's Box Marker.
 * For more information see https://plot.ly/javascript/reference/#box-marker
 * @author daykin
 */

@JsonInclude(Include.NON_NULL)
public class BoxMarker{
    
    private final Number opacity;
    private final String outliercolor;
    private final String symbol;
    private final Line line;
    private final String color;
    private final Number size;

    /**
     *
     */
    public static class Builder {

        private Number opacity;
        private String outliercolor;
        private String symbol;
        private String color;
        private Line line;
        private Number size;

        private Builder() {
        }

        /**
         *
         * @param value
         * @return
         */
        public Builder opacity(final Number value) {
            this.opacity = value;
            return this;
        }

        /**
         *
         * @param value
         * @return
         */
        public Builder outliercolor(final String value) {
            this.outliercolor = value;
            return this;
        }

        /**
         *
         * @param value
         * @return
         */
        public Builder symbol(final String value) {
            this.symbol = value;
            return this;
        }

        /**
         *
         * @param value
         * @return
         */
        public Builder line(final Line value) {
            this.line = value;
            return this;
        }

        /**
         *
         * @param value
         * @return
         */
        public Builder size(final Number value) {
            this.size = value;
            return this;
        }
        
        /**
         *
         * @param color
         * @return
         */
        public Builder color(final String color){
            this.color = color;
            return this;
        }

        /**
         *
         * @return
         */
        public BoxMarker build() {
            return new net.java.html.plotlyjs.BoxMarker(this);
        }
    }

    /**
     *
     * @return
     */
    public static BoxMarker.Builder builder() {
        return new BoxMarker.Builder();
    }

    private BoxMarker(Builder builder) {
        this.opacity = builder.opacity;
        this.outliercolor = builder.outliercolor;
        this.symbol = builder.symbol;
        this.color = builder.color;
        this.line = builder.line;
        this.size = builder.size;
    }
    
    
}
