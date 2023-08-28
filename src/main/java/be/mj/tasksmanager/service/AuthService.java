package be.mj.tasksmanager.service;

import be.mj.tasksmanager.dto.SignupRequest;
import be.mj.tasksmanager.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
}
