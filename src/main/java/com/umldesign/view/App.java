package com.umldesign.view;
import javax.swing.*;
import com.umldesign.controller.*;
import java.awt.event.MouseAdapter;
import com.umldesign.model.ConcreteRepositoryService;
import com.umldesign.model.Repository;
import com.umldesign.model.RepositoryService;
import com.umldesign.model.Status;
import java.awt.*;
/**
 * App class is the starting point of this application. It contains the main method.
 *
 * @author Harish Kumar Srinivasappa
 * @author Naheer Fatima
 * @version 1.0
 */
public class App extends JFrame {
    /**
     * App constructor sets layout and configures UI.
     */
    public App(){
        setLayout(new BorderLayout());
        setResizable(false);
    }

    /**
     * The main method creates the UI panels, Handlers and adds the panels as observers of the repository.
     *
     * @param args command line arguments from the user.
     */
    public static void main(String[] args) {
        RepositoryService service = new ConcreteRepositoryService();
        FileActionHandler loadActionHandler = new LoadActionHandler(new SimpleFileReader(), new JSONDeserializer(service));
        JMenuItem loadMenuItem = new JMenuItem("Load");
        loadMenuItem.setPreferredSize(new Dimension(200, 30));
        loadMenuItem.addActionListener(new LoadAction(loadActionHandler));

        FileActionHandler saveActionHandler = new SaveActionHandler(new JSONSerializer(),new SimpleFileWriter());
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setPreferredSize(new Dimension(200, 30));
        saveMenuItem.addActionListener(new SaveAction(saveActionHandler));

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.setPreferredSize(new Dimension(200, 30));
        newMenuItem.addActionListener(new NewAction(service));

        JPopupMenu fileMenu = new JPopupMenu();
        fileMenu.setPreferredSize(new Dimension(200,90));
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(newMenuItem);

        JPopupMenu helpMenu = new JPopupMenu();
        helpMenu.setLayout(new BoxLayout(helpMenu, BoxLayout.Y_AXIS));
        helpMenu.setPreferredSize(new Dimension(250,210));

        JLabel authorLabel = new JLabel("Authors:");
        authorLabel.setPreferredSize(new Dimension(250, 30));
        authorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel harishKumarLabel = new JLabel("Harish Kumar Srinivasappa");
        harishKumarLabel.setPreferredSize(new Dimension(250, 30));
        harishKumarLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel praveenLabel = new JLabel("Praveen Anbazhagan");
        praveenLabel.setPreferredSize(new Dimension(250, 30));
        praveenLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel aakashLabel = new JLabel("Aakash Vora");
        aakashLabel.setPreferredSize(new Dimension(250, 30));
        aakashLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel fathimaLabel = new JLabel("Naheer Fatima");
        fathimaLabel.setPreferredSize(new Dimension(250, 30));
        fathimaLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel jashminLabel = new JLabel("Jashmin Patel");
        jashminLabel.setPreferredSize(new Dimension(250, 30));
        jashminLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel devenLabel = new JLabel("Deven Prajapati");
        devenLabel.setPreferredSize(new Dimension(250, 30));
        devenLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        helpMenu.add(authorLabel);
        helpMenu.add(harishKumarLabel);
        helpMenu.add(praveenLabel);
        helpMenu.add(aakashLabel);
        helpMenu.add(fathimaLabel);
        helpMenu.add(jashminLabel);
        helpMenu.add(devenLabel);

        MenuPanel menuPanel = new MenuPanel();
        menuPanel.addMenuButton("File",100,40,fileMenu);
        menuPanel.addMenuButton("Help", 100, 40, helpMenu);

        TextEditorPanel textEditorPanel = new TextEditorPanel(new TextTraversalStrategy());
        GraphicPanel graphicPanel = new GraphicPanel(new GraphTraversalStrategy(new UMLConnectionFactory()));

        Repository.getInstance().addObserver(graphicPanel);
        Repository.getInstance().addObserver(textEditorPanel);

        SingleClickHandler singleClickHandler = new SingleClickHandler(service);
        DoubleClickHandler doubleClickHandler = new DoubleClickHandler(service);
        DragHandler dragHandler = new DragHandler(service);

        singleClickHandler.setClickHandler(doubleClickHandler);
        doubleClickHandler.setClickHandler(dragHandler);

        MouseAdapter panelActionListener = new PanelActionListener(singleClickHandler, new ConcreteCollisionDetector());
        graphicPanel.addMouseListener(panelActionListener);
        graphicPanel.addMouseMotionListener(panelActionListener);

        StatusPanel statusPanel = new StatusPanel();
        Status.getInstance().addObserver(statusPanel);

        App app = new App();
        app.setSize(1000,820);
        app.setTitle("Final Project");

        app.add(menuPanel, BorderLayout.NORTH);
        app.add(textEditorPanel, BorderLayout.WEST);
        app.add(graphicPanel, BorderLayout.CENTER);
        app.add(statusPanel, BorderLayout.SOUTH);
        app.setVisible(true);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
