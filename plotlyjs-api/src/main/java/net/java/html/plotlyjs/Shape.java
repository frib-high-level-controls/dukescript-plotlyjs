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
 * @author berryman
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shape {
    public enum TYPE { circle, rect, path, line };
    private final TYPE type;
    private final Number x0;
    private final Number y0;
    private final Number x1;
    private final Number y1;
    private final Line line;

    public static class Builder {
        private TYPE type;
        private Number x0;
        private Number y0;
        private Number x1;
        private Number y1;
        private Line line;
        
        public Builder start(Number x0, Number y0) {
            this.x0 = x0;
            this.y0 = y0;
            return this;
        }
        
        public Builder end (Number x1, Number y1) {
            this.x1 = x1;
            this.y1 = y1;
            return this;
        }
        
        public Builder type (TYPE type) {
            this.type = type;
            return this;
        }
        
        public Builder line (Line line) {
            this.line = line;
            return this;
        }
        
        public Shape build () {
            return new Shape(this);
        }
    }
    public Shape(Builder builder) {
        this.type = builder.type;
        this.x0 = builder.x0;
        this.y0 = builder.y0;
        this.x1 = builder.x1;
        this.y1 = builder.y1;
        this.line = builder.line;
    }    
}
