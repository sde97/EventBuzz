package project.service;

import org.springframework.stereotype.Service;

@Service
public interface PasswordHelperService {
    public String generateHash(String input);
}
