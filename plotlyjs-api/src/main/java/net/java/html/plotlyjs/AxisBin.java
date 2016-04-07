/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.html.plotlyjs;

/**
 *
 * @author daykin
 */
public class AxisBin {
   private Number start;
   private Number end;
   private Number size;

    public static class Builder {

        private Number start;
        private Number end;
        private Number size = 1;

        private Builder() {
        }

        public Builder start(final Number value) {
            this.start = value;
            return this;
        }

        public Builder end(final Number value) {
            this.end = value;
            return this;
        }

        public Builder size(final Number value) {
            this.size = value;
            return this;
        }

        public AxisBin build() {
            return new net.java.html.plotlyjs.AxisBin(start, end, size);
        }
    }

    public static AxisBin.Builder builder() {
        return new AxisBin.Builder();
    }

    private AxisBin(final Number start, final Number end, final Number size) {
        this.start = start;
        this.end = end;
        this.size = size;
    }
   
}
