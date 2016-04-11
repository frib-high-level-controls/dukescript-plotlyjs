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
 *
 * @author daykin
 */
public abstract class Chart {
    String type;
    List x;
    List y;
    
    public static final class Orientations{
        public static final String VERTICAL = "v";
        public static final String HORIZONTAL = "h";
    }
    
    public static final class TextPositions{
	public static final String TOP_LEFT = "top left";
	public static final String TOP_CENTER = "top center";
	public static final String TOP_RIGHT = "top right";
	public static final String MIDDLE_LEFT = "middle left";
	public static final String MIDDLE_CENTER = "middle center";
	public static final String MIDDLE_RIGHT = "middle right";
	public static final String BOTTOM_LEFT = "bottom left";
	public static final String BOTTOM_CENTER = "bottom center";
	public static final String BOTTOM_RIGHT = "bottom right";
    }
    
    public static final class FillModes{
        public static final String NONE = "none";
	public static final String TOZEROY = "tozeroy";
	public static final String TOZEROX = "tozerox";
	public static final String TONEXTY = "tonexty";
	public static final String TONEXTX = "tonextx";

    }
    
    public static final class HistFunc{
        public static final String COUNT = "count";
        public static final String SUM = "sum";
        public static final String AVG = "avg";
        public static final String MIN = "min";
        public static final String MAX = "max";
    }
    
    public static final class HistNorm{
        public static final String PERCENT = "percent";
        public static final String PROBABILITY = "probability";
        public static final String DENSITY = "density";
        public static final String PROBABILITY_DENSITY = "probability density";
    }  
    
    public static final class HoverFlags{
        public static final String X = "x";
        public static final String Y = "y";
        public static final String Z = "Z";
        public static final String TEXT = "text";
        public static final String NAME = "name";
        public static final String ALL = "all";
        public static final String XY = "x+y";
        public static final String XZ = "x+z";
        public static final String XYZ = "x+y+z";
        public static final String YZ = "y+z";
    }
    
    public static final class Visibility{
        public static final Boolean TRUE = true;
        public static final Boolean FALSE = false;
        public static final String LEGENDONLY = "legendonly";
    }
    
    public static final class ZSmooth{
        public static final String FAST = "fast";
        public static final String BEST = "best";
        public static final Boolean FALSE = false;
    }
    
}
