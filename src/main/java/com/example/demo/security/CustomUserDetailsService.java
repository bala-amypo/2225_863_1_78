@Service
public class CustomUserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String name, String email, String password, String role) {
        User u = new User();
        u.setFullName(name);
        u.setEmail(email);
        u.setPassword(password);
        u.setRole(role);
        return userRepository.save(u);
    }

    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
