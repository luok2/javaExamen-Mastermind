package be.pxl.games.mastermind.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import be.pxl.games.mastermind.controller.*;
import be.pxl.games.mastermind.model.*;
import be.pxl.games.mastermind.model.Color;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class InputPanel extends JPanel {
   private static final int COLUMNS = 4;
   private MasterMindController controller;
   private JComboBox[] colorChoices;
   private JButton guessButton;
   private JButton resetButton;

   public InputPanel(MasterMindController controller) {
      this.controller = controller;
      initComponents();
      layoutComponents();
      initListeners();
   }

   // Public methods
   public void reset() {
      for(JComboBox cc: colorChoices) {
         cc.setSelectedIndex(0);
         cc.setEnabled(true);
      }
      guessButton.setEnabled(true);
   }
   
   public void disable() {
      for(JComboBox cc: colorChoices) {
         cc.setEnabled(false);
      }
      guessButton.setEnabled(false);
   }
   
   // Private methods
   private void initComponents() {
      colorChoices = new JComboBox[COLUMNS];
      for (int i = 0; i < colorChoices.length; i++) {
         colorChoices[i] = new JComboBox(Color.values());         
      }
      guessButton = new JButton("Guess");
      resetButton = new JButton("Reset");
   }

   private void layoutComponents() {
      setLayout(new GridLayout(1, COLUMNS + 2,5,5));
      for (JComboBox cc : colorChoices) {
         add(cc);
      }
      add(guessButton);
      add(resetButton);
   }

   private void initListeners() {
      // Vraag 5: voeg event handlers toe

      guessButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Guess guess = new Guess();
            for (int i = 0; i < colorChoices.length; i++) {
               Color theColor = Color.WHITE;
               for (Color color:Color.values())
               {
                  if (colorChoices[i].getSelectedItem().toString().equals(color.toString())) theColor=color;
               }
               guess.setColor(i, theColor);
            }
            controller.guess(guess);
         }
      });
      resetButton.addActionListener(e -> controller.reset());
   }
}
