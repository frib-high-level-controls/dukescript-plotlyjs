package net.java.html.plotlyjs;

import com.fasterxml.jackson.annotation.JsonInclude;

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


/**
 *
 * @author daykin
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Projection {
    private final ProjectionAxis x;
    private final ProjectionAxis y;
    private final ProjectionAxis z;

    public static class Builder {

        private ProjectionAxis x;
        private ProjectionAxis y;
        private ProjectionAxis z;

        private Builder() {
        }

        public Builder x(final ProjectionAxis value) {
            this.x = value;
            return this;
        }

        public Builder y(final ProjectionAxis value) {
            this.y = value;
            return this;
        }

        public Builder z(final ProjectionAxis value) {
            this.z = value;
            return this;
        }

        public Projection build() {
            return new net.java.html.plotlyjs.Projection(this);
        }
    }

    public static Projection.Builder builder() {
        return new Projection.Builder();
    }

    private Projection(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
    }
    
    
}
