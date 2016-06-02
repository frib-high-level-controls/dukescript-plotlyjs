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


import java.util.List;

/**
 * This class simply wraps CartesianTrace for readability. 
 * for 1d histograms, Plotly will ignore x or y
 * axes on its own, depending on its <code>orientation</code> 
 * (vertical/horizontal).
 * Data binning settings of distributions are done in their respective builders.
 * @author daykin
 */
public class DistributionTrace extends CartesianTrace implements Trace  {    
    
    public DistributionTrace(List<?> x, List<?> y){
        super(x,y);
    }
    
    public DistributionTrace(){}
    
    @Override
    public DistributionTrace y(List<?> y) {
        this.y = y;
        return this;
    }

    @Override
    public DistributionTrace x(List<?> x) {
        this.x = x;
        return this;
    }
    
    
    
}
