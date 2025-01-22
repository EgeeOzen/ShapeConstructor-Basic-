import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

import static java.lang.Integer.parseInt;


// ContainerPanel class for CE203 Assignment to use and modify if needed
// Date: 04/11/2023
// Author: F. Doctor

public class ContainerPanel extends JPanel{

    ContainerFrame conFrame;


    public ContainerPanel(ContainerFrame cf) {
        conFrame = cf;   // reference to ContainerFrame object
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D comp = (Graphics2D)g;   // You will need to use a Graphics2D objects for this
        Dimension size = getSize();        // You will need to use this Dimension object to get
                                           // the width / height of the JPanel in which the
                                           // Polygon is going to be drawn

        // Based on which stored PolygonContainer object you want to be retrieved from the
        // ArrayList and displayed, the object would be accessed and its drawPolygon() method
        // would be called here.

        // modify this to search for IDs to retrieve the
        if (conFrame.drawSelection == 1) {
            int targetID = parseInt(conFrame.RegNoTextField.getText());// specify the ID you are searching for;
//             Iterate through the polygonList to find the polygon with the specified ID
            for (RegPolygon polygon : conFrame.polygonList) {
                if (polygon.getStoredID() == targetID) {

                    // Do something with the found polygon, e.g., print its information
        //                    polygon.drawPolygon(comp, size);
                    polygon.drawPolygon(comp, size);
                    System.out.println("Found Polygon with ID " + targetID + ": " + polygon.toString());
                    break; // Assuming IDs are unique, exit the loop once a match is found
                }
             }
        }


    }
}
