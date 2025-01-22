
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import static java.lang.Integer.parseInt;

// ContainerButtonHandler class for CE203 Assignment to use and modify if needed
// Date: 11/11/2022
// Author: F. Doctor

class ContainerButtonHandler implements ActionListener {
    ContainerFrame theApp;   // Reference to ContainerFrame object
    RegPolygon theReg;

    // ButtonHandler constructor
    ContainerButtonHandler(ContainerFrame app ) {
        theApp = app;
        theReg = new RegPolygon(app); // Initialize theReg with a default RegPolygon object

    }


    // The action performed method would determine what text input or button press events
    // you might have a single event handler instance where the action performed method determines
    // the source of the event, or you might have separate event handler instances.
    // You might have separate event handler classes for managing text input retrieval and button
    // press events.

    public void actionPerformed(ActionEvent e) {
        //THINGS GOING TO HAPPEN WHEN CLICKED ON DISPLAY
        if (e.getSource() == theApp.displayPolygon) {

            System.out.println("List of RegPolygons:");
            for (RegPolygon polygon : theApp.polygonList) {
                System.out.println(polygon.toString());
            }
        }


        //THINGS GOING TO HAPPEN WHEN CLICKED ON ADD
        if (e.getSource() == theApp.addPolygon) {
            String pID = theApp.RegNoTextField.getText();
            String pSides = theApp.NumberOfSidesBOX.getText();
            String pStarting_angle = theApp.StartingAngle.getText();
            String pRadius = theApp.StartingRadius.getText();


            if (pID.length() != 6 || !pID.matches("\\d{6}" )) {
                System.out.println("The Polygon '" + pID + "' was not added to the list as a valid ID was not provided. ID should be 6 digits.");
                return; // Exit the method as the ID is invalid
            }

            if (pID.startsWith("0")) {
                System.out.println("The Polygon '" + pID + "' was not added to the list as a valid ID was not provided. ID should not start with 0.");
                return; // Exit the method as the ID is invalid
            }

            int id = parseInt(pID);
            try {
                if (id < 0) {
                    System.out.println("The Polygon '" + pID + "' was not added to the list as a valid ID was not provided. ID can't be negative.");
                    return; // Exit the method as the ID is invalid
                }
            }
            catch (NumberFormatException numberFormatException) {
                System.out.println("The Polygon '" + pID + "' was not added to the list as a valid ID was not provided. ID should be only digits.");
                return; // Exit the method as the ID is invalid
            }

            // Check for duplicate IDs
            if (theReg.isIdAlreadyExists(id)) {
                System.out.println("The Polygon '" + pID + "' was not added to the list as the ID already exists. Please provide a unique ID.");
                return; // Exit the method as the ID is a duplicate
            }


            theReg.registerPolygon(parseInt(pSides), parseInt(pStarting_angle), parseInt(pRadius));
            theApp.drawSelection = 1;
            theApp.repaint();

        }

        if(e.getSource() == theApp.searchPolygon) {

            Integer enteredID = parseInt(theApp.RegNoTextField.getText());

            for(RegPolygon polygon : theApp.polygonList) {
                if (polygon.getStoredID() == enteredID) {
                    theApp.drawSelection = 1;
                    theApp.repaint();
                    polygon.displayInfo();


                    break;
                }

            }


        }

        if(e.getSource() == theApp.sortPolygon){
            Collections.sort(theApp.polygonList);
            System.out.println("Sorted List of RegPolygons:");
            for (RegPolygon polygon : theApp.polygonList) {
                System.out.println(polygon.toString());
            }

        }


        }
}

