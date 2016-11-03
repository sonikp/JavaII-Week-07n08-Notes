import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SubmenuEx extends JFrame 
{

    public SubmenuEx() 
    {

        initUI();
    }

    private void initUI() 
    {

        createMenuBar();

        setTitle("Submenu Example");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() 
    {

        JMenuBar menubar = new JMenuBar();

        ImageIcon iconNew = new ImageIcon("icon/New.png");
        ImageIcon iconOpen = new ImageIcon("icon/OK.png");
        ImageIcon iconSave = new ImageIcon("icon/Save.png");
        ImageIcon iconExit = new ImageIcon("icon/Exit.png");

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        JMenu impMenu = new JMenu("Import");

        JMenuItem newsfMi = new JMenuItem("Import newsfeed list...");
        newsfMi.setToolTipText("Imports Newsfeeds lists");
        
        JMenuItem bookmMi = new JMenuItem("Import bookmarks...");
        bookmMi.setToolTipText("Imports Bookmarks");
        
        JMenuItem mailMi = new JMenuItem("Import mail...");
        mailMi.setToolTipText("Imports mail components");

        impMenu.add(newsfMi);
        impMenu.add(bookmMi);
        impMenu.add(mailMi);

        JMenuItem newMi = new JMenuItem("New", iconNew);
        JMenuItem openMi = new JMenuItem("Open", iconOpen);
        JMenuItem saveMi = new JMenuItem("Save", iconSave);

        JMenuItem exitMi = new JMenuItem("Exit", iconExit);
        exitMi.setToolTipText("Exit application");

        exitMi.addActionListener((ActionEvent event) -> 
        {
            System.exit(0);
        });

        fileMenu.add(newMi);
        fileMenu.add(openMi);
        fileMenu.add(saveMi);
        fileMenu.addSeparator();
        fileMenu.add(impMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMi);

        menubar.add(fileMenu);
        menubar.add(editMenu);

        setJMenuBar(menubar);
    }

    public static void main(String[] args) 
    {

        EventQueue.invokeLater(() -> 
        {
            SubmenuEx ex = new SubmenuEx();
            ex.setVisible(true);
        });
    }
}