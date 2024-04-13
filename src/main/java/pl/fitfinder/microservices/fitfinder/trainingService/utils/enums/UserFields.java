package pl.fitfinder.microservices.fitfinder.trainingService.utils.enums;

import lombok.Getter;

public enum UserFields {
    USERNAME("username"),
    ID("id"),
    PASSWORD("password"),
    EMAIL("email");

    @Getter
    private String field;
    UserFields(String field){
        this.field = field;
    }
}
