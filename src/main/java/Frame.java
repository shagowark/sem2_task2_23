import util.ArrayUtils;
import util.JTableUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Frame extends JFrame{
    private JPanel panelMain;
    private JTable tableInput1;
    private JTable tableOutput;
    private JButton buttonGetResult;
    private JTable tableInput2;
    private JButton buttonLoadFromFile2;
    private JButton buttonLoadFromFile1;

    private final JFileChooser fileChooserOpen;
    public Frame() {
        this.setTitle("Task3");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);
        this.pack();


        JTableUtils.initJTableForArray(tableInput1, 40, true, true, false, true);
        JTableUtils.resizeJTable(tableInput1, 1, 1, 30, 70);

        JTableUtils.initJTableForArray(tableInput2, 40, true, true, false, true);
        JTableUtils.resizeJTable(tableInput2, 1, 1, 30, 70);

        JTableUtils.initJTableForArray(tableOutput, 40, true, true, false, false);
        JTableUtils.resizeJTable(tableOutput, 1, 1, 30, 70);
        tableOutput.setEnabled(false);

        fileChooserOpen = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);

        this.setVisible(true);
        this.setSize(860, 500);

        buttonGetResult.addActionListener(e -> {
            try {
                int[] input1 = JTableUtils.readIntArrayFromJTable(tableInput1);
                LinkedList<Integer> list1 = new LinkedList<>();
                for (int elem : input1) {
                    list1.add(elem);
                }

                int[] input2 = JTableUtils.readIntArrayFromJTable(tableInput2);
                LinkedList<Integer> list2 = new LinkedList<>();
                for (int elem : input2) {
                    list2.add(elem);
                }

                LinkedList<Integer> result = Logic.getNewSortedList(list1, list2);
                int[] resultArr = new int[result.size()];
                for (int i = 0; i < result.size(); i++){
                    resultArr[i] = result.get(i);
                }
                JTableUtils.writeArrayToJTable(tableOutput, resultArr);
            } catch (Exception ex) {
                displayError("Ошибка в исходных данных");
            }
        });
        
        buttonLoadFromFile1.addActionListener(actionEvent -> {
            try {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    int[][] arr = ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());

                    JTableUtils.writeArrayToJTable(tableInput1, arr);
                }
            } catch (Exception e) {
                displayError("Ошибка в исходных данных");
            }
        });

        buttonLoadFromFile2.addActionListener(actionEvent -> {
            try {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    int[][] arr = ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());

                    JTableUtils.writeArrayToJTable(tableInput2, arr);
                }
            } catch (Exception e) {
                displayError("Ошибка в исходных данных");
            }
        });
    }
        private void displayError(String errorText) {
            JOptionPane.showMessageDialog(this, errorText,
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

