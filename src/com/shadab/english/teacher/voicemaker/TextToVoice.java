package com.shadab.english.teacher.voicemaker;

import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer;

public class TextToVoice {

	public void generateVoice(Synthesizer synthesizer, String text) {
		// Allocate synthesizer
		try {

			synthesizer.speakPlainText(text, null);
			synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
		} catch (EngineStateError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
