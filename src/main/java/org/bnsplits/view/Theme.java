package org.bnsplits.view;

import java.awt.Color;

public class Theme {

  public static final String PRIMARY_COLOR = "#5A7388";
  public static final String PRIMARY_DIM_COLOR = String.format("#%06X",
      Color.decode(PRIMARY_COLOR).darker().getRGB() & 0xFFFFFF);
  public static final String PRIMARY_BRIGHT_COLOR = String.format("#%06X",
      Color.decode(PRIMARY_COLOR).brighter().getRGB() & 0xFFFFFF);

  public static final String ON_PRIMARY_COLOR = "#FFFFFF";

  public static final String BACKGROUND_COLOR = "#F6F7FB";
  public static final String ON_BACKGROUND_COLOR = "#000000";

  public static final String SURFACE_COLOR = "#FFFFFF";
  public static final String ON_SURFACE_COLOR = "#000000";

  public static final String SURFACE_DIM_COLOR = "#E5E7EB";
  public static final String ON_SURFACE_DIM_COLOR = "#6B7280";

  public static final String OUTLINE_COLOR = "#EFF0F3";

  public static final String ERROR_COLOR = "#DC2626";
  public static final String WARNING_COLOR = "#F59E0B";
  public static final String SUCCESS_COLOR = "#22C55E";
}
