package com.optimus.nnlt.dto


import lombok.Data;

@Data
class UserDTO {
    Integer id
    String email
    String password
    List<Integer> roleIds
    String firstName
    String lastName
}
