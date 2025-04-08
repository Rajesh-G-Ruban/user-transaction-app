package txn.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class JwtBlacklistService {

    // In-memory storage for blacklisted tokens
    private Set<String> blacklistedTokens = new HashSet<>();

    // Add a token to the blacklist
    public void blacklistToken(String token) {
        blacklistedTokens.add(token);
    }

    // Check if a token is blacklisted
    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }

    // Remove a token from the blacklist (optional, for cleanup)
    public void removeFromBlacklist(String token) {
        blacklistedTokens.remove(token);
    }
}
