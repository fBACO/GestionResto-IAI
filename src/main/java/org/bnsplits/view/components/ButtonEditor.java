package org.bnsplits.view.components;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import org.bnsplits.view.Theme;

// Editor pour rendre les boutons cliquables
public class ButtonEditor extends DefaultCellEditor {
  private JPanel panel;
  private JButton editButton;
  private JButton deleteButton;
  private int currentRow;
  private ActionListener editListener;
  private ActionListener deleteListener;

  public ButtonEditor(JCheckBox checkBox) {
    super(checkBox);

    panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 4));

    editButton = new JButton("Modifier");
    deleteButton = new JButton("Supprimer");

    // Style
    editButton.setBackground(Color.decode(Theme.PRIMARY_COLOR));
    editButton.setForeground(Color.WHITE);
    editButton.setFocusPainted(false);
    editButton.setBorderPainted(false);
    editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

    deleteButton.setBackground(Color.decode(Theme.ERROR_COLOR));
    deleteButton.setForeground(Color.WHITE);
    deleteButton.setFocusPainted(false);
    deleteButton.setBorderPainted(false);
    deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

    panel.add(editButton);
    panel.add(deleteButton);

    // Actions des boutons
    editButton.addActionListener(e -> {
      fireEditingStopped();
      if (editListener != null) {
        editListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, String.valueOf(currentRow)));
      }
    });

    deleteButton.addActionListener(e -> {
      fireEditingStopped();
      if (deleteListener != null) {
        deleteListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, String.valueOf(currentRow)));
      }
    });
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    currentRow = row;
    panel.setBackground(Color.decode(Theme.SURFACE_COLOR));
    return panel;
  }

  @Override
  public Object getCellEditorValue() {
    return "";
  }

  public void setEditListener(ActionListener listener) {
    this.editListener = listener;
  }

  public void setDeleteListener(ActionListener listener) {
    this.deleteListener = listener;
  }
}
