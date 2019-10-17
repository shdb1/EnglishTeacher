package com.shadab.english.teacher.utils;

import java.util.Locale;

import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class SynthesizerProvider {

	
	public static Synthesizer getSynthesizer(){
		
		Synthesizer synthesizer = null;
		// Set property as Kevin Dictionary 
					System.setProperty(EnglishTeacherConstants.TTS_VOICE_LOCALE,EnglishTeacherConstants.TTS_VOICE_US_EN_LANGUAGE_IMPL); 

					// Register Engine 
					try {
						Central.registerEngineCentral(EnglishTeacherConstants.ENGINE_CENTRAL);
					} catch (EngineException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 

					// Create a Synthesizer 
					try {
						 synthesizer 
							= Central.createSynthesizer( 
								new SynthesizerModeDesc(Locale.US));
							synthesizer.allocate();
							try {
								synthesizer.resume();
							} catch (AudioException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (EngineStateError e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					} catch (IllegalArgumentException | EngineException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					return synthesizer;
	}
}
