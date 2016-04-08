/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.html.plotlyjs;

import java.util.List;

/**
 *
 * @author daykin
 */
public class PolarTrace implements Trace {
    
    List<Number> r;
    List<Number> t;
    
    PolarTrace(List<Number> r,List<Number> t){
        this.r = r;
        this.t = t;
    }

    public void setR(List<Number> r) {
        this.r = r;
    }

    public void setT(List<Number> t) {
        this.t = t;
    }
    
    
    
}
