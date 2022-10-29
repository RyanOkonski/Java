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
import control.ControlWeapon;

public class ScreenWeapon extends JFrame {
   private JTextField weaponColor = new JTextField(10);
   private JTextField weaponSize = new JTextField(4);
   private JTextField weaponBool = new JTextField(5);
   private ControlWeapon control = new ControlWeapon();
   private String data;

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public ScreenWeapon() {
      this.setTitle("Create Weapon");
      this.getContentPane().setLayout(new BorderLayout());
      this.getContentPane().add(getInputs(), BorderLayout.CENTER);
      this.getContentPane().add(getButtons(), BorderLayout.PAGE_END);
      this.pack();
      this.setSize(450,200);
      this.setLocationRelativeTo(null);
      this.setVisible(true);
   }

   public JPanel getInputs() {
      JPanel panelJedi = new JPanel(new GridLayout(4, 2));
      panelJedi.add(new JLabel("Insert Weapon color:"));
      panelJedi.add(this.weaponColor);
      panelJedi.add(new JLabel("Insert Weapon size:"));
      panelJedi.add(this.weaponSize);
      panelJedi.add(new JLabel("Weapon is Open? (True or False):"));
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
            this.dispose();
            break;
      }
   }

   public void btnCancelClick(ActionEvent e) {
      clearFields();
   }

   public void btnSaveClick(ActionEvent e) {
      switch (JOptionPane.showConfirmDialog(this, "Would you like to Save?", "Confirmation",
            JOptionPane.YES_NO_OPTION)) {
         case JOptionPane.NO_OPTION:
            break;
         case JOptionPane.OK_OPTION:
            this.setData(this.weaponColor.getText() + "," + this.weaponSize.getText() + "," + this.weaponBool.getText());
            control.saveWeapon(data);
            clearFields();
            try {
               control.escreverArquivoWeapon();
               JOptionPane.showMessageDialog(this, "Your Weapon has been saved!");
            } catch (Exception ae) {
               System.out.println("We couldn't save your Weapon!");
            }
            this.dispose();
            break;
      }
   }

   public void clearFields() {
      this.weaponColor.setText("");
      this.weaponSize.setText("");
      this.weaponBool.setText("");
   }
}
