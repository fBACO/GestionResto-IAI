package org.bnsplits.view.components;

import javax.swing.*;
import java.awt.*;
import org.bnsplits.view.Theme;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.swing.FontIcon;

public class CustomLabel extends JLabel {

  private Ikon icon;
  private int iconSize = 16;
  private boolean isBold = false;
  private int fontSize = 14;
  private String colorTheme = "default"; // default, primary, dim, error, warning, success

  // Constructeurs
  public CustomLabel() {
    super();
    initStyle();
  }

  public CustomLabel(String text) {
    super(text);
    initStyle();
  }

  public CustomLabel(String text, int horizontalAlignment) {
    super(text, horizontalAlignment);
    initStyle();
  }

  public CustomLabel(String text, Ikon icon) {
    super(text);
    this.icon = icon;
    initStyle();
  }

  public CustomLabel(String text, boolean isBold) {
    super(text);
    this.isBold = isBold;
    initStyle();
  }

  private void initStyle() {
    // Appliquer l'icône si présente
    if (icon != null) {
      setIcon(FontIcon.of(icon, iconSize, getForegroundColor()));
      setIconTextGap(8);
    }

    // Appliquer le style
    applyStyle();
  }

  private void applyStyle() {
    // Font
    int fontStyle = isBold ? Font.BOLD : Font.PLAIN;
    setFont(new Font("Segoe UI", fontStyle, fontSize));

    // Couleur selon le thème
    setForeground(getForegroundColor());

    // Mettre à jour l'icône si présente
    if (icon != null && getIcon() != null) {
      setIcon(FontIcon.of(icon, iconSize, getForegroundColor()));
    }
  }

  private Color getForegroundColor() {
    return switch (colorTheme) {
      case "primary" -> Color.decode(Theme.PRIMARY_COLOR);
      case "dim" -> Color.decode(Theme.ON_SURFACE_DIM_COLOR);
      case "error" -> Color.decode(Theme.ERROR_COLOR);
      case "warning" -> Color.decode(Theme.WARNING_COLOR);
      case "success" -> Color.decode(Theme.SUCCESS_COLOR);
      default -> Color.decode(Theme.ON_SURFACE_COLOR);
    };
  }

  // Getters
  public Ikon getIconValue() {
    return icon;
  }

  public int getIconSize() {
    return iconSize;
  }

  public boolean isBold() {
    return isBold;
  }

  public int getFontSize() {
    return fontSize;
  }

  public String getColorTheme() {
    return colorTheme;
  }

  // Setters
  public void setIconValue(Ikon icon) {
    this.icon = icon;
    if (icon != null) {
      setIcon(FontIcon.of(icon, iconSize, getForegroundColor()));
      setIconTextGap(8);
    } else {
      setIcon(null);
    }
    repaint();
  }

  public void setIconSize(int iconSize) {
    this.iconSize = iconSize;
    if (icon != null) {
      setIcon(FontIcon.of(icon, iconSize, getForegroundColor()));
    }
    repaint();
  }

  public void setBold(boolean bold) {
    this.isBold = bold;
    applyStyle();
    repaint();
  }

  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
    applyStyle();
    repaint();
  }

  public void setColorTheme(String colorTheme) {
    this.colorTheme = colorTheme;
    applyStyle();
    repaint();
  }
}
