package com.austin.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.austin.dojooverflow.models.Answer;
import com.austin.dojooverflow.models.NewQuestion;
import com.austin.dojooverflow.models.Question;
import com.austin.dojooverflow.models.Tag;
import com.austin.dojooverflow.repositories.AnswerRepo;
import com.austin.dojooverflow.repositories.QuestionRepo;
import com.austin.dojooverflow.repositories.TagRepo;

@Service
public class AppService {
	@Autowired
	private QuestionRepo qRepo;
	@Autowired
	private AnswerRepo aRepo;
	@Autowired
	private TagRepo tRepo;
	
//	All questions
	public List<Question> allQuestions() {
		return this.qRepo.findAll();
	}
	
//	One question
	public Question findQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
//	Create Question
//	public Question createQuestion(NewQuestion newQuestion) {
//		List<Tag> questionsTags = new ArrayList<Tag>();
//		for(String subject: newQuestion.splitTags()) {
//			Tag tag = this.tRepo.findBySubject(subject).orElse(null);
//			if (tag == null) {
//				tag = new Tag(subject);
//				this.tRepo.save(tag);
//			}
//			if(!questionsTags.contains(tag))
//				questionsTags.add(tag);
//		}
//		Question newQuestion = new Question(question.findQuestion(), questionsTags);
//		this.qRepo.save(newQuestion);
//	}
	
	public void createQuestion(NewQuestion question) {
		// TODO: make a real question here
		List<Tag> questionsTags = new ArrayList<Tag>();
		for(String subject: question.splitTags()) {
			Tag tag = this.tRepo.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tag(subject);
				this.tRepo.save(tag);
			}
			// prevent dupe tags
			if(!questionsTags.contains(tag))
				questionsTags.add(tag);
		}
		Question newQuestion = new Question(question.findQuestion(), questionsTags);
		this.qRepo.save(newQuestion);
	}
	
//	All answers
	public List<Answer> allAnswers() {
		return this.aRepo.findAll();
	}
	
//	Create Answer
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
//	All tags
	public List<Tag> allTags() {
		return this.tRepo.findAll();
	}
	
//	Create Tag
	public Tag createTag(Tag tag) {
		return this.tRepo.save(tag);
	}
}
