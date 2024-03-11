package com.example.utktravel.services;

public interface EmailService {
    public void sendVerificationEmail(String to, String subject, String text);
}
