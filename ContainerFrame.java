import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


// ContainerFrame class for CE203 Assignment to use and modify if needed
// Date: 04/11/2023
// Author: F. Doctor

// A skeleton JFrame class has been provided which you would need to modifiy to include the other GUI components
// data structre and functionality specified in the assignment specification
public class ContainerFrame extends JFrame{

//    JButton drawPolygon1;    // Example Button to select Polygon 1 to draw
    JComboBox<String> colorComboBox;
    JButton displayPolygon;
    JTextField RegNoTextField;
    JTextField NumberOfSidesBOX;
    JTextField StartingAngle;
    JTextField StartingRadius;
    JButton addPolygon;
    JButton searchPolygon;
    JButton sortPolygon;
    int drawSelection = 0;   // Selection variable to determine which Polygon is selected to be drawn
    ArrayList<RegPolygon> polygonList = new ArrayList<>();

    // Here I have provided an example of one PolygonContainer objects where the number of sides
    // and side length of the polygon are hardcoded.
    // These should be input from the application text fields where the user would type them in.
    // This would create new PolygonContainer objects that would be stored in and accessed from
    // an ArrayList data structure rather than be explicitly defined as below

//    RegPolygon polyContain1 = new RegPolygon(5, 10, 100);

    public void createComponents() {
        JPanel drawPanel = new ContainerPanel(this);
        ContainerButtonHandler cbHandler = new ContainerButtonHandler(this);

        //Adding Display Button and Layout
        JPanel buttPanel = new JPanel();
        buttPanel.setLayout(new FlowLayout());
        displayPolygon = new JButton("Display");
        displayPolygon.setPreferredSize(new Dimension(200,50));
        displayPolygon.addActionListener(cbHandler);
        buttPanel.add(displayPolygon);


        //Adding ADD Button and Layout
        buttPanel.setLayout(new FlowLayout());
        addPolygon = new JButton("ADD");
        addPolygon.setPreferredSize(new Dimension(200,50));
        addPolygon.addActionListener(cbHandler);
        buttPanel.add(addPolygon);


        //Adding Search Button and Layout
        buttPanel.setLayout(new FlowLayout());
        searchPolygon = new JButton("Search");
        searchPolygon.setPreferredSize(new Dimension(200,50));
        searchPolygon.addActionListener(cbHandler);
        buttPanel.add(searchPolygon);


        //Adding Sort Button and Layout
        buttPanel.setLayout(new FlowLayout());
        sortPolygon = new JButton("Sort");
        sortPolygon.setPreferredSize(new Dimension(200,50));
        sortPolygon.addActionListener(cbHandler);
        buttPanel.add(sortPolygon);



        //Adding RegisterID Input TextBox
        JPanel userInputPanel = new JPanel();


        userInputPanel.setLayout(new FlowLayout());
        RegNoTextField = new JTextField(20);
        userInputPanel.add(new JLabel("RegID:"));
        userInputPanel.add(RegNoTextField);

        //Adding Number of Sides Box
        userInputPanel.setLayout(new FlowLayout());
        NumberOfSidesBOX = new JTextField(20);
        userInputPanel.add(new JLabel("NumberOfSides:"));
        userInputPanel.add(NumberOfSidesBOX);

        //Adding the Starting Angle Box
        userInputPanel.setLayout(new FlowLayout());
        StartingAngle = new JTextField(20);
        userInputPanel.add(new JLabel("Starting Angle:"));
        userInputPanel.add(StartingAngle);

        // Adding the Radius Box
        userInputPanel.setLayout(new FlowLayout());
        StartingRadius = new JTextField(20);
        userInputPanel.add(new JLabel("StartingRadius:"));
        userInputPanel.add(StartingRadius);



        //Adding the Color Choosing Box
        userInputPanel.setLayout(new FlowLayout());
        colorComboBox = new JComboBox<>(new String[]{"Black","Red", "Green", "Blue", "Yellow", "Orange", "Magenta"});
        userInputPanel.add(new JLabel("Select Color:"));
        userInputPanel.add(colorComboBox);


        //Laying Out the Panels in BorderLayout
        add(userInputPanel,BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(buttPanel, BorderLayout.SOUTH);
        setSize(1300, 500);
        setVisible(true);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	// Close action.
    }


    public static void main(String[] args) {

        ContainerFrame cFrame = new ContainerFrame();
        cFrame.createComponents();
    }

}
