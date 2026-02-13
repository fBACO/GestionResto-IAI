package org.bnsplits.view.components;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import org.bnsplits.view.Theme;
import com.formdev.flatlaf.FlatClientProperties;

public class CustomTable extends JTable {

  private ActionListener editActionListener;
  private ActionListener deleteActionListener;

  public CustomTable() {
    super();
    initStyle();
  }

  public CustomTable(TableModel model) {
    super(model);
    initStyle();
  }

  private void initStyle() {
    // Table styling
    putClientProperty(FlatClientProperties.STYLE,
        "showHorizontalLines: false;" +
            "showVerticalLines: false;" +
            "intercellSpacing: 0,8;" +
            "rowHeight: 56;" +
            "selectionBackground: " + Theme.BACKGROUND_COLOR + ";" +
            "selectionForeground: " + Theme.ON_SURFACE_COLOR + ";" +
            "background: " + Theme.BACKGROUND_COLOR + ";" +
            "selectionInactiveBackground: " + Theme.BACKGROUND_COLOR + ";" +
            "selectionInactiveForeground: " + Theme.ON_SURFACE_COLOR);

    // Header styling
    JTableHeader header = getTableHeader();
    header.putClientProperty(FlatClientProperties.STYLE,
        "height: 48;" +
            "font: bold 12;" +
            "foreground: " + Theme.ON_BACKGROUND_COLOR + ";" +
            "background: " + Theme.SURFACE_COLOR + ";" +
            "hoverBackground: " + Theme.SURFACE_COLOR + ";" +
            "separatorColor: " + Theme.SURFACE_COLOR + ";" +
            "bottomSeparatorColor: " + Theme.OUTLINE_COLOR);

    header.setReorderingAllowed(false);
    header.setResizingAllowed(false);

    // Centrer le texte du header
    DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
    headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

    // Désactiver le tri par clic sur l'en-tête
    setAutoCreateRowSorter(false);
    setRowSorter(null);

    // General table settings
    setShowGrid(false);
    setIntercellSpacing(new Dimension(0, 8));
    setRowHeight(56);
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    setFont(new Font("Segoe UI", Font.PLAIN, 14));
    setDefaultEditor(Object.class, null);

    // Désactiver la sélection visuelle
    setRowSelectionAllowed(false);
    setColumnSelectionAllowed(false);
    setCellSelectionEnabled(false);
    setFocusable(false);

    // Centrer le texte des cellules par défaut
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    setDefaultRenderer(Object.class, centerRenderer);
  }

  /**
   * Active les boutons d'action pour les colonnes spécifiées
   * 
   * @param editColumnIndex   Index de la colonne "Modifier" (-1 pour désactiver)
   * @param deleteColumnIndex Index de la colonne "Supprimer" (-1 pour désactiver)
   */
  public void enableActionButtons(int editColumnIndex, int deleteColumnIndex) {
    if (editColumnIndex >= 0) {
      getColumnModel().getColumn(editColumnIndex).setCellRenderer(new EditButtonRenderer());
      getColumnModel().getColumn(editColumnIndex).setCellEditor(new EditButtonEditor());
    }

    if (deleteColumnIndex >= 0) {
      getColumnModel().getColumn(deleteColumnIndex).setCellRenderer(new DeleteButtonRenderer());
      getColumnModel().getColumn(deleteColumnIndex).setCellEditor(new DeleteButtonEditor());
    }
  }

  /**
   * Définit l'action à exécuter lors du clic sur "Modifier"
   * Le ActionEvent contient le numéro de ligne dans getActionCommand()
   */
  public void setEditActionListener(ActionListener listener) {
    this.editActionListener = listener;
  }

  /**
   * Définit l'action à exécuter lors du clic sur "Supprimer"
   * Le ActionEvent contient le numéro de ligne dans getActionCommand()
   */
  public void setDeleteActionListener(ActionListener listener) {
    this.deleteActionListener = listener;
  }

  // ========== Classes internes pour les boutons ==========
  // ================= Inutile d'y toucher =================

  // Renderer pour le bouton Modifier
  private class EditButtonRenderer extends JButton implements TableCellRenderer {
    public EditButtonRenderer() {
      setText("Modifier");
      setContentAreaFilled(false);
      setBorderPainted(false);
      setFocusPainted(false);
      setOpaque(false);
      setForeground(Color.decode(Theme.PRIMARY_COLOR));
      setFont(new Font("Segoe UI", Font.BOLD, 14));
      setCursor(new Cursor(Cursor.HAND_CURSOR));
      setHorizontalAlignment(SwingConstants.CENTER);
      setMargin(new Insets(0, 0, 0, 0));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
      return this;
    }
  }

  // Editor pour le bouton Modifier
  private class EditButtonEditor extends DefaultCellEditor {
    private JButton button;
    private int currentRow;

    public EditButtonEditor() {
      super(new JCheckBox());
      setClickCountToStart(1);

      button = new JButton("Modifier");
      button.setContentAreaFilled(false);
      button.setBorderPainted(false);
      button.setFocusPainted(false);
      button.setOpaque(false);
      button.setForeground(Color.decode(Theme.PRIMARY_COLOR));
      button.setFont(new Font("Segoe UI", Font.BOLD, 14));
      button.setCursor(new Cursor(Cursor.HAND_CURSOR));
      button.setHorizontalAlignment(SwingConstants.CENTER);
      button.setMargin(new Insets(0, 0, 0, 0));

      button.addActionListener(e -> {
        fireEditingStopped();
        if (editActionListener != null) {
          editActionListener.actionPerformed(
              new ActionEvent(this, ActionEvent.ACTION_PERFORMED, String.valueOf(currentRow)));
        }
      });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
        boolean isSelected, int row, int column) {
      currentRow = row;
      return button;
    }

    @Override
    public Object getCellEditorValue() {
      return "";
    }
  }

  // Renderer pour le bouton Supprimer
  private class DeleteButtonRenderer extends JButton implements TableCellRenderer {
    public DeleteButtonRenderer() {
      setText("Supprimer");
      setContentAreaFilled(false);
      setBorderPainted(false);
      setFocusPainted(false);
      setOpaque(false);
      setForeground(Color.decode(Theme.ERROR_COLOR));
      setFont(new Font("Segoe UI", Font.BOLD, 14));
      setCursor(new Cursor(Cursor.HAND_CURSOR));
      setHorizontalAlignment(SwingConstants.CENTER);
      setMargin(new Insets(0, 0, 0, 0));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
      return this;
    }
  }

  // Editor pour le bouton Supprimer
  private class DeleteButtonEditor extends DefaultCellEditor {
    private JButton button;
    private int currentRow;

    public DeleteButtonEditor() {
      super(new JCheckBox());
      setClickCountToStart(1);

      button = new JButton("Supprimer");
      button.setContentAreaFilled(false);
      button.setBorderPainted(false);
      button.setFocusPainted(false);
      button.setOpaque(false);
      button.setForeground(Color.decode(Theme.ERROR_COLOR));
      button.setFont(new Font("Segoe UI", Font.BOLD, 14));
      button.setCursor(new Cursor(Cursor.HAND_CURSOR));
      button.setHorizontalAlignment(SwingConstants.CENTER);
      button.setMargin(new Insets(0, 0, 0, 0));

      button.addActionListener(e -> {
        fireEditingStopped();
        if (deleteActionListener != null) {
          deleteActionListener.actionPerformed(
              new ActionEvent(this, ActionEvent.ACTION_PERFORMED, String.valueOf(currentRow)));
        }
      });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
        boolean isSelected, int row, int column) {
      currentRow = row;
      return button;
    }

    @Override
    public Object getCellEditorValue() {
      return "";
    }
  }
}
