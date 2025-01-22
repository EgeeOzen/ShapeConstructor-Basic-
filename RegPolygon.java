import java.awt.*;

import static java.lang.Integer.parseInt;


// Incomplete PolygonContainer class for CE203 Assignment
// Date: 04/11/2023
// Author: F. Doctor

public class RegPolygon implements Comparable<RegPolygon>{

    Color pColor = Color.BLACK; // Colour of the polygon, set to a Colour object, default set to black
    int pId = 000000;    // Polygon ID should be a six digit non-negative integer
    int pSides;          // Number of sides of the polygon, should be non-negative value
    double pStarting_angle;   // starting angle
    double pRadius;           // radius of polygon
    int polyCenX;    // x value of centre point (pixel) of polygon when drawn on the panel
    int polyCenY;    // y value of centre point (pixel of polygon when drawn on the panel
    double [] pointsX;  // int array containing x values of each vertex (corner point) of the polygon
    double [] pointsY;  // int array containing y values of each vertex (corner point) of the polygon

    // Constructor currently sets the number of sides, starting angle of the Polygon
    // You will need to modify the constructor to set the pId and pColour fields.
    ContainerFrame containerFrame; // Add this line
    public RegPolygon(ContainerFrame containerFrame) {
        this.containerFrame = containerFrame;
    }

    public Color getColorByName(String colorName) {
        switch (colorName) {
            case "Black":
                return Color.BLACK;
            case "Red":
                return Color.RED;
            case "Green":
                return Color.GREEN;
            case "Blue":
                return Color.BLUE;
            case "Yellow":
                return Color.YELLOW;
            case "Orange":
                return Color.ORANGE;
            case "Magenta":
                return Color.MAGENTA;
            default:
                return Color.BLACK; // Default to black if the color name is not recognized
        }

    }

    public void registerPolygon(int p_sides, double st_angle, double rad) {

        RegPolygon newPolygon = new RegPolygon(containerFrame);
        this.pSides = p_sides;              // user defined number of sides should be non-negative
        this.pStarting_angle = st_angle;   // user defined starting angle
        this.pRadius = rad;
        this.pointsX = new double[p_sides];  // Initialize the pointsX array with the correct size
        this.pointsY = new double[p_sides];  // Initialize the pointsY array with the correct size// user defined radius

        String selectedColorName = (String) containerFrame.colorComboBox.getSelectedItem();
        this.pColor = getColorByName(selectedColorName);




        newPolygon.pId = parseInt(containerFrame.RegNoTextField.getText());
        newPolygon.pSides = p_sides;
        newPolygon.pStarting_angle = st_angle;
        newPolygon.pRadius = rad;
        newPolygon.pointsX = new double[p_sides];  // Initialize pointsX in the newPolygon
        newPolygon.pointsY = new double[p_sides];  // Initialize pointsY in the newPolygon

        newPolygon.pColor = getColorByName(selectedColorName);

        if (isIdAlreadyExists(newPolygon.getID())) {
            System.out.println("ID already exists. Choose a different ID.");
            return;  // Do not add the polygon if the ID already exists
        }


        System.out.println("Polygon '" + newPolygon.pId + "' has been added to the list.");
        containerFrame.polygonList.add(newPolygon);
    }


    public boolean isIdAlreadyExists(int id) {
        for (RegPolygon polygon : containerFrame.polygonList) {
            if (polygon.getStoredID() == id) {
                return true; // ID already exists
            }

        }
        return false;
    }



    // Used to populate the points array with the vertices corners (points) and construct a polygon with the
    // number of sides defined by pSides and the length of each side defined by pSideLength.
    // Dimension object that is passed in as an argument is used to get the width and height of the ContainerPanel
    // and used to determine the x and y values of its centre point that will be used to position the drawn Polygon.
    private Polygon getPolygonPoints(Dimension dim) {

        polyCenX = dim.width / 2;                  // x value of centre point of the polygon
        polyCenY = dim.height / 2;                 // y value of centre point of the polygon
        double angleIncrement = 2 * Math.PI / pSides;  // increment of each angle
        Polygon p = new Polygon();                 // Polygon to be drawn

        // Compute coordinates for n-sided regular polygon of given radius and start angle
        // All values are in radians

        // Using a for loop build up the points of polygon and iteratively assign then to the arrays
        // of points above. You could use the following equation, make sure the values are cast to (ints)

        //x = x_center + radius * math.cos(angle)
        //y = y_center + radius * math.sin(angle)

        // after completing the loop increment the angle by the angleIncrement:


        // To get cos use the Math.cos() class method
        // To get sine use the Math.sin() class method
        // to get PI use the constant Math.PI

        // Add the ith x and y points to the arrays pointsX[] and pointsY[]
        // Call addPoint() method on Polygon with arguments ith index of points
        // arrays 'pointsX[i]' and 'pointsY[i]'



        for(int i = 0; i < pSides; i++)
        {


            double x = polyCenX + pRadius * Math.cos(pStarting_angle);
            double y = polyCenY + pRadius * Math.sin(pStarting_angle);

            pointsX[i] = x;
            pointsY[i] = y;

//            p.addPoint((int)pointsX[i], (int)pointsY[i]);
            p.addPoint((int) x, (int) y);

            pStarting_angle = pStarting_angle + angleIncrement;
        }
        return p;
    }


    // You will need to modify this method to set the colour of the Polygon to be drawn
    // Remember that Graphics2D has a setColor() method available for this purpose
    public void drawPolygon(Graphics2D g, Dimension d) {

        g.setColor(pColor);
        g.drawPolygon(getPolygonPoints(d));

    }


    public int getID() {
        return parseInt(containerFrame.RegNoTextField.getText());

    }

    //     gets a stored ID
    public int getStoredID() {
        return pId;
    }

    public void displayInfo() {
        System.out.println("Polygon Information:");
        System.out.println("ID: " + pId);
        System.out.println("Color: " + pColor.toString());
        System.out.println("Number of Sides: " + pSides);
        System.out.println("Starting Angle: " + pStarting_angle);
        System.out.println("Starting Radius: " + pRadius);

    }




    @Override
    // method used for comparing PolygonContainer objects based on stored ids, you need to complete the method
    public int compareTo(RegPolygon o) {
        return Integer.compare(this.pId, o.pId);
    }


    // outputs a string representation of the PolygonContainer object, you need to complete this to use for testing
    public String toString()
    {
//        pId = parseInt(containerFrame.RegNoTextField.getText());
        return "RegPolygon[ID=" + pId + ", Color=" + pColor + ", Sides=" + pSides + "]";
    }

}
