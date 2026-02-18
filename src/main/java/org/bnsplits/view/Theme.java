package org.bnsplits.view;

import java.awt.Color;

public class Theme {

  public static final String PRIMARY_COLOR = "#5A7388"; // Bleu Gris (couleur principale)
  public static final String PRIMARY_DIM_COLOR = String.format("#%06X",
      Color.decode(PRIMARY_COLOR).darker().getRGB() & 0xFFFFFF); // Bleu Gris un peu plus sombre
  public static final String PRIMARY_BRIGHT_COLOR = String.format("#%06X",
      Color.decode(PRIMARY_COLOR).brighter().getRGB() & 0xFFFFFF); // Bleu Gris un peu plus clair

  public static final String ON_PRIMARY_COLOR = "#FFFFFF"; // Full Blanc

  public static final String BACKGROUND_COLOR = "#F6F7FB"; // Blanc legerement plus sombre (arriere plan)
  public static final String ON_BACKGROUND_COLOR = "#000000"; // Full noir (pour les texts sur l'arriere plan)

  public static final String SURFACE_COLOR = "#FFFFFF"; // Full Blanc
  public static final String ON_SURFACE_COLOR = "#000000"; // Full noir (pour les texts sur l'arriere plan)

  public static final String SURFACE_DIM_COLOR = "#E5E7EB"; // Blanc legerement plus sombre (arriere plan)
  public static final String ON_SURFACE_DIM_COLOR = "#6B7280"; // Bleu Gris un peu plus clair

  public static final String OUTLINE_COLOR = "#EFF0F3"; // Gris clair (utiliser pour les bordures)

  public static final String ERROR_COLOR = "#DC2626"; // Rouge (Erreur)
  public static final String WARNING_COLOR = "#F59E0B"; // Orange (Warning)
  public static final String SUCCESS_COLOR = "#22C55E"; // Vert (vert...)
}
