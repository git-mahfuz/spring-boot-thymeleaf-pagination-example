package com.newroz.thymeleafpagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchFormParam {
    private String name;
    private String email;
    private UserStatus status;
}
