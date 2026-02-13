package org.bnsplits.view.components;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.*;
import java.awt.*;
import org.bnsplits.view.Theme;

public class CustomCard extends JPanel {
  private boolean haveBorder = false;
  private int radius = 32;

  // Constructeurs
  public CustomCard() {
    super();
    initStyle();
  }

  public CustomCard(LayoutManager layout) {
    super(layout);
    initStyle();
  }

  public CustomCard(boolean isDoubleBuffered) {
    super(isDoubleBuffered);
    initStyle();
  }

  public CustomCard(LayoutManager layout, boolean isDoubleBuffered) {
    super(layout, isDoubleBuffered);
    initStyle();
  }

  private void initStyle() {
    setBackground(Color.decode(Theme.SURFACE_COLOR));
    applyFlatLafStyle();
  }

  private void applyFlatLafStyle() {
    putClientProperty(FlatClientProperties.STYLE,
        "arc: " + radius + ";" +
            (haveBorder ? "border: 1,1,1,1," + Theme.OUTLINE_COLOR + ",1,999" : ""));
  }

  // Getters
  public boolean isHaveBorder() {
    return haveBorder;
  }

  public int getRadius() {
    return radius;
  }

  // Setters
  public void setHaveBorder(boolean haveBorder) {
    this.haveBorder = haveBorder;
    applyFlatLafStyle();
    repaint();
  }

  public void setRadius(int radius) {
    this.radius = radius;
    applyFlatLafStyle();
    repaint();
  }
}
