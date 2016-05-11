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

/**
 *
 * @author daykin
 */

/*
    coloring, start, end line toggle, and size for contour plots
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contours {
    private final String coloring;
    private final Number end;
    private final Boolean showlines;
    private final Number start;
    private final Number size;

    public static class Builder {

        private String coloring;
        private Number end;
        private Boolean showlines;
        private Number start;
        private Number size;

        private Builder() {
        }

        public Builder coloring(final String value) {
            this.coloring = value;
            return this;
        }

        public Builder end(final Number value) {
            this.end = value;
            return this;
        }

        public Builder showlines(final Boolean value) {
            this.showlines = value;
            return this;
        }

        public Builder start(final Number value) {
            this.start = value;
            return this;
        }

        public Builder size(final Number value) {
            this.size = value;
            return this;
        }

        public Contours build() {
            return new net.java.html.plotlyjs.Contours(this);
        }
    }

    public static Contours.Builder builder() {
        return new Contours.Builder();
    }

    private Contours(Builder builder) {
        this.coloring = builder.coloring;
        this.end = builder.end;
        this.showlines = builder.showlines;
        this.start = builder.start;
        this.size = builder.size;
    }


    
}
