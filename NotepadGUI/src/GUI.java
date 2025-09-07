import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile;
    JMenuItem iNew,iOpen, iSave, iSaveAs, iExit;

    FunctionsOfFile file = new FunctionsOfFile(this);


    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {

        createWindow();
        createTextArea();
        cretaeMenuBar();
        createMenuItem();

        window.setVisible(true);

    }

    public void createWindow(){

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void createTextArea(){

        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);

    }

    public void cretaeMenuBar(){

        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

    }

    public void createMenuItem(){

        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command){
            case "New": file.newFile(); break;
            case "Open": file.open(); break;
            case "Save": file.save(); break;
            case "Save As": file.saveAs(); break;
            case "Exit": file.exit(); break;
            //case "Open": file.open(); break;
        }

    }
}
