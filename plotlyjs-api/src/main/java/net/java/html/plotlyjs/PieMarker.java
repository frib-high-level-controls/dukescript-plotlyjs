package net.java.html.plotlyjs;

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



import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PieMarker {

    
    public final List<?> colors;

    
    public final Line line;

    
    public final Object colorssrc;

    
    public static class Builder {

        private List<?> colors;
        private Line line;
        private Object colorssrc;

        private Builder() {
        }

        
        public Builder colors(final List<?> value) {
            this.colors = value;
            return this;
        }

        
        public Builder line(final Line value) {
            this.line = value;
            return this;
        }

        
        public Builder colorssrc(final Object value) {
            this.colorssrc = value;
            return this;
        }

        
        public PieMarker build() {
            return new net.java.html.plotlyjs.PieMarker(this);
        }
    }

    
    public static PieMarker.Builder builder() {
        return new PieMarker.Builder();
    }

    private PieMarker(Builder builder) {
        this.colors = builder.colors;
        this.line = builder.line;
        this.colorssrc = builder.colorssrc;
    }
}
