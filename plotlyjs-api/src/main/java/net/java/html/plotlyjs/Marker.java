package net.java.html.plotlyjs;

import java.util.Map;

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
public abstract class Marker {
    
    /**
     *
     */
    public static final class SizeModes{

        /**
         *
         */
        public static final String DIAMETER = "diameter";

        /**
         *
         */
        public static final String AREA = "area";
    }
    
    /**
     *
     */
    public static final class Symbols{

        /**
         *
         */
        public static final String CIRCLE = "circle";

        /**
         *
         */
        public static final String CIRCLE_OPEN = "circle-open";

        /**
         *
         */
        public static final String CIRCLE_DOT = "circle-dot";

        /**
         *
         */
        public static final String CIRCLE_OPEN_DOT = "circle-open-dot";

        /**
         *
         */
        public static final String SQUARE = "square";

        /**
         *
         */
        public static final String SQUARE_OPEN = "square-open";

        /**
         *
         */
        public static final String SQUARE_DOT = "square-dot";

        /**
         *
         */
        public static final String SQUARE_OPEN_DOT = "square-open-dot";

        /**
         *
         */
        public static final String DIAMOND = "diamond";

        /**
         *
         */
        public static final String DIAMOND_OPEN = "diamond-open";

        /**
         *
         */
        public static final String DIAMOND_DOT = "diamond-dot";

        /**
         *
         */
        public static final String DIAMOND_OPEN_DOT = "diamond-open-dot";

        /**
         *
         */
        public static final String CROSS = "cross";

        /**
         *
         */
        public static final String CROSS_OPEN = "cross-open";

        /**
         *
         */
        public static final String CROSS_DOT = "cross-dot";

        /**
         *
         */
        public static final String CROSS_OPEN_DOT = "cross-open-dot";

        /**
         *
         */
        public static final String X = "x";

        /**
         *
         */
        public static final String X_OPEN = "x-open";

        /**
         *
         */
        public static final String X_DOT = "x-dot";

        /**
         *
         */
        public static final String X_OPEN_DOT = "x-open-dot";

        /**
         *
         */
        public static final String TRIANGLE_UP = "triangle-up";

        /**
         *
         */
        public static final String TRIANGLE_UP_OPEN = "triangle-up-open";

        /**
         *
         */
        public static final String TRIANGLE_UP_DOT = "triangle-up-dot";

        /**
         *
         */
        public static final String TRIANGLE_UP_OPEN_DOT = "triangle-up-open-dot";

        /**
         *
         */
        public static final String TRIANGLE_DOWN = "triangle-down";

        /**
         *
         */
        public static final String TRIANGLE_DOWN_OPEN = "triangle-down-open";

        /**
         *
         */
        public static final String TRIANGLE_DOWN_DOT = "triangle-down-dot";

        /**
         *
         */
        public static final String TRIANGLE_DOWN_OPEN_DOT = "triangle-down-open-dot";

        /**
         *
         */
        public static final String TRIANGLE_LEFT = "triangle-left";

        /**
         *
         */
        public static final String TRIANGLE_LEFT_OPEN = "triangle-left-open";

        /**
         *
         */
        public static final String TRIANGLE_LEFT_DOT = "triangle-left-dot";

        /**
         *
         */
        public static final String TRIANGLE_LEFT_OPEN_DOT = "triangle-left-open-dot";

        /**
         *
         */
        public static final String TRIANGLE_RIGHT = "triangle-right";

        /**
         *
         */
        public static final String TRIANGLE_RIGHT_OPEN = "triangle-right-open";

        /**
         *
         */
        public static final String TRIANGLE_RIGHT_DOT = "triangle-right-dot";

        /**
         *
         */
        public static final String TRIANGLE_RIGHT_OPEN_DOT = "triangle-right-open-dot";

        /**
         *
         */
        public static final String TRIANGLE_NE = "triangle-ne";

        /**
         *
         */
        public static final String TRIANGLE_NE_OPEN = "triangle-ne-open";

        /**
         *
         */
        public static final String TRIANGLE_NE_DOT = "triangle-ne-dot";

        /**
         *
         */
        public static final String TRIANGLE_NE_OPEN_DOT = "triangle-ne-open-dot";

        /**
         *
         */
        public static final String TRIANGLE_SE = "triangle-se";

        /**
         *
         */
        public static final String TRIANGLE_SE_OPEN = "triangle-se-open";

        /**
         *
         */
        public static final String TRIANGLE_SE_DOT = "triangle-se-dot";

        /**
         *
         */
        public static final String TRIANGLE_SE_OPEN_DOT = "triangle-se-open-dot";

        /**
         *
         */
        public static final String TRIANGLE_SW = "triangle-sw";

        /**
         *
         */
        public static final String TRIANGLE_SW_OPEN = "triangle-sw-open";

        /**
         *
         */
        public static final String TRIANGLE_SW_DOT = "triangle-sw-dot";

        /**
         *
         */
        public static final String TRIANGLE_SW_OPEN_DOT = "triangle-sw-open-dot";

        /**
         *
         */
        public static final String TRIANGLE_NW = "triangle-nw";

        /**
         *
         */
        public static final String TRIANGLE_NW_OPEN = "triangle-nw-open";

        /**
         *
         */
        public static final String TRIANGLE_NW_DOT = "triangle-nw-dot";

        /**
         *
         */
        public static final String TRIANGLE_NW_OPEN_DOT = "triangle-nw-open-dot";

        /**
         *
         */
        public static final String PENTAGON = "pentagon";

        /**
         *
         */
        public static final String PENTAGON_OPEN = "pentagon-open";

        /**
         *
         */
        public static final String PENTAGON_DOT = "pentagon-dot";

        /**
         *
         */
        public static final String PENTAGON_OPEN_DOT = "pentagon-open-dot";

        /**
         *
         */
        public static final String HEXAGON = "hexagon";

        /**
         *
         */
        public static final String HEXAGON_OPEN = "hexagon-open";

        /**
         *
         */
        public static final String HEXAGON_DOT = "hexagon-dot";

        /**
         *
         */
        public static final String HEXAGON_OPEN_DOT = "hexagon-open-dot";

        /**
         *
         */
        public static final String HEXAGON2 = "hexagon2";

        /**
         *
         */
        public static final String HEXAGON2_OPEN = "hexagon2-open";

        /**
         *
         */
        public static final String HEXAGON2_DOT = "hexagon2-dot";

        /**
         *
         */
        public static final String HEXAGON2_OPEN_DOT = "hexagon2-open-dot";

        /**
         *
         */
        public static final String OCTAGON = "octagon";

        /**
         *
         */
        public static final String OCTAGON_OPEN = "octagon-open";

        /**
         *
         */
        public static final String OCTAGON_DOT = "octagon-dot";

        /**
         *
         */
        public static final String OCTAGON_OPEN_DOT = "octagon-open-dot";

        /**
         *
         */
        public static final String STAR = "star";

        /**
         *
         */
        public static final String STAR_OPEN = "star-open";

        /**
         *
         */
        public static final String STAR_DOT = "star-dot";

        /**
         *
         */
        public static final String STAR_OPEN_DOT = "star-open-dot";

        /**
         *
         */
        public static final String HEXAGRAM = "hexagram";

        /**
         *
         */
        public static final String HEXAGRAM_OPEN = "hexagram-open";

        /**
         *
         */
        public static final String HEXAGRAM_DOT = "hexagram-dot";

        /**
         *
         */
        public static final String HEXAGRAM_OPEN_DOT = "hexagram-open-dot";

        /**
         *
         */
        public static final String STAR_TRIANGLE_UP = "star-triangle-up";

        /**
         *
         */
        public static final String STAR_TRIANGLE_UP_OPEN = "star-triangle-up-open";

        /**
         *
         */
        public static final String STAR_TRIANGLE_UP_DOT = "star-triangle-up-dot";

        /**
         *
         */
        public static final String STAR_TRIANGLE_UP_OPEN_DOT = "star-triangle-up-open-dot";

        /**
         *
         */
        public static final String STAR_TRIANGLE_DOWN = "star-triangle-down";

        /**
         *
         */
        public static final String STAR_TRIANGLE_DOWN_OPEN = "star-triangle-down-open";

        /**
         *
         */
        public static final String STAR_TRIANGLE_DOWN_DOT = "star-triangle-down-dot";

        /**
         *
         */
        public static final String STAR_TRIANGLE_DOWN_OPEN_DOT = "star-triangle-down-open-dot";

        /**
         *
         */
        public static final String STAR_SQUARE = "star-square";

        /**
         *
         */
        public static final String STAR_SQUARE_OPEN = "star-square-open";

        /**
         *
         */
        public static final String STAR_SQUARE_DOT = "star-square-dot";

        /**
         *
         */
        public static final String STAR_SQUARE_OPEN_DOT = "star-square-open-dot";

        /**
         *
         */
        public static final String STAR_DIAMOND = "star-diamond";

        /**
         *
         */
        public static final String STAR_DIAMOND_OPEN = "star-diamond-open";

        /**
         *
         */
        public static final String STAR_DIAMOND_DOT = "star-diamond-dot";

        /**
         *
         */
        public static final String STAR_DIAMOND_OPEN_DOT = "star-diamond-open-dot";

        /**
         *
         */
        public static final String DIAMOND_TALL = "diamond-tall";

        /**
         *
         */
        public static final String DIAMOND_TALL_OPEN = "diamond-tall-open";

        /**
         *
         */
        public static final String DIAMOND_TALL_DOT = "diamond-tall-dot";

        /**
         *
         */
        public static final String DIAMOND_TALL_OPEN_DOT = "diamond-tall-open-dot";

        /**
         *
         */
        public static final String DIAMOND_WIDE = "diamond-wide";

        /**
         *
         */
        public static final String DIAMOND_WIDE_OPEN = "diamond-wide-open";

        /**
         *
         */
        public static final String DIAMOND_WIDE_DOT = "diamond-wide-dot";

        /**
         *
         */
        public static final String DIAMOND_WIDE_OPEN_DOT = "diamond-wide-open-dot";

        /**
         *
         */
        public static final String HOURGLASS = "hourglass";

        /**
         *
         */
        public static final String HOURGLASS_OPEN = "hourglass-open";

        /**
         *
         */
        public static final String BOWTIE = "bowtie";

        /**
         *
         */
        public static final String BOWTIE_OPEN = "bowtie-open";

        /**
         *
         */
        public static final String CIRCLE_CROSS = "circle-cross";

        /**
         *
         */
        public static final String CIRCLE_CROSS_OPEN = "circle-cross-open";

        /**
         *
         */
        public static final String CIRCLE_X = "circle-x";

        /**
         *
         */
        public static final String CIRCLE_X_OPEN = "circle-x-open";

        /**
         *
         */
        public static final String SQUARE_CROSS = "square-cross";

        /**
         *
         */
        public static final String SQUARE_CROSS_OPEN = "square-cross-open";

        /**
         *
         */
        public static final String SQUARE_X = "square-x";

        /**
         *
         */
        public static final String SQUARE_X_OPEN = "square-x-open";

        /**
         *
         */
        public static final String DIAMOND_CROSS = "diamond-cross";

        /**
         *
         */
        public static final String DIAMOND_CROSS_OPEN = "diamond-cross-open";

        /**
         *
         */
        public static final String DIAMOND_X = "diamond-x";

        /**
         *
         */
        public static final String DIAMOND_X_OPEN = "diamond-x-open";

        /**
         *
         */
        public static final String CROSS_THIN = "cross-thin";

        /**
         *
         */
        public static final String CROSS_THIN_OPEN = "cross-thin-open";

        /**
         *
         */
        public static final String X_THIN = "x-thin";

        /**
         *
         */
        public static final String X_THIN_OPEN = "x-thin-open";

        /**
         *
         */
        public static final String ASTERISK = "asterisk";

        /**
         *
         */
        public static final String ASTERISK_OPEN = "asterisk-open";

        /**
         *
         */
        public static final String HASH = "hash";

        /**
         *
         */
        public static final String HASH_OPEN = "hash-open";

        /**
         *
         */
        public static final String HASH_DOT = "hash-dot";

        /**
         *
         */
        public static final String HASH_OPEN_DOT = "hash-open-dot";

        /**
         *
         */
        public static final String Y_UP = "y-up";

        /**
         *
         */
        public static final String Y_UP_OPEN = "y-up-open";

        /**
         *
         */
        public static final String Y_DOWN = "y-down";

        /**
         *
         */
        public static final String Y_DOWN_OPEN = "y-down-open";

        /**
         *
         */
        public static final String Y_LEFT = "y-left";

        /**
         *
         */
        public static final String Y_LEFT_OPEN = "y-left-open";

        /**
         *
         */
        public static final String Y_RIGHT = "y-right";

        /**
         *
         */
        public static final String Y_RIGHT_OPEN = "y-right-open";

        /**
         *
         */
        public static final String LINE_EW = "line-ew";

        /**
         *
         */
        public static final String LINE_EW_OPEN = "line-ew-open";

        /**
         *
         */
        public static final String LINE_NS = "line-ns";

        /**
         *
         */
        public static final String LINE_NS_OPEN = "line-ns-open";

        /**
         *
         */
        public static final String LINE_NE = "line-ne";

        /**
         *
         */
        public static final String LINE_NE_OPEN = "line-ne-open";

        /**
         *
         */
        public static final String LINE_NW = "line-nw";

        /**
         *
         */
        public static final String LINE_NW_OPEN = "line-nw-open";
    }
    
    Boolean autocolorscale;
    Number cmax;
    Number cmin;
    Map<Number,String> colorscale;
    String color;
    Boolean reversescale;
    Boolean cauto;
    ColorBar colorbar;
    Line line;
    String colorsrc;
    Boolean showscale;
    Number opacity;
    String opacitySrc;
    
}
