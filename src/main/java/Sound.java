import java.util.*;
public class Sound
{
  /** the array of values in this sound; guaranteed not to be null */
  int[] samples;



  /** Changes those values in this sound that have an amplitude greater than limit.
   *  Values greater than limit are changed to limit.
   *  Values less than -limit are changed to -limit.
   *  @param limit the amplitude limit
   *         Precondition: limit >= 0
   *  @return the number of values in this sound that this method changed
   */
  public int limitAmplitude(int limit) {
    int t=0;
    for (int i=0;i<samples.length;i++) {
      if (samples[i]>limit) {
        t++;
        samples[i] = limit;
      } else if (samples[i]<-limit) {
        t++;
        samples[i] = -limit;
      }
    }
    return t;
  }



  /** Removes all silence from the beginning of this sound.
   *  Silence is represented by a value of 0.
   *  Precondition: samples contains at least one nonzero value
   *  Postcondition: the length of samples reflects the removal of starting silence
   */
  public void trimSilenceFromBeginning() {
    int t=0;
    int i=0;
    while (samples[i]==0) {t++;}
    int[] a = new int[samples.length-t];
    for (int i2=0;i2<a.length;i2++) {
      a[i2] = samples[i2-t];
    }
    samples = a;
  }
}
