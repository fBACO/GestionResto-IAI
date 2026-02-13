package org.bnsplits.view.components;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import org.bnsplits.view.Theme;

// Renderer pour afficher les boutons
public class ButtonRenderer extends JPanel implements TableCellRenderer {
  private JButton editButton;
  private JButton deleteButton;

  public ButtonRenderer() {
    setLayout(new FlowLayout(FlowLayout.CENTER, 8, 4));
    setOpaque(true);

    editButton = new JButton("Modifier");
    deleteButton = new JButton("Supprimer");

    // Style simple
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

    add(editButton);
    add(deleteButton);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    setBackground(isSelected ? Color.decode(Theme.SURFACE_COLOR) : Color.decode(Theme.BACKGROUND_COLOR));
    return this;
  }
}
