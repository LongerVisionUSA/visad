//
// ContourWidget.java
//

/*
VisAD system for interactive analysis and visualization of numerical
data.  Copyright (C) 1996 - 2000 Bill Hibbard, Curtis Rueden, Tom
Rink, Dave Glowacki, Steve Emmerson, Tom Whittaker, Don Murray, and
Tommy Jasmin.

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Library General Public
License as published by the Free Software Foundation; either
version 2 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Library General Public License for more details.

You should have received a copy of the GNU Library General Public
License along with this library; if not, write to the Free
Software Foundation, Inc., 59 Temple Place - Suite 330, Boston,
MA 02111-1307, USA
*/

package visad.browser;

import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

/**
 * A widget that allows users to control graphics mode parameters.
 */
public class ContourWidget extends Widget implements ActionListener, ItemListener {

  Checkbox contours;
  Checkbox labels;
  Checkbox dashed;
  TextField interval;
  TextField base;
  Label surfaceLabel;
  //CTR: TODO: Slider surface;
  //CTR: TODO: ContourRangeSlider contourRange;

  private boolean cwMainContours;
  private boolean cwLabels;
  private float cwSurfaceValue;
  private float cwContourInterval;
  private float cwLowLimit;
  private float cwHiLimit;
  private float cwBase;

  /**
   * Constructs a new ContourWidget.
   */
  public ContourWidget() {
    // lay out components with GridBagLayout
    GridBagLayout gridbag = new GridBagLayout();
    setLayout(gridbag);

    // construct GUI components
    contours = new Checkbox("contours", cwMainContours);
    labels = new Checkbox("labels", cwLabels);
    dashed = new Checkbox("dashed lines below base", cwContourInterval < 0);
    interval = new TextField(Convert.shortString(Math.abs(cwContourInterval)));
    base = new TextField(Convert.shortString(cwBase));
    surfaceLabel = new Label("--- = ---");
    //CTR: TODO: surface = new Slider();
    //CTR: TODO: contourRange = new ContourRangeSlider();

    // add listeners
    contours.addItemListener(this);
    labels.addItemListener(this);
    dashed.addItemListener(this);
    interval.addActionListener(this);
    base.addActionListener(this);

    // lay out Components
    addComponent(contours, gridbag, 1, 0, 1, 1, 0.0, 0.0);
    addComponent(labels, gridbag, 2, 0, 2, 1, 0.0, 0.0);
    addComponent(dashed, gridbag, 1, 1, 3, 1, 0.0, 0.0);
    addComponent(new Label("interval:"), gridbag, 0, 2, 1, 1, 0.0, 0.0);
    addComponent(interval, gridbag, 1, 2, 1, 1, 1.0, 0.0);
    addComponent(new Label("base:"), gridbag, 2, 2, 1, 1, 0.0, 0.0);
    addComponent(base, gridbag, 3, 2, 1, 1, 1.0, 0.0);
    addComponent(surfaceLabel, gridbag, 0, 3, 4, 1, 1.0, 0.0);
    //CTR: TODO: addComponent(surface, gridbag, 0, 4, 4, 1, 1.0, 0.0);
    //CTR: TODO: addComponent(contourRange, gridbag, 0, 5, 4, 1, 1.0, 1.0);
  }

  /**
   * Gets the value of the contours checkbox.
   */
  public boolean getMainContours() {
    return cwMainContours;
  }

  /**
   * Sets the value of the contours checkbox.
   */
  public void setMainContours(boolean mc) {
    cwMainContours = mc;
    contours.setState(mc);
  }

  /**
   * Gets the value of the labels checkbox.
   */
  public boolean getLabels() {
    return cwLabels;
  }

  /**
   * Sets the value of the labels checkbox.
   */
  public void setLabels(boolean lb) {
    cwLabels = lb;
    labels.setState(lb);
  }

  /**
   * Gets the value of the surface value slider.
   */
  public float getSurfaceValue() {
    return cwSurfaceValue;
  }

  /**
   * Sets the value of the surface value slider.
   */
  public void setSurfaceValue(float sv) {
    cwSurfaceValue = sv;
    //CTR: TODO: surface.setValue(sv);
  }

  /**
   * Gets the value of the interval text field.
   */
  public float getContourInterval() {
    return cwContourInterval;
  }

  /**
   * Sets the value of the interval text field.
   */
  public void setContourInterval(float ci) {
    cwContourInterval = ci;
    interval.setText(Convert.shortString(Math.abs(ci)));
    dashed.setState(ci < 0);
  }

  /**
   * Gets the low value of the contour range slider.
   */
  public float getLowLimit() {
    return cwLowLimit;
  }

  /**
   * Gets the hi value of the contour range slider.
   */
  public float getHiLimit() {
    return cwHiLimit;
  }

  /**
   * Sets the range of the contour range slider.
   */
  public void setLimits(float lo, float hi) {
    cwLowLimit = lo;
    cwHiLimit = hi;
    //CTR: TODO: contourRange.setValues(lo, hi);
  }

  /**
   * Gets the value of the base text field.
   */
  public float getBase() {
    return cwBase;
  }

  /**
   * Sets the value of the base text field.
   */
  public void setBase(float bs) {
    cwBase = bs;
    base.setText(Convert.shortString(bs));
  }

  /**
   * Gets a string representing this widget's current state.
   */
  public String getSaveString() {
    return cwMainContours + " " + cwLabels + " " + cwSurfaceValue + " " +
      cwContourInterval + " " + cwLowLimit + " " + cwHiLimit + " " + cwBase;
  }

  /**
   * Reconstructs this widget's state using the specified save string.
   */
  public void setSaveString(String save) {
    if (save == null) {
      if (DEBUG) System.err.println("Invalid save string");
      return;
    }
    StringTokenizer st = new StringTokenizer(save);
    if (st.countTokens() < 7) {
      if (DEBUG) System.err.println("Invalid save string");
      return;
    }

    // determine contour settings
    boolean mc = Convert.getBoolean(st.nextToken());
    boolean lb = Convert.getBoolean(st.nextToken());
    float sv = Convert.getFloat(st.nextToken());
    float ci = Convert.getFloat(st.nextToken());
    float lo = Convert.getFloat(st.nextToken());
    float hi = Convert.getFloat(st.nextToken());
    float bs = Convert.getFloat(st.nextToken());

    // reset contour settings
    setMainContours(mc);
    setLabels(lb);
    setSurfaceValue(sv);
    setContourInterval(ci);
    setLimits(lo, hi);
    setBase(bs);
  }

  /**
   * Handles TextField changes.
   */
  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    Object source = e.getSource();
    if (source == interval) {
      float iv = Float.NaN;
      try {
        iv = Float.valueOf(interval.getText()).floatValue();
      }
      catch (NumberFormatException exc) {
        interval.setText(Convert.shortString(Math.abs(cwContourInterval)));
      }
      if (iv > 0) {
        if (dashed.getState()) iv = -iv;
        setContourInterval(iv);
        contours.requestFocus();
        notifyListeners(new WidgetEvent(this));
      }
    }
    else if (source == base) {
      float bs = Float.NaN;
      try {
        bs = Float.valueOf(base.getText()).floatValue();
      }
      catch (NumberFormatException exc) {
        base.setText(Convert.shortString(cwBase));
      }
      if (bs == bs) {
        setBase(bs);
        contours.requestFocus();
        notifyListeners(new WidgetEvent(this));
      }
    }
  }

  /**
   * Handles Checkbox changes.
   */
  public void itemStateChanged(ItemEvent e) {
    Object source = e.getItemSelectable();
    boolean on = (e.getStateChange() == ItemEvent.SELECTED);
    if (source == contours) setMainContours(on);
    else if (source == labels) setLabels(on);
    else if (source == dashed) setContourInterval(-cwContourInterval);
    notifyListeners(new WidgetEvent(this));
  }

  /**
   * Tests ContourWidget.
   */
  public static void main(String[] args) {
    new ContourWidget().testWidget();
  }

}
