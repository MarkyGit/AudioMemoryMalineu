// Mark fragt: folgend wird die length als 0 definiert

package audioMemory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class PlayerWithInput {

	// Länge der abzuspielenden Note
	int length = 0;
	// Tonhöhe
	int hoehe = 120;
	// Laustärtke
	int lautstaerke = 100;

	Sliderer wertSliderer = new Sliderer();length=wertSliderer.getValue();

	public static void main(String[] args) {
		PlayerWithInput mini = new PlayerWithInput();
		mini.spielenMitInput(1000);
	}

	// Note abspielen, mit der Variablen int length alks Notenlänge, Tonhöhe folgt
	// noch
	public void spielenMitInput(int length) {
		try {

			this.length = length;

			// Sequencer player = MidiSystem.getSequencer();
			// player.open();

			// Sequence seq = new Sequence(Sequence.PPQ, 4);

			// Track track = seq.createTrack();

			ShortMessage a = new ShortMessage();

			/*
			 * ShortMessage (command,channel,data1,data2) command - the MIDI command
			 * represented by this message channel - the channel associated with the message
			 * CHANNEL data1 - the first data byte TONHOEHE data2 - the second data byte
			 * TONLAUTSTAERKE
			 */
			a.setMessage(144, 2, 44, 100);
			// a.setMessage(192, 1, 102, 0);// Möglichkeit, zum Instrumenten-Wechsel
			MidiEvent noteOn = new MidiEvent(a, 1);
			// track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 2, 44, 100);

			MidiEvent noteOff = new MidiEvent(b, length);
			// track.add(noteOff);
			abspielen(noteOn, noteOff);
			// player.setSequence(seq);
			// player.start();
			// Thread.sleep(5000);
			// player.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	// separate Funktion, welche mit mit "on" den Anfangsbefehl entgegennimmt und
	// mit "off" den Abschlussbefehl des Tons
	public void abspielen(MidiEvent on, MidiEvent off) throws InvalidMidiDataException, InterruptedException {

		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			track.add(on);
			track.add(off);

			player.setSequence(seq);
			player.start();
			Thread.sleep(3000);
			player.close();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}

}
