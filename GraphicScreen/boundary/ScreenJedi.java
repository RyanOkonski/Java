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
import control.ControlJedi;

public class ScreenJedi extends JFrame {
   private JTextField name = new JTextField(30);
   private JTextField age = new JTextField(4);
   private JTextField hight = new JTextField(3);
   private ControlJedi control = new ControlJedi();
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
      this.pack();
      this.setSize(350,200);
      this.setLocationRelativeTo(null);
      this.setVisible(true);
   }

   public JPanel getInputs() {
      JPanel panelJedi = new JPanel(new GridLayout(4, 2));
      panelJedi.add(new JLabel("Insert Jedi's name:"));
      panelJedi.add(this.name);
      panelJedi.add(new JLabel("Insert Jedi's age:"));
      panelJedi.add(this.age);
      panelJedi.add(new JLabel("Insert Jedi's hight:"));
      panelJedi.add(this.hight);

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
            this.setData(this.name.getText() + "," + this.age.getText() + "," + this.hight.getText());
            control.saveJedi(data);
            clearFields();
            try {
               control.escreverArquivoJedi();
               JOptionPane.showMessageDialog(this, "Your Jedi has been saved!");
            } catch (Exception ae) {
               System.out.println("We couldn't save your Jedi!");
            }
            this.dispose();
            break;
      }
   }

   public void clearFields() {
      this.name.setText("");
      this.age.setText("");
      this.hight.setText("");
   }
}
