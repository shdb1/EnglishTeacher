package com.shadab.english.teacher.runner;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer;

import com.shadab.english.teacher.questions.QuestionsReader;
import com.shadab.english.teacher.utils.EnglishTeacherConstants;
import com.shadab.english.teacher.utils.SynthesizerProvider;
import com.shadab.english.teacher.voicemaker.TextToVoice;

public class StartApp { 
	
	Synthesizer synthesizer;
	
	{
		 synthesizer = SynthesizerProvider.getSynthesizer();
	}

	public static void main(String[] args) 
	{ 

		try { 
			
			StartApp startApp = new StartApp();
			startApp.runTask();
			
		} 

		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
	
	public void runTask(){
		
		// Read questions
		QuestionsReader questionsReader = new QuestionsReader();
		TextToVoice textToVoice = new TextToVoice();
		try {
			List<String> result = questionsReader.getQuestions(EnglishTeacherConstants.QUESTIONS_FILE);
			ListIterator<String> listIterator = result.listIterator();
			while (listIterator.hasNext()) {
				String question =   listIterator.next();
				textToVoice.generateVoice(synthesizer, question);
				try {
					Thread.sleep(EnglishTeacherConstants.VOICE_GAP_TIME_IN_MS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			synthesizer.deallocate();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineStateError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} 
