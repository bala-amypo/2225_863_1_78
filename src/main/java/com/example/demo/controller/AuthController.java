@RestController
@RequestMapping("/auth")
public class AuthController {

    private final VolunteerProfileService service;
    private final JwtTokenProvider tokenProvider;

    public AuthController(VolunteerProfileService service,
                          JwtTokenProvider tokenProvider) {
        this.service = service;
        this.tokenProvider = tokenProvider;
    }

    // POST /auth/register
    @PostMapping("/register")
    public VolunteerProfile register(@RequestBody RegisterRequest request) {
        return service.registerVolunteer(request);
    }

    // POST /auth/login
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        String token = tokenProvider.generateToken(
                request.getEmail(), "USER");
        return new AuthResponse(token, 1L, "USER");
    }
}
