package org.bnsplits.view.components;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.*;
import java.awt.*;
import org.bnsplits.view.Theme;

public class CustomComboBox<E> extends JComboBox<E> {

  private int radius = 32;
  private String placeholderText = "";

  // Constructeurs
  public CustomComboBox() {
    super();
    initStyle();
  }

  public CustomComboBox(E[] items) {
    super(items);
    initStyle();
  }

  public CustomComboBox(ComboBoxModel<E> model) {
    super(model);
    initStyle();
  }

  private void initStyle() {
    setFont(new Font("Segoe UI", Font.PLAIN, 14));
    setCursor(new Cursor(Cursor.HAND_CURSOR));

    applyFlatLafStyle();
  }

  private void applyFlatLafStyle() {
    putClientProperty(FlatClientProperties.STYLE,
        "arc: " + radius + ";" +
            "background: " + Theme.SURFACE_COLOR + ";" +
            "foreground: " + Theme.ON_SURFACE_COLOR + ";" +
            "borderColor: " + Theme.OUTLINE_COLOR + ";" +
            "focusedBorderColor: " + Theme.PRIMARY_COLOR + ";" +
            "hoverBorderColor: " + Theme.PRIMARY_COLOR + ";" +
            "padding: 12,16,12,16;" +
            "buttonBackground: " + Theme.SURFACE_COLOR + ";" +
            "buttonArrowColor: " + Theme.ON_SURFACE_COLOR + ";" +
            "buttonHoverArrowColor: " + Theme.PRIMARY_COLOR);

    if (!placeholderText.isEmpty()) {
      putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, placeholderText);
    }
  }

  // Getters
  public int getRadius() {
    return radius;
  }

  public String getPlaceholderText() {
    return placeholderText;
  }

  // Setters
  public void setRadius(int radius) {
    this.radius = radius;
    applyFlatLafStyle();
    repaint();
  }

  public void setPlaceholderText(String placeholderText) {
    this.placeholderText = placeholderText;
    applyFlatLafStyle();
    repaint();
  }
}
