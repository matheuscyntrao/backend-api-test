package model.digital.panvelEcommerceBff.oauth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostOAuthV1Request {
    private String password;
    private String username;
}
