package be.pxl.games.mastermind.view;

import java.awt.*;
import javax.swing.*;
import be.pxl.games.mastermind.model.*;
import be.pxl.games.mastermind.model.Color;

public class DisplayPanel extends JPanel {
   private static final int COLUMNS = 4;

   private JLabel[] colorLabels;
   private JLabel correctColorsLabel;
   private JLabel correctPlacesLabel;

   public DisplayPanel() {
      initComponents();
      layoutComponents();
   }

   // Public methods
   public void setResult(Color[] colors, int correctColors, int correctPlaces) {
      for (int i = 0; i < colors.length; i++)
         colorLabels[i].setBackground(translateColor(colors[i]));
      correctColorsLabel.setText(String.valueOf(correctColors));
      correctPlacesLabel.setText(String.valueOf(correctPlaces));
   }

   public void reset() {
      for(JLabel colorLabel:colorLabels)
         colorLabel.setBackground(translateColor(Color.WHITE));
      correctColorsLabel.setText(" ");
      correctPlacesLabel.setText(" ");

   }
   
   // Private methods
   private void initComponents() {
      colorLabels = new JLabel[COLUMNS];
      for (int i = 0; i < colorLabels.length; i++) {
         colorLabels[i] = new JLabel(" ");
         colorLabels[i].setOpaque(true);
      }
      correctPlacesLabel = new JLabel(" ");
      correctPlacesLabel.setHorizontalAlignment(SwingConstants.CENTER);
      correctColorsLabel = new JLabel(" ");
      correctColorsLabel.setHorizontalAlignment(SwingConstants.CENTER);
   }

   private void layoutComponents() {
      setLayout(new GridLayout(1, COLUMNS + 2,5,5));
      for (JLabel l : colorLabels) {
         add(l);
      }
      add(correctColorsLabel);
      add(correctPlacesLabel);
   }

   private java.awt.Color translateColor(Color c) {
      switch (c) {
      case BLACK:
         return java.awt.Color.BLACK;
      case CYAN:
         return java.awt.Color.CYAN;
      case GREEN:
         return java.awt.Color.GREEN;
      case RED:
         return java.awt.Color.RED;
      case WHITE:
         return java.awt.Color.WHITE;
      case YELLOW:
         return java.awt.Color.YELLOW;
      default:
         return java.awt.Color.WHITE;
      }
   }
}
