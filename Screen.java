import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea; 
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Graphics;

import java.io.*;
import java.util.Scanner;
import java.awt.Dimension;

import java.awt.Color;
import java.awt.Font; 

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image; 


public class Screen extends JPanel implements ActionListener{ 
    private boolean show1; 
    private boolean show2;
    private boolean show3;
    private boolean show4;
    private boolean show5;
    private boolean show6;
    private boolean show7;
    private boolean show8;
    private boolean show9;
    private boolean show10;
    private boolean show11;
    private boolean show12;
    private boolean show13;
    private boolean show14;
    private boolean show15;
    private boolean show16;
    private boolean show17;
    private boolean show18;
    private boolean show19;
    private boolean show20;

    private BufferedImage image; 
    private BufferedImage image2; 
    private BufferedImage image3; 
    private BufferedImage image4; 
    private BufferedImage image5; 
    private BufferedImage image6; 
    private BufferedImage image7; 
    private BufferedImage image8; 
    private BufferedImage image9; 
    private BufferedImage image10; 
    private BufferedImage image11; 
    private BufferedImage image12; 
    private BufferedImage image13; 
    private BufferedImage image14; 
    private BufferedImage image15; 
    private BufferedImage image16; 
    private BufferedImage image17; 
    private BufferedImage image18; 
    private BufferedImage image19; 
    private BufferedImage image20; 

    //textfields
    private JTextField start; 
    private JTextField end; 

    //buttons
    private JButton enter; 

    //textareas
    private JTextArea displayKeys; 
    private JTextArea displayDirections; 

    //images 
    private BufferedImage background; 

    //fonts 
    private Font plainFont; 
    private Font italicFont;

    //graph - containing locations + distances 
    private WGraph<Location> map; 

    //connections stored
    private Connections<Location> connections; 

    //dllist
    private DLList<Location> locations; 

    //strings 
    private String keyDisplayString; 
    private String directions; 
    private String highway; 


	public Screen(){
        show1 = false; 
        show2 = false; 
        show3 = false; 
        show4 = false; 
        show5 = false; 
        show6 = false; 
        show7 = false; 
        show8 = false; 
        show9 = false; 
        show10 = false; 
        show11 = false; 
        show12 = false; 
        show13 = false; 
        show14 = false; 
        show15 = false; 
        show16 = false; 
        show17 = false; 
        show18 = false; 
        show19 = false; 
        show20 = false; 


        try{
			image = ImageIO.read(new File("1_.png"));
		} catch (IOException e) {} 
        try{
			image2 = ImageIO.read(new File("2_.png"));
		} catch (IOException e) {} 
        try{
			image3 = ImageIO.read(new File("3_.png"));
		} catch (IOException e) {}
        try{
			image4 = ImageIO.read(new File("4_.png"));
		} catch (IOException e) {} 
        try{
			image5 = ImageIO.read(new File("5_.png"));
		} catch (IOException e) {} 
        try{
			image6 = ImageIO.read(new File("6_.png"));
		} catch (IOException e) {} 
        try{
			image7 = ImageIO.read(new File("7_.png"));
		} catch (IOException e) {} 
        try{
			image8 = ImageIO.read(new File("8_.png"));
		} catch (IOException e) {} 
        try{
			image9 = ImageIO.read(new File("9_.png"));
		} catch (IOException e) {} 
        try{
			image10 = ImageIO.read(new File("10_.png"));
		} catch (IOException e) {} 
        try{
			image11 = ImageIO.read(new File("11_.png"));
		} catch (IOException e) {} 
        try{
			image12 = ImageIO.read(new File("12_.png"));
		} catch (IOException e) {} 
        try{
			image13 = ImageIO.read(new File("13_.png"));
		} catch (IOException e) {} 
        try{
			image14 = ImageIO.read(new File("14_.png"));
		} catch (IOException e) {} 
        try{
			image15 = ImageIO.read(new File("15_.png"));
		} catch (IOException e) {} 
        try{
			image16 = ImageIO.read(new File("16_.png"));
		} catch (IOException e) {} 
        try{
			image17 = ImageIO.read(new File("17_.png"));
		} catch (IOException e) {} 
        try{
			image18 = ImageIO.read(new File("18_.png"));
		} catch (IOException e) {} 
        try{
			image19 = ImageIO.read(new File("19_.png"));
		} catch (IOException e) {} 
        try{
			image20 = ImageIO.read(new File("20_.png"));
		} catch (IOException e) {} 
        


        //textfields
        start = new JTextField(); 
        start.setBounds(1080, 426, 100, 30); 

        end = new JTextField(); 
        end.setBounds(1080, 462, 100, 30); 

        //buttons
        enter = new JButton("Enter"); 
        enter.setBounds(1050, 500, 100, 30); 

        //textareas
        displayKeys = new JTextArea(); 
        displayKeys.setBounds(970, 40, 300, 330); 
        displayKeys.setEditable(false); 
        displayKeys.setFont(plainFont); 

        displayDirections = new JTextArea();
        displayDirections.setBounds(880, 530, 475, 235); 
        displayDirections.setEditable(false); 
        displayDirections.setFont(plainFont); 

        //graph/map 
        map = new WGraph<Location>(); 

        //connections stored
        connections = new Connections<Location>(); 

        //dllist of locations 
        locations = new DLList<Location>(); 
        locations.add(new Location("Rome", "ROM"));
        locations.add(new Location("Florence", "FLR"));
        locations.add(new Location("Venice", "VCE"));
        locations.add(new Location("Cinque Terre", "CTE"));
        locations.add(new Location("Amalfi Coast", "AMC"));
        locations.add(new Location("Sicily", "SIC"));
        locations.add(new Location("Pisa", "PSA"));
        locations.add(new Location("Naples", "NAP"));
        locations.add(new Location("Bari", "BRI"));
        locations.add(new Location("Lake Como", "COM"));
        locations.add(new Location("Milan", "LIN"));
        locations.add(new Location("The Dolomites", "DOL"));
        locations.add(new Location("Lake Garda", "GAR"));
        locations.add(new Location("Pescara", "PSR"));
        locations.add(new Location("Foggia", "FOG"));
        locations.add(new Location("Lecce", "LEC"));
        locations.add(new Location("Turin", "TRN"));
        locations.add(new Location("Grosseto", "GRS"));
        locations.add(new Location("Assisi", "ISI"));
        locations.add(new Location("Bologna", "BOL"));

        //add locations to weighted graph
        for(int i = 0; i < locations.size(); i++){
            map.add(locations.get(i)); 
            connections.add(locations.get(i));
        }

        //add distances/weight to the graph 
        map.addEdge(locations.get(2), locations.get(1), 270); 
        connections.addConnection(locations.get(2), locations.get(1), 1);
        map.addEdge(locations.get(2), locations.get(10), 278);
        connections.addConnection(locations.get(2), locations.get(10), 2);
        map.addEdge(locations.get(2), locations.get(11), 165); 
        connections.addConnection(locations.get(2), locations.get(11), 3);

        map.addEdge(locations.get(10), locations.get(2), 278); 
        connections.addConnection(locations.get(10), locations.get(2), 2);
        map.addEdge(locations.get(10), locations.get(9), 82); 
        connections.addConnection(locations.get(10), locations.get(9), 4);
        map.addEdge(locations.get(10), locations.get(16), 143);
        connections.addConnection(locations.get(10), locations.get(16), 5);

        map.addEdge(locations.get(16), locations.get(10), 143); 
        connections.addConnection(locations.get(16), locations.get(10), 5);
        
        map.addEdge(locations.get(9), locations.get(10), 82);
        connections.addConnection(locations.get(9), locations.get(10), 4);

        map.addEdge(locations.get(13), locations.get(0), 209); 
        connections.addConnection(locations.get(13), locations.get(0), 6);
        map.addEdge(locations.get(13), locations.get(14), 185);
        connections.addConnection(locations.get(13), locations.get(14), 7);
        map.addEdge(locations.get(13), locations.get(18), 233); 
        connections.addConnection(locations.get(13), locations.get(18), 8);

        map.addEdge(locations.get(18), locations.get(13), 233); 
        connections.addConnection(locations.get(18), locations.get(13), 8);

        map.addEdge(locations.get(14), locations.get(13), 185);
        connections.addConnection(locations.get(14), locations.get(13), 7);

        map.addEdge(locations.get(12), locations.get(11), 184); 
        connections.addConnection(locations.get(12), locations.get(11), 9);

        map.addEdge(locations.get(11), locations.get(12), 184); 
        connections.addConnection(locations.get(11), locations.get(12), 9);
        map.addEdge(locations.get(11), locations.get(2), 165);
        connections.addConnection(locations.get(11), locations.get(2), 3);
        
        map.addEdge(locations.get(1), locations.get(2), 270); 
        connections.addConnection(locations.get(1), locations.get(2), 1);
        map.addEdge(locations.get(1), locations.get(0), 274); 
        connections.addConnection(locations.get(1), locations.get(0), 10);
        map.addEdge(locations.get(1), locations.get(6), 88);
        connections.addConnection(locations.get(1), locations.get(6), 11);

        map.addEdge(locations.get(0), locations.get(1), 274); 
        connections.addConnection(locations.get(0), locations.get(1), 10);
        map.addEdge(locations.get(0), locations.get(4), 279);
        connections.addConnection(locations.get(0), locations.get(4), 12);
        map.addEdge(locations.get(0), locations.get(13), 209);
        connections.addConnection(locations.get(0), locations.get(13), 6);

        map.addEdge(locations.get(4), locations.get(5), 605);
        connections.addConnection(locations.get(4), locations.get(5), 13);
        map.addEdge(locations.get(4), locations.get(0), 279); 
        connections.addConnection(locations.get(4), locations.get(0), 12);
        map.addEdge(locations.get(4), locations.get(7), 61);
        connections.addConnection(locations.get(4), locations.get(7), 14);

        map.addEdge(locations.get(7), locations.get(4), 61); 
        connections.addConnection(locations.get(7), locations.get(4), 14);

        map.addEdge(locations.get(8), locations.get(5), 595); 
        connections.addConnection(locations.get(8), locations.get(5), 15);
        map.addEdge(locations.get(8), locations.get(15), 153);
        connections.addConnection(locations.get(8), locations.get(15), 16);
        
        map.addEdge(locations.get(15), locations.get(8), 153); 
        connections.addConnection(locations.get(15), locations.get(8), 16);

        map.addEdge(locations.get(5), locations.get(4), 605);
        connections.addConnection(locations.get(5), locations.get(4), 13);
        map.addEdge(locations.get(5), locations.get(8), 595); 
        connections.addConnection(locations.get(5), locations.get(8), 15);

        map.addEdge(locations.get(3), locations.get(6), 117);
        connections.addConnection(locations.get(3), locations.get(6), 17);
        map.addEdge(locations.get(3), locations.get(19), 256);
        connections.addConnection(locations.get(3), locations.get(19), 18);

        map.addEdge(locations.get(19), locations.get(3), 256); 
        connections.addConnection(locations.get(19), locations.get(3), 18);

        map.addEdge(locations.get(6), locations.get(3), 117);
        connections.addConnection(locations.get(6), locations.get(3), 17);
        map.addEdge(locations.get(6), locations.get(1), 88); 
        connections.addConnection(locations.get(6), locations.get(1), 11);
        map.addEdge(locations.get(6), locations.get(17), 158);
        connections.addConnection(locations.get(6), locations.get(17), 19);

        map.addEdge(locations.get(17), locations.get(6), 158); 
        connections.addConnection(locations.get(17), locations.get(6), 19);

        map.addEdge(locations.get(2), locations.get(18), 403); 
        connections.addConnection(locations.get(2), locations.get(18), 20);
        map.addEdge(locations.get(18), locations.get(2), 403); 
        connections.addConnection(locations.get(18), locations.get(2), 20);



        try{
			background = ImageIO.read(new File("background.png"));
		} catch (IOException e) {}

        //fonts 
        plainFont = new Font("Monospcaed", Font.PLAIN, 13); 
        italicFont = new Font("Monospcaed", Font.ITALIC, 13);

        //strings 
        keyDisplayString = ""; 
        directions = ""; 
        highway = ""; 

        

        setLayout(null); 

        //add textFields
        add(start); 
        add(end); 
        
        //add buttons
        add(enter); 

        //add textareas
        add(displayKeys); 
        add(displayDirections);

        //add ActionListener to buttons 
        enter.addActionListener(this); 
        
        


        
    }
	

	//set the size of the JPanel container
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(1400,800);
	}
	
	@Override
	public void paintComponent(Graphics g){
        //background 
        g.setColor(new Color(255, 253, 208)); 
        g.fillRect(0, 0, 1400, 800); 
        g.drawImage(background, 0, 0, null); 

        //key 
        g.setColor(Color.BLACK); 
        g.setFont(plainFont); 
        g.drawString("Key: ", 1100, 30); 
        keyString();
        displayKeys.setText(keyDisplayString); 
        displayDirections.setText(directions);

        //search distance 
        g.drawString("Find the shortest path of travel between 2 locations", 960, 390);
        g.setFont(italicFont); 
        g.drawString("Enter the abbreviation of both locations below", 970, 412); 
        g.drawString("From: ", 1010, 440); 
        g.drawString("To: ", 1010, 480); 

        if(show1  == true){
            g.drawImage(image, 0, 0, null); 
        }
        if(show2 == true){
            g.drawImage(image2, 0, 0, null); 
        }
        if(show3 == true){
            g.drawImage(image3, 0, 0, null); 
        }
        if(show4 == true){
            g.drawImage(image4, 0, 0, null); 
        }
        if(show5 == true){
            g.drawImage(image5, 0, 0, null); 
        }
        if(show6 == true){
            g.drawImage(image6, 0, 1, null); 
        }
        if(show7 == true){
            g.drawImage(image7, 0, 1, null);
        }
        if(show8 == true){
            g.drawImage(image8, 0, 1, null);
        }
        if(show9 == true){
            g.drawImage(image9, 0, 1, null);
        }
        if(show10 == true){
            g.drawImage(image10, 0, 1, null);
        }
        if(show11 == true){
            g.drawImage(image11, 0, 1, null);
        }
        if(show12 == true){
            g.drawImage(image12, 0, 1, null);
        }
        if(show13 == true){
            g.drawImage(image13, 0, 1, null);
        }
        if(show14 == true){
            g.drawImage(image14, 0, 1, null);
        }
        if(show15 == true){
            g.drawImage(image15, 0, 1, null);
        }
        if(show16 == true){
            g.drawImage(image16, 0, 1, null);
        }
        if(show17 == true){
            g.drawImage(image17, 0, 1, null);
        }
        if(show18 == true){
            g.drawImage(image18, 0, 1, null);
        }
        if(show19 == true){
            g.drawImage(image19, 0, 1, null);
        }
        if(show20 == true){
            g.drawImage(image20, 0, 0, null);
        }

        
    }

    public void keyString(){
        keyDisplayString = ""; 
        String[] locArray = locations.toString().split(", "); 
        for(int i = 0; i < locArray.length; i++){
            keyDisplayString += locArray[i] + "\n"; 
        }
        
    }

	//action to be performed when a button is clicked
	public void actionPerformed(ActionEvent e){
        if(e.getSource() == enter){
            directions = ""; 
            int totalDistance = 0; 
            show1 = false; 
            show2 = false; 
            show3 = false; 
            show4 = false; 
            show5 = false; 
            show6 = false; 
            show7 = false; 
            show8 = false; 
            show9 = false; 
            show10 = false; 
            show11 = false;     
            show12 = false; 
            show13 = false; 
            show14 = false; 
            show15 = false; 
            show16 = false; 
            show17 = false; 
            show18 = false; 
            show19 = false; 
            show20 = false;
            String startLoc = start.getText(); 
            String endLoc = end.getText(); 
            Location newStart = null;
            Location newEnd = null; 
            for(int i = 0; i < locations.size(); i++){
                if(locations.get(i).getAbv().equals(startLoc)){
                    newStart = locations.get(i); 
                }
                else if(locations.get(i).getAbv().equals(endLoc)){
                    newEnd = locations.get(i); 
                }
            }

            DLList<Location> reversedList = map.shortestPath(newStart, newEnd); 
            for(int i = reversedList.size()-1; i >= 0; i --){
                if(map.findWeight(reversedList.get(i), reversedList.get(i-1)) != -1){
                    int roadToDisplay = connections.connectionNum(reversedList.get(i), reversedList.get(i-1));
                    if(roadToDisplay == 1){
                        show1 = true; 
                        highway = "A13";
                    }
                    else if(roadToDisplay == 2){
                        show2 = true; 
                        highway = "A4";
                    }
                    else if(roadToDisplay == 3){
                        show3 = true; 
                        highway = "A27";
                    }
                    else if(roadToDisplay == 4){
                        show4 = true; 
                        highway = "A9 and E35";
                    }
                    else if(roadToDisplay == 5){
                        show5 = true; 
                        highway = "A4";
                    }
                    else if(roadToDisplay == 6){
                        show6 = true; 
                        highway = "A25 and A24";
                    }
                    else if(roadToDisplay == 7){
                        show7 = true; 
                        highway = "A14";
                    }
                    else if(roadToDisplay == 8){
                        show8 = true; 
                        highway = "A14 and SS77";
                    }
                    else if(roadToDisplay == 9){
                        show9 = true; 
                        highway = "A22 and E45";
                    }
                    else if(roadToDisplay == 10){
                        show10 = true; 
                        highway = "A1 and E35";
                    }
                    else if(roadToDisplay == 11){
                        show11 = true; 
                        highway = "A11 and E76";
                    }
                    else if(roadToDisplay == 12){
                        show12 = true; 
                        highway = "E45";
                    }
                    else if(roadToDisplay == 13){
                        show13 = true; 
                        highway = "A2";
                    }
                    else if(roadToDisplay == 14){
                        show14 = true; 
                        highway = "A3";
                    }
                    else if(roadToDisplay == 15){
                        show15 = true; 
                        highway = "A2";
                    }
                    else if(roadToDisplay == 16){
                        show16 = true; 
                        highway = "SS379"; 
                    }
                    else if(roadToDisplay == 17){
                        show17 = true; 
                        highway = "A12 and E80";
                    }
                    else if(roadToDisplay == 18){
                        show18 = true; 
                        highway = "A15 and A1";
                    }
                    else if(roadToDisplay == 19){
                        show19 = true; 
                        highway = "E80"; 
                    }
                    else if(roadToDisplay == 20){
                        show20 = true; 
                        highway = "SS309"; 
                    }
                    if(i == reversedList.size()-1){
                        directions += "Take " + reversedList.get(i).getName() + " to " + reversedList.get(i-1).getName() + " via highway " + highway + " - " + map.findWeight(reversedList.get(i), reversedList.get(i-1)) + "km\n";
                        totalDistance += map.findWeight(reversedList.get(i), reversedList.get(i-1));
                    }
                    else{
                        directions += "Then take " + reversedList.get(i).getName() + " to " + reversedList.get(i-1).getName() + " via highway " + highway +  " - " + map.findWeight(reversedList.get(i), reversedList.get(i-1)) + "km\n";
                        totalDistance += map.findWeight(reversedList.get(i), reversedList.get(i-1));
                    }
                    
                }
            }
            directions += "The total distance is " + totalDistance + "km";

            start.setText(""); 
            end.setText(""); 



        }

        repaint(); 
	}


}
