package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import control.ControlSystem;

public class ScreenJedi extends JFrame {
   private JTextField name = new JTextField(30);
   private JTextField age = new JTextField(4);
   private JTextField hight = new JTextField(3);
   private JTextField skillName = new JTextField(30);
   private JTextField skillValue = new JTextField(4);
   private JTextField weaponColor = new JTextField(10);
   private JTextField weaponSize = new JTextField(4);
   private JTextField weaponBool = new JTextField(5);
   private ControlSystem control = new ControlSystem();
   private String data;

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public ScreenJedi() {
      this.setTitle("Create Jedi");
      this.getContentPane().setLayout(new BorderLayout());
      this.getContentPane().add(getInputs(), BorderLayout.CENTER);
      this.getContentPane().add(getButtons(), BorderLayout.PAGE_END);
      this.setSize(1280, 900);
      this.pack();
      this.setLocationRelativeTo(null);
      this.setVisible(true);
   }

   public JPanel getInputs() {
      JPanel panelJedi = new JPanel(new GridLayout(9, 2));
      panelJedi.add(new JLabel("Insert Jedi's name:"));
      panelJedi.add(this.name);
      panelJedi.add(new JLabel("Insert Jedi's age:"));
      panelJedi.add(this.age);
      panelJedi.add(new JLabel("Insert Jedi's hight:"));
      panelJedi.add(this.hight);
      panelJedi.add(new JLabel("Insert Skill name:"));
      panelJedi.add(this.skillName);
      panelJedi.add(new JLabel("Insert Skill value:"));
      panelJedi.add(this.skillValue);
      panelJedi.add(new JLabel("Insert Weapon color:"));
      panelJedi.add(this.weaponColor);
      panelJedi.add(new JLabel("Insert Weapon size:"));
      panelJedi.add(this.weaponSize);
      panelJedi.add(new JLabel("Weapon is Open? (True or False)"));
      panelJedi.add(this.weaponBool);

      return panelJedi;
   }

   public JPanel getButtons() {
      JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
      JButton btnExit = new JButton("Exit");
      JButton btnSave = new JButton("Save");
      JButton btnCancel = new JButton("Clear");
      btnExit.addActionListener(this::btnExitClick);
      btnCancel.addActionListener(this::btnCancelClick);
      btnSave.addActionListener(this::btnSaveClick);
      panelButtons.add(btnExit);
      panelButtons.add(btnCancel);
      panelButtons.add(btnSave);

      return panelButtons;
   }

   public void btnExitClick(ActionEvent e) {
      switch (JOptionPane.showConfirmDialog(this, "Would you like to Exit?", "Confirmation",
            JOptionPane.OK_CANCEL_OPTION)) {
         case JOptionPane.CANCEL_OPTION:
            break;

         case JOptionPane.OK_OPTION:
            clearFields();
            JOptionPane.showMessageDialog(this, "Thanks for coming!");
            this.dispose();
            break;
      }
   }

   public void btnCancelClick(ActionEvent e) {
      this.name.setText("");
      this.age.setText("");
      this.hight.setText("");
      this.skillName.setText("");
      this.skillValue.setText("");
      this.weaponColor.setText("");
      this.weaponSize.setText("");
      this.weaponBool.setText("");
   }

   public void btnSaveClick(ActionEvent e) {
      switch (JOptionPane.showConfirmDialog(this, "Would you like to Save?", "Confirmation",
            JOptionPane.YES_NO_OPTION)) {
         case JOptionPane.NO_OPTION:
            break;
         case JOptionPane.OK_OPTION:
            this.setData(
                  this.weaponColor.getText() + "," + this.weaponSize.getText() + "," + this.weaponBool.getText() + "," +
                        this.skillName.getText() + "," + this.skillValue.getText() + "," +
                        this.name.getText() + "," + this.age.getText() + "," + this.hight.getText());
            clearFields();
            control.salvarJedi(this.getData());
            try {
               control.escreverArquivoJedi();
               JOptionPane.showMessageDialog(this, "Your Jedi has been saved!");
            } catch (Exception ae) {
               System.out.println("We couldn't save your Jedi!");
            }
            break;
      }
   }

   public void clearFields() {
      this.name.setText("");
      this.age.setText("");
      this.hight.setText("");
      this.skillName.setText("");
      this.skillValue.setText("");
      this.weaponColor.setText("");
      this.weaponSize.setText("");
      this.weaponBool.setText("");
   }
}
