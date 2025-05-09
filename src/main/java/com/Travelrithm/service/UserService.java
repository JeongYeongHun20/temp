package com.Travelrithm.service;


import com.Travelrithm.domain.UserEntity;
import com.Travelrithm.dto.KakaoUserResponseDto;
import com.Travelrithm.dto.UserRequestDto;
import com.Travelrithm.dto.UserResponseDto;
import com.Travelrithm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserResponseDto createUser(KakaoUserResponseDto kakaoUserInfo) {
        UserEntity userEntity= UserEntity.builder()
                .socialId(kakaoUserInfo.id())
                .name(kakaoUserInfo.kakao_account().name())
                .email(kakaoUserInfo.kakao_account().email())
                .nickname(kakaoUserInfo.kakao_account().profile().nickname())
                .thumbnailImageUrl(kakaoUserInfo.kakao_account().profile().thumbnail_image_url())
                .createdAt(LocalDateTime.now())
                .build();
        validateDuplicateEmail(userEntity);
        userRepository.save(userEntity);

        return new UserResponseDto(userEntity);
    }

    public UserResponseDto createUser(UserRequestDto localUserInfo) {
        UserEntity userEntity = UserEntity.builder()
                .name(localUserInfo.name())
                .password(bCryptPasswordEncoder.encode(localUserInfo.password()))
                .email(localUserInfo.email())
                .nickname(localUserInfo.nickname())
                .socialType(localUserInfo.socialType())
                .thumbnailImageUrl(localUserInfo.thumbnail_image_url())
                .createdAt(LocalDateTime.now())
                .build();
        validateDuplicateEmail(userEntity);
        userRepository.save(userEntity);

        return new UserResponseDto(userEntity);
    }

    @Transactional(readOnly = true)
    public UserResponseDto findUser(Integer id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponseDto::new)
                .toList();
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public UserResponseDto updateUser(Integer userId, UserRequestDto updatedUserDto){
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 입니다"));
        userEntity.update(updatedUserDto);
        return new UserResponseDto(userEntity);
    }

    private void validateDuplicateEmail(UserEntity user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(i-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }



}
