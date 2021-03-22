package com.ivoronline.springboot_mockito_spy.controllers;

import com.ivoronline.springboot_mockito_spy.entities.Person;
import com.ivoronline.springboot_mockito_spy.respositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class MyControllerTest {

  //MOCK DEPENDENCY CLASS
  @Spy PersonRepository personRepositoryMock;

  //INJECT SPIES (where @autowired is used)
  @InjectMocks MyController myController;

  //ENDPOINT
  @Test
  void getPerson() {

    //MOCK REPOSITORY METHOD
    when(personRepositoryMock.getPersonById(1)).thenReturn(new Person(1, "Susan", 50));

    //TEST CONTROLLER ENDPOINT
    String result = myController.getPerson(1);
    System.out.println(result);

    //TEST RESULT
    assertEquals("Susan is 50 years old", result);

  }

}
