package com.dukescript.charts.sample;

import org.csstudio.scan.display.DataNotifier;
import org.csstudio.scan.display.data.Scan;

import net.java.html.json.Model;
import net.java.html.json.Property;

@Model(className = "ScanData", targetId="", properties = {
        @Property(name = "id", type = long.class),
        @Property(name = "name", type = String.class),
        @Property(name = "created", type = String.class),
        @Property(name = "percentage", type = double.class),
        @Property(name = "color", type = String.class),
        @Property(name = "visible", type = boolean.class),
        @Property(name = "x", type = String.class),
        @Property(name = "y", type = String.class)
    })
public class ScanModel implements DataNotifier {

    private static ScanData ui;
    
    ScanModel(){
        ui = new ScanData();
    }
    

    @Override
    public void scanDataUpdated(Scan scan) {

    }


    @Override
    public void scanSubmitted(Scan scan) {

    }

}
