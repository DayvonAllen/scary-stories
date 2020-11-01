package com.dna.dev.userservice.api.v1.domain;

import com.dna.dev.userservice.model.Role;

import java.time.LocalDate;
import java.util.UUID;

public class UserDto {

    private UUID id;
    private String username;
    private String email;
    private String password;
    private LocalDate lastLoginDate;
    private LocalDate joinDate;
    private Role role;
    private Boolean isActive;
    private Boolean isUnlocked;
    private FavoriteDtoList favorites;
    private ImageDto profilePicture;
    private StoryDtoList stories;

    public UserDto() {
    }

    public UserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserDto(UUID id, String username, String email, String password, LocalDate lastLoginDate, LocalDate joinDate, Role role, Boolean isActive, Boolean isUnlocked) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.lastLoginDate = lastLoginDate;
        this.joinDate = joinDate;
        this.role = role;
        this.isActive = isActive;
        this.isUnlocked = isUnlocked;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(Boolean unlocked) {
        isUnlocked = unlocked;
    }

    public FavoriteDtoList getFavorites() {
        return favorites;
    }

    public void setFavorites(FavoriteDtoList favorites) {
        this.favorites = favorites;
    }

    public ImageDto getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(ImageDto profilePicture) {
        this.profilePicture = profilePicture;
    }

    public StoryDtoList getStories() {
        return stories;
    }

    public void setStories(StoryDtoList stories) {
        this.stories = stories;
    }
}
