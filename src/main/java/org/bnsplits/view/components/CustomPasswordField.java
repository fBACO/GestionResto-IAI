package org.bnsplits.view.components;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.*;
import java.awt.*;

public class CustomPasswordField extends JPasswordField {

  private String backgroundColor = "#E5E7EB";
  private String foregroundColor = "#111827";
  private String placeholderColor = "#6B7280";
  private String focusColor = "#2563EB";
  private String caretColor = "#2563EB";
  private int radius = 12;
  private String placeholderText = "Mot de passe...";

  public CustomPasswordField() {
    super();
    initStyle();
  }

  public CustomPasswordField(String placeholder) {
    super();
    this.placeholderText = placeholder;
    initStyle();
  }

  private void initStyle() {
    setCursor(new Cursor(Cursor.TEXT_CURSOR));
    setCaretColor(Color.decode(caretColor));
    applyFlatLafStyle();
  }

  private void applyFlatLafStyle() {
    putClientProperty(FlatClientProperties.STYLE,
        "font: plain 14;" +
            "foreground: " + foregroundColor + ";" +
            "background: " + backgroundColor + ";" +
            "arc: " + radius + ";" +
            "borderWidth: 0;" +
            "focusWidth: 0;" +
            "innerFocusWidth: 0;" +
            "minimumWidth: 200;" +
            "margin: 8,12,8,12");

    if (!placeholderText.isEmpty()) {
      putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, placeholderText);
      putClientProperty(FlatClientProperties.STYLE + ".placeholderForeground", placeholderColor);
    }
  }

  public String getBackgroundColor() {
    return backgroundColor;
  }

  public void setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
    applyFlatLafStyle();
  }

  public String getForegroundColor() {
    return foregroundColor;
  }

  public void setForegroundColor(String foregroundColor) {
    this.foregroundColor = foregroundColor;
    applyFlatLafStyle();
  }

  public String getPlaceholderColor() {
    return placeholderColor;
  }

  public void setPlaceholderColor(String placeholderColor) {
    this.placeholderColor = placeholderColor;
    applyFlatLafStyle();
  }

  public String getFocusColor() {
    return focusColor;
  }

  public void setFocusColor(String focusColor) {
    this.focusColor = focusColor;
    applyFlatLafStyle();
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
    applyFlatLafStyle();
  }

  public String getPlaceholderText() {
    return placeholderText;
  }

  public void setPlaceholderText(String placeholderText) {
    this.placeholderText = placeholderText;
    applyFlatLafStyle();
  }
}
