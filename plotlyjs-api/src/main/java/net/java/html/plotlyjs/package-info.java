package net.java.html.plotlyjs;
/**
 * 
 * <h3>Plotly for Dukescript</h3> A
 * <a href="https://dukescript.com/">Dukescript</a>-based Java wrapper for <a href="https://plot.ly/javascript/">Plotly.js</a>.
 * <h4>Typical Usage</h4> In order to construct a basic chart, the prototype is generally as follows: <br>
 * <ol>
 * <li> in your view, include Plotly.js and create a container for your plot as outlined <a href="https://plot.ly/javascript/getting-started/">here.</a>
 * <li>Put the data to be plotted in a {@link java.util.List}.</li>
 * <li>Construct one or more {@link Trace}s  with the specified data.</li>
 * <li>Build one or more {@link Chart}s with the trace type as the parameter.</li>
 * <li>Construct a {@link PlotlyData} object with the <code>Chart< &lt;some Trace&gt; ></code> as the type parameter. </li>
 * <li>Call {@link Plotly#newPlot(String,PlotlyData,Layout)}, or {@link Plotly#newPlot(String,PlotlyData,Layout,Config)} for advanced options</li>
 * <li>Enjoy the magic of Plotly.</li>
 * </ol>
 * <h3>Example</h3>
 * <code>
 * 	&#47;&#47;constructing a simple sine graph in a div called "myScatter" with 480x400px dimensions...<br>
 *  &#09; List<Number> scatter0x = new ArrayList<>();<br>
 *   &#09;List<Number> scatter0y = new ArrayList<>();<br>
 *   &#09;for(double t = 0;t<4*Math.PI;t+=0.1){<br>
 *    &#09;&#09;    scatter0x.add(t);<br>
 *   &#09;&#09;    scatter0y.add(Math.sin(t));<br>
 *   &#09;}<br>
 *   &#09;CartesianTrace scatterTrace0 = new CartesianTrace(scatter0x,scatter0y);<br>
 *   &#09;Scatter<CartesianTrace> scatter0 = Scatter.<CartesianTrace>builder().trace(scatterTrace0).build();<br>
 *   &#09;PlotlyData<Scatter<CartesianTrace>> scatterData = new PlotlyData<>(scatter0);<br>
 *   &#09;Plotly<Scatter<CartesianTrace>> scatter = Plotly.
 *   &#09;&#09;       newPlot("myScatter", scatterData, new Layout.Builder()<br>
 *   &#09;&#09;               .title("Scatter with Click Event")<br>
 *   &#09;&#09;               .width(480)<br>
 *   &#09;&#09;               .height(400)<br>
 *   &#09;&#09;               .build());<br>
 * </code>
 * 
 * @author daykin &lt;daykin at frib msu edu&gt; </span>
 */