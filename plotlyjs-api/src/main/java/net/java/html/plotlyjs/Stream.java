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
public class Stream {
    private String token;
    private Integer maxpoints;
    
    public Stream(String token){
        this.token = token;
        this.maxpoints = 50;
    }
    
    public Stream(String token, Integer maxpoints){
        this.token=token;
        this.maxpoints = maxpoints;
    }
    
    public void setToken(String token){
        this.token = token;
    }
    
    public void setMaxPoints(Integer maxpoints){
        this.maxpoints = maxpoints;
    }
    
    public String getToken(){
        return this.token;
    }
    
    public Integer getMaxPoints(){
        return this.maxpoints;
    }
}
