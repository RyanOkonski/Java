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
import control.ControlSkill;

public class ScreenSkill extends JFrame {
   private JTextField skillName = new JTextField(30);
   private JTextField skillValue = new JTextField(4);
   private ControlSkill control = new ControlSkill();
   private String data;

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public ScreenSkill() {
      this.setTitle("Create Skill");
      this.getContentPane().setLayout(new BorderLayout());
      this.getContentPane().add(getInputs(), BorderLayout.CENTER);
      this.getContentPane().add(getButtons(), BorderLayout.PAGE_END);
      this.pack();
      this.setSize(350,200);
      this.setLocationRelativeTo(null);
      this.setVisible(true);
   }

   public JPanel getInputs() {
      JPanel panelJedi = new JPanel(new GridLayout(3, 2));
      panelJedi.add(new JLabel("Insert Skill name:"));
      panelJedi.add(this.skillName);
      panelJedi.add(new JLabel("Insert Skill value:"));
      panelJedi.add(this.skillValue);

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
            this.setData(this.skillName.getText() + "," + this.skillValue.getText());
            control.saveSkills(data);
            clearFields();
            try {
               control.escreverArquivoSkill();
               JOptionPane.showMessageDialog(this, "Your Skill has been saved!");
            } catch (Exception ae) {
               System.out.println("We couldn't save your Skill!");
            }
            this.dispose();
            break;
      }
   }

   public void clearFields() {
      this.skillName.setText("");
      this.skillValue.setText("");
   }
}
