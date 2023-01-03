package di.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberEntity {
    private String id;
    private String nickname;
    private String password;

}
