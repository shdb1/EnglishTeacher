package com.shadab.english.teacher.questions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.shadab.english.teacher.utils.EnglishTeacherConstants;

public class QuestionsReader {

	public  List<String> getQuestions(String filaName) throws IOException{
		
		

        List<String> result = new ArrayList<>();
        BufferedReader br = null;

        try {
        	ClassLoader classLoader = getClass().getClassLoader();
             URL resource = classLoader.getResource(filaName);
            System.out.println(resource.getPath());
            br = new BufferedReader(new FileReader(resource.getPath()));

            String line;
            while ((line = br.readLine()) != null) {
             	String[] questions = line.split("\\?");
            	Collections.addAll(result, questions);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return result;
    }
		
		
	
	
}
