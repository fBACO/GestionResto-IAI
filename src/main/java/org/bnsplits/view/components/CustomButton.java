package org.bnsplits.view.components;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.*;
import java.awt.*;
import org.bnsplits.view.Theme;
import org.kordamp.ikonli.fontawesome6.*;
import org.kordamp.ikonli.swing.FontIcon;

public class CustomButton extends JButton {

  private boolean isTextButton = false;
  private boolean isSelected = true;
  private int radius = 16;
  private FontAwesomeSolid icon;

  // Constructeurs
  public CustomButton() {
    super();
    initStyle();
  }

  public CustomButton(String text) {
    super(text);
    initStyle();
  }

  public CustomButton(String text, boolean isTextButton) {
    super(text);
    this.isTextButton = isTextButton;
    initStyle();
  }

  public CustomButton(boolean isTextButton) {
    super();
    this.isTextButton = isTextButton;
    initStyle();
  }

  private void initStyle() {
    if (icon != null) {
      Color iconColor = isTextButton ? Color.decode(Theme.PRIMARY_COLOR) : Color.WHITE;
      setIcon(FontIcon.of(icon, 16, iconColor));
    }

    setCursor(new Cursor(Cursor.HAND_CURSOR));

    if (isTextButton) {
      setContentAreaFilled(false);
      setBorderPainted(false);
      setFocusPainted(false);
      setOpaque(false);
    }

    applyFlatLafStyle();
  }

  private void applyFlatLafStyle() {
    if (isTextButton) {
      String foregroundColor = isSelected ? Theme.PRIMARY_COLOR : Theme.ON_BACKGROUND_COLOR;
      putClientProperty(FlatClientProperties.STYLE,
          "font: bold 14;" +
              "foreground: " + foregroundColor + ";" +
              "margin: 8,12,8,12;" +
              "iconTextGap: 8");
    } else {
      putClientProperty(FlatClientProperties.STYLE,
          "font: bold 14;" +
              "foreground: " + Theme.ON_PRIMARY_COLOR + ";" +
              "background: " + Theme.PRIMARY_BRIGHT_COLOR + ";" +
              "arc: " + radius + ";" +
              "borderWidth: 0;" +
              "focusWidth: 0;" +
              "iconTextGap: 8;" +
              "margin: 16,20,16,20;" +
              "hoverBackground: " + Theme.PRIMARY_COLOR + ";" +
              "pressedBackground: " + Theme.PRIMARY_DIM_COLOR + ";" +
              "focusedBackground: " + Theme.PRIMARY_BRIGHT_COLOR + ";" +
              "disabledBackground: #888888");
    }
  }

  // Getters + Setters
  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
    applyFlatLafStyle();
  }

  public boolean isTextButton() {
    return isTextButton;
  }

  public void setTextButton(boolean textButton) {
    this.isTextButton = textButton;
    initStyle();
  }

  public boolean isSelected() {
    return isSelected;
  }

  public void setSelected(boolean selected) {
    this.isSelected = selected;
    applyFlatLafStyle();
  }

  public void setIcon(FontAwesomeSolid icon) {
    this.icon = icon;
    initStyle();
  }
}
