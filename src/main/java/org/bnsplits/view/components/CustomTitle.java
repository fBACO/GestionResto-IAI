package org.bnsplits.view.components;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.*;
import java.awt.*;
import org.bnsplits.view.Theme;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.feather.Feather;
import org.kordamp.ikonli.fontawesome6.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignD;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;
import org.kordamp.ikonli.materialdesign2.MaterialDesignR;

public class CustomTitle extends JPanel {

  private JLabel iconLabel;
  private JLabel textLabel;
  private Ikon icon = FontAwesomeSolid.RECEIPT;
  private String text = "Gestion Restaurant";

  // Constructeurs
  public CustomTitle() {
    super();
    initComponents();
    initStyle();
  }

  public CustomTitle(String text) {
    super();
    this.text = text;
    initComponents();
    initStyle();
  }

  public CustomTitle(String text, Ikon icon) {
    super();
    this.text = text;
    this.icon = icon;
    initComponents();
    initStyle();
  }

  private void initComponents() {
    setLayout(new FlowLayout(FlowLayout.LEFT, 12, 0));

    // Icon label
    iconLabel = new JLabel();
    if (icon != null) {
      iconLabel.setIcon(FontIcon.of(icon, 32, Color.decode(Theme.ON_BACKGROUND_COLOR)));
      add(iconLabel);
    }

    // Text label
    textLabel = new JLabel(text);
    add(textLabel);
  }

  private void initStyle() {
    setBackground(Color.decode(Theme.BACKGROUND_COLOR));
    setOpaque(false);

    // Style du texte
    textLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
    textLabel.setForeground(Color.decode(Theme.ON_BACKGROUND_COLOR));
  }

  // Getters
  public String getText() {
    return text;
  }

  public Ikon getIcon() {
    return icon;
  }

  // Setters
  public void setText(String text) {
    this.text = text;
    textLabel.setText(text);
    revalidate();
    repaint();
  }

  public void setIcon(Ikon icon) {
    this.icon = icon;
    if (icon != null) {
      if (iconLabel.getParent() == null) {
        add(iconLabel, 0);
      }
      iconLabel.setIcon(FontIcon.of(icon, 32, Color.decode(Theme.ON_BACKGROUND_COLOR)));
    } else {
      if (iconLabel.getParent() != null) {
        remove(iconLabel);
      }
    }
    revalidate();
    repaint();
  }
}
