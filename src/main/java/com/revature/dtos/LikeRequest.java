package com.revature.dtos;

import lombok.*;

@NoArgsConstructor
@Data
@Getter
@Setter
@AllArgsConstructor
public class LikeRequest {

    private int postId;
    private String email;
}
