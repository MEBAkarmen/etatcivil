@JsonApiResource(type = "users")
public class user {
	@JsonApiId
    private Long id;

    private String name;

    private String email;
}
