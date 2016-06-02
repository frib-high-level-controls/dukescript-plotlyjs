/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


import java.util.List;

/**
 * Trace type for any plot requiring an x and y axis.
 * @author daykin
 */
public class CartesianTrace implements Trace{
    
    List<?> x;
    List<?> y;
    
    /**
     *
     * @param x
     * @param y
     */
    public CartesianTrace(List<?> x, List<?> y){
        this.x = x;
        this.y = y;
    }
    

    public CartesianTrace(){
        
    }

    /**
     *
     * @param value
     * @return
     */
    public CartesianTrace x(List<?> value) {
        this.x = value;
        return this;
    }

    /**
     *
     * @param value
     * @return
     */
    public CartesianTrace y(List<?> value) {
        this.y = value;
        return this;
    }
    
}
