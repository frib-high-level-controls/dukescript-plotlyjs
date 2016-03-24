/*
 * The MIT License
 *
 * Copyright 2016 MSU.
 *
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
 */
package net.java.html.plotlyjs;

import java.util.ArrayList;

/**
 *
 * @author daykin
 */
public class Axis {
    
    public static class AxisBuilder{
        String showexponent = "all";
        boolean showticklabels = true;
        String showticksuffix = "all";
        Font titleFont = new Font.FontBuilder().build();
        String lineColor;
        String mirror = "False";
        int nticks = 0;
        int linewidth = 1;
        String autorange = "True";
        String tickprefix = "";
        int position = 0;
        String tickformat = "";
        String tickmode = "auto";
        String title = "Axis Title";
        String ticks = "";
        String overlaying = "free";
        String rangemode = "normal";
        String showtickprefix = "all";
        boolean zeroline = true;
        ArrayList<Integer> domain = new ArrayList<Integer>(){{
            add(0);
            add(1);
        }};
        String gridcolor = "#eee";
        String type = "-";
        int zerolinewidth = 1;
        int ticklen = 5;
        String hoverformat = "";
        String ticksuffix = "";
        boolean fixedrange = false;
        boolean showline = true;
        ArrayList<String> ticktext = new ArrayList<String>();
        boolean showgrid = false;
        int tickvals[]; 
        Font tickfont = new Font.FontBuilder().build();
        int tickwidth = 1;
        int tick0 = 0;
        int tickangle = -90;
        int gridwidth = 1;
        int dtick = 1;
        String side;
        String zerolinecolor = "#444";
        ArrayList<Integer>range = new ArrayList<Integer>(){{add(0);add(10);}};
        String anchor = "free";
        String exponentformat = "B";
    }
    
}
