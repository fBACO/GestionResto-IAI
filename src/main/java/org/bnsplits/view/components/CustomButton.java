package org.bnsplits.view.components;

import com.formdev.flatlaf.FlatClientProperties;

import javax.swing.*;
import java.awt.*;
import org.kordamp.ikonli.fontawesome6.*;
import org.kordamp.ikonli.swing.FontIcon;

public class CustomButton extends JButton {

  private String primaryColor = "#2563EB";
  private String hoverColor = "#1D4ED8";
  private String clickColor = "#1E40AF";
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

  public CustomButton(String text, Icon icon) {
    super(text);
    initStyle();
  }

  // Fonction d'initialisation du style
  private void initStyle() {
    if (icon != null)
      setIcon(FontIcon.of(icon, 16, Color.WHITE));

    setCursor(new Cursor(Cursor.HAND_CURSOR));
    applyFlatLafStyle();
  }

  // Application du style via FlatLaf
  private void applyFlatLafStyle() {
    putClientProperty(FlatClientProperties.STYLE,
        "font: bold 14;" +
            "foreground: #FFFFFF;" +
            "background: " + primaryColor + ";" +
            "arc: " + radius + ";" +
            "borderWidth: 0;" +
            "focusWidth: 0;" +
            "hoverBackground: " + hoverColor + ";" +
            "pressedBackground: " + clickColor + ";" +
            "disabledBackground: #888888");
  }

  // Getters + Setters
  public String getPrimaryColor() {
    return primaryColor;
  }

  public void setPrimaryColor(String primaryColor) {
    this.primaryColor = primaryColor;
    applyFlatLafStyle();
  }

  public String getHoverColor() {
    return hoverColor;
  }

  public void setHoverColor(String hoverColor) {
    this.hoverColor = hoverColor;
    applyFlatLafStyle();
  }

  public String getClickColor() {
    return clickColor;
  }

  public void setClickColor(String clickColor) {
    this.clickColor = clickColor;
    applyFlatLafStyle();
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
    applyFlatLafStyle();
  }

  // INFO: Ça marche pas
  // public FontAwesomeSolid getIcon() {
  //   return icon;
  // }

  public void setIcon(FontAwesomeSolid icon) {
    this.icon = icon;
    initStyle();
  }
}
