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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Data <T extends Chart> {

    private List<T> traces = new ArrayList<T>();
    
    @SafeVarargs
    public Data(T... traces){
        this.traces.addAll(Arrays.asList(traces));  
    }
    
    public void addTraces(T... traces){
        this.traces.addAll(Arrays.asList(traces));
    }
    
    public void deleteTraces(int... traces){
        for(int trace: traces){
            this.traces.remove(trace);
        }
    }

    public void moveTraces(int... traces){
        for(int trace: traces){
            this.traces.add(this.traces.remove(trace));
        }
    }
    
    public void moveTraces(int[] from, int[] to)throws PlotlyException{
        if(from.length!=to.length){
            throw new PlotlyException("arrays must be the same size.");
        }
        else{
            for(int i=0;i<from.length;i++){
                Collections.swap(this.traces,from[i], to[i]);
            }
        }
    }
    
    
    public List<T> getTraces(){
        return this.traces;
    }

}
