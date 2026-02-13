package org.bnsplits.view.components;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import org.bnsplits.view.Theme;
import com.formdev.flatlaf.FlatClientProperties;

public class CustomTable extends JTable {

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
            "selectionBackground: " + Theme.SURFACE_COLOR + ";" +
            "selectionForeground: " + Theme.ON_SURFACE_COLOR + ";" +
            "background: " + Theme.BACKGROUND_COLOR + ";" +
            "selectionInactiveBackground: " + Theme.SURFACE_COLOR + ";" +
            "selectionInactiveForeground: " + Theme.ON_SURFACE_COLOR);

    // Header styling
    JTableHeader header = getTableHeader();
    header.putClientProperty(FlatClientProperties.STYLE,
        "height: 48;" +
            "font: bold 12;" +
            "foreground: " + Theme.ON_BACKGROUND_COLOR + ";" +
            "background: " + Theme.SURFACE_COLOR + ";" +
            "separatorColor: " + Theme.SURFACE_COLOR + ";" +
            "bottomSeparatorColor: " + Theme.OUTLINE_COLOR);

    header.setReorderingAllowed(false);
    header.setResizingAllowed(false);

    // General table settings
    setShowGrid(false);
    setIntercellSpacing(new Dimension(0, 8));
    setRowHeight(56);
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    setFont(new Font("Segoe UI", Font.PLAIN, 14));
    setDefaultEditor(Object.class, null);
  }
}
