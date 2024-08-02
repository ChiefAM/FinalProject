package POS;


import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.util.EventObject;

public class DynamicJTextFieldEditor implements TableCellEditor {

    private JTextField currentTextField; // Store the currently active JTextField

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // Create a new JTextField for each cell edit
        currentTextField = new JTextField();
        currentTextField.setText(value != null ? value.toString() : "1");

        // Add KeyListener to allow only numeric input
        currentTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume(); // Prevent invalid characters
                }
            }
        });

        currentTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { updateTotalPrice(row);
 }
            @Override
            public void removeUpdate(DocumentEvent e) { updateTotalPrice(row); }
            @Override
            public void changedUpdate(DocumentEvent e) { updateTotalPrice(row); }
        });
        return currentTextField;
    }

    

    @Override
    public Object getCellEditorValue() {
        return currentTextField != null ? currentTextField.getText() : ""; 
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true; 
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        // Check if the Enter key was pressed
        if (SalesUI.table.getCellEditor() != null && ((ComponentEvent) SalesUI.table.getCellEditor()).getComponent() instanceof JTextField) {
            JTextField textField = (JTextField) ((ComponentEvent) SalesUI.table.getCellEditor()).getComponent();
            if (textField.hasFocus()) {
                // Simulate an Enter key press to trigger the default action (committing the value)
                textField.postActionEvent();
                return true; // Indicate that editing should stop
            }
        }
    
        // If not Enter, or not a JTextField, continue with default behavior
        return false;
    }

    public void cancelCellEditing() {
        // Handle cancellation if needed
    }

    // Helper method to update the total price
    private void updateTotalPrice(int row) {
        try {
            int quantity = Integer.parseInt(currentTextField.getText());
            double price = (double) SalesUI.table.getValueAt(row, 1);
            double total = quantity * price;
            SalesUI.model.setValueAt(total, row, 3); 
        } catch (NumberFormatException ex) {
            // You might want to handle this more gracefully, 
            // perhaps by displaying an error message or resetting the text field
        }
    }


    @Override
    public void addCellEditorListener(CellEditorListener l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCellEditorListener'");
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeCellEditorListener'");
    }

    
}
