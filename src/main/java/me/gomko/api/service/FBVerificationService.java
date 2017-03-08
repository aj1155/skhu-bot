package me.gomko.api.service;

public interface FBVerificationService {

    String verifyWebhook(final String verifyToken, final String challenge);
}
