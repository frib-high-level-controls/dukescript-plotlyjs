/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
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


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author daykin
 */
@JsonInclude(Include.NON_NULL)
public class Config {
        // no interactivity; for export or image generation
    private final Boolean staticPlot;

    // we can edit titles; move annotations; etc
    private final Boolean editable;

    // plot will respect layout.autosize=true and infer its container size
    private final Boolean  autosizable;

    // if we DO autosize; do we fill the container or the screen?
    private final Boolean  fillFrame;

    // if we DO autosize; set the frame margins in percents of plot size
    private final Number frameMargins;

    // mousewheel or two-finger scroll zooms the plot
    private final Boolean  scrollZoom;

    // double click interaction (false; 'reset'; 'autosize' or 'reset+autosize')
    private final String doubleClick;

    // new users see some hints about interactivity
    private final Boolean  showTips;

    // link to open this plot in plotly
    private final Boolean  showLink;

    // if we show a link; does it contain data or just link to a plotly file?
    private final Boolean  sendData;

    // text appearing in the sendData link
    private final String linkText;

    // false or function adding source(s) to linkText <text>
    private final Boolean  showSources;

    // display the mode bar (true; false; or 'hover')
    private final String displayModeBar;

    // remove mode bar button by name
    // (see ./components/modebar/buttons.js for the list of names)
    private final String[] modeBarButtonsToRemove;

    // add mode bar button using config objects
    // (see https://github.com/plotly/plotly.js/blob/master/src/components/modebar/buttons.js for list of arguments)
    private final String[] modeBarButtonsToAdd;

    // fully custom mode bar buttons as nested array;
    // where the outer arrays represents button groups; and
    // the inner arrays have buttons config objects or names of default buttons
    // (see https://github.com/plotly/plotly.js/blob/master/src/components/modebar/buttons.js for more info)
    private final Boolean  modeBarButtons;

    // add the plotly logo on the end of the mode bar
    private final Boolean  displaylogo;

    // increase the pixel ratio for Gl plot images
    private final Number plotGlPixelRatio;

    // URL to topojson files used in geo charts
    private final String topojsonURL;

    public static class Builder {

        private Boolean staticPlot;
        private Boolean editable;
        private Boolean autosizable;
        private Boolean fillFrame;
        private Number frameMargins;
        private Boolean scrollZoom;
        private String doubleClick;
        private Boolean showTips;
        private Boolean showLink;
        private Boolean sendData;
        private String linkText;
        private Boolean showSources;
        private String displayModeBar;
        private String[] modeBarButtonsToRemove;
        private String[] modeBarButtonsToAdd;
        private Boolean modeBarButtons;
        private Boolean displaylogo;
        private Number plotGlPixelRatio;
        private String topojsonURL;

        public Builder() {
        }

        public Builder staticPlot(final Boolean value) {
            this.staticPlot = value;
            return this;
        }

        public Builder editable(final Boolean value) {
            this.editable = value;
            return this;
        }

        public Builder autosizable(final Boolean value) {
            this.autosizable = value;
            return this;
        }

        public Builder fillFrame(final Boolean value) {
            this.fillFrame = value;
            return this;
        }

        public Builder frameMargins(final Number value) {
            this.frameMargins = value;
            return this;
        }

        public Builder scrollZoom(final Boolean value) {
            this.scrollZoom = value;
            return this;
        }

        public Builder doubleClick(final String value) {
            this.doubleClick = value;
            return this;
        }

        public Builder showTips(final Boolean value) {
            this.showTips = value;
            return this;
        }

        public Builder showLink(final Boolean value) {
            this.showLink = value;
            return this;
        }

        public Builder sendData(final Boolean value) {
            this.sendData = value;
            return this;
        }

        public Builder linkText(final String value) {
            this.linkText = value;
            return this;
        }

        public Builder showSources(final Boolean value) {
            this.showSources = value;
            return this;
        }

        public Builder displayModeBar(final String value) {
            this.displayModeBar = value;
            return this;
        }

        public Builder modeBarButtonsToRemove(final String[] value) {
            this.modeBarButtonsToRemove = value;
            return this;
        }

        public Builder modeBarButtonsToAdd(final String[] value) {
            this.modeBarButtonsToAdd = value;
            return this;
        }

        public Builder modeBarButtons(final Boolean value) {
            this.modeBarButtons = value;
            return this;
        }

        public Builder displaylogo(final Boolean value) {
            this.displaylogo = value;
            return this;
        }

        public Builder plotGlPixelRatio(final Number value) {
            this.plotGlPixelRatio = value;
            return this;
        }

        public Builder topojsonURL(final String value) {
            this.topojsonURL = value;
            return this;
        }

        public Config build() {
            return new net.java.html.plotlyjs.Config(this);
        }
    }

    public static Config.Builder builder() {
        return new Config.Builder();
    }

    private Config(Builder builder) {
        this.staticPlot = builder.staticPlot;
        this.editable = builder.editable;
        this.autosizable = builder.autosizable;
        this.fillFrame = builder.fillFrame;
        this.frameMargins = builder.frameMargins;
        this.scrollZoom = builder.scrollZoom;
        this.doubleClick = builder.doubleClick;
        this.showTips = builder.showTips;
        this.showLink = builder.showLink;
        this.sendData = builder.sendData;
        this.linkText = builder.linkText;
        this.showSources = builder.showSources;
        this.displayModeBar = builder.displayModeBar;
        this.modeBarButtonsToRemove = builder.modeBarButtonsToRemove;
        this.modeBarButtonsToAdd = builder.modeBarButtonsToAdd;
        this.modeBarButtons = builder.modeBarButtons;
        this.displaylogo = builder.displaylogo;
        this.plotGlPixelRatio = builder.plotGlPixelRatio;
        this.topojsonURL = builder.topojsonURL;
    }
    
    
}
