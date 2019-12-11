package audioMemory;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMiniMusikProg {

	// diesen Text habe ich heute, 20. 11.19, gepusht
	public static void main(String[] args) {
		MiniMiniMusikProg mini = new MiniMiniMusikProg();
		mini.spielen();
	}

	public void spielen() {
		try {

			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();

			ShortMessage a = new ShortMessage();

			a.setMessage(144, 1, 44, 110);
			// a.setMessage(192, 1, 102, 0);// Möglichkeit, zum Instrumenten-Wechsel
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 127);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);

			player.setSequence(seq);
			player.start();
			Thread.sleep(5000);
			player.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

}
