package visad.data.amanda;

import java.rmi.RemoteException;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import visad.CellImpl;
import visad.DataReferenceImpl;
import visad.FieldImpl;
import visad.Real;
import visad.ScalarMap;
import visad.VisADException;

import visad.data.amanda.AmandaFile;
import visad.data.amanda.Event;

import visad.util.VisADSlider;

public class EventWidget
  extends JPanel
{
  private AmandaFile fileData;
  private FieldImpl amanda;
  private DataReferenceImpl amandaRef;

  private GregorianCalendar cal;

  private VisADSlider slider;
  private JLabel dateLabel;
  private TrackWidget trackWidget;

  private Event thisEvent;

  public EventWidget(AmandaFile fileData, FieldImpl amanda,
                     DataReferenceImpl amandaRef)
    throws RemoteException, VisADException
  {
    this(fileData, amanda, amandaRef, null);
  }

  public EventWidget(AmandaFile fileData, FieldImpl amanda,
                     DataReferenceImpl amandaRef, ScalarMap trackMap)
    throws RemoteException, VisADException
  {
    super();

    this.fileData = fileData;
    this.amanda = amanda;
    this.amandaRef = amandaRef;

    cal = new GregorianCalendar();

    thisEvent = null;

    // initialize before buildSlider() in case it triggers a reference to them
    if (trackMap == null) {
      trackWidget = null;
    } else {
      trackWidget = new TrackWidget(trackMap);
    }
    dateLabel = new JLabel();

    slider = buildSlider(amanda);

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    add(slider);
    add(dateLabel);
    if (trackWidget != null) add(trackWidget);
  }

  private VisADSlider buildSlider(FieldImpl amanda)
    throws RemoteException, VisADException
  {
    final DataReferenceImpl eventRef = new DataReferenceImpl("event");

    final int nEvents = amanda.getLength();

    VisADSlider slider = new VisADSlider("event", 0, nEvents - 1, 0, 1.0,
                                         eventRef, Event.indexType, true);
    slider.hardcodeSizePercent(110); // leave room for label changes

    // call setIndex() whenever slider changes
    CellImpl cell = new CellImpl() {
      public void doAction()
        throws RemoteException, VisADException
      {
        Real r = (Real )eventRef.getData();
        if (r != null) {
          int index = (int )r.getValue();
          if (index < 0) {
            index = 0;
          } else if (index > nEvents) {
            index = nEvents;
          }
          indexChanged(index);
        }
      }
    };
    cell.addReference(eventRef);

    return slider;
  }

  private final Date getDate(int year, int day, double time)
  {
    final int hr = (int )((time + 3599.0) / 3600.0);
    time -= (double )hr * 3600.0;

    final int min = (int )((time + 59.0) / 60.0);
    time -= (double )min * 60.0;

    final int sec = (int )time;
    time -= (double )sec;

    final int milli = (int )(time * 1000.0);

    cal.clear();

    cal.set(GregorianCalendar.YEAR, year);
    cal.set(GregorianCalendar.DAY_OF_YEAR, day);
    cal.set(GregorianCalendar.HOUR_OF_DAY, hr);
    cal.set(GregorianCalendar.MINUTE, min);
    cal.set(GregorianCalendar.SECOND, sec);
    cal.set(GregorianCalendar.MILLISECOND, milli);
    cal.set(GregorianCalendar.DST_OFFSET, 0);

    return cal.getTime();
  }

  public final Event getEvent() { return thisEvent; }
  public final JLabel getLabel() { return dateLabel; }
  public final VisADSlider getSlider() { return slider; }
  public final TrackWidget getTrackWidget() { return trackWidget; }

  /**
   * This method is called whenever the event index is changed
   */
  private void indexChanged(int index)
    throws RemoteException, VisADException
  {
    amandaRef.setData(amanda.getSample(index));

    thisEvent = fileData.getEvent(index);
    if (thisEvent == null) {
      dateLabel.setText("*** NO DATE ***");
    } else {
      dateLabel.setText(getDate(thisEvent.getYear(), thisEvent.getDay(),
                                thisEvent.getTime()).toGMTString());

    }

    if (trackWidget != null) trackWidget.setEvent(thisEvent);

    this.invalidate();
  }
}