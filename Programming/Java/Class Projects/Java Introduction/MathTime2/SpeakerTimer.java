import sacco.*;
public class SpeakerTimer extends SaccoObject
{
    private Speaker mySpeaker;

    public SpeakerTimer(Speaker tmpSpeaker)
    {
        this.setDelay(1000);
        mySpeaker = tmpSpeaker;
    }

    @Override
    public void onTimerTick()
    {
        mySpeaker.speak();
    }

    public static void main()
    {
        Speaker kat = new Banana();
        SpeakerTimer timer = new SpeakerTimer(kat);
        timer.start();
    }
}