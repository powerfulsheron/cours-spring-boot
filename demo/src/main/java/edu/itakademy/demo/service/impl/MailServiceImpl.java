package edu.itakademy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	JavaMailSender emailSender;

	@Override
	public void sendSimpleMessage(Book book) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("DemoApp");
		message.setTo("lcanavaggio@wedigital.garden");
		message.setSubject("Nouveau livre ajouté");
		message.setText("Le livre "+ book.getName() + "à été ajouté dans la base de donnée");
		emailSender.send(message);
	}

}
