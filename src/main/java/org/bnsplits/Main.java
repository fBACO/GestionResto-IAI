package org.bnsplits;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import org.bnsplits.util.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import org.bnsplits.view.*;

public class Main {
  public static void main(String[] args) throws SQLException {

    // Appliquer le thème clair de FlatLaf
    // FlatDarkLaf.setup();
    FlatLightLaf.setup();

    TestFrame testFrame = new TestFrame();
    testFrame.setVisible(true);
  }
}
