
/**
 * Write a description of class cryptoDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class cryptoDriver extends Application
{
    private static final short ALPHABET_LENGTH = 32;
    private static final short ALPHA_UPPER_LOWER_DIFFERENCE = 32;
    private static int[] alphaFrequency = new int[26];
    private static float[] alphaOccuranceRate = new float[26];
    private static int alphaTotalCount = 0;
    private static int charTotalCount = 0;
    private static int readStatus;
    private static FileReader inFile = null;
    
    public void start(Stage primaryStage) throws  IOException
    {
        
        
        try
        {
            /** 
             * Open the input file
             */
            inFile = new FileReader("encrypted.csv");

            while ((readStatus = inFile.read()) != -1)
            {
                /** 
                 * Use char type and increment through alphabet for each character
                 * read. Add 1 to total character count.
                 */
                for (char i = 'a'; i <= 'z'; i++){
                    /** 
                     * If read status is equal to i letter in alphabet or it's lowercase
                     * equivalent, output letter detected, add counter to appropriate 
                     * position in array
                     */
                    if (readStatus == i || readStatus == i - ALPHA_UPPER_LOWER_DIFFERENCE){
                        alphaFrequency[i - 'a']++;
                    }
                }
                charTotalCount++;
            }
            
            /** 
             * Add each letter count(alphaFrequency[]) to alphaTotalCount
             */
            for (char i = 'a'; i <= 'z'; i++){
                alphaTotalCount += alphaFrequency[i - 'a'];
            }
            
            /** 
             * If there are letters found, find the percentage rate of each letter's
             * occurence. Otherwise set to 0, since all letter's count must each be 0.
             */
            if (alphaTotalCount > 0){
                for (int i = 0; i < 26; i++){
                    alphaOccuranceRate[i] = alphaFrequency[i] / (float) alphaTotalCount;
                }
            }
            else{
                for (int i = 0; i < 26; i++){
                    alphaOccuranceRate[i] = (float) 0.0;
                }
            }
        }
        finally
        {
            /** 
             * Close input file after processing
             */
            if (inFile != null)
            {
                inFile.close();
            }    
        }
        
        /** 
         * Set scene on stage and set title.
         */
        Scene scene = new Scene(new frequencyAnalysisPane(), 1000, 450);

        primaryStage.setTitle("Frequency Analysis");
        primaryStage.setScene(scene);

        /** 
         * Show the Stage (window).
         */
        primaryStage.show();
    }
    
    public static void main (String[] args)
    {
        Application.launch(args);
    }
    
    /** 
     * Accessor for alphaOccurenceRate[]
     */
    public final static float[] getAlphaOccuranceRate(){
        return alphaOccuranceRate;
    }
 }
