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


/**
 *
 * @author daykin
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pie<TRACE_T extends PieTrace> extends Charts{

    public final String type;
    public final Object labelssrc;    
    public final String textposition;
    public final Domain domain;
    public final Stream stream;
    public final List<?> text;
    public final List<?> labels;
    public final String direction;
    public final Object textsrc;
    public final Object visible;
    public final Object pullsrc;
    public final PieMarker marker;
    public final String textinfo;
    public final Number rotation;
    public final Boolean showlegend;
    public final Font outsidetextfont;
    public final Object valuessrc;
    public final List<?> values;
    public final Number opacity;
    public final Font textfont;
    public final String legendgroup;
    public final Number label0;
    public final Object textpositionsrc;
    public final Boolean sort;
    public final String hoverinfo;
    public final Number dlabel;
    public final Number hole;
    public final Number pull;
    public final String name;
    public final Font insidetextfont;
    public final String scalegroup;

    public static class Builder<TRACE_2 extends PieTrace> {
        private Object labelssrc;
        private String textposition;
        private Domain domain;
        private Stream stream;
        private List<?> text;
        private List<?> labels;
        private String direction;
        private Object textsrc;
        private Object visible;
        private Object pullsrc;
        private PieMarker marker;
        private String textinfo;
        private Number rotation;
        private Boolean showlegend;
        private Font outsidetextfont;
        private Object valuessrc;
        private List<?> values;
        private Number opacity;
        private Font textfont;
        private String legendgroup;
        private Number label0;
        private Object textpositionsrc;
        private Boolean sort;
        private String hoverinfo;
        private Number dlabel;
        private Number hole;
        private Number pull;
        private String name;
        private Font insidetextfont;
        private String scalegroup;

        private Builder() {
        }
        
        private static <TRACE_3 extends PieTrace> Builder<TRACE_3> start(){
            return new Builder<>();
        }

        public Builder<TRACE_2> labelssrc(final Object value) {
            this.labelssrc = value;
            return this;
        }

        public Builder<TRACE_2> textposition(final String value) {
            this.textposition = value;
            return this;
        }

        public Builder<TRACE_2> domain(final Domain value) {
            this.domain = value;
            return this;
        }

        public Builder<TRACE_2> stream(final Stream value) {
            this.stream = value;
            return this;
        }

        public Builder<TRACE_2> text(final List<?> value) {
            this.text = value;
            return this;
        }

        public Builder<TRACE_2> labels(final List<?> value) {
            this.labels = value;
            return this;
        }
        
        public Builder<TRACE_2> values(final List<?> values){
            this.values = values;
            return this;
        }
        
        public Builder<TRACE_2> direction(final String value) {
            this.direction = value;
            return this;
        }

        public Builder<TRACE_2> textsrc(final Object value) {
            this.textsrc = value;
            return this;
        }

        public Builder<TRACE_2> visible(final Object value) {
            this.visible = value;
            return this;
        }

        public Builder<TRACE_2> pullsrc(final Object value) {
            this.pullsrc = value;
            return this;
        }

        public Builder<TRACE_2> marker(final PieMarker value) {
            this.marker = value;
            return this;
        }

        public Builder<TRACE_2> textinfo(final String value) {
            this.textinfo = value;
            return this;
        }

        public Builder<TRACE_2> rotation(final Number value) {
            this.rotation = value;
            return this;
        }

        public Builder<TRACE_2> showlegend(final Boolean value) {
            this.showlegend = value;
            return this;
        }

        public Builder<TRACE_2> outsidetextfont(final Font value) {
            this.outsidetextfont = value;
            return this;
        }

        public Builder<TRACE_2> valuessrc(final Object value) {
            this.valuessrc = value;
            return this;
        }

        public Builder<TRACE_2> opacity(final Number value) {
            this.opacity = value;
            return this;
        }

        public Builder<TRACE_2> textfont(final Font value) {
            this.textfont = value;
            return this;
        }

        public Builder<TRACE_2> legendgroup(final String value) {
            this.legendgroup = value;
            return this;
        }

        public Builder<TRACE_2> label0(final Number value) {
            this.label0 = value;
            return this;
        }

        public Builder<TRACE_2> textpositionsrc(final Object value) {
            this.textpositionsrc = value;
            return this;
        }

        public Builder<TRACE_2> sort(final Boolean value) {
            this.sort = value;
            return this;
        }

        public Builder<TRACE_2> hoverinfo(final String value) {
            this.hoverinfo = value;
            return this;
        }

        public Builder<TRACE_2> dlabel(final Number value) {
            this.dlabel = value;
            return this;
        }

        public Builder<TRACE_2> hole(final Number value) {
            this.hole = value;
            return this;
        }

        public Builder<TRACE_2> pull(final Number value) {
            this.pull = value;
            return this;
        }

        public Builder<TRACE_2> name(final String value) {
            this.name = value;
            return this;
        }

        public Builder<TRACE_2> insidetextfont(final Font value) {
            this.insidetextfont = value;
            return this;
        }

        public Builder<TRACE_2> scalegroup(final String value) {
            this.scalegroup = value;
            return this;
        }

        public Pie<TRACE_2> build() {
            return new net.java.html.plotlyjs.Pie<>(this);
        }
    }

    public static <TRACE_3 extends PieTrace> Pie.Builder<TRACE_3> builder() {
        return new Pie.Builder<>();
    }

    private Pie(Builder<TRACE_T> builder) {
        this.type = "pie";        
        this.labelssrc = builder.labelssrc;
        this.textposition = builder.textposition;
        this.domain = builder.domain;
        this.stream = builder.stream;
        this.text = builder.text;
        this.labels = builder.labels;
        this.direction = builder.direction;
        this.textsrc = builder.textsrc;
        this.visible = builder.visible;
        this.pullsrc = builder.pullsrc;
        this.marker = builder.marker;
        this.textinfo = builder.textinfo;
        this.rotation = builder.rotation;
        this.showlegend = builder.showlegend;
        this.outsidetextfont = builder.outsidetextfont;        
        this.valuessrc = builder.valuessrc;
        this.values = builder.values;
        this.opacity = builder.opacity;
        this.textfont = builder.textfont;
        this.legendgroup = builder.legendgroup;
        this.label0 = builder.label0;
        this.textpositionsrc = builder.textpositionsrc;
        this.sort = builder.sort;
        this.hoverinfo = builder.hoverinfo;
        this.dlabel = builder.dlabel;
        this.hole = builder.hole;
        this.pull = builder.pull;
        this.name = builder.name;
        this.insidetextfont = builder.insidetextfont;
        this.scalegroup = builder.scalegroup;
    }

}










