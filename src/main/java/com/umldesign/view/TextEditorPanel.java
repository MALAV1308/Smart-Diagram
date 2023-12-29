package com.umldesign.view;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
/**
 * The TextEditorPanel is used to represent the textual representation of the GUI generated, using the JTextarea element.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class TextEditorPanel extends JPanel implements Observer {
    private JTextArea textArea;
    private TraversalStrategy traversalStrategy;

    /**
     * The TextEditorPanel constructor is responsible for configuring the text panel UI.
     */
    public TextEditorPanel(TraversalStrategy traversalStrategy){
        this.traversalStrategy = traversalStrategy;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(350,720));
        addTextEditorUI();
    }

    /**
     * The addTextEditorUI method is responsible for adding the textarea to the TextEditorPanel.
     */
    protected void addTextEditorUI(){
        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(300,720));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(textArea, BorderLayout.WEST);

        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane);
    }

    /**
     * The update is invoked when there is a change in the repository. We then update the text in the textarea UI.
     *
     * @param o observable object reference
     * @param arg additional arguments
     */
    @Override
    public void update(Observable o, Object arg) {
        TraversalData data = traversalStrategy.traverse();
        textArea.setText(data.getTextData());
    }
}
