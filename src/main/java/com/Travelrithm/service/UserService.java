package com.Travelrithm.service;


import com.Travelrithm.domain.UserInfo;
import com.Travelrithm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public void join(UserInfo user) {
        validateDuplicateMember(user);
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<UserInfo> findOne(Long id) {
        return userRepository.findById(id);

    }
    @Transactional(readOnly = true)
    public List<UserInfo> findAll() {
        return userRepository.findAll();
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    private void validateDuplicateMember(UserInfo user) {
        userRepository.findByName(user.getName())
                .ifPresent(i-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

}
