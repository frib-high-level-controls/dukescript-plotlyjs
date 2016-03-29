/*
 * The MIT License 
 *
 * This software is Copyright by the Board of Trustees of Michigan
 * State University (c) Copyright 2016.
 * Contact Information:
 * Facility for Rare Isotope Beams
 * Michigan State University
 * East Lansing, MI 48824-1321
 * http://frib.msu.edu

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
package net.java.html.plotlyjs;

/**
 *
 * @author daykin
 */
public class Margin {
    @SuppressWarnings("unused")
    private int b;
    private int l;
    private int r;
    private int pad;
    private int t;
    private boolean autoexpand;
    
    
    public Margin(MarginBuilder builder){
        b = builder.b;
        l = builder.l;
        r = builder.r;
        pad = builder.pad;
        t = builder.t;
        autoexpand = builder.autoexpand;
    }
    

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getPad() {
        return pad;
    }

    public void setPad(int pad) {
        this.pad = pad;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public boolean isAutoexpand() {
        return autoexpand;
    }

    public void setAutoexpand(boolean autoexpand) {
        this.autoexpand = autoexpand;
    }
    
    @Override
    public String toString() {
        return "Margin{" + "b=" + b + ", l=" + l + ", r=" + r + ", pad=" + pad + ", t=" + t + ", autoexpand=" + autoexpand + '}';
    }
    
    public static class MarginBuilder{

            int b = 80;
            int l = 80;
            int r = 80;
            int pad = 0;
            int t = 100;
            boolean autoexpand = true;
       
        public MarginBuilder(){}
        
        public MarginBuilder b(int b){
            this.b = b;
            return this;
        }

        public MarginBuilder l(int l){
            this.l = l;
            return this;
        }

        public MarginBuilder r(int r){
            this.r = r;
            return this;
        }

        public MarginBuilder pad(int pad){
            this.pad = pad;
            return this;
        }

        public MarginBuilder t(int t){
            this.t = t;
            return this;
        }

        public MarginBuilder autoexpand(boolean autoexpand){
            this.autoexpand = autoexpand;
            return this;
        }

        public Margin build(){
            return new Margin(this);
        }
    }
}
