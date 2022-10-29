import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import javax.swing.KeyStroke;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class MainMenu extends JFrame {
   
   public MainMenu() {
      this.setTitle(".:MAIN MENU:.");
      this.getContentPane().setLayout(new BorderLayout());
      this.getContentPane().add(getMenu(), BorderLayout.BEFORE_FIRST_LINE);
      this.pack();
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }

   public JMenuBar getMenu() {
      JMenuBar menuBar = new JMenuBar();
      JMenu menu;
      JMenuItem menuItem;
      KeyStroke stroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK);
      KeyStroke stroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK);
      KeyStroke stroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK);
      KeyStroke stroke4 = KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK);

      menu = new JMenu("Menu");
      menu.setMnemonic(KeyEvent.VK_A);

      // button for Create Jedi on MenuBar
      menuItem = new JMenuItem("Create Jedi");
      menuItem.setAccelerator(stroke1);
      menu.add(menuItem);

      menuItem.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
            new ScreenJedi();
         }
      });

      // button for Create Skill on MenuBar
      menuItem = new JMenuItem("Create Skill");
      menuItem.setAccelerator(stroke2);
      menu.add(menuItem);

      menuItem.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
            new ScreenSkill();
         }
      });

      // button for Create Weapon on MenuBar
      menuItem = new JMenuItem("Create Weapon");
      menuItem.setAccelerator(stroke3);
      menu.add(menuItem);

      menuItem.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
            new ScreenWeapon();
         }
      });

      // button for Exit on MenuBar
      menuItem = new JMenuItem("Exit");
      menuItem.setAccelerator(stroke4);
      menu.add(menuItem);

      menuItem.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
            switch (JOptionPane.showConfirmDialog(menu, "Would you like to Exit?", "Confirmation", JOptionPane.YES_NO_OPTION)) {
               case JOptionPane.NO_OPTION:
                  break;
            
               case JOptionPane.YES_OPTION:
                  JOptionPane.showMessageDialog(menu, "Thanks for coming!");
                  System.exit(0);
                  break;
            }
         }
      });

      menuBar.add(menu);

      return menuBar;
   }
}