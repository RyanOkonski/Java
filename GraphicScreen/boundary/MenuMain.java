import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import javax.swing.KeyStroke;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuMain extends JFrame {
   private JFrame menuMain;
   
   public MenuMain() {
      this.menuMain = new JFrame();
      this.menuMain.setTitle(".:MAIN MENU:.");
      this.menuMain.getContentPane().setLayout(new BorderLayout());
      this.menuMain.getContentPane().add(getMenu(), BorderLayout.BEFORE_FIRST_LINE);
      this.menuMain.add(getWallpaper());
      this.menuMain.pack();
      this.menuMain.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.menuMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.menuMain.setVisible(true);
   }

   public JLabel getWallpaper() {
      ImageIcon img = new ImageIcon("BackGround.jpg");
      JLabel background = new JLabel("",img,JLabel.CENTER);
      background.setSize(getPreferredSize());
      background.setLayout(null);

      return background;
   }

   public JMenuBar getMenu() {
      JMenuBar menuBar = new JMenuBar();
      JMenu menu;
      JMenuItem menuItem;
      KeyStroke stroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK);
      KeyStroke stroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK);
      KeyStroke stroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK);
      KeyStroke stroke4 = KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK);

      //first button for MenuBar
      menu = new JMenu("Menu");
      menu.setMnemonic(KeyEvent.VK_M);

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
            switch (JOptionPane.showConfirmDialog(menuMain, "Would you like to Exit?", "Confirmation", JOptionPane.YES_NO_OPTION)) {
               case JOptionPane.NO_OPTION:
                  break;
            
               case JOptionPane.YES_OPTION:
                  JOptionPane.showMessageDialog(menuMain, "Thanks for coming!");
                  System.exit(0);
                  break;
            }
         }
      });

      menuBar.add(menu);

      return menuBar;
   }
}