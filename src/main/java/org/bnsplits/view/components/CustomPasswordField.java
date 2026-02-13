package org.bnsplits.view.components;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.*;

import org.bnsplits.view.Theme;

import java.awt.*;

public class CustomPasswordField extends JPasswordField {

  private String backgroundColor = Theme.SURFACE_DIM_COLOR;
  private String foregroundColor = Theme.ON_SURFACE_COLOR;
  private String placeholderColor = Theme.ON_SURFACE_DIM_COLOR;
  private String focusColor = Theme.PRIMARY_COLOR;
  private String caretColor = Theme.PRIMARY_COLOR;
  private int radius = 16;
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
