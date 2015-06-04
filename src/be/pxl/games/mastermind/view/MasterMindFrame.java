package be.pxl.games.mastermind.view;

import java.awt.*;
import javax.swing.*;
import be.pxl.games.mastermind.controller.*;
import be.pxl.games.mastermind.model.Color;

public class MasterMindFrame extends JFrame {
   private MasterMindController controller;   
   private InputPanel inputPanel;
   private DisplayPanel[] displayPanels;   
   private static final int ROWS = 11;
   
   public MasterMindFrame(MasterMindController controller) {
      super("Mastermind");
      this.controller = controller;
      initComponents();      
      layoutComponents();
      setVisible(true);
   }


   // Public methods
   public void setResult(int guess, Color[] colors, int correctColors, int correctPlaces) {

         displayPanels[guess].setResult(colors,correctColors,correctPlaces);

      if (guess == ROWS-1)
         disable();
   }
   
   public void reset() {
      for(DisplayPanel panel: displayPanels) {
         panel.reset();
      }
      inputPanel.reset();     
   }
   
   public void disable() {
      inputPanel.disable();
   }
   
   
   // Private methods
   private void initComponents() {     
      // Create input panel
      inputPanel = new InputPanel(controller);
      
      // Create display panels
      displayPanels = new DisplayPanel[ROWS];
      for(int i = 0; i < displayPanels.length; i++) {
         displayPanels[i] = new DisplayPanel();
      }
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(500, 700);
      setLocation(20, 20);
   }

   private void layoutComponents() {
      setLayout(new GridLayout(ROWS+1,1,5,5));
      
      for(DisplayPanel dp: displayPanels) {
         add(dp);
      }
      add(inputPanel);
   }   
}
