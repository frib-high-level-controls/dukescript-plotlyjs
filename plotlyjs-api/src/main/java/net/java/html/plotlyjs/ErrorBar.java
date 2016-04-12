/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ErrorBar {
    private Boolean copy_ystyle;
    private Integer tracerefminus;
    private Integer width;
    private Boolean copy_zstyle;
    private Integer value;
    private Integer thickness;
    private Boolean symmetric;
    private Boolean visible;
    private Integer traceref;
    private Integer valueminus;
    private Data arrayminus;
    private Data array;
    private String type;
    private String color;
    
    public static final class RuleTypes{
        public static final String PERCENT = "percent";
        public static final String CONSTANT = "constant";
        public static final String SQRT = "sqrt";
        public static final String DATA = "data";
    }

    public static class Builder {

        private Boolean copy_ystyle;
        private Integer tracerefminus;
        private Integer width;
        private Boolean copy_zstyle;
        private Integer value = 10;
        private Integer thickness = 2;
        private Boolean symmetric;
        private Boolean visible;
        private Integer traceref;
        private Integer valueminus = 10;
        private Data arrayminus;
        private Data array;
        private String type;
        private String color;

        private Builder() {
        }

        public Builder copy_ystyle(final Boolean value) {
            this.copy_ystyle = value;
            return this;
        }

        public Builder tracerefminus(final Integer value) {
            if(value>=0){
               this.tracerefminus = value;
            }
            return this;
        }

        public Builder width(final Integer value) {
            if(value>=0){
            this.width = value;
            }
            return this;
        }

        public Builder copy_zstyle(final Boolean value) {
            this.copy_zstyle = value;
            return this;
        }

        public Builder value(final Integer value) {
            if(value>=0){
            this.value = value;
            }
            return this;
        }

        public Builder thickness(final Integer value) {
            if(value>=0){
            this.thickness = value;
            }
            return this;
        }

        public Builder symmetric(final Boolean value) {
            this.symmetric = value;
            return this;
        }

        public Builder visible(final Boolean value) {
            this.visible = value;
            return this;
        }

        public Builder traceref(final Integer value) {
            if(value>=0){
            this.traceref = value;
            }
            return this;
        }

        public Builder valueminus(final Integer value) {
            this.valueminus = value;
            return this;
        }

        public Builder arrayminus(final Data value) {
            this.arrayminus = value;
            return this;
        }

        public Builder array(final Data value) {
            this.array = value;
            return this;
        }

        public Builder type(final String value) {
            this.type = value;
            return this;
        }

        public Builder color(final String value) {
            this.color = value;
            return this;
        }

        public ErrorBar build() {
            return new net.java.html.plotlyjs.ErrorBar(this);
        }
    }

    public static ErrorBar.Builder builder() {
        return new ErrorBar.Builder();
    }

    private ErrorBar(Builder builder) {
        this.copy_ystyle = builder.copy_ystyle;
        this.tracerefminus = builder.tracerefminus;
        this.width = builder.width;
        this.copy_zstyle = builder.copy_zstyle;
        this.value = builder.value;
        this.thickness = builder.thickness;
        this.symmetric = builder.symmetric;
        this.visible = builder.visible;
        this.traceref = builder.traceref;
        this.valueminus = builder.valueminus;
        this.arrayminus = builder.arrayminus;
        this.array = builder.array;
        this.type = builder.type;
        this.color = builder.color;
    }
    
    
}
