/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.html.plotlyjs;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
 * Generates binning settings for distribution based plots such as
 * {@link Histogram}. Consists of a start, end and size. If this is not set, Plotly will automatically infer the binning settings.
 * @author daykin
 */
@JsonInclude(Include.NON_NULL)
public class AxisBin {
   private final Number start;
   private final Number end;
   private final Number size;
   
    public static class Builder {
        private Number start;
        private Number end;
        private Number size;
        private Builder() {
        }
        /**
         * Set the start value for binning.
         * @param value the minimum bin, i.e. values in the distribution with this value or less.
         * @return a builder with the start value set.
         */
        public Builder start(final Number value) {
            this.start = value;
            return this;
        }
        /**
         *Set the maximum value for binning.
         * @param value the maximum bin, i.e. values in the distribution with this value or greater.
         * @return a builder with the 
         */
        public Builder end(final Number value) {
            this.end = value;
            return this;
        }
        /**
         * Set the step of values that the bin encapsulates. 
         * @param value
         * @return
         */
        public Builder size(final Number value) {
            this.size = value;
            return this;
        }
        /**
         * Build an AxisBin Bean with the specified values.
         * @return an AxisBin Object. 
         */
        public AxisBin build() {
            return new net.java.html.plotlyjs.AxisBin(this);
        }
    }
    /**
     * Begin an <code>AxisBin</code> builder.
     * @return a <code>Builder</code> object.
     */
    public static AxisBin.Builder builder() {
        return new AxisBin.Builder();
    }
    private AxisBin(Builder builder) {
        this.start = builder.start;
        this.end = builder.end;
        this.size = builder.size;
    }
}
