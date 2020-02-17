/**
(1) Name: Dakota Morgan  
(2) Date: 9/16/2019 
(3) Instructor: Ms Tucker 
(4) Class: CIT249 Java II  
(5) Purpose: Create a "Lights" game where player must select 8 colors.
    Will display colors selected in order when "Remember Game" button is selected.
    Start a new game at any time using the "New Game" button.
**/

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.File;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class frequencyAnalysisPane extends HBox
{
    /** 
     * Declare variables and objects.
     */
    private Label[] alphaLabel = new Label[26];
    private VBox[] alphaFrequencyVBox = new VBox[26];
    private Label[] alphaFrequencyLabel = new Label[26];
    private float[] alphaPercentage = cryptoDriver.getAlphaOccuranceRate();
    private GraphicsContext[] graphicsContext = new GraphicsContext[26];
    private Canvas[] canvas = new Canvas[26];
    
    private Color binColor = Color.rgb(0, 200, 200);
    
    public frequencyAnalysisPane()
    {
    /** 
     * Set Pane(HBox) formatting.
     */
    setAlignment(Pos.CENTER);
    setPadding(new Insets(10, 10, 10, 10));
    setMinSize(1000, 450);
    setSpacing(8);

    
    char letter;
    for (int i = 0; i < 26; i++){
       /**
        * Create alphaFrequencyVBox containers for each letter, 
        * Create new labels for letter frequency and format
        */
       alphaFrequencyVBox[i] = new VBox();
       alphaFrequencyLabel[i] = new Label(String.format("%3.2f", alphaPercentage[i] * 100));
       
       /**
        * Create canvas containers for each letter, setting height equal to ratio.
        * Set color of each rectangle to binColor and fill.
        */
       canvas[i] = new Canvas(20, 200);
       graphicsContext[i] = canvas[i].getGraphicsContext2D();
       graphicsContext[i].setFill(binColor);
       graphicsContext[i].fillRect(0, 10, 50, alphaPercentage[i] * 1000);
       
       /**
        * Create labels for letters
        */
       letter = (char) (i + 65);
       alphaLabel[i] = new Label(Character.toString(letter));
       
       /**
        * Add labels and rectangle to each letters VBox
        * Add VBoxes to main HBox Pane
        */
       alphaFrequencyVBox[i].getChildren().addAll(alphaLabel[i], alphaFrequencyLabel[i], canvas[i]);
       getChildren().addAll(alphaFrequencyVBox[i]);
    }
    }
}