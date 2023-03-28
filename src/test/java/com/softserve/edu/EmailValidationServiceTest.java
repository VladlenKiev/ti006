package com.softserve.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidationServiceTest {

    private EmailValidationService emailValidationService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void checkEmail_fullCondition() {
        assertTrue(EmailValidationService.checkEmail("example.email@example.com.ua"));
    }

    @Test
    void checkEmail_startAndEndWithLetter() {
        assertFalse(EmailValidationService.checkEmail("1example@example.com.ua"));
        assertTrue(EmailValidationService.checkEmail("email1@example.com.ua"));
    }

    @Test
    void checkEmail_endWithLetterOrNumber() {
        assertTrue(EmailValidationService.checkEmail("example12@example.com.ua"));
        assertTrue(EmailValidationService.checkEmail("example.email12@example.com.ua"));
    }

    @Test
    void checkEmail_mayContainsLatinAndDot() {
        assertTrue(EmailValidationService.checkEmail("example.dot12@example.com.ua"));
        assertFalse(EmailValidationService.checkEmail("example.іівва@example.com.ua"));
    }

    @Test
    void checkEmail_atLeastTwoDomainLevel() {
        assertTrue(EmailValidationService.checkEmail("example.dot12@example.com.ua"));
        assertTrue(EmailValidationService.checkEmail("example.dot12@example.edu.com.ua"));
        assertTrue(EmailValidationService.checkEmail("example.dot12@example.soft.serv.edu.com.ua"));
        assertFalse(EmailValidationService.checkEmail("example.іівва@example.com"));
    }

    @Test
    void checkEmail_topLevelDomainAtLeastTwoLetters() {
        assertTrue(EmailValidationService.checkEmail("example.dot12@edu.com.ua"));
        assertFalse(EmailValidationService.checkEmail("example.іівва@e.com.ua"));
    }
}