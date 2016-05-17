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


/**
 *
 * @author daykin
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProjectionAxis {
    private final Number Opacity;
    private final Number scale;
    private final Boolean show;

    public static class Builder {

        private Number Opacity;
        private Number scale;
        private Boolean show;

        private Builder() {
        }

        public Builder Opacity(final Number value) {
            this.Opacity = value;
            return this;
        }

        public Builder scale(final Number value) {
            this.scale = value;
            return this;
        }

        public Builder show(final Boolean value) {
            this.show = value;
            return this;
        }

        public ProjectionAxis build() {
            return new net.java.html.plotlyjs.ProjectionAxis(this);
        }
    }

    public static ProjectionAxis.Builder builder() {
        return new ProjectionAxis.Builder();
    }

    private ProjectionAxis(Builder builder) {
        this.Opacity = builder.Opacity;
        this.scale = builder.scale;
        this.show = builder.show;
    }
    
}
