import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionsOfFile {
    GUI gui;
    String fileName;
    String fileAddress;

    public FunctionsOfFile(GUI gui){
        this.gui = gui;

    }
    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
    }

    public void open(){

        FileDialog fileDialog = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null){
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");

            String line = null;

            while ((line = bufferedReader.readLine()) != null);{
                gui.textArea.append(line + "\n");
            }
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("File not opend.");;
        }

    }
    public void save(){
        if (fileName == null){
            saveAs();
        }else {
            try {
                FileWriter fileWriter = new FileWriter(fileAddress + fileName);
                fileWriter.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fileWriter.close();

            }catch (Exception e){
                System.out.println("Something wrong.");
            }
        }
    }
    public void saveAs(){
        FileDialog fileDialog = new FileDialog(gui.window, "Save",FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null){
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {
            FileWriter fileWriter = new FileWriter(fileAddress + fileName);
            fileWriter.write(gui.textArea.getText());
            fileWriter.close();

        }catch (Exception e){
            System.out.println("Something wrong."+e.getMessage());
        }
    }
    public void exit(){
        System.exit(0);
    }
}
