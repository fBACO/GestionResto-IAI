package org.bnsplits.view.components;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.*;
import java.awt.*;
import org.bnsplits.view.Theme;

public class NavigationButton extends JButton {

  private boolean isSelected = true;
  private int radius = 16;

  public NavigationButton() {
    super();
    initStyle();
  }

  public NavigationButton(String text) {
    super(text);
    initStyle();
  }

  private void initStyle() {
    setCursor(new Cursor(Cursor.HAND_CURSOR));
    setFocusPainted(false);
    setHorizontalAlignment(SwingConstants.LEFT);
    applyFlatLafStyle();
  }

  private void applyFlatLafStyle() {
    if (isSelected) {
      // Selected: semi-transparent gray background + colored border
      putClientProperty(FlatClientProperties.STYLE,
          "font: bold 16;" +
              "foreground: " + Theme.ON_PRIMARY_COLOR + ";" +
              "background: #88888840;" + // slightly transparent gray
              "arc: " + radius + ";" +
              "borderColor: " + Theme.OUTLINE_COLOR + ";" +
              "borderWidth: 2;" +
              "focusWidth: 0;" +
              "iconTextGap: 8;" +
              "margin: 16,20,16,20;" +
              "hoverBackground: #55808080;" + // locked — same as normal
              "pressedBackground: #55808080;" + // locked — same as normal
              "focusedBackground: #55808080"); // locked — same as normal
    } else {
      // Not selected: plain text button, no background, no border
      putClientProperty(FlatClientProperties.STYLE,
          "font: demibold 16;" +
              "foreground: " + Theme.ON_PRIMARY_COLOR + ";" +
              "background: null;" +
              "arc: " + radius + ";" +
              "borderWidth: 0;" +
              "focusWidth: 0;" +
              "iconTextGap: 8;" +
              "margin: 16,20,16,20;" +
              "hoverBackground: null;" + // locked — no hover effect
              "pressedBackground: null;" + // locked — no press effect
              "focusedBackground: null"); // locked — no focus effect

      setContentAreaFilled(false);
      setBorderPainted(false);
      setOpaque(false);
    }
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
    applyFlatLafStyle();
  }

  public boolean getIsSelected() {
    return isSelected;
  }

  public void setIsSelected(boolean selected) {
    this.isSelected = selected;

    // Reset paint flags before re-applying style
    setContentAreaFilled(selected);
    setBorderPainted(selected);
    setOpaque(false); // always false, FlatLaf handles painting

    applyFlatLafStyle();
    repaint();
  }
}
